package cs544.exercise25_1.client;

import java.util.Collection;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cs544.exercise25_1.service.Customer;
import cs544.exercise25_1.service.ICustomerService;

public class CustomerApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
		ICustomerService remoteService = context.getBean("customerServiceProxy", ICustomerService.class);
		
		// TODO add 3 customers & print customers list
		Customer customer1 = new Customer("AAABBB001", "Syed");
		remoteService.addCustomer(customer1);
		Customer customer2 = new Customer("AAABBB002", "Zaman");
		remoteService.addCustomer(customer2);
		Customer customer3 = new Customer("AAABBB003", "Abul");
		remoteService.addCustomer(customer3);
		
		printCustomers(remoteService.getCustomers());
		

		// TODO update 1 customer & print customers list
		Customer customer = remoteService.getCustomer("AAABBB001");
		if(customer != null) {
			customer.setName("Maal");
			remoteService.updateCustomer(customer);
		}
		printCustomers(remoteService.getCustomers());
		
		// TODO delete 1 customer & print customers list
		remoteService.deleteCustomer("AAABBB003");
		printCustomers(remoteService.getCustomers());
	}
	
	public static void printCustomers(Collection<Customer> customers) {
		for (Customer customer : customers) {
			System.out.println(customer.getName() + " " + customer.getCustomerNumber());
		}
		System.out.println();
	}
}
