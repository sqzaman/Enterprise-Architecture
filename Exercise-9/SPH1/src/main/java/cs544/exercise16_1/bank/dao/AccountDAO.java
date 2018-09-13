package cs544.exercise16_1.bank.dao;

import java.util.*;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cs544.exercise16_1.bank.domain.Account;


@Repository
public class AccountDAO implements IAccountDAO {
	@Autowired
    SessionFactory sessionFactory;
	Collection<Account> accountlist = new ArrayList<Account>();

	public void saveAccount(Account account) {
		// System.out.println("AccountDAO: saving account with accountnr ="+account.getAccountnumber());
		//accountlist.add(account); // add the new
		sessionFactory.getCurrentSession().persist(account);
	}

	public void updateAccount(Account account) {
		// System.out.println("AccountDAO: update account with accountnr ="+account.getAccountnumber());
		Account accountexist = loadAccount(account.getAccountnumber());
		if (accountexist != null) {
			sessionFactory.getCurrentSession().remove(accountexist);
			sessionFactory.getCurrentSession().persist(account);
			
			//accountlist.remove(accountexist); // remove the old
			//accountlist.add(account); // add the new
			
			
		}

	}

	public Account loadAccount(long accountnumber) {
		// System.out.println("AccountDAO: loading account with accountnr ="+accountnumber);
		return (Account) sessionFactory.getCurrentSession().get(Account.class, accountnumber);
		/*
		for (Account account : accountlist) {
			if (account.getAccountnumber() == accountnumber) {
				return account;
			}
		}
		
		return null;
		*/
	}

	public Collection<Account> getAccounts() {
		@SuppressWarnings("unchecked")
		Collection<Account> accountlist = sessionFactory.getCurrentSession().createQuery("from Account").list();
		return accountlist;
	}

}
