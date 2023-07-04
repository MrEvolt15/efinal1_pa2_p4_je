package com.example.demo.service;

import com.example.demo.repository.modelo.Doctor;

public interface DoctorService {
	public void guardar(Doctor doctor);
	public void borrar(Integer id);
	public Doctor buscarPorID(Integer id);
	public void actualizar(Doctor doctor);
	public Doctor buscarPorCedula(String cedula);
}
