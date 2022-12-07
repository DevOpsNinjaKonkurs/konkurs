package pl.creditagricole.devopsninja.offercalculator.web.domain.credits.car.database;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarCreditRepository extends JpaRepository<CarCreditEntity, Long> {
}
