package pl.creditagricole.devopsninja.offercalculator.web.domain.schedule.model;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;

@Value
@Builder
public class CreditScheduleEntry {
	private LocalDate paymentDate;
	private BigDecimal capital;
	private BigDecimal interest;
	private BigDecimal installment;
	private BigDecimal leftCapital;
}
