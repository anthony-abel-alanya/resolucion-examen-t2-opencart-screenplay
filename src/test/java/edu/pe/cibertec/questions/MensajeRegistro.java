package edu.pe.cibertec.questions;

import edu.pe.cibertec.ui.RegistroPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class MensajeRegistro implements Question<String> {

    public static MensajeRegistro mostrado() {
        return new MensajeRegistro();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(RegistroPage.SUCCESS_MESSAGE).answeredBy(actor).trim();
    }

}
