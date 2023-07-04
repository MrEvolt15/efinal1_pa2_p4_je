package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Doctor;
import com.example.demo.repository.modelo.Paciente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PacienteRepositoryImpl implements PacienteRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(paciente);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Paciente encontrado = this.seleccionarPorID(id);
		this.entityManager.remove(encontrado);
	}

	@Override
	public Paciente seleccionarPorID(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Paciente.class, id);
	}

	@Override
	public void actualizar(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.merge(paciente);
	}

	@Override
	public Paciente seleccionarPorCedula(String cedula) {
		Query myQuery = this.entityManager.createQuery("SELECT e FROM Paciente e WHERE e.cedula= :datoCedula");
		myQuery.setParameter("datoCedula", cedula);
		return (Paciente) myQuery.getSingleResult();
	}
}
