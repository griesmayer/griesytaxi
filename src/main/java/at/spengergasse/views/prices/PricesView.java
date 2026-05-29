package at.spengergasse.views.prices;

import at.spengergasse.views.home.HomeView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
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

        VerticalLayout header = HomeView.getHeader();

        H2 pricelist = new H2("Price List");
        pricelist.getStyle()
                .set("margin", "0")
                .set("color", "gray");

        FlexLayout districts = new FlexLayout();
        VerticalLayout district1 = getCard("1050 Wien", 1.2, 1.7, 3.0);
        VerticalLayout district2 = getCard("1030 Wien", 1.4, 1.9, 3.0);
        VerticalLayout district3 = getCard("1080 Wien", 2.2, 2.7, 2.0);
        VerticalLayout district4 = getCard("1010 Wien", 2.9, 4.0, 5.0);
        VerticalLayout district5 = getCard("Rest Wien", 2.0, 2.4, 3.0);
        districts.setWidthFull();
        districts.setJustifyContentMode(JustifyContentMode.CENTER);
        districts.setFlexWrap(FlexLayout.FlexWrap.WRAP);
        districts.add(district1, district2, district3, district4, district5);

        Paragraph info = new Paragraph("Inklusive Steuer.");

        add(header, pricelist,
                districts,
                info);
    }

    public VerticalLayout getCard(String districtName, double priceDay, double priceNight, double priceOrder) {
        VerticalLayout district = new VerticalLayout();
        H2 districtNameH2 = new H2(districtName);
        Paragraph priceDayP = new Paragraph("Preis KM Tag: " + priceDay + "€");
        Paragraph priceNightP = new Paragraph("Preis KM Nacht: " + priceNight + "€");
        Paragraph priceEnterP = new Paragraph("Zusätzlich kommen noch " + priceOrder + "€ für die Bestellung dazu!");

        district.setWidth("350px");
        district.setPadding(true);
        district.setSpacing(false);
        district.getStyle()
                .set("border", "1px solid lightgray")
                .set("border-radius", "10px")
                .set("margin", "10px");
        district.add(districtNameH2, priceDayP, priceNightP, priceEnterP);

        return district;
    }

}
