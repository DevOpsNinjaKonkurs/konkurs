package pl.creditagricole.devopsninja.offercalculator.web.domain.credits.installment.database;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InstallmentCreditRepository extends JpaRepository<InstallmentCreditEntity, Long> {
}
