import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {ToastrModule} from 'ngx-toastr';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {TourListComponent} from './component/tour-list/tour-list.component';
import {AppNavbarComponent} from './component/app-navbar/app-navbar.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { TourCreateComponent } from './component/tour-create/tour-create.component';
import { StatisticComponent } from './component/statistic/statistic.component';

@NgModule({
  declarations: [
    AppComponent,
    TourListComponent,
    AppNavbarComponent,
    TourCreateComponent,
    StatisticComponent
  ],
  imports     : [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    ToastrModule.forRoot({
      positionClass: 'toast-top-right'
    }),
  ],
  providers   : [],
  bootstrap   : [AppComponent]
})
export class AppModule {
}
