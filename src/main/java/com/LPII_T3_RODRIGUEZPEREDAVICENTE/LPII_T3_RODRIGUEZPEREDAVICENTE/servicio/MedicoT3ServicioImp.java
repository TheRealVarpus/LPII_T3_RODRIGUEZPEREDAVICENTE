package com.LPII_T3_RODRIGUEZPEREDAVICENTE.LPII_T3_RODRIGUEZPEREDAVICENTE.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.LPII_T3_RODRIGUEZPEREDAVICENTE.LPII_T3_RODRIGUEZPEREDAVICENTE.modelo.Tbl_MedicoT3;
import com.LPII_T3_RODRIGUEZPEREDAVICENTE.LPII_T3_RODRIGUEZPEREDAVICENTE.repositorio.I_MedicoT3Repositorio;

public class MedicoT3ServicioImp implements I_MedicoT3Servicio{
	
	@Autowired
	private I_MedicoT3Repositorio imedicorepositorio;

	@Override
	public void RegistrarMedico(Tbl_MedicoT3 tblmedico) {
		// TODO Auto-generated method stub
		imedicorepositorio.save(tblmedico);
	}

	@Override
	public void EliminarMedico(Tbl_MedicoT3 tblmedico) {
		// TODO Auto-generated method stub
		imedicorepositorio.delete(tblmedico);
	}

	@Override
	public List<Tbl_MedicoT3> ListadoMedicos() {
		// TODO Auto-generated method stub
		return (List<Tbl_MedicoT3>) imedicorepositorio.findAll();
	}

	@Override
	public Tbl_MedicoT3 buscarporId(Integer id) {
		// TODO Auto-generated method stub
		return imedicorepositorio.findById(id).orElse(null);
	}

	@Override
	public List<Tbl_MedicoT3> buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return imedicorepositorio.findByNombreContainingIgnoreCase(nombre);
	}

}
