package com.example.demo.repository;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface CitaMedicaRepository {
	public void insertarCitaPorDatos(String numCita, LocalDate fechaCita,BigDecimal valoCita, String lugarCita, String cedulaDoc,String cedulaPaci);
	public void actualizarCitaPorDatos(String numCita,String diagnostico,String receta,LocalDate fechaProxCita);
}
