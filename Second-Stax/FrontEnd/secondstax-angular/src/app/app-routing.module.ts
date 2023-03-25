import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './components/admin/admin.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { ProviderDetailsComponent } from './components/provider-details/provider-details.component';
import { PurchaseComponent } from './components/purchase/purchase.component';
import { TradersTableComponent } from './components/traders-table/traders-table.component';

const routes: Routes = [{path:'providers', component: TradersTableComponent},
{path: 'providerDetail/:providerid', component: ProviderDetailsComponent},
{path: 'purchases', component: PurchaseComponent},
{path: 'sales', component: AdminComponent},
{path: 'login', component: LoginComponent},
{path: '', component: HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
