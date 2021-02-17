package com.trabajo.pedidos.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 70)
    private String nombreProducto;
    @Column(length = 10)
    private double precioUnitario;
    private int unidadesEnStock;

    //@JoinColumn(foreignKey = @ForeignKey(name = "fk_producto_categoria_id"), name="categoria_id", referencedColumnName = "id", columnDefinition = "long")
    @ManyToOne
    private Categoria categoria;
    //@JoinColumn(foreignKey = @ForeignKey(name = "fk_producto_proveedor_id"), name="proveedor_id", referencedColumnName = "id", columnDefinition = "long")
    @ManyToOne
    private Proveedor proveedor;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public int getUnidadesEnStock() {
		return unidadesEnStock;
	}
	public void setUnidadesEnStock(int unidadesEnStock) {
		this.unidadesEnStock = unidadesEnStock;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
    
    






}
