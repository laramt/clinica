package com.clinoconect.clinica.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinoconect.clinica.exeptions.ResourceNotFoundException;
import com.clinoconect.clinica.models.Pacient;
import com.clinoconect.clinica.services.PacientService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/clinica")
public class PacientController {

	@Autowired
	PacientService pacientService;

	 // Creats new pacients
	@PostMapping("/pacients")
	public Pacient save(@RequestBody Pacient pacient) {

		return pacientService.save(pacient);

	}
	
    // Get pacient by id
	@GetMapping("/pacients/{id}")
	public ResponseEntity<Object> findById(@PathVariable Long id) {
		Pacient pacient = pacientService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Pacient não existe com id: " + id));
		
		return ResponseEntity.status(HttpStatus.OK).body(pacient);

	}

	// Get all pacients
	@GetMapping("/pacients")
	public List<Pacient> findAll() {
		return pacientService.findsAll();
	}


	@PutMapping("/pacients/{id}")
	public ResponseEntity<Object> updates(@PathVariable Long id, @RequestBody Pacient pacient) {
		pacient = pacientService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Pacient não existe com id: " + id));
		
		
		pacient = pacientService.update(id, pacient);
		return ResponseEntity.ok().body(pacient);
	}
	
	// Deletes pacient
	@DeleteMapping
	public ResponseEntity<Map<String, Boolean>> deletePacient(@PathVariable Long id){
		Pacient pacient = pacientService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Paciente not exist with id :" + id));
		
		pacientService.delete(pacient);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	
	
	/*@GetMapping("/pacients/name")
	public ResponseEntity<Page<Pacient>> findByName(@RequestParam String name, Pageable pageable) {
		Page<Pacient> pacients = pacientService.findByName(name, pageable);
		return ResponseEntity.status(HttpStatus.OK).body(pacients);

	}

	@GetMapping("/pacients/email")
	public ResponseEntity<Page<Pacient>> findByEmail(@RequestParam String email, Pageable pageable) {
		Page<Pacient> pacients = pacientService.findByEmail(email, pageable);
		return ResponseEntity.status(HttpStatus.OK).body(pacients);

	}

	@GetMapping("/pacients/cpf")
	public ResponseEntity<Page<Pacient>> findByCpf(@RequestParam String cpf, Pageable pageable) {
		Page<Pacient> pacients = pacientService.findByCpf(cpf, pageable);
		return ResponseEntity.status(HttpStatus.OK).body(pacients);

	}*/
	
}
}