package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CitaMedicaRepository;

@Service
public class CitaMedicaServiceImple implements CitaMedicaService{

	@Autowired
	private CitaMedicaRepository citaMedicaRepository;
	@Override
	public void insertarCitaPorDatos(String numCita, LocalDate fechaCita, BigDecimal valoCita, String lugarCita,
			String cedulaDoc, String cedulaPaci) {
		// TODO Auto-generated method stub
		this.citaMedicaRepository.insertarCitaPorDatos(numCita, fechaCita, valoCita, lugarCita, cedulaDoc, cedulaPaci);
	}
	@Override
	public void actualizarCitaPorDatos(String numCita, String diagnostico, String receta, LocalDate fechaProxCita) {
		// TODO Auto-generated method stub
		this.citaMedicaRepository.actualizarCitaPorDatos(numCita, diagnostico, receta, fechaProxCita);
	}

}
