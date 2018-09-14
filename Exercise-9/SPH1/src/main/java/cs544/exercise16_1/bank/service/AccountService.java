package cs544.exercise16_1.bank.service;

import java.util.Collection;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.exercise16_1.bank.dao.AccountDAO;
import cs544.exercise16_1.bank.domain.Account;
import cs544.exercise16_1.bank.domain.Customer;
import cs544.exercise16_1.bank.jms.JMSSender;
import cs544.exercise16_1.bank.logging.Logger;





@Service("accountService")
public class AccountService implements IAccountService {
	
	
	@Autowired
    SessionFactory sessionFactory;
	
	@Autowired	
	private AccountDAO accountDAO;
	@Autowired
	private CurrencyConverter currencyConverter;
	@Autowired
	JMSSender jmsSender;
	private Logger logger;
	
	public AccountService(){
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Account createAccount(long accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		accountDAO.saveAccount(account);
		//logger.log("createAccount with parameters accountNumber= "+accountNumber+" , customerName= "+customerName);
		return account;
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void deposit(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.deposit(amount);
		accountDAO.updateAccount(account);
		//logger.log("deposit with parameters accountNumber= "+accountNumber+" , amount= "+amount);
		if (amount > 10000){
			jmsSender.sendJMSMessage("Deposit of $ "+amount+" to account with accountNumber= "+accountNumber);
		}
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly = true)
	public Account getAccount(long accountNumber) {
		Account account = accountDAO.loadAccount(accountNumber);
		return account;
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly = true)
	public Collection<Account> getAllAccounts() {
		return accountDAO.getAccounts();
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void withdraw(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.withdraw(amount);
		accountDAO.updateAccount(account);
		//logger.log("withdraw with parameters accountNumber= "+accountNumber+" , amount= "+amount);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void depositEuros(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		double amountDollars = currencyConverter.euroToDollars(amount);
		account.deposit(amountDollars);
		accountDAO.updateAccount(account);
		//logger.log("depositEuros with parameters accountNumber= "+accountNumber+" , amount= "+amount);
		if (amountDollars > 10000){
			jmsSender.sendJMSMessage("Deposit of $ "+amount+" to account with accountNumber= "+accountNumber);
		}
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void withdrawEuros(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		double amountDollars = currencyConverter.euroToDollars(amount);
		account.withdraw(amountDollars);
		accountDAO.updateAccount(account);
		//logger.log("withdrawEuros with parameters accountNumber= "+accountNumber+" , amount= "+amount);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
		Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
		Account toAccount = accountDAO.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		accountDAO.updateAccount(fromAccount);
		accountDAO.updateAccount(toAccount);
		//logger.log("transferFunds with parameters fromAccountNumber= "+fromAccountNumber+" , toAccountNumber= "+toAccountNumber+" , amount= "+amount+" , description= "+description);
		if (amount > 10000){
			jmsSender.sendJMSMessage("TransferFunds of $ "+amount+" from account with accountNumber= "+fromAccount+" to account with accountNumber= "+toAccount);
		}
	}
}
