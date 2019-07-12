package ci.training.repo;

import java.util.HashMap;
import java.util.Map;

import ci.training.beans.Customer;

public class WalletRepoClass implements WalletRepo{
	static Map<String, Customer> customerDetails = new HashMap<String, Customer>();
    static int ct=0;
	@Override
	public boolean save(Customer c) {
		System.out.println(++ct);
		customerDetails.put(c.getPhoneNumber(), c);
		System.out.println(customerDetails.get(c.getPhoneNumber()));
		return true;
	}

	@Override
	public Customer find(String phoneNumber) {
		// TODO Auto-generated method stub
		System.out.println(++ct);
		System.out.println("Here"+customerDetails);
		Customer c = customerDetails.get(phoneNumber) ;
		System.out.println(c.getName());
		return c;
	}

}
