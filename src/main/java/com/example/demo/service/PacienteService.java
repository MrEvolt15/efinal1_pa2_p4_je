package com.example.demo.service;

import com.example.demo.repository.modelo.Paciente;

public interface PacienteService {
	public void guardar(Paciente paciente);
	public void borrar(Integer id);
	public Paciente buscarPorID(Integer id);
	public void actualizar(Paciente paciente);
	public Paciente seleccionarPorCedula(String cedula);
}
