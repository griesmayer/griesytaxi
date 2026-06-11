package at.spengergasse.repository;

import at.spengergasse.domain.TaxiDrive;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxiDriveRepository extends JpaRepository<TaxiDrive, Long> {
}
