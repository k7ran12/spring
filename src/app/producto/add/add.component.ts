import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Categoria } from 'src/app/modelo/categoria';
import { Producto } from 'src/app/modelo/producto';
import { Proveedor } from 'src/app/modelo/proveedor';
import { CategoriaService } from 'src/app/service/categoria.service';
import { ProductoService } from 'src/app/service/producto.service';
import { ProveedorService } from 'src/app/service/proveedor.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class ProductoAddComponent implements OnInit {

  producto:Producto=new Producto();
  categorias:Categoria []=[];
  proveedores:Proveedor []=[];
  constructor(private router:Router, private service:ProductoService, private provedorService:ProveedorService, private serviceCategoria:CategoriaService) { }

  ngOnInit() :void {
    this.listaCategoria();
    this.listaProveedor();
    console.log(this.proveedores);
  }

  Guardar(){
    console.log(this.producto);
    this.service.createProducto(this.producto)
    .subscribe(data=>{
      
      alert("Se Agrego con Exito...!!!");
      this.router.navigate(["producto/listar"]);
    })
  }

  listaCategoria(){
      this.serviceCategoria.getCategoria().subscribe(data =>{
          this.categorias= data;
      })
    }

    listaProveedor(){
      this.provedorService.getPersonas().subscribe(data =>{
          this.proveedores= data;
      })
    }

}
