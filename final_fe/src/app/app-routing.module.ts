import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {TourListComponent} from './component/tour-list/tour-list.component';
import {TourCreateComponent} from './component/tour-create/tour-create.component';
import {StatisticComponent} from './component/statistic/statistic.component';


const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'list'},
  {path: 'list', component: TourListComponent},
  {path: 'create', component: TourCreateComponent},
  {path: 'statistic', component: StatisticComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
