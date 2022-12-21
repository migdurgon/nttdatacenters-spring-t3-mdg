/**
 * 
 */
package com.nttdata.spring.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.nttdata.spring.repository.Client;
import com.nttdata.spring.repository.ClientRepository;

/**
 * @author DURAN
 *
 */
@RestController
@RequestMapping()
public class ClientRestController {

	@Autowired
	private ClientRepository clientRepository;

	@GetMapping()
	public @ResponseBody String clientList(ModelMap modelmap) {
		String view = "/clientList";
		List<Client> clients = clientRepository.findAll();

		modelmap.addAttribute("clients", clients);

		return view;

	}

	@GetMapping(path = "/delete/{clientId}")
	public @ResponseBody String deleteClient(@PathVariable("clientId") Long clientId, ModelMap modelmap) {
		Optional<Client> client = clientRepository.findById(clientId);

		if (client.isPresent()) {
			clientRepository.delete(client.get());
			modelmap.addAttribute("message", "Client delete succesfully");
			System.out.println("Se ha borrado el cliente " + client.get().getNombre());

		} else {
			modelmap.addAttribute("message", "Product not found");
		}
		String view = clientList(modelmap);
		return view;
	}

	@PostMapping(value = "/new")
	public @ResponseBody String newClient(@Valid Client client, BindingResult result) {
		// Crear cliente
		this.clientRepository.save(client);

		return "redirect:/clientList";
	}

	@GetMapping("/{nombre}")
	public @ResponseBody ModelAndView showClient(@PathVariable("nombre") String nombre) {
		ModelAndView mav = new ModelAndView("/showClient");
		mav.addObject(this.clientRepository.findByName(nombre));
		return mav;
	}

}
