package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.modelo.Doctor;
@Service
public class DoctorServiceImpl implements DoctorService{
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Override
	public void guardar(Doctor doctor) {
		// TODO Auto-generated method stub
		this.doctorRepository.insertar(doctor);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.doctorRepository.eliminar(id);
	}

	@Override
	public Doctor buscarPorID(Integer id) {
		// TODO Auto-generated method stub
		return this.doctorRepository.seleccionarPorID(id);
	}

	@Override
	public void actualizar(Doctor doctor) {
		// TODO Auto-generated method stub
		this.doctorRepository.actualizar(doctor);
	}

	@Override
	public Doctor buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.doctorRepository.seleccionarPorCedula(cedula);
	}

}
