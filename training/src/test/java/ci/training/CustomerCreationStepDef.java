package ci.training;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import ci.training.beans.Customer;
import ci.training.repo.WalletRepoClass;
import ci.training.service.WalletServiceImpl;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CustomerCreationStepDef {
	WalletRepoClass repo = new WalletRepoClass();;
	WalletServiceImpl walletService;
	Customer res;
	@Given("^I have customerDetail$")
	public void i_have_customerDetail() { 
		walletService = new WalletServiceImpl(repo);
	}
	@When("^I have \"([^\"]*)\" \"([^\"]*)\" and (\\d+)$")
	public void i_have_and(String name, String phoneNumber, BigDecimal balance){
		res = walletService.createWallet(name, phoneNumber, balance);
	}

	@Then("^I should get \"([^\"]*)\" \"([^\"]*)\" and (\\d+)$")
	public void i_should_get_and(String name, String phoneNumber, BigDecimal balance){
		assertThat(res.getName()).isEqualTo(name);
		assertThat(res.getPhoneNumber()).isEqualTo(phoneNumber);
		assertThat(res.getWallet().getBalance()).isEqualTo(balance);
	}
}
