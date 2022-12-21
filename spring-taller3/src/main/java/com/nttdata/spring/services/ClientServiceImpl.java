/**
 * 
 */
package com.nttdata.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.nttdata.spring.repository.Client;
import com.nttdata.spring.repository.ClientRepository;

/**
 * @author DURAN
 *
 */
@Service
public class ClientServiceImpl implements ClientServiceI {

	@Autowired
	ClientRepository clienteRepository;

	@Override
	public Client insertarCliente(Client nuevoCliente) {

		// Verificación de nulidad.
		if (nuevoCliente != null && nuevoCliente.getClienteId() == null) {

			// Insercción de cliente.
			nuevoCliente = clienteRepository.save(nuevoCliente);
		}

		return nuevoCliente;
	}

	@Override
	public void searchByFullName(String name, String surname) {
		// Obtención del listado de clientes por nombre y apellidos.
		final List<Client> searchClientes = clienteRepository.findByNameAndSurname(name, surname);

		// Muestra el listado obtenido.
		if (!CollectionUtils.isEmpty(searchClientes)) {
			for (Client cliente : searchClientes) {
				System.out.println(cliente.toString());
			}
		}

	}

	@Override
	public void buscarClientes() {
		// Consulta clientes.
		final Iterable<Client> clientes = clienteRepository.findAll();

		// Itera e imprime los clientes.
		clientes.forEach((final Client cliente) -> System.out.println(cliente.toString()));
	}

	@Override
	public void searchByName(String name) {

		// Obtención del listado de clientes por nombre.
		final List<Client> searchClientes = clienteRepository.findByName(name);

		// Muestra el listado obtenido.
		if (!CollectionUtils.isEmpty(searchClientes)) {
			for (Client cliente : searchClientes) {
				System.out.println(cliente.toString());
			}
		}
	}

}
