package com.LPII_T3_RODRIGUEZPEREDAVICENTE.LPII_T3_RODRIGUEZPEREDAVICENTE.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.LPII_T3_RODRIGUEZPEREDAVICENTE.LPII_T3_RODRIGUEZPEREDAVICENTE.modelo.Tbl_MedicoT3;

public interface I_MedicoT3Repositorio extends CrudRepository<Tbl_MedicoT3, Integer> {

	List<Tbl_MedicoT3> findByNombreContainingIgnoreCase(String nombre);
}
