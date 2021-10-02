package com.paciente.pacientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paciente.pacientes.models.Pacientes;

public interface PacienteRepository extends JpaRepository<Pacientes, Long> {
	
	Pacientes findById(long id);

}
