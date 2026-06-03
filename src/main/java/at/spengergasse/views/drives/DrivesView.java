package at.spengergasse.views.drives;

import at.spengergasse.domain.TaxiDrive;
import at.spengergasse.service.TaxiDriveService;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Drives")
@Route("drives")
@Menu(order = 1, icon = LineAwesomeIconUrl.FILE)
public class DrivesView extends VerticalLayout {
    private final Button buttonRemoveAllDrives = new Button("Remove all");
    private final Button buttonAdd10Drives = new Button("Add 10 drives");
    private final Button buttonAdd1Euro = new Button("Add 1 EUR");
    private final Button buttonRemoveAllNightDrives = new Button("Remove night drives");
    private final Grid<TaxiDrive> grid = new Grid<>(TaxiDrive.class, true);
    private final TaxiDriveService taxiDriveService;

    public DrivesView(@Autowired TaxiDriveService taxiDriveService) {
        this.taxiDriveService = taxiDriveService;

        setSpacing(true);
        setSizeFull();
        grid.setSizeFull();

        buttonRemoveAllDrives.addClickListener(event -> removeAllDrives());
        buttonAdd10Drives.addClickListener( event -> add10Drives());
        buttonAdd1Euro.addClickListener( event -> add1Euro());
        buttonRemoveAllNightDrives.addClickListener(event -> removeAllNightDrives());
        add(new HorizontalLayout(buttonRemoveAllDrives, buttonAdd10Drives, buttonAdd1Euro, buttonRemoveAllNightDrives));

        add(grid);
        reload();
    }

    private void removeAllNightDrives() {
        taxiDriveService.removeAllNightDrives();
        reload();
    }

    private void add1Euro() {
        taxiDriveService.add1Euro();
        reload();
    }

    private void add10Drives() {
        taxiDriveService.add10Drives();
        buttonRemoveAllDrives.setEnabled(true);
        buttonRemoveAllNightDrives.setEnabled(true);
        reload();
    }

    private void removeAllDrives() {
        taxiDriveService.removeAllDrives();
        buttonRemoveAllDrives.setEnabled(false);
        buttonRemoveAllNightDrives.setEnabled(false);
        reload();
    }

    private void reload() {
        grid.setItems(taxiDriveService.findAll());
    }
}
