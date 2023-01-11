package com.clinoconect.clinica.services;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.clinoconect.clinica.models.Pacient;
import com.clinoconect.clinica.repositories.PacientRepository;

@Service
public class PacientService {

	@Autowired
	PacientRepository pacientRepository;


	@Transactional
	public Pacient save(Pacient pacient) {

		// verifica email
		String email = pacient.getEmail();
		if (pacientRepository.existsByEmail(email)) {
			throw new RuntimeException("This email is already in use.");
		}

		Pattern patternEmail = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
		Matcher matcherEmail = patternEmail.matcher(email);
		if (matcherEmail.matches()) {
			throw new RuntimeException("Invalid email format");
		}

		// verifica cpf
		String cpf = pacient.getCpf();
		if (pacientRepository.existsByCpf(cpf)) {
			throw new RuntimeException("This Cpf is already in use.");
		}
		Pattern patternCpf = Pattern.compile("^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$");
		Matcher matcherCpf = patternCpf.matcher(cpf);
		if (!matcherCpf.matches()) {
			throw new RuntimeException("Invalid cpf format.");
		}

		return pacientRepository.save(pacient);
	}

	public Pacient update(Long id, Pacient pacient) {
		Pacient pac = pacientRepository.getById(id);

		pac.setName(pacient.getName());
		pac.setEmail(pacient.getEmail());
		pac.setCpf(pacient.getCpf());
		pac.setCellphone(pacient.getCellphone());
		
		return pacientRepository.save(pac);
	}

	@Transactional
	public void delete(Long id) {
		pacientRepository.deleteById(id);
	}

	public List<Pacient> findsAll() {
		return pacientRepository.findAll();
	}

	public Optional<Pacient> findById(Long id) {
		return pacientRepository.findById(id);
	}

	public Page<Pacient> findByName(String nome, Pageable pageable) {
		return pacientRepository.findByName(nome, pageable);
	}

	public Page<Pacient> findByEmail(String email, Pageable pageable) {
		return pacientRepository.findByEmail(email, pageable);
	}

	public Page<Pacient> findByCpf(String cpf, Pageable pageable) {
		return pacientRepository.findByCpf(cpf, pageable);
	}

}
