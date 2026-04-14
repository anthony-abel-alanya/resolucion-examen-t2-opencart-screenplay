package edu.pe.cibertec.tasks;
import edu.pe.cibertec.ui.CarritoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class AgregarAlCarrito implements Task {

    private final String nombreProducto;

    public AgregarAlCarrito(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    // instrumented() permite que Serenity registre la tarea correctamente en reportes
    public static AgregarAlCarrito elProducto(String nombreProducto) {
        return instrumented(AgregarAlCarrito.class, nombreProducto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(nombreProducto).into(CarritoPage.SEARCH_INPUT),
                Click.on(CarritoPage.SEARCH_BUTTON),
                // WaitUntil evita Thread.sleep — espera real al elemento
                WaitUntil.the(CarritoPage.ADD_TO_CART_BUTTON, isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(CarritoPage.ADD_TO_CART_BUTTON)
        );
    }

}
