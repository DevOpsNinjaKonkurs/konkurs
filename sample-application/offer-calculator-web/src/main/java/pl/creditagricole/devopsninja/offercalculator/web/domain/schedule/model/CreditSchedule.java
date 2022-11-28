package pl.creditagricole.devopsninja.offercalculator.web.domain.schedule.model;

import io.vavr.collection.List;
import lombok.Value;

@Value(staticConstructor = "of")
public class CreditSchedule {
	private List<CreditScheduleEntry> entries;
}
