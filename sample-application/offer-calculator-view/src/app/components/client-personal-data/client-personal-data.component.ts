import {Component, Input} from '@angular/core';
import {faAddressCard, faEnvelope, faUser} from '@fortawesome/free-solid-svg-icons';
import {PersonalData} from "../../model/personal-data";

@Component({
  selector: 'app-client-personal-data',
  templateUrl: './client-personal-data.component.html',
  styleUrls: ['./client-personal-data.component.css']
})
export class ClientPersonalDataComponent {
  faEnvelope = faEnvelope;
  faUser = faUser;
  faAddress = faAddressCard;

  @Input()
  data: PersonalData = {
    fullName: "",
    email: "",
    address: "",
    gender: "F",
    birthDate: "",
  }
}
