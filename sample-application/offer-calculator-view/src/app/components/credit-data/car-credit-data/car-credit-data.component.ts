import {Component} from '@angular/core';
import {PersonalData} from "../../../model/personal-data";
import {CarCreditData} from "../../../model/car-credit-data";
import {CreditService} from "../../../services/credit.service";
import {CreditData} from "../../../model/credit-data";

@Component({
  selector: 'app-car-credit-data',
  templateUrl: './car-credit-data.component.html',
  styleUrls: ['./car-credit-data.component.css']
})
export class CarCreditDataComponent {
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

  carCreditData: CarCreditData = {
    productionYear: 1994,
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

    return !this.carCreditData.productionYear
  }

  complete() {
    this.service.applyForCarCredit(this.carCreditData).subscribe(data => {
      const id = data.id
      this.service.carCreditReport(id)
    })
  }
}
