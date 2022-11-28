package com.clinoconect.clinica.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@Entity
	public class Pacient {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		private String name;
		@Column(nullable = false, unique = true)
		private String cpf;
		@Column(nullable = false)
		private String cellphone;
		@Column(nullable = false)
		private String email;

	
}
