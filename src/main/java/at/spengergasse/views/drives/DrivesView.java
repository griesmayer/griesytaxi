package at.spengergasse.views.drives;

import at.spengergasse.domain.TaxiDrive;
import at.spengergasse.domain.TaxiDriveException;
import at.spengergasse.service.TaxiDriveService;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import jakarta.validation.constraints.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.lineawesome.LineAwesomeIconUrl;
import tools.jackson.databind.ser.std.DelegatingSerializer;

import java.time.LocalDate;

@PageTitle("Drives")
@Route("drives")
@Menu(order = 1, icon = LineAwesomeIconUrl.FILE)
public class DrivesView extends VerticalLayout {
    private final Button buttonRemoveAllDrives = new Button("Remove all");
    private final Button buttonAdd10Drives = new Button("Add 10 drives");
    private final Button buttonAdd1Euro = new Button("Add 1 EUR");
    private final Button buttonRemoveAllNightDrives = new Button("Remove night drives");
    private final Button buttonAddWrong = new Button("Add WRONG");
    private final Button buttonAdd1Drive = new Button("Add Drive");
    private final Grid<TaxiDrive> grid = new Grid<>(TaxiDrive.class, false);
    private final TaxiDriveService taxiDriveService;

    public DrivesView(@Autowired TaxiDriveService taxiDriveService) {
        this.taxiDriveService = taxiDriveService;

        setSpacing(true);
        setSizeFull();
        grid.setSizeFull();

        buttonRemoveAllDrives.addClickListener(event -> removeAllDrives());
        buttonAdd10Drives.addClickListener(event -> add10Drives());
        buttonAdd1Euro.addClickListener(event -> add1Euro());
        buttonRemoveAllNightDrives.addClickListener(event -> removeAllNightDrives());
        buttonAddWrong.addClickListener(event -> addWrongDrive());
        buttonAdd1Drive.addClickListener(event -> add1Drive());
        add(new HorizontalLayout(buttonRemoveAllDrives, buttonAdd10Drives, buttonAdd1Euro, buttonRemoveAllNightDrives, buttonAddWrong, buttonAdd1Drive));

        grid.addColumn(drive -> drive.getTaxiDriveId())
            .setHeader("Drive ID")
            .setSortable(true);
        grid.addColumn(drive -> drive.getTaxiDriveDate())
            .setHeader("Drive Date")
            .setSortable(true);
        grid.addColumn(drive -> drive.getCustomerName())
            .setHeader("Customer Name")
            .setSortable(true);

        Image l = new Image("icons/taxi.png", "Taxi logo");
        l.setWidth("32px");
        HorizontalLayout headerType = new HorizontalLayout(l, new Span("Type"));
        grid.addColumn(drive -> drive.getTaxiType())
            .setHeader(headerType)
            .setSortable(true);

        grid.addColumn(drive -> drive.getPrice())
            .setHeader("Price EUR")
            .setSortable(true);
        grid.addColumn(drive -> drive.getNumberPassangers())
            .setHeader("Passangers")
            .setSortable(true);
        grid.addColumn(drive -> drive.getNightDrive())
            .setHeader("Night Drive")
            .setSortable(true);
        grid.addColumn(drive -> {
                    if (drive.getNightDrive() == true)
                            return "Night";
                    else
                        return "Day";
                })
            .setHeader("Drive Time")
            .setSortable(true);
        grid.addColumn(drive -> (drive.getNightDrive() == true)? "Night" : "Day")
            .setHeader("Drive Time")
            .setSortable(true);
        grid.addComponentColumn(drive -> {
                    Checkbox night = new Checkbox(drive.getNightDrive());
                    night.setReadOnly(true);
                    return night;
                 })
            .setHeader("Night drive")
            .setSortable(true);
        grid.addComponentColumn(drive -> {
                    Button delete = new Button("Delete");
                    delete.addClickListener(e -> remove1Drive(drive.getTaxiDriveId()));
                    return delete;
        })
            .setHeader("Action")
            .setSortable(false);

        grid.addComponentColumn(drive -> {
                    Button add1Passanger = new Button("Add 1 Passanger");
                    add1Passanger.addClickListener(e-> add1Passanger(drive.getTaxiDriveId()));
                    return add1Passanger;
        })
            .setHeader("Action")
            .setSortable(false);


        add(grid);
        reload();
    }

    private void add1Drive() {
        Dialog dialog;

        dialog = new Dialog();
        dialog.setHeaderTitle("Add 1 Taxi drive");

        TextField  taxiDriveId = new TextField("Taxi Drive ID");
        DatePicker taxiDriveDate = new DatePicker("Drive date");
        TextField  customerName = new TextField("Customer name");
        ComboBox   taxiType = new ComboBox("Taxi type");
        taxiType.setItems("Small", "Medium", "Regular", "VAN");
        NumberField price = new NumberField("Price");
        IntegerField numberPassangers = new IntegerField("Number of passangers");
        Checkbox nightDrive = new Checkbox("Night drive");

        BeanValidationBinder<TaxiDrive> binder = new BeanValidationBinder<>(TaxiDrive.class);
        binder.forField(taxiDriveDate)
                .bind("taxiDriveDate");
        binder.forField(customerName)
                .bind("customerName");
        binder.forField(taxiType)
                .bind("taxiType");
        binder.forField(price)
                .bind("price");
        binder.forField(numberPassangers)
                .bind("numberPassangers");
        binder.forField(nightDrive)
                .bind("nightDrive");

        TaxiDrive drive = new TaxiDrive();
        binder.setBean(drive);

        taxiDriveId.setValue(""+drive.getTaxiDriveId());
        taxiDriveId.setReadOnly(true);

        VerticalLayout formLaout = new VerticalLayout(
                taxiDriveId,
                taxiDriveDate,
                customerName,
                taxiType,
                price,
                numberPassangers,
                nightDrive
        );

        Button buttonOK = new Button("OK");
        Button buttonCancel = new Button("Cancel");

        buttonOK.addClickListener(event -> {
            try {
                if (binder.validate().isOk() == true) {
                    taxiDriveService.add1Drive(drive);
                    dialog.close();
                    reload();
                    Notification.show("New drive added");
                }
                else {
                    Notification.show("Check your input!");
                }
            }
            catch (TaxiDriveException e) {
                Notification.show(e.getMessage());
            }
        });
        buttonCancel.addClickListener(event -> dialog.close());

        dialog.add(formLaout);
        dialog.getFooter().add(buttonOK, buttonCancel);
        dialog.open();
    }

    private void add1Passanger(Long taxiDriveId) {
        try {
            taxiDriveService.add1Passanger(taxiDriveId);
            reload();
        }
        catch (TaxiDriveException e) {
            Notification.show(e.getMessage());
        }
    }

    private void remove1Drive(Long taxiDriveId) {
        try {
            taxiDriveService.remove1Drive(taxiDriveId);
            reload();
        }
        catch (TaxiDriveException e) {
            Notification.show(e.getMessage());
        }
    }

    private void addWrongDrive() {
        try {
            taxiDriveService.addWrongDrive();
            reload();
        }
        catch (TaxiDriveException e) {
            Notification.show(e.getMessage());
            reload();
        }
    }

    private void removeAllNightDrives() {
        try {
            taxiDriveService.removeAllNightDrives();
            reload();
        }
        catch (TaxiDriveException e) {
            Notification.show(e.getMessage());
            reload();
        }
    }

    private void add1Euro() {
        try {
            taxiDriveService.add1Euro();
            reload();
        } catch (TaxiDriveException e) {
            Notification.show(e.getMessage());
            reload();
        }
    }

    private void add10Drives() {
        try {
            taxiDriveService.add10Drives();
            buttonRemoveAllDrives.setEnabled(true);
            buttonRemoveAllNightDrives.setEnabled(true);
            reload();
        }
        catch (TaxiDriveException e) {
            Notification.show(e.getMessage());
            reload();
        }
    }

    private void removeAllDrives() {
        try {
            taxiDriveService.removeAllDrives();
            buttonRemoveAllDrives.setEnabled(false);
            buttonRemoveAllNightDrives.setEnabled(false);
            reload();
        }
        catch (TaxiDriveException e) {
            Notification.show(e.getMessage());
            reload();
        }
    }

    private void reload() {
        grid.setItems(taxiDriveService.findAll());
    }
}
