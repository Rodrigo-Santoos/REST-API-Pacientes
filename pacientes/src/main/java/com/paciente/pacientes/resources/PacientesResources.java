package com.paciente.pacientes.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paciente.pacientes.models.Pacientes;
import com.paciente.pacientes.repository.PacienteRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST de Pacientes")
@CrossOrigin(origins="*")
public class PacientesResources {
	
	@Autowired
	PacienteRepository pacienteRepository;
	
	//trazendo todos
	@GetMapping("/pacientes")
	@ApiOperation(value="Trazer todos os Pacientes")
	public List<Pacientes> listarPacientes(){
		return pacienteRepository.findAll();
		
	}
	
	//trazendo um produto pela id 
	@GetMapping("/pacientes/{id}")
	@ApiOperation(value="Trazer unico Paciente")
	public Pacientes listarUnicoPacientes(@PathVariable(value="id") long id){
		return pacienteRepository.findById(id);
		
	}
	
	//Salvando o Produto via postman no banco de Dados
	@PostMapping("/pacientes")
	@ApiOperation(value="Adicionar Paciente")
	public Pacientes salvaPaciente(@RequestBody Pacientes paciente){
		return pacienteRepository.save(paciente);
		
	}
	
	@DeleteMapping("/pacientes")
	@ApiOperation(value="Apagar Paciente")
	public void deletarPaciente(@RequestBody Pacientes paciente){
		pacienteRepository.delete(paciente);
		
	}
	
	@PutMapping("/pacientes")
	@ApiOperation(value="Atualizar Paciente")
	public Pacientes atualizarPaciente(@RequestBody Pacientes paciente){
		return pacienteRepository.save(paciente);
		
	}
	
	
	

}
