package pl.creditagricole.devopsninja.offercalculator.web.domain.shared.database;

import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Embeddable
public class CreditDataEntity {
	private Long creditAmount;
	private Integer installmentCount;

	public CreditDataEntity() {
	}

	@Builder
	public CreditDataEntity(
			@NonNull Long creditAmount,
			@NonNull Integer installmentCount
	) {
		this.creditAmount = creditAmount;
		this.installmentCount = installmentCount;
	}
}
