package edu.pe.cibertec.stepdefinitions;
import edu.pe.cibertec.questions.ContadorDelCarrito;
import edu.pe.cibertec.tasks.AgregarAlCarrito;
import edu.pe.cibertec.ui.CarritoPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import java.util.List;
import java.util.stream.Collectors;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CarritoStepDefinitions {

    @When("the user adds the product {string} to the cart")
    public void the_User_Adds_The_Product_To_The_Cart(String producto) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AgregarAlCarrito.elProducto(producto)
        );
    }

    @Then("the cart should show {string}")
    public void the_Cart_Should_Show(String expectedCount) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ContadorDelCarrito.enElHeader(), containsString(expectedCount))
        );
    }

    @And("navigates to the cart")
    public void navigates_To_The_Cart() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Open.url("https://naveenautomationlabs.com/opencart/index.php?route=checkout/cart")
        );
    }

    // Navegación alternativa - Reemplazada por Open.url().

    /*
      @And("navigates to the cart")
        public void navigatesToTheCart() {
            OnStage.theActorInTheSpotlight().attemptsTo(
              Click.on(CarritoPage.CART_BUTTON),
            WaitUntil.the(CarritoPage.VIEW_CART_LINK, isVisible()).forNoMoreThan(5).seconds(),
              Click.on(CarritoPage.VIEW_CART_LINK)
        );
      }
    */

    @Then("the user should see the product {string} in the cart list")
    public void theUserShouldSeeTheProductInTheCartList(String producto) {
        List<String> productosEnCarrito = CarritoPage.CART_PAGE_PRODUCT_NAMES
                .resolveAllFor(OnStage.theActorInTheSpotlight())
                .stream()
                .map(e -> e.getText().trim())
                .collect(Collectors.toList());

        assertThat("El carrito contiene el producto: " + producto,
                productosEnCarrito, hasItem(containsString(producto)));
    }

}
