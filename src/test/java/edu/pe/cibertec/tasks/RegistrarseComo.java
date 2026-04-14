package edu.pe.cibertec.tasks;

import edu.pe.cibertec.ui.RegistroPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;

public class RegistrarseComo implements Task {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phone;
    private final String password;

    public RegistrarseComo(String firstName, String lastName,
                           String email, String phone, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public static RegistrarseComo conDatos(String firstName, String lastName,
                                           String email, String phone, String password) {
        return Tasks.instrumented(
                RegistrarseComo.class,
                firstName, lastName, email, phone, password
        );
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(firstName).into(RegistroPage.FIRST_NAME),
                Enter.theValue(lastName).into(RegistroPage.LAST_NAME),
                Enter.theValue(email).into(RegistroPage.EMAIL),
                Enter.theValue(phone).into(RegistroPage.TELEPHONE),
                Enter.theValue(password).into(RegistroPage.PASSWORD),
                Enter.theValue(password).into(RegistroPage.CONFIRM_PASSWORD)

        );
    }

}
