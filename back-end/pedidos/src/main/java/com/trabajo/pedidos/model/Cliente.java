package com.trabajo.pedidos.model;

import lombok.Data;

import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Table(name = "cliente")
@EntityListeners(AuditingEntityListener.class)
@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    @Column(length = 50)
    private String nombreEmpresa;
    @Column(length = 50)
    private String nombreContacto;
    @Column(length = 70)
    private String direccion;
    @Column(length = 50)
    private String ciudad;
    @Column(length = 9)
    private String telefono;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	public String getNombreContacto() {
		return nombreContacto;
	}
	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
    
    

}
