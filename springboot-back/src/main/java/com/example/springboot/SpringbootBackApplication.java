package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springboot.model.Cliente;
import com.example.springboot.repositorio.ClienteRepositorio;

@SpringBootApplication
public class SpringbootBackApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackApplication.class, args);
	}
	
	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	@Override
	public void run(String...args) throws Exception{
		this.clienteRepositorio.save(new Cliente("Cristian", "Antonio"));
		this.clienteRepositorio.save(new Cliente("Marco", "Antonio"));
	}
	

}
