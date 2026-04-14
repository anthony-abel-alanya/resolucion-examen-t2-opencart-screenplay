package edu.pe.cibertec.questions;

import edu.pe.cibertec.ui.BusquedaPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class MensajeNoResultados implements Question<String> {

    public static MensajeNoResultados mostrado() {
        return new MensajeNoResultados();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(BusquedaPage.NO_RESULTS_MESSAGE)
                .answeredBy(actor)
                .trim();
    }
}
