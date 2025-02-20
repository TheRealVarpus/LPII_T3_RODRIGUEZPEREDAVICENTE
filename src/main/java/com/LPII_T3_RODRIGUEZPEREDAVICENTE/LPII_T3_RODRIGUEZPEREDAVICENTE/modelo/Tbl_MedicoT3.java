package com.LPII_T3_RODRIGUEZPEREDAVICENTE.LPII_T3_RODRIGUEZPEREDAVICENTE.modelo;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name = "TBL_MEDICOT3")
@Data // Lombok genera automáticamente getters, setters y otros métodos útiles

public class Tbl_MedicoT3 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMedicoT3;

	@Column(length = 255, nullable = false)
	private String nombreT3;

	@Column(length = 255, nullable = false)
	private String apellidoT3;

	@Column(length = 255, nullable = false, unique = true)
	private String emailT3;

	@Column(length = 255, nullable = false, unique = true)
	private String dniT3;

	@Column(length = 255)
	private String estadoCivilT3;

	@Temporal(TemporalType.DATE)
	private Date fechaNacimT3;

	public Integer getIdMedicoT3() {
		return idMedicoT3;
	}

	public void setIdMedicoT3(Integer idMedicoT3) {
		this.idMedicoT3 = idMedicoT3;
	}

	public String getNombreT3() {
		return nombreT3;
	}

	public void setNombreT3(String nombreT3) {
		this.nombreT3 = nombreT3;
	}

	public String getApellidoT3() {
		return apellidoT3;
	}

	public void setApellidoT3(String apellidoT3) {
		this.apellidoT3 = apellidoT3;
	}

	public String getEmailT3() {
		return emailT3;
	}

	public void setEmailT3(String emailT3) {
		this.emailT3 = emailT3;
	}

	public String getDniT3() {
		return dniT3;
	}

	public void setDniT3(String dniT3) {
		this.dniT3 = dniT3;
	}

	public String getEstadoCivilT3() {
		return estadoCivilT3;
	}

	public void setEstadoCivilT3(String estadoCivilT3) {
		this.estadoCivilT3 = estadoCivilT3;
	}

	public Date getFechaNacimT3() {
		return fechaNacimT3;
	}

	public void setFechaNacimT3(Date fechaNacimT3) {
		this.fechaNacimT3 = fechaNacimT3;
	}

	
	
}
