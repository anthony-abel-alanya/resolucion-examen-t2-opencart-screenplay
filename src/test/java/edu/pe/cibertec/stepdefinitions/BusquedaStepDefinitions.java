package edu.pe.cibertec.stepdefinitions;

import edu.pe.cibertec.questions.MensajeNoResultados;
import edu.pe.cibertec.questions.ResultadosDeBusqueda;
import edu.pe.cibertec.tasks.BuscarProducto;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class BusquedaStepDefinitions {

    @Given("the user is on the OpenCart home page")
    public void the_user_is_on_the_OpenCart_home_page() {
        OnStage.setTheStage(new OnlineCast());

        OnStage.theActorCalled("Usuario").attemptsTo(
                Open.url("https://naveenautomationlabs.com/opencart/index.php?route=common/home")
        );
    }

    @When("the user searches for the product {string}")
    public void the_user_searches_for_the_product(String product) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                BuscarProducto.llamado(product)
        );
    }

    @Then("the user should see at least one result with the name {string}")
    public void the_user_should_see_at_least_one_result_with_the_name(String expectedProduct) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(
                        ResultadosDeBusqueda.productos(),
                        hasItem(containsString(expectedProduct))
                )
        );
    }

    @Then("the user should see the search error message {string}")
    public void the_user_should_see_the_search_error_message(String expectedMessage) {

        OnStage.theActorInTheSpotlight().should(
                seeThat(
                        MensajeNoResultados.mostrado(),
                        equalTo(expectedMessage)
                )
        );
    }

}
