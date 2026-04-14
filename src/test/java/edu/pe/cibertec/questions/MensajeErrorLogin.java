package edu.pe.cibertec.questions;

import edu.pe.cibertec.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class MensajeErrorLogin implements Question<String> {

    public static MensajeErrorLogin mostrado() {
        return new MensajeErrorLogin();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(LoginPage.ERROR_MESSAGE).answeredBy(actor).trim();
    }

}
