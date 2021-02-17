export class Producto {
    id : number;
    nombreProducto : String;
    precioUnitario : number;
    unidadesEnStock : number;
    categoria : {
        nombreCategoria : String;
    }
    proveedor : {
        nombreEmpresa : String;
    }

}
