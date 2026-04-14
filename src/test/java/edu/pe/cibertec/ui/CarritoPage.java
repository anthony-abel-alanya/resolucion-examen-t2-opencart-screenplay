package edu.pe.cibertec.ui;

import net.serenitybdd.screenplay.targets.Target;

public class CarritoPage {


    // Header - buscador
    public static final Target SEARCH_INPUT =
            Target.the("search input")
                    .locatedBy("//input[@name='search']");

    public static final Target SEARCH_BUTTON =
            Target.the("search button")
                    .locatedBy("#search button");


    public static final Target ADD_TO_CART_BUTTON =
            Target.the("add to cart button")
                    .locatedBy("//button[@onclick and contains(@onclick,'cart.add')]");

    // Contador del carrito
    public static final Target CART_COUNTER =
            Target.the("cart counter")
                    .locatedBy("#cart-total");

    // Nombres de productos en la tabla
    public static final Target CART_PAGE_PRODUCT_NAMES =
            Target.the("product names in cart")
                    .locatedBy("#content .table-responsive table tbody tr td:nth-child(2) a");

}



