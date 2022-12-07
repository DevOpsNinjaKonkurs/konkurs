package pl.creditagricole.devopsninja.offercalculator.web.domain.credits.car;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.creditagricole.devopsninja.offercalculator.web.domain.credits.car.logic.CarCreditApi;
import pl.creditagricole.devopsninja.offercalculator.web.domain.credits.car.model.CarCreditApplyRequest;
import pl.creditagricole.devopsninja.offercalculator.web.domain.shared.model.Id;
import pl.creditagricole.devopsninja.offercalculator.web.tools.PdfTools;

@CrossOrigin
@RestController
@RequestMapping("/api/credits/car")
@RequiredArgsConstructor
class CarCreditController {
	private final CarCreditApi carCreditApi;

	@GetMapping("/report/{id}")
	public ResponseEntity<byte[]> report(@PathVariable Long id) {
		return PdfTools.asResponse(carCreditApi.report(id));
	}

	@PostMapping("/apply")
	public ResponseEntity<Id> apply(@Valid @RequestBody CarCreditApplyRequest request) {
		return ResponseEntity.ok(carCreditApi.apply(request));
	}
}
