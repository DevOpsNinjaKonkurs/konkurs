package pl.creditagricole.devopsninja.offercalculator.web.tools;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MoneyTools {
	public static BigDecimal pln(BigDecimal value) {
		return value.setScale(2, RoundingMode.HALF_EVEN);
	}
}
