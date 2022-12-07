import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CarCreditData} from "../model/car-credit-data";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {Id} from "../model/id";
import {CashCreditData} from "../model/cash-credit-data";
import {InstallmentCreditData} from "../model/installment-credit-data";

@Injectable({
  providedIn: 'root'
})
export class CreditService {
  constructor(public http: HttpClient) {
  }

  applyForCarCredit(carCreditData: CarCreditData): Observable<Id> {
    return this.http.post<Id>(environment.apiBase + "credits/car/apply", carCreditData);
  }

  carCreditReport(id: number) {
    window.open(environment.apiBase + `credits/car/report/${id}`, '_blank');
  }

  applyForCashCredit(cashCreditData: CashCreditData): Observable<Id> {
    return this.http.post<Id>(environment.apiBase + "credits/cash/apply", cashCreditData);
  }

  cashCreditReport(id: number) {
    window.open(environment.apiBase + `credits/cash/report/${id}`, '_blank');
  }

  applyForInstallmentCredit(installmentCreditData: InstallmentCreditData): Observable<Id> {
    return this.http.post<Id>(environment.apiBase + "credits/installment/apply", installmentCreditData);
  }

  installmentCreditReport(id: number) {
    window.open(environment.apiBase + `credits/installment/report/${id}`, '_blank');
  }
}
