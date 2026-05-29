package at.spengergasse.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TaxiDriveTest {
    @Test
    void testWrongPrice() {
        TaxiDrive a = null;
        try {
            a = new TaxiDrive(LocalDate.now(), "Thomas", "Regular", 1.0, 3, false);
            System.out.println(a);
            assertEquals(1,0);
        }
        catch (TaxiDriveException e) {
            System.out.println(e.getMessage());
            assertEquals(1,1);
        }
    }


    @Test
    void testToString() {
        TaxiDrive a = null;
        try {
            a = new TaxiDrive(LocalDate.now(), "Thomas", "Regular", 12.0, 3, false);
            System.out.println(a);
            System.out.println(a.getTaxiDriveDate());
            System.out.println(a.getCustomerName());
            a.setCustomerName("Susi");
            System.out.println(a.getCustomerName());
        }
        catch (TaxiDriveException e) {
            System.out.println(e.getMessage());
        }
    }
}