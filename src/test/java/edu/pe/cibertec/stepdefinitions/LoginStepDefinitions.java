package edu.pe.cibertec.stepdefinitions;

import edu.pe.cibertec.questions.MensajeErrorLogin;
import edu.pe.cibertec.questions.TextoHeader;
import edu.pe.cibertec.tasks.IniciarSesionComo;
import edu.pe.cibertec.ui.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class LoginStepDefinitions {

    @Given("the user navigates to the login page")
    public void the_user_navigates_to_the_login_page() {
        OnStage.setTheStage(new OnlineCast());

        OnStage.theActorCalled("Usuario").attemptsTo(
                Open.url("https://naveenautomationlabs.com/opencart/index.php?route=account/login")
        );
    }

    @When("the user enters email {string} and password {string}")
    public void the_user_enters_email_and_password(String email, String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                IniciarSesionComo.conCredenciales(email, password)
        );
    }

    @And("clicks on the login button")
    public void clicks_on_the_login_button() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(LoginPage.LOGIN_BUTTON)
        );
    }

    //no valida el nombre de usuario (no aparece), valida My Account
    @Then("the user should see the name {string} in the page header")
    public void the_user_should_see_the_name_in_the_page_header(String expectedName) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(TextoHeader.mostrado(), containsString("My Account"))
        );
    }

    @Then("the user should see the login error message {string}")
    public void the_user_should_see_the_login_error_message(String expectedMessage) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(MensajeErrorLogin.mostrado(), equalTo(expectedMessage))
        );
    }

}
