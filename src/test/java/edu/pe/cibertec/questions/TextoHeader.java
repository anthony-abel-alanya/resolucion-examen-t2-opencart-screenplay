package edu.pe.cibertec.questions;

import edu.pe.cibertec.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TextoHeader implements Question<String> {

    public static TextoHeader mostrado() {
        return new TextoHeader();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(LoginPage.ACCOUNT_LINK).answeredBy(actor).trim();
    }

}
