package at.spengergasse.service;

import at.spengergasse.domain.TaxiDrive;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class TaxiDriveService {
    private ArrayList<TaxiDrive> taxiDrives;

    public TaxiDriveService() {
        taxiDrives = new ArrayList<>(1000);
        fillTestData();
    }

    public void fillTestData() {
        taxiDrives.add(new TaxiDrive(LocalDate.of(2025, 1, 5),  "Mayer",      "Small",   12.50, 1, false));
        taxiDrives.add(new TaxiDrive(LocalDate.of(2025, 1, 6),  "Huber",      "Medium",  18.00, 2, false));
        taxiDrives.add(new TaxiDrive(LocalDate.of(2025, 1, 7),  "Gruber",     "Regular", 25.30, 3, true));
        taxiDrives.add(new TaxiDrive(LocalDate.of(2025, 1, 8),  "Wagner",     "VAN",     40.00, 6, false));
        taxiDrives.add(new TaxiDrive(LocalDate.of(2025, 1, 9),  "Bauer",      "Small",    9.80, 1, false));
        taxiDrives.add(new TaxiDrive(LocalDate.of(2025, 1, 10), "Hofer",      "Medium",  16.40, 2, true));
        taxiDrives.add(new TaxiDrive(LocalDate.of(2025, 1, 11), "Eder",       "Regular", 22.10, 4, false));
        taxiDrives.add(new TaxiDrive(LocalDate.of(2025, 1, 12), "Schmid",     "VAN",     35.70, 5, true));
        taxiDrives.add(new TaxiDrive(LocalDate.of(2025, 1, 13), "Pichler",    "Small",   11.20, 1, false));
        taxiDrives.add(new TaxiDrive(LocalDate.of(2025, 1, 14), "Leitner",    "Medium",  19.90, 2, false));

        taxiDrives.add(new TaxiDrive(LocalDate.of(2025, 1, 15), "Fuchs",      "Regular", 28.60, 3, true));
        taxiDrives.add(new TaxiDrive(LocalDate.of(2025, 1, 16), "Moser",      "VAN",     45.20, 7, true));
        taxiDrives.add(new TaxiDrive(LocalDate.of(2025, 1, 17), "Koller",     "Small",   13.10, 1, false));
        taxiDrives.add(new TaxiDrive(LocalDate.of(2025, 1, 18), "Winter",     "Medium",  17.50, 2, false));
        taxiDrives.add(new TaxiDrive(LocalDate.of(2025, 1, 19), "Steiner",    "Regular", 24.80, 4, true));
        taxiDrives.add(new TaxiDrive(LocalDate.of(2025, 1, 20), "Lang",       "VAN",     38.40, 6, false));
        taxiDrives.add(new TaxiDrive(LocalDate.of(2025, 1, 21), "Brunner",    "Small",   10.90, 1, false));
        taxiDrives.add(new TaxiDrive(LocalDate.of(2025, 1, 22), "Auer",       "Medium",  21.30, 3, true));
        taxiDrives.add(new TaxiDrive(LocalDate.of(2025, 1, 23), "Egger",      "Regular", 27.70, 4, false));
        taxiDrives.add(new TaxiDrive(LocalDate.of(2025, 1, 24), "Berger",     "VAN",     42.50, 8, true));

        taxiDrives.add(new TaxiDrive(LocalDate.of(2025, 1, 25), "Schwarz",    "Small",   14.20, 2, false));
        taxiDrives.add(new TaxiDrive(LocalDate.of(2025, 1, 26), "Hartmann",   "Medium",  20.60, 3, true));
        taxiDrives.add(new TaxiDrive(LocalDate.of(2025, 1, 27), "Kranz",      "Regular", 23.40, 2, false));
        taxiDrives.add(new TaxiDrive(LocalDate.of(2025, 1, 28), "Mayr",       "VAN",     39.90, 5, false));
        taxiDrives.add(new TaxiDrive(LocalDate.of(2025, 1, 29), "Neumann",    "Small",   12.80, 1, true));
        taxiDrives.add(new TaxiDrive(LocalDate.of(2025, 1, 30), "Seidl",      "Medium",  18.70, 2, false));
        taxiDrives.add(new TaxiDrive(LocalDate.of(2025, 1, 31), "Zimmermann", "Regular", 26.90, 4, true));
        taxiDrives.add(new TaxiDrive(LocalDate.of(2025, 2, 1),  "Kraus",      "VAN",     47.30, 7, true));
        taxiDrives.add(new TaxiDrive(LocalDate.of(2025, 2, 2),  "Jäger",      "Small",   11.70, 1, false));
        taxiDrives.add(new TaxiDrive(LocalDate.of(2025, 2, 3),  "Graf",       "Regular", 29.50, 4, true));
    }

    public ArrayList<TaxiDrive> findAll() {
        ArrayList<TaxiDrive> clone;
        clone = new ArrayList<>(taxiDrives);
        return clone;
    }

    @Override
    public String toString() {
        String erg = "";

        for (TaxiDrive t : taxiDrives) {
            erg += t.toString() + "\n";
        }
        return erg;
    }

    /*
    public String toString() {
        return taxiDrives.stream()
                .map(d -> d.toString())
                .collect(Collectors.joining("\n"));
    }*/
}
