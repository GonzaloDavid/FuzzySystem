import {ModuleWithProviders } from '@angular/core';
import {Routes,RouterModule} from '@angular/router';
import { PersonComponent } from './components/person/person.component';

const appRoutes:Routes = [
    {path: '', component: PersonComponent},
    {path: 'person', component: PersonComponent },
    {path: '**', component: PersonComponent },

];

export const appRoutingProviders : any[]=[];
export const routing: ModuleWithProviders=RouterModule.forRoot(appRoutes);
