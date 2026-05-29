package at.spengergasse.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaxiDriveServiceTest {

    @Test
    void testToString() {
        TaxiDriveService griesy = new TaxiDriveService();
        griesy.fillTestData();
        System.out.println(griesy);
    }
}