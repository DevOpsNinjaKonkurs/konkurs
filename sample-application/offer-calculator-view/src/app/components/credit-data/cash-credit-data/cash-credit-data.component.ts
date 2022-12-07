import {Component} from '@angular/core';
import {PersonalData} from "../../../model/personal-data";
import {CreditData} from "../../../model/credit-data";
import {CreditService} from "../../../services/credit.service";
import {CashCreditData} from "../../../model/cash-credit-data";

@Component({
  selector: 'app-cash-credit-data',
  templateUrl: './cash-credit-data.component.html',
  styleUrls: ['./cash-credit-data.component.css']
})
export class CashCreditDataComponent {
  personalData: PersonalData = {
    fullName: "",
    email: "",
    address: "",
    gender: "F",
    birthDate: "",
  }

  creditData: CreditData = {
    creditAmount: 5000,
    installmentCount: 12,
  }

  cashCreditData: CashCreditData = {
    creditData: this.creditData,
    personalData: this.personalData
  }

  constructor(public service: CreditService) {

  }

  notEnoughData(): boolean {
    if (!this.personalData.fullName
      || !this.personalData.email
      || !this.personalData.address
      || !this.personalData.birthDate)
      return true

    return false
  }

  complete() {
    this.service.applyForCashCredit(this.cashCreditData).subscribe(data => {
      const id = data.id
      this.service.cashCreditReport(id)
    })
  }
}
