/**
 * 
 */
package com.nttdata.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author DURAN
 *
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	
	/**
	 * Obtención del cliente mediante el nombre completo.
	 * 
	 * @param name
	 * @return List<Client>
	 */
	public List<Client> findByName(final String name);
	
	/**
	 * Obtención del cliente mediante el nombre completo.
	 * 
	 * @param name
	 * @param surname
	 * @return List<Client>
	 */
	public List<Client> findByNameAndSurname(final String name, final String surname);


}
