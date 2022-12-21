/**
 * 
 */
package com.nttdata.spring.services;

import com.nttdata.spring.repository.Client;

/**
 * @author DURAN
 *
 */
public interface ClientServiceI {
	
	/**
	 * Insertar cliente.
	 * 
	 * @param nuevoCliente
	 */
	public Client insertarCliente(Client nuevoCliente);
	
	/**
	 * Consulta todos los clientes.
	 */
	public void buscarClientes();
	
	/**
	 * Búsqueda por nombre completo.
	 * 
	 * @param name
	 */
	public void searchByName(final String name);
	/**
	 * Búsqueda por nombre completo.
	 * 
	 * @param name
	 * @param surname
	 */
	public void searchByFullName(final String name, final String surname);


}
