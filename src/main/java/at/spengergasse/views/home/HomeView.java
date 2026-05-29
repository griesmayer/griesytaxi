package at.spengergasse.views.home;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Home")
@Route("")
@Menu(order = 0, icon = LineAwesomeIconUrl.GLOBE_SOLID)
public class HomeView extends VerticalLayout {

    private TextField name;
    private Button sayHello;

    public HomeView() {
        setSpacing(false);
        setAlignItems(Alignment.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        VerticalLayout header = getHeader();

        HorizontalLayout logoText = new HorizontalLayout();
        Image logo = new Image("images/logo.png", "Griesy Taxi Logo");
        logo.setWidth("800px");
        Paragraph line1 = new Paragraph("Griesy Taxi steht für zuverlässigen, komfortablen und pünktlichen Fahrservice. Unser Unternehmen bietet sichere und angenehme Fahrten für Privatpersonen, Geschäftsreisende und Touristen. Egal ob kurze Strecken innerhalb der Stadt oder längere Fahrten – bei Griesy Taxi stehen Kundenzufriedenheit, Freundlichkeit und Professionalität immer an erster Stelle.");
        line1.setWidth("500px");
        line1.getStyle()
                .set("font-size", "22px")
                .set("line-height", "1.6")
                .set("text-align", "left");
        logoText.add(logo, line1);

        Paragraph line2 = new Paragraph("Mit modernen Fahrzeugen und erfahrenen Fahrern sorgt Griesy Taxi für eine entspannte und stressfreie Mobilität. Wir legen großen Wert auf Sauberkeit, Sicherheit und einen erstklassigen Service. Unsere Kunden profitieren von flexiblen Fahrzeiten, fairen Preisen und einer unkomplizierten Buchung. ");
        line2.setWidth("500px");
        line2.getStyle()
                .set("font-size", "22px")
                .set("line-height", "1.6")
                .set("text-align", "left");

        Paragraph line3 = new Paragraph("Griesy Taxi ist mehr als nur ein Fahrdienst – wir sind Ihr verlässlicher Partner für jede Fahrt. Ob Flughafentransfer, Geschäftsreise, Krankenhausfahrt oder spontaner Transport: Wir bringen Sie sicher und bequem an Ihr Ziel. Vertrauen Sie auf Qualität, Erfahrung und persönlichen Service mit Griesy Taxi.");
        line3.setWidth("500px");
        line3.getStyle()
                .set("font-size", "22px")
                .set("line-height", "1.6")
                .set("text-align", "left");

        HorizontalLayout address = new HorizontalLayout();
        H3 name = new H3("Griesy Taxi GmbH");
        H3 street = new H3("Spengergasse 20");
        H3 city = new H3("1050 Wien");
        address.add(name, street, city);

        add(header, logoText, line2, line3, address);
    }

    public static VerticalLayout getHeader() {
        VerticalLayout header;

        header = new VerticalLayout();

        H1 company = new H1("Griesy Taxi");
        company.getStyle()
                .set("font-family", "cursive")
                .set("font-size", "6rem")
                .set("margin", "0");

        H2 subName = new H2("... the best taxi in town ...");
        subName.getStyle()
                .set("margin", "0")
                .set("color", "gray");

        header.add(company, subName);

        return header;
    }

}
