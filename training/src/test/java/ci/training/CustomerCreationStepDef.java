package ci.training;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import ci.training.beans.Customer;
import ci.training.beans.Wallet;
import ci.training.repo.WalletRepoClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CustomerCreationStepDef {
	WalletRepoClass repo=new WalletRepoClass();
	Customer customer;
	Boolean res1;
	String phoneNumber;
	Customer res2;
	
	@Given("^I have customerDetail$")
	public void i_have_customerDetail() throws Throwable { 
		System.out.println("hHghkagh");
	}
	
	@When("^I have \"([^\"]*)\" \"([^\"]*)\" and (\\d+)$")
	public void i_have_and(String name, String phoneNumber, BigDecimal balance) throws Throwable {
		customer = new Customer(name, phoneNumber, new Wallet(balance));
		res1 = repo.save(customer);
	}

	@Then("^I should be able to create customer$")
	public void i_should_be_able_to_create_customer() throws Throwable {
		assertThat(res1).isEqualTo(true);
	}

	
	
	@Given("^I have phoneNumber$")
	public void i_have_phoneNumber() throws Throwable {
		res2 = new Customer();   
	}

	@When("^I search \"([^\"]*)\"$")
	public void i_search(String phoneNumber) throws Throwable {
		res2 = repo.find(phoneNumber);
		System.out.println("kefhjkeg"+res2.getName());
	}

	
	@Then("^I should get \"([^\"]*)\" \"([^\"]*)\" and (\\d+)$")
	public void i_should_get_and(String name, String phoneNumber, BigDecimal balance) throws Throwable {
		assertThat(res2.getName()).isEqualTo(name);
		assertThat(res2.getPhoneNumber()).isEqualTo(phoneNumber);
		assertThat(res2.getWallet().getBalance()).isEqualTo(balance);
	}
	
	

}
