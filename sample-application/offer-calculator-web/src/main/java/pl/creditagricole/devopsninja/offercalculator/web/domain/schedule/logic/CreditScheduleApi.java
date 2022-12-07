package pl.creditagricole.devopsninja.offercalculator.web.domain.schedule.logic;

import io.vavr.collection.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.creditagricole.devopsninja.offercalculator.web.domain.schedule.model.CreditSchedule;
import pl.creditagricole.devopsninja.offercalculator.web.domain.schedule.model.CreditScheduleEntry;
import pl.creditagricole.devopsninja.offercalculator.web.domain.shared.model.Percent;
import pl.creditagricole.devopsninja.offercalculator.web.tools.MoneyTools;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;

@Slf4j
@Service
public class CreditScheduleApi {
	private static final BigDecimal HUNDRED = BigDecimal.valueOf(100);

	public CreditSchedule calculate(long amount, int installmentCount, Percent interestRate) {
		BigDecimal singleInstallment = singleInstallment(amount, installmentCount, interestRate);

		log.info("Calculated single installment = {}", singleInstallment);

		BigDecimal capitalLeftToPay = BigDecimal.valueOf(amount);
		LocalDate paymentDate = calculateNextPaymentDate(LocalDate.of(2020, 1, 1));

		final java.util.List<CreditScheduleEntry> entries = new ArrayList<>();
		for (int i = 0; i < installmentCount; i++) {
			BigDecimal interest = calculateInterest(capitalLeftToPay, interestRate);
			BigDecimal capital = singleInstallment.subtract(interest);

			if (i == installmentCount - 1) {
				capital = capitalLeftToPay;
				singleInstallment = capitalLeftToPay;
				interest = BigDecimal.ZERO;
			}

			capitalLeftToPay = capitalLeftToPay.subtract(capital);

			entries.add(
					CreditScheduleEntry.builder()
							.paymentDate(paymentDate)
							.capital(capital)
							.interest(interest)
							.installment(singleInstallment)
							.leftCapital(capitalLeftToPay)
							.build()
			);

			paymentDate = calculateNextPaymentDate(paymentDate);
		}

		return CreditSchedule.of(List.ofAll(entries));
	}

	private static BigDecimal singleInstallment(long amount, int installmentCount, Percent interestRate) {
		if (interestRate.getValue().compareTo(BigDecimal.ZERO) == 0)
			return MoneyTools.pln(BigDecimal.valueOf(amount / installmentCount));

		final BigDecimal interest = interestRate.getValue().divide(HUNDRED);
		final BigDecimal installmentsInYear = BigDecimal.valueOf(12);

		final BigDecimal numerator = BigDecimal.valueOf(amount).multiply(interest)
				.setScale(2, RoundingMode.HALF_EVEN);

		final BigDecimal growingInterest = installmentsInYear.setScale(16)
				.divide(installmentsInYear.add(interest), RoundingMode.HALF_EVEN)
				.pow(installmentCount);
		final BigDecimal divider = installmentsInYear.multiply(BigDecimal.ONE.subtract(growingInterest));

		return MoneyTools.pln(numerator.divide(divider, RoundingMode.HALF_EVEN));
	}

	private static LocalDate calculateNextPaymentDate(LocalDate from) {
		return from.with(TemporalAdjusters.firstDayOfNextMonth());
	}

	private BigDecimal calculateInterest(BigDecimal leftToPay, Percent interestRate) {
		final BigDecimal interest = interestRate.getValue().divide(HUNDRED);
		final BigDecimal numerator = leftToPay.multiply(interest);
		return MoneyTools.pln(numerator.divide(BigDecimal.valueOf(12), RoundingMode.HALF_EVEN));
	}
}
