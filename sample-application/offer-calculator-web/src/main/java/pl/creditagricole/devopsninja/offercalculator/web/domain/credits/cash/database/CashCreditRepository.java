package pl.creditagricole.devopsninja.offercalculator.web.domain.credits.cash.database;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CashCreditRepository extends JpaRepository<CashCreditEntity, Long> {
}
