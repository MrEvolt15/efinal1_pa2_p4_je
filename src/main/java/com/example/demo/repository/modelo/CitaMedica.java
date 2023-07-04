package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table
public class CitaMedica {
	@GeneratedValue(generator = "seq_paciente",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_paciente",sequenceName ="seq_paciente",allocationSize = 1 )
	@Id
	@Column(name= "cime_id")
	private Integer id;
	@Column(name= "cime_numero_cita")
	private String numCita;
	@Column(name= "cime_fecha_cita")
	private LocalDate fechaCita;
	@Column(name= "cime_valor_cita")
	private BigDecimal valorCita;
	@Column(name= "cime_lugar_cita")
	private String lugarCita;
	@Column(name= "cime_diagnostico")
	private String diagnostico;
	@Column(name= "cime_receta")
	private String receta;
	@Column(name= "cime_fecha_proxima_cita")
	private LocalDate fechaProxCita;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "doc_cime_id")
	private Doctor doctor;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "paci_cime_id")
	private Paciente paciente;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumCita() {
		return numCita;
	}
	public void setNumCita(String numCita) {
		this.numCita = numCita;
	}
	public LocalDate getFechaCita() {
		return fechaCita;
	}
	public void setFechaCita(LocalDate fechaCita) {
		this.fechaCita = fechaCita;
	}
	public BigDecimal getValorCita() {
		return valorCita;
	}
	public void setValorCita(BigDecimal valorCita) {
		this.valorCita = valorCita;
	}
	public String getLugarCita() {
		return lugarCita;
	}
	public void setLugarCita(String lugarCita) {
		this.lugarCita = lugarCita;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public String getReceta() {
		return receta;
	}
	public void setReceta(String receta) {
		this.receta = receta;
	}
	public LocalDate getFechaProxCita() {
		return fechaProxCita;
	}
	public void setFechaProxCita(LocalDate fechaProxCita) {
		this.fechaProxCita = fechaProxCita;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	
	
}
