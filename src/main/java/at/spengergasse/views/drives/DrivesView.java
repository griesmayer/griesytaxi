package at.spengergasse.views.drives;

import at.spengergasse.domain.TaxiDrive;
import at.spengergasse.service.TaxiDriveService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
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
    private final Grid<TaxiDrive> grid = new Grid<>(TaxiDrive.class, true);
    private final TaxiDriveService taxiDriveService;

    public DrivesView(@Autowired TaxiDriveService taxiDriveService) {
        this.taxiDriveService = taxiDriveService;

        setSpacing(true);
        setSizeFull();
        grid.setSizeFull();
        add(grid);
        reload();
    }

    private void reload() {
        grid.setItems(taxiDriveService.findAll());
    }


}
