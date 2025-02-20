package com.LPII_T3_RODRIGUEZPEREDAVICENTE.LPII_T3_RODRIGUEZPEREDAVICENTE.servicio;

import java.util.List;

import com.LPII_T3_RODRIGUEZPEREDAVICENTE.LPII_T3_RODRIGUEZPEREDAVICENTE.modelo.Tbl_MedicoT3;

public interface I_MedicoT3Servicio {

	void RegistrarMedico(Tbl_MedicoT3 tblmedico);
	void EliminarMedico(Tbl_MedicoT3 tblmedico);
	List<Tbl_MedicoT3> ListadoMedicos();
	Tbl_MedicoT3 buscarporId(Integer id);
	List<Tbl_MedicoT3> buscarPorNombre(String nombre);
		
}
