package ci.training.repo;

import java.util.HashMap;
import java.util.Map;

import ci.training.beans.Customer;

public class WalletRepoClass implements WalletRepo{
	Map<String, Customer> customerDetails = new HashMap<String, Customer>();
	@Override
	public boolean save(Customer c) {
		customerDetails.put(c.getPhoneNumber(), c);
		return true;
	}
	@Override
	public Customer find(String phoneNumber) {
		Customer c = customerDetails.get(phoneNumber) ;
		return c;
	}

}
