package at.spengergasse.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

@Getter
@Setter
@ToString
//@NoArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode(of = "taxiDriveId", callSuper = false)
@Entity
public class TaxiDrive {
    @Id
    private Long      taxiDriveId;
    @NotNull(message = "Taxi drive date is required!")
    @PastOrPresent(message = "Taxi drive only in the past or present!")
    private LocalDate taxiDriveDate;
    @NotBlank(message = "Customer name date is required!")
    @Size(min=3, max=100, message = "Wrong name!")
    private String    customerName;
    @NotNull(message = "Taxi type is required!")
    @Pattern(
            regexp = "Small|Medium|Regular|VAN",
            message = "Type must be Small, Medium,Regular or VAN"
    )
    private String    taxiType;
    @NotNull(message = "Price is required!")
    @DecimalMin(value = "5.0", message = "Min 5 EUR!")
    @DecimalMax(value = "50.0", message = "Max price 50 EUR!")
    private Double    price;
    @NotNull(message = "Number of passangers is required!")
    @Min(value = 1, message = "Min 1 passanger")
    private Integer   numberPassangers;
    @NotNull(message = "Day time is required!")
    private Boolean   nightDrive;

    private static final AtomicLong sequence = new AtomicLong(1000);

    public TaxiDrive() {
    }

    public TaxiDrive(LocalDate taxiDriveDate, String customerName, String taxiType, Double price, Integer numberPassangers, Boolean nightDrive) {
        setTaxiDriveId();
        setTaxiDriveDate (taxiDriveDate);
        setCustomerName (customerName);
        setTaxiType (taxiType);
        setPrice (price);
        setNumberPassangers (numberPassangers);
        setNightDrive (nightDrive);
    }

    public TaxiDrive(Long taxiDriveId, LocalDate taxiDriveDate, String customerName, String taxiType, Double price, Integer numberPassangers, Boolean nightDrive) {
        setTaxiDriveId(taxiDriveId);
        setTaxiDriveDate (taxiDriveDate);
        setCustomerName (customerName);
        setTaxiType (taxiType);
        setPrice (price);
        setNumberPassangers (numberPassangers);
        setNightDrive (nightDrive);
    }

    public void setTaxiDriveId() {
        taxiDriveId = sequence.getAndIncrement();
    }

    public void setPrice(Double price) {
        if (price < 7)
            throw new TaxiDriveException("Price is to low!");
        if (price > 140)
            throw new TaxiDriveException("Price is to high");
        this.price = price;
    }

    public void setTaxiTypes(String taxiType) {
        this.taxiType = taxiType;
    }

    public Long getTaxiDriveId() {
        return taxiDriveId;
    }

    public void setTaxiDriveId(Long taxiDriveId) {
        this.taxiDriveId = taxiDriveId;
    }

    public LocalDate getTaxiDriveDate() {
        return taxiDriveDate;
    }

    public void setTaxiDriveDate(LocalDate taxiDriveDate) {
        this.taxiDriveDate = taxiDriveDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTaxiType() {
        return taxiType;
    }

    public void setTaxiType(String taxiType) {
        this.taxiType = taxiType;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getNumberPassangers() {
        return numberPassangers;
    }

    public void setNumberPassangers(Integer numberPassangers) {
        this.numberPassangers = numberPassangers;
    }

    public Boolean getNightDrive() {
        return nightDrive;
    }

    public void setNightDrive(Boolean nightDrive) {
        this.nightDrive = nightDrive;
    }

    @Override
    public TaxiDrive clone() {
        return new TaxiDrive(taxiDriveId, taxiDriveDate, customerName, taxiType, price, numberPassangers, nightDrive);
    }
}
