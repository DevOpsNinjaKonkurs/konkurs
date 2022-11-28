package pl.creditagricole.devopsninja.offercalculator.web.domain.credits.installment;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.creditagricole.devopsninja.offercalculator.web.domain.credits.installment.logic.InstallmentCreditApi;
import pl.creditagricole.devopsninja.offercalculator.web.domain.credits.installment.model.InstallmentCreditApplyRequest;
import pl.creditagricole.devopsninja.offercalculator.web.domain.shared.model.Id;
import pl.creditagricole.devopsninja.offercalculator.web.tools.PdfTools;

@CrossOrigin
@RestController
@RequestMapping("/api/credits/installment")
@RequiredArgsConstructor
class InstallmentCreditController {
	private final InstallmentCreditApi installmenthCreditApi;

	@GetMapping("/report/{id}")
	public ResponseEntity<byte[]> report(@PathVariable Long id) {
		return PdfTools.asResponse(installmenthCreditApi.report(id));
	}

	@PostMapping("/apply")
	public ResponseEntity<Id> apply(@Valid @RequestBody InstallmentCreditApplyRequest request) {
		return ResponseEntity.ok(installmenthCreditApi.apply(request));
	}
}
