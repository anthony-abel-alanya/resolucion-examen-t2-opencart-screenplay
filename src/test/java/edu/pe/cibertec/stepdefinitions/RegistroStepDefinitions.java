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
    public void the_user_navigates_to_the_register_page() {
        OnStage.setTheStage(new OnlineCast());

        OnStage.theActorCalled("Usuario").attemptsTo(
                Open.url("https://naveenautomationlabs.com/opencart/index.php?route=account/register")
        );
    }

    @When("the user fills the form with first name {string}, last name {string}, email {string}, phone {string} and password {string}")
    public void the_user_fills_the_form_with_firstname_lastname_email_phone_and_password(String firstName, String lastName,
                         String email, String phone, String password) {

        email = email.replace("@", "_" + System.currentTimeMillis() + "@");

        OnStage.theActorInTheSpotlight().attemptsTo(
                RegistrarseComo.conDatos(firstName, lastName, email, phone, password)
        );
    }

    @When("accepts the privacy policy")
    public void accepts_the_privacy_policy() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(RegistroPage.PRIVACY_POLICY)
        );
    }

    @When("clicks on continue")
    public void clicks_on_continue() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(RegistroPage.CONTINUE_BUTTON)
        );
    }

    @Then("the user should see the registration message {string}")
    public void the_user_should_see_the_registration_message(String expected) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(MensajeRegistro.mostrado(), equalTo(expected))
        );
    }

}
