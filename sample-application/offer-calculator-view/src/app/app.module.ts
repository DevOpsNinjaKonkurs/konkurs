import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatStepperModule} from "@angular/material/stepper";
import {MatFormFieldModule} from "@angular/material/form-field";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatInputModule} from "@angular/material/input";
import { CreditTypePickerComponent } from './components/credit-type-picker/credit-type-picker.component';
import { ClientPersonalDataComponent } from './components/client-personal-data/client-personal-data.component';
import {MatCheckbox, MatCheckboxModule} from "@angular/material/checkbox";
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatNativeDateModule} from "@angular/material/core";
import {MatRadioModule} from "@angular/material/radio";
import {MatButtonModule} from "@angular/material/button";
import {MatIconModule} from "@angular/material/icon";
import { CarCreditDataComponent } from './components/credit-data/car-credit-data/car-credit-data.component';
import { CashCreditDataComponent } from './components/credit-data/cash-credit-data/cash-credit-data.component';
import { InstallmentCreditDataComponent } from './components/credit-data/installment-credit-data/installment-credit-data.component';
import { CreditSummaryComponent } from './components/credit-summary/credit-summary.component';
import {MatSliderModule} from "@angular/material/slider";
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    CreditTypePickerComponent,
    ClientPersonalDataComponent,
    CarCreditDataComponent,
    CashCreditDataComponent,
    InstallmentCreditDataComponent,
    CreditSummaryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatStepperModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    MatInputModule,
    MatCheckboxModule,
    FontAwesomeModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatRadioModule,
    MatButtonModule,
    MatIconModule,
    FormsModule,
    MatSliderModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
