import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CreditTypePickerComponent} from "./components/credit-type-picker/credit-type-picker.component";
import {CarCreditDataComponent} from "./components/credit-data/car-credit-data/car-credit-data.component";
import {
  InstallmentCreditDataComponent
} from "./components/credit-data/installment-credit-data/installment-credit-data.component";
import {CashCreditDataComponent} from "./components/credit-data/cash-credit-data/cash-credit-data.component";

const routes: Routes = [
  {path: '', redirectTo: 'credits', pathMatch: 'full'},
  {path: 'credits', component: CreditTypePickerComponent},
  {path: 'credits/cash', component: CashCreditDataComponent},
  {path: 'credits/installment', component: InstallmentCreditDataComponent},
  {path: 'credits/car', component: CarCreditDataComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
