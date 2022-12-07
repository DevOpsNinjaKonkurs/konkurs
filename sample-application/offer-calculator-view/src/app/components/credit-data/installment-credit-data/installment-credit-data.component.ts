import {Component} from '@angular/core';
import {PersonalData} from "../../../model/personal-data";
import {CreditData} from "../../../model/credit-data";
import {CreditService} from "../../../services/credit.service";
import {InstallmentCreditData} from "../../../model/installment-credit-data";

@Component({
  selector: 'app-installment-credit-data',
  templateUrl: './installment-credit-data.component.html',
  styleUrls: ['./installment-credit-data.component.css']
})
export class InstallmentCreditDataComponent {
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

  installmentCreditData: InstallmentCreditData = {
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
    this.service.applyForInstallmentCredit(this.installmentCreditData).subscribe(data => {
      const id = data.id
      this.service.installmentCreditReport(id)
    })
  }
}
