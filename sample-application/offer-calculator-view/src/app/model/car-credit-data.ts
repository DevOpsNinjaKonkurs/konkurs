import {PersonalData} from "./personal-data";
import {CreditData} from "./credit-data";

export interface CarCreditData {
  productionYear: number
  creditData: CreditData
  personalData: PersonalData
}

