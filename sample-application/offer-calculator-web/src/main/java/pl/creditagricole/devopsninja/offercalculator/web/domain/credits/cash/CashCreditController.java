package pl.creditagricole.devopsninja.offercalculator.web.domain.credits.cash;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.creditagricole.devopsninja.offercalculator.web.domain.credits.cash.logic.CashCreditApi;
import pl.creditagricole.devopsninja.offercalculator.web.domain.credits.cash.model.CashCreditApplyRequest;
import pl.creditagricole.devopsninja.offercalculator.web.domain.shared.model.Id;
import pl.creditagricole.devopsninja.offercalculator.web.tools.PdfTools;

@CrossOrigin
@RestController
@RequestMapping("/api/credits/cash")
@RequiredArgsConstructor
class CashCreditController {
	private final CashCreditApi cashCreditApi;

	@GetMapping("/report/{id}")
	public ResponseEntity<byte[]> report(@PathVariable Long id) {
		return PdfTools.asResponse(cashCreditApi.report(id));
	}

	@PostMapping("/apply")
	public ResponseEntity<Id> apply(@Valid @RequestBody CashCreditApplyRequest request) {
		return ResponseEntity.ok(cashCreditApi.apply(request));
	}
}
