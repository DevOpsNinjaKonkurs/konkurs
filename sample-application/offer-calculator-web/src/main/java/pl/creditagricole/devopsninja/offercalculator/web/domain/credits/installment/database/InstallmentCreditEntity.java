package pl.creditagricole.devopsninja.offercalculator.web.domain.credits.installment.database;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import pl.creditagricole.devopsninja.offercalculator.web.domain.shared.database.CreditDataEntity;
import pl.creditagricole.devopsninja.offercalculator.web.domain.shared.database.PersonalDataEntity;

@Entity
@Getter
@Table(name = "INSTALLMENT_CREDIT")
public class InstallmentCreditEntity {
	@Id
	@GeneratedValue
	private Long id;

	@Embedded
	@Column(nullable = false)
	private CreditDataEntity creditData;

	@Embedded
	@Column(nullable = false)
	private PersonalDataEntity personalData;

	public InstallmentCreditEntity() {
	}

	@Builder
	public InstallmentCreditEntity(
			@NonNull CreditDataEntity creditData,
			@NonNull PersonalDataEntity personalData
	) {
		this.creditData = creditData;
		this.personalData = personalData;
	}
}
