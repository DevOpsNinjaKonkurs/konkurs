package pl.creditagricole.devopsninja.offercalculator.web.domain.credits.car.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.creditagricole.devopsninja.offercalculator.web.domain.credits.car.database.CarCreditEntity;
import pl.creditagricole.devopsninja.offercalculator.web.domain.credits.car.database.CarCreditRepository;
import pl.creditagricole.devopsninja.offercalculator.web.domain.credits.car.model.CarCreditApplyRequest;
import pl.creditagricole.devopsninja.offercalculator.web.domain.schedule.logic.CreditScheduleApi;
import pl.creditagricole.devopsninja.offercalculator.web.domain.schedule.model.CreditSchedule;
import pl.creditagricole.devopsninja.offercalculator.web.domain.shared.logic.CreditParameters;
import pl.creditagricole.devopsninja.offercalculator.web.domain.shared.logic.CreditPdfCreation;
import pl.creditagricole.devopsninja.offercalculator.web.domain.shared.model.Id;

@Service
@RequiredArgsConstructor
public class CarCreditApi {
	private final CarCreditRepository repository;
	private final CreditPdfCreation pdfCreation;
	private final CreditScheduleApi scheduleApi;

	public Id apply(CarCreditApplyRequest request) {
		final CarCreditEntity entity = CarCreditMapping.toEntity(request);
		final CarCreditEntity saved = repository.save(entity);
		return Id.of(saved.getId());
	}

	public byte[] report(Long id) {
		final CarCreditEntity entity = repository.findById(id)
				.orElseThrow(IllegalArgumentException::new);

		final CreditSchedule schedule = scheduleApi.calculate(
				entity.getCreditData().getCreditAmount(), entity.getCreditData().getInstallmentCount(), CreditParameters.CAR_CREDIT_INTEREST_RATE);

		return pdfCreation.toPdf("Raport kredytu samochodowego dla " + entity.getPersonalData().getFullName(),
				entity.getCreditData(), entity.getPersonalData(), schedule);
	}
}
