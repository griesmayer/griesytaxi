package at.spengergasse.service;

import at.spengergasse.domain.TaxiDrive;
import at.spengergasse.domain.TaxiDriveException;
import at.spengergasse.repository.TaxiDriveRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;

@Service
public class TaxiDriveService {
    private final TaxiDriveRepository repository;

    public TaxiDriveService(TaxiDriveRepository repository) {
        this.repository = repository;
        if (repository.count() == 0)
            fillTestData();
    }

    public void fillTestData() {
        repository.save(new TaxiDrive(LocalDate.of(2025, 1, 5),  "Mayer",      "Small",   12.50, 1, false));
        repository.save(new TaxiDrive(LocalDate.of(2025, 1, 6),  "Huber",      "Medium",  18.00, 2, false));
        repository.save(new TaxiDrive(LocalDate.of(2025, 1, 7),  "Gruber",     "Regular", 25.30, 3, true));
        repository.save(new TaxiDrive(LocalDate.of(2025, 1, 8),  "Wagner",     "VAN",     40.00, 6, false));
        repository.save(new TaxiDrive(LocalDate.of(2025, 1, 9),  "Bauer",      "Small",    9.80, 1, false));
        repository.save(new TaxiDrive(LocalDate.of(2025, 1, 10), "Hofer",      "Medium",  16.40, 2, true));
        repository.save(new TaxiDrive(LocalDate.of(2025, 1, 11), "Eder",       "Regular", 22.10, 4, false));
        repository.save(new TaxiDrive(LocalDate.of(2025, 1, 12), "Schmid",     "VAN",     35.70, 5, true));
        repository.save(new TaxiDrive(LocalDate.of(2025, 1, 13), "Pichler",    "Small",   11.20, 1, false));
        repository.save(new TaxiDrive(LocalDate.of(2025, 1, 14), "Leitner",    "Medium",  19.90, 2, false));
        repository.save(new TaxiDrive(LocalDate.of(2025, 1, 15), "Fuchs",      "Regular", 28.60, 3, true));
        repository.save(new TaxiDrive(LocalDate.of(2025, 1, 16), "Moser",      "VAN",     45.20, 7, true));
    }

    public ArrayList<TaxiDrive> findAll() {
        ArrayList<TaxiDrive> clone;
        clone = (ArrayList<TaxiDrive>) repository.findAll();
        return clone;
    }

    @Override
    public String toString() {
        String erg = "";

        for (TaxiDrive t : repository.findAll()) {
            erg += t.toString() + "\n";
        }
        return erg;
    }

    public void removeAllDrives() {
        repository.deleteAll();
    }

    public void add10Drives() {
        repository.save(new TaxiDrive(LocalDate.of(2025, 1, 5),  "Mayer",      "Small",   12.50, 1, false));
        repository.save(new TaxiDrive(LocalDate.of(2025, 1, 6),  "Huber",      "Medium",  18.00, 2, false));
        repository.save(new TaxiDrive(LocalDate.of(2025, 1, 7),  "Gruber",     "Regular", 25.30, 3, true));
        repository.save(new TaxiDrive(LocalDate.of(2025, 1, 8),  "Wagner",     "VAN",     40.00, 6, false));
        repository.save(new TaxiDrive(LocalDate.of(2025, 1, 9),  "Bauer",      "Small",    9.80, 1, false));
        repository.save(new TaxiDrive(LocalDate.of(2025, 1, 10), "Hofer",      "Medium",  16.40, 2, true));
        repository.save(new TaxiDrive(LocalDate.of(2025, 1, 11), "Eder",       "Regular", 22.10, 4, false));
        repository.save(new TaxiDrive(LocalDate.of(2025, 1, 12), "Schmid",     "VAN",     35.70, 5, true));
        repository.save(new TaxiDrive(LocalDate.of(2025, 1, 13), "Pichler",    "Small",   11.20, 1, false));
        repository.save(new TaxiDrive(LocalDate.of(2025, 1, 14), "Leitner",    "Medium",  19.90, 2, false));
    }

    public void add1Euro() {
        for (TaxiDrive t : repository.findAll()) {
            t.setPrice(t.getPrice() + 1);
            repository.save(t);
        }
    }

    public void removeAllNightDrives() {
        for (TaxiDrive t: repository.findAll()) {
            if (t.getNightDrive() == true) {
                repository.deleteById(t.getTaxiDriveId());
            }
        }
    }

    public void addWrongDrive() {
        repository.save(new TaxiDrive(LocalDate.of(2025, 1, 5),  "Mayer",      "Small",   -5.0, 1, false));
    }

    public void remove1Drive(Long taxiDriveId) {
        /*TaxiDrive drive;

        for (TaxiDrive t: taxiDrives) {
            if (t.getTaxiDriveId().equals(taxiDriveId))
                drive = t;
        }
        taxiDrives.remove(drive);*/
        if (taxiDriveId == null)
            throw new TaxiDriveException("Drive ID does not exist!");
        if (!repository.existsById(taxiDriveId))
            throw new TaxiDriveException("Drive ID does not exist!");
        repository.deleteById(taxiDriveId);
    }

    public void add1Passanger(Long taxiDriveId) {
        if (taxiDriveId == null)
            throw new TaxiDriveException("Drive ID does not exist!");

        for (TaxiDrive d: repository.findAll()) {
            if (d.getTaxiDriveId().equals(taxiDriveId)) {
                d.setNumberPassangers(d.getNumberPassangers() + 1);
                repository.save(d);
            }
        }
    }

    public void add1Drive(TaxiDrive drive) {
        if (drive==null)
            throw new TaxiDriveException("No drive!");
        repository.save(drive);
    }

    /*
    public String toString() {
        return taxiDrives.stream()
                .map(d -> d.toString())
                .collect(Collectors.joining("\n"));
    }*/
}
