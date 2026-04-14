package edu.pe.cibertec.questions;

import edu.pe.cibertec.ui.BusquedaPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import java.util.List;

@Subject("resultados de búsqueda")
public class ResultadosDeBusqueda implements Question<List<String>> {

    public static ResultadosDeBusqueda productos() {
        return new ResultadosDeBusqueda();
    }

    @Override
    public List<String> answeredBy(Actor actor) {
        return BusquedaPage.PRODUCT_TITLES
                .resolveAllFor(actor)
                .stream()
                .map(e -> e.getText().trim())
                .toList();
    }
}
