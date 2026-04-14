package edu.pe.cibertec.questions;
import edu.pe.cibertec.ui.CarritoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

@Subject("Contador carrito - header")
public class ContadorDelCarrito implements Question<String> {

    public static ContadorDelCarrito enElHeader() {
        return new ContadorDelCarrito();
    }

    @Override
    public String answeredBy(Actor actor) {

        //OpenCart actualiza - pausa - cambie el contador
        String cartText = "";
        int maxAttempts = 10;

        for (int i = 0; i < maxAttempts; i++) {
            cartText = CarritoPage.CART_COUNTER
                    .resolveFor(actor)
                    .getText()
                    .trim();
        //Contador actualizado
            if (!cartText.startsWith("0 item")) {
                break;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        // Retorna item
        if (cartText.contains(" - ")) {
            return cartText.split(" - ")[0].trim();
        }
        return cartText;
    }
}




