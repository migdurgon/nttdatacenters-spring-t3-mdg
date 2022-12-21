package com.nttdata.spring.springtaller3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.spring.repository.Client;
import com.nttdata.spring.services.ClientServiceI;

@SpringBootApplication
public class SpringTaller3Application implements CommandLineRunner {

	/** Servicio de gestión de clientes */
	@Autowired
	private ClientServiceI clienteServicio;

	public static void main(String[] args) {
		SpringApplication.run(SpringTaller3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Nuevos clientes.
		final Client newCliente1 = new Client();
		newCliente1.setNombre("Miguel");
		newCliente1.setApellidos("Duran Gonzalez");
		newCliente1.setDni("24753695U");
		clienteServicio.insertarCliente(newCliente1);

		final Client newCliente2 = new Client();
		newCliente2.setNombre("Diego");
		newCliente2.setApellidos("Duran Gonzalez");
		newCliente2.setDni("58697842P");
		clienteServicio.insertarCliente(newCliente2);

		final Client newCliente3 = new Client();
		newCliente3.setNombre("Macarena");
		newCliente3.setApellidos("Duran Gonzalez");
		newCliente3.setDni("00223344F");
		clienteServicio.insertarCliente(newCliente3);

		System.out.println("----- INICIO TODOS LOS CLIENTES POR NOMBRE -----");

		// Obtiene los clientes por nombre.
		clienteServicio.searchByFullName("Miguel", "Duran Gonzalez");

		System.out.println("----- FIN TODOS LOS CLIENTES POR NOMBRE Y APELLIDOS -----");

	}

}
