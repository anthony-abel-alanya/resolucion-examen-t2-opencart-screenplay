package edu.pe.cibertec.stepdefinitions;

import edu.pe.cibertec.questions.MensajeRegistro;
import edu.pe.cibertec.tasks.RegistrarseComo;
import edu.pe.cibertec.ui.RegistroPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class RegistroStepDefinitions {

    @Given("the user navigates to the register page")
    public void navigate() {
        OnStage.setTheStage(new OnlineCast());

        OnStage.theActorCalled("Usuario").attemptsTo(
                Open.url("https://naveenautomationlabs.com/opencart/index.php?route=account/register")
        );
    }

    @When("the user fills the form with first name {string}, last name {string}, email {string}, phone {string} and password {string}")
    public void fillForm(String firstName, String lastName,
                         String email, String phone, String password) {

        email = email.replace("@", "_" + System.currentTimeMillis() + "@");

        OnStage.theActorInTheSpotlight().attemptsTo(
                RegistrarseComo.conDatos(firstName, lastName, email, phone, password)
        );
    }

    @When("accepts the privacy policy")
    public void acceptPolicy() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(RegistroPage.PRIVACY_POLICY)
        );
    }

    @When("clicks on continue")
    public void clickContinue() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(RegistroPage.CONTINUE_BUTTON)
        );
    }

    @Then("the user should see the message {string}")
    public void validateMessage(String expected) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(MensajeRegistro.mostrado(), equalTo(expected))
        );
    }

}
