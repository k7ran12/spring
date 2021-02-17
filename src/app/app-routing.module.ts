import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListarComponent } from './empleado/listar/listar.component';
import { AddComponent } from './empleado/add/add.component';
import { EditComponent } from './empleado/edit/edit.component';

import { ProveedorListarComponent } from './proveedor/listar/listar.component';
import { ProveedorAddComponent } from './proveedor/add/add.component';
import { ProveedorEditComponent } from './proveedor/edit/edit.component';


const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'empleado/listar'},
  {path:'empleado/listar',component:ListarComponent},
  {path:'empleado/add',component:AddComponent},
  {path:'empleado/edit',component:EditComponent},
  {path:'proveedor/listar',component:ProveedorListarComponent},
  {path:'proveedor/add',component:ProveedorAddComponent},
  {path:'proveedor/edit',component:ProveedorEditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
