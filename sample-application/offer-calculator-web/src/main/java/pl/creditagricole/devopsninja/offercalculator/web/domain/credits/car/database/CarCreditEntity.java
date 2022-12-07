package pl.creditagricole.devopsninja.offercalculator.web.domain.credits.car.database;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import pl.creditagricole.devopsninja.offercalculator.web.domain.shared.database.CreditDataEntity;
import pl.creditagricole.devopsninja.offercalculator.web.domain.shared.database.PersonalDataEntity;

@Entity
@Getter
@Table(name = "CAR_CREDIT")
public class CarCreditEntity {
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private Integer productionYear;

	@Embedded
	@Column(nullable = false)
	private CreditDataEntity creditData;

	@Embedded
	@Column(nullable = false)
	private PersonalDataEntity personalData;

	public CarCreditEntity() {
	}

	@Builder
	public CarCreditEntity(
			@NonNull Integer productionYear,
			@NonNull CreditDataEntity creditData,
			@NonNull PersonalDataEntity personalData
	) {
		this.productionYear = productionYear;
		this.creditData = creditData;
		this.personalData = personalData;
	}
}
