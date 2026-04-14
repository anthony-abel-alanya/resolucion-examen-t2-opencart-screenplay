package edu.pe.cibertec.ui;


import net.serenitybdd.screenplay.targets.Target;

public class BusquedaPage {

    public static final Target SEARCH_BOX =
            Target.the("search input")
                    .locatedBy("//input[@name='search']");

    public static final Target SEARCH_BUTTON =
            Target.the("search button")
                    .locatedBy("#search button");

    public static final Target PRODUCT_TITLES =
            Target.the("product titles")
                    .locatedBy(".product-layout h4 a");

    public static final Target NO_RESULTS_MESSAGE =
            Target.the("no results message")
                    .locatedBy("//div[@id='content']//p[contains(text(),'There is no product')]");
}
