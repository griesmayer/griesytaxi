package at.spengergasse.views.prices;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Prices")
@Route("prices")
@Menu(order = 2, icon = LineAwesomeIconUrl.FILE)
public class PricesView extends VerticalLayout {

    public PricesView() {
        setSpacing(false);

        H1 company = new H1("Griesy Taxi");
        company.getStyle()
                .set("font-family", "cursive")
                .set("font-size", "6rem")
                .set("margin", "0");

        H2 subName = new H2("... the best taxi in town ...");
        subName.getStyle()
                .set("margin", "0")
                .set("color", "gray");

        H2 pricelist = new H2("Price List");
        pricelist.getStyle()
                .set("margin", "0")
                .set("color", "gray");

        H2 district1 = new H2("1050 Wien");
        Paragraph priceDay1 = new Paragraph("Preis KM Tag: 1.20€");
        Paragraph priceNight1 = new Paragraph("Preis KM Nacht: 1.70€");
        Paragraph priceEnter1 = new Paragraph("Zusätzlich kommen noch 3.00€ für die Bestellung dazu!");

        H2 district2 = new H2("1030 Wien");
        Paragraph priceDay2 = new Paragraph("Preis KM Tag: 1.40€");
        Paragraph priceNight2 = new Paragraph("Preis KM Nacht: 1.90€");
        Paragraph priceEnter2 = new Paragraph("Zusätzlich kommen noch 3.00€ für die Bestellung dazu!");

        H2 district3 = new H2("1080 Wien");
        Paragraph priceDay3 = new Paragraph("Preis KM Tag: 2.20€");
        Paragraph priceNight3 = new Paragraph("Preis KM Nacht: 2.70€");
        Paragraph priceEnter3 = new Paragraph("Zusätzlich kommen noch 2.00€ für die Bestellung dazu!");

        H2 district4 = new H2("1010 Wien");
        Paragraph priceDay4 = new Paragraph("Preis KM Tag: 2.90€");
        Paragraph priceNight4 = new Paragraph("Preis KM Nacht: 4.00€");
        Paragraph priceEnter4 = new Paragraph("Zusätzlich kommen noch 5.00€ für die Bestellung dazu!");

        H2 district5 = new H2("Rest Wien");
        Paragraph priceDay5 = new Paragraph("Preis KM Tag: 2.00€");
        Paragraph priceNight5 = new Paragraph("Preis KM Nacht: 2.40€");
        Paragraph priceEnter5 = new Paragraph("Zusätzlich kommen noch 3.00€ für die Bestellung dazu!");

        add(company, subName, pricelist,
                district1, priceDay1, priceNight1, priceEnter1,
                district2, priceDay2, priceNight2, priceEnter2,
                district3, priceDay3, priceNight3, priceEnter3,
                district4, priceDay4, priceNight4, priceEnter4,
                district5, priceDay5, priceNight5, priceEnter5);
    }

}
