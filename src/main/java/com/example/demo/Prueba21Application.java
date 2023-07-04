package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.CitaMedica;
import com.example.demo.repository.modelo.Doctor;
import com.example.demo.repository.modelo.Paciente;
import com.example.demo.service.CitaMedicaService;
import com.example.demo.service.DoctorService;
import com.example.demo.service.PacienteService;

@SpringBootApplication
public class Prueba21Application implements CommandLineRunner{

	@Autowired
	private DoctorService doctorService;
	@Autowired
	private CitaMedicaService citaMedicaService;
	
	public static void main(String[] args) {
		SpringApplication.run(Prueba21Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Doctor doc1 = new Doctor();
		doc1.setApellido("Nunez");
		doc1.setCedula("17231451235");
		doc1.setCodSenecyt("1325425ar");
		doc1.setFechaNacimiento(LocalDate.of(1998, 1, 29));
		doc1.setGenero("Masculino");
		doc1.setNombre("Andres");
		doc1.setNumConsultorio("258185158");
		
		Paciente paci1 = new Paciente();
		paci1.setApellido("Espinosa");
		paci1.setCedula("124269067");
		paci1.setCodSeguro("asg1358dfj00");
		paci1.setEstatura(178.50);
		paci1.setFechaNacimiento(LocalDate.of(1999, 12, 3));
		paci1.setGenero("Masculino");
		paci1.setNombre("Alberto");
		paci1.setPeso(75.38);

		CitaMedica cime1 = new CitaMedica();
		cime1.setDiagnostico("dislocacion");
		cime1.setFechaCita(LocalDate.of(2023, 7, 3));
		cime1.setLugarCita("Vaca Ortiz");
		cime1.setNumCita("256");
		cime1.setReceta("paracetamol 5mg");
		cime1.setValorCita(new BigDecimal(25.00));
		cime1.setDoctor(doc1);
		cime1.setPaciente(paci1);
		List<CitaMedica> citas = new ArrayList<>();
		citas.add(cime1);
		
		paci1.setCitasMedicas(citas);
		doc1.setCitasMedica(citas);
		
		//this.doctorService.guardar(doc1);
		//this.pacienteService.guardar(paci1);
		this.citaMedicaService.insertarCitaPorDatos("163", LocalDate.of(2023, 8, 10),	new BigDecimal(40.3), "Julio Suarez", "17231451235", "124269067");
		this.citaMedicaService.actualizarCitaPorDatos("163", "Rotura Perone", "Reduccion", LocalDate.of(2024, 10, 2));
	}

}
