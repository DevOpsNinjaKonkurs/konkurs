package pl.creditagricole.devopsninja.offercalculator.web.domain.credits.installment.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.creditagricole.devopsninja.offercalculator.web.domain.credits.installment.database.InstallmentCreditEntity;
import pl.creditagricole.devopsninja.offercalculator.web.domain.credits.installment.database.InstallmentCreditRepository;
import pl.creditagricole.devopsninja.offercalculator.web.domain.credits.installment.model.InstallmentCreditApplyRequest;
import pl.creditagricole.devopsninja.offercalculator.web.domain.schedule.logic.CreditScheduleApi;
import pl.creditagricole.devopsninja.offercalculator.web.domain.schedule.model.CreditSchedule;
import pl.creditagricole.devopsninja.offercalculator.web.domain.shared.logic.CreditParameters;
import pl.creditagricole.devopsninja.offercalculator.web.domain.shared.logic.CreditPdfCreation;
import pl.creditagricole.devopsninja.offercalculator.web.domain.shared.model.Id;

@Service
@RequiredArgsConstructor
public class InstallmentCreditApi {
	private final InstallmentCreditRepository repository;
	private final CreditPdfCreation pdfCreation;
	private final CreditScheduleApi scheduleApi;

	public Id apply(InstallmentCreditApplyRequest request) {
		final InstallmentCreditEntity entity = InstallmentCreditMapping.toEntity(request);
		final InstallmentCreditEntity saved = repository.save(entity);
		return Id.of(saved.getId());
	}

	public byte[] report(Long id) {
		final InstallmentCreditEntity entity = repository.findById(id)
				.orElseThrow(IllegalArgumentException::new);

		final CreditSchedule schedule = scheduleApi.calculate(
				entity.getCreditData().getCreditAmount(), entity.getCreditData().getInstallmentCount(), CreditParameters.INSTALLMENT_CREDIT_INTEREST_RATE);

		return pdfCreation.toPdf("Raport kredytu ratalnego dla " + entity.getPersonalData().getFullName(),
				entity.getCreditData(), entity.getPersonalData(), schedule);
	}
}
