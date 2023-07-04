package com.example.demo.repository;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.CitaMedica;
import com.example.demo.repository.modelo.Paciente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class CitaMedicaRepositoryImpl implements CitaMedicaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private DoctorRepository doctorRepository;
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Override
	public void insertarCitaPorDatos(String numCita, LocalDate fechaCita, BigDecimal valoCita, String lugarCita,
			String cedulaDoc, String cedulaPaci) {
		CitaMedica nuevaCita = new CitaMedica();
		
		nuevaCita.setNumCita(numCita);
		nuevaCita.setFechaCita(fechaCita);
		nuevaCita.setValorCita(valoCita);
		nuevaCita.setLugarCita(lugarCita);
		nuevaCita.setDiagnostico("reservado");
		nuevaCita.setFechaProxCita(LocalDate.now());
		nuevaCita.setReceta("indefinida");
		
		
		nuevaCita.setDoctor(this.doctorRepository.seleccionarPorCedula(cedulaDoc));
		nuevaCita.setPaciente(this.pacienteRepository.seleccionarPorCedula(cedulaPaci));
		this.entityManager.persist(nuevaCita);
	}

	@Override
	public void actualizarCitaPorDatos(String numCita, String diagnostico, String receta, LocalDate fechaProxCita) {
		
		Query myQuery = this.entityManager.createQuery("SELECT e FROM CitaMedica e WHERE e.numCita= :datoNumCita");
		myQuery.setParameter("datoNumCita", numCita);
		CitaMedica c1= (CitaMedica) myQuery.getSingleResult();
		c1.setDiagnostico(diagnostico);
		c1.setReceta(receta);
		c1.setFechaProxCita(fechaProxCita);
		
		this.entityManager.merge(c1);
	}

}
