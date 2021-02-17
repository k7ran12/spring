import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Producto } from 'src/app/modelo/producto';
import { ProductoService } from 'src/app/service/producto.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class ProductoAddComponent implements OnInit {

  producto:Producto=new Producto();
  constructor(private router:Router, private service:ProductoService) { }

  ngOnInit() :void {
   
  }

  Guardar(){
    console.log(this.producto);
    this.service.createProducto(this.producto)
    .subscribe(data=>{
      
      alert("Se Agrego con Exito...!!!");
      this.router.navigate(["producto/listar"]);
    })
  }

}
