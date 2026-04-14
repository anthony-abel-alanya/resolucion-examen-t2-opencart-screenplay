package edu.pe.cibertec.tasks;

import edu.pe.cibertec.ui.BusquedaPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BuscarProducto implements Task {

    private final String producto;

    public BuscarProducto(String producto) {
        this.producto = producto;
    }

    public static BuscarProducto llamado(String producto) {
        return instrumented(BuscarProducto.class, producto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Enter.theValue(producto).into(BusquedaPage.SEARCH_BOX),
                Click.on(BusquedaPage.SEARCH_BUTTON)
        );
    }

}
