package com.clinoconect.clinica.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinoconect.clinica.models.Pacient;

@Repository
public interface PacientRepository extends JpaRepository<Pacient, Long> {

	boolean existsByCpf(String cpf);

	boolean existsByEmail(String email);

	Page<Pacient> findByName(String name, Pageable pageable);

	Page<Pacient> findByCpf(String cpf, Pageable pageable);

	Page<Pacient> findByEmail(String email, Pageable pageable);

}
