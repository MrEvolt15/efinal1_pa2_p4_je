package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface CitaMedicaService {
	public void insertarCitaPorDatos(String numCita, LocalDate fechaCita,BigDecimal valoCita, String lugarCita, String cedulaDoc,String cedulaPaci);
	public void actualizarCitaPorDatos(String numCita,String diagnostico,String receta,LocalDate fechaProxCita);
}
