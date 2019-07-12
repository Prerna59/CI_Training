package ci.training;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import ci.training.beans.Customer;
import ci.training.repo.WalletRepo;
import ci.training.repo.WalletRepoClass;
import ci.training.service.WalletServiceImpl;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CustomerCreationStepDef {
	WalletRepo repo = new WalletRepoClass();
	WalletServiceImpl walletService;
	Customer res;
	Customer result;
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
		result = repo.find(phoneNumber);
		assertThat(result.getName()).isEqualTo(name);
		assertThat(result.getPhoneNumber()).isEqualTo(phoneNumber);
		assertThat(result.getWallet().getBalance()).isEqualTo(balance);
	}
}
