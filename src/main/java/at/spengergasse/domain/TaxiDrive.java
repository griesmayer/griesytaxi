package at.spengergasse.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private LocalDate taxiDriveDate;
    private String    customerName;
    private String    taxiType;
    private Double    price;
    private Integer   numberPassangers;
    private Boolean   nightDrive;

    private static final AtomicLong sequence = new AtomicLong(1000);
    private static final String[] taxiTypes = {"Small", "Medium", "Regular", "VAN"};

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
        if (! Arrays.asList(taxiTypes).contains(taxiType) )
            throw new TaxiDriveException("Unkn taxi type!");
        this.taxiType = taxiType;
    }

    @Override
    public TaxiDrive clone() {
        return new TaxiDrive(taxiDriveId, taxiDriveDate, customerName, taxiType, price, numberPassangers, nightDrive);
    }
}
