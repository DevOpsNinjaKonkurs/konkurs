package pl.creditagricole.devopsninja.offercalculator.web.domain.credits.cash.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.creditagricole.devopsninja.offercalculator.web.domain.credits.cash.database.CashCreditEntity;
import pl.creditagricole.devopsninja.offercalculator.web.domain.credits.cash.database.CashCreditRepository;
import pl.creditagricole.devopsninja.offercalculator.web.domain.credits.cash.model.CashCreditApplyRequest;
import pl.creditagricole.devopsninja.offercalculator.web.domain.schedule.logic.CreditScheduleApi;
import pl.creditagricole.devopsninja.offercalculator.web.domain.schedule.model.CreditSchedule;
import pl.creditagricole.devopsninja.offercalculator.web.domain.shared.logic.CreditParameters;
import pl.creditagricole.devopsninja.offercalculator.web.domain.shared.logic.CreditPdfCreation;
import pl.creditagricole.devopsninja.offercalculator.web.domain.shared.model.Id;

@Service
@RequiredArgsConstructor
public class CashCreditApi {
	private final CashCreditRepository repository;
	private final CreditPdfCreation pdfCreation;
	private final CreditScheduleApi scheduleApi;

	public Id apply(CashCreditApplyRequest request) {
		final CashCreditEntity entity = CashCreditMapping.toEntity(request);
		final CashCreditEntity saved = repository.save(entity);
		return Id.of(saved.getId());
	}

	public byte[] report(Long id) {
		final CashCreditEntity entity = repository.findById(id)
				.orElseThrow(IllegalArgumentException::new);

		final CreditSchedule schedule = scheduleApi.calculate(
				entity.getCreditData().getCreditAmount(), entity.getCreditData().getInstallmentCount(), CreditParameters.CASH_CREDIT_INTEREST_RATE);

		return pdfCreation.toPdf("Raport kredytu gotówkowego dla " + entity.getPersonalData().getFullName(),
				entity.getCreditData(), entity.getPersonalData(), schedule);
	}
}
