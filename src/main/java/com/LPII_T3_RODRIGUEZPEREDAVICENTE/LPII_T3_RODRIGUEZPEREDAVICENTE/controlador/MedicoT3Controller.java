package com.LPII_T3_RODRIGUEZPEREDAVICENTE.LPII_T3_RODRIGUEZPEREDAVICENTE.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.LPII_T3_RODRIGUEZPEREDAVICENTE.LPII_T3_RODRIGUEZPEREDAVICENTE.modelo.Tbl_MedicoT3;
import com.LPII_T3_RODRIGUEZPEREDAVICENTE.LPII_T3_RODRIGUEZPEREDAVICENTE.servicio.I_MedicoT3Servicio;

@Controller
@RequestMapping("/vistas")
public class MedicoT3Controller {

	@Autowired
	private I_MedicoT3Servicio imedicoservicio;

	@GetMapping("ListadoMedicos")

    public String listarMedicos(@RequestParam(name = "nombre", required = false) String nombre, Model modelo) {
        
		List<Tbl_MedicoT3> listado;
        if (nombre != null && !nombre.isEmpty()) {
            listado = imedicoservicio.buscarPorNombre(nombre);
        } else {
            listado = imedicoservicio.ListadoMedicos();
        }

        //Guarda lista en el modelo
        modelo.addAttribute("listado", listado);
        // Mantener el valor de búsqueda
        modelo.addAttribute("nombre", nombre); 
        //Retorna la vista donde la mostrará  filtrada
        return "vistas/ListadoMedicos";
    }
	
	@GetMapping("/RegistrarMedico")
	public String RegistrarMedico(Model modelo) {
		// Crear objeto vacío
		Tbl_MedicoT3 tblmed = new Tbl_MedicoT3();
		//Se envía a vista el objeto
		modelo.addAttribute("regmedico", tblmed);
		//Carga página del form
		return "vistas/FrmRegMedico";
		//return "vistas/holamundo";
	}
	
	// Mapea la acción cuando se envía form
		@PostMapping("/GuardarMedico")
		//Recibe producto enviado desde form
		public String GuardarMedico(@ModelAttribute Tbl_MedicoT3 tblmed, RedirectAttributes redirectAttributes) {
			try {
				//Guardar medico en BD
	            imedicoservicio.RegistrarMedico(tblmed);
	            // Agregar mensaje de éxito
	            redirectAttributes.addFlashAttribute("mensaje", "Médico registrado exitosamente.");
	            
	        } catch (Exception e) {
	        	// Agregar mensaje de error
	            redirectAttributes.addFlashAttribute("mensaje", "Error al registrar médico.");
	        }
			 // Redirigir a lista
	        return "redirect:/vistas/ListadoMedicos";
		}
	
		//Mapea URL dinámica con ID
		@GetMapping("/EditarMedico/{id}")
		// Captura ID de URL
		public String Editar(@PathVariable("id") Integer idMedico, Model modelo) {
			//Busca producto en la BD
			Tbl_MedicoT3 clmedico = imedicoservicio.buscarporId(idMedico);
			//Envía producto encontrado al form
			modelo.addAttribute("regmedico", clmedico);
			//Carga form con los datos del producto
			return "/vistas/FrmRegMedico";
			
		}
		
		@GetMapping("/EliminarMedico/{id}")
		// Captura ID de URL
		public String eliminar(@PathVariable("id") Integer idmedico, RedirectAttributes redirectAttributes) {
			try {
				// Crea objeto producto con el ID
	            Tbl_MedicoT3 tblmed = new Tbl_MedicoT3();
	            tblmed.setIdMedicoT3(idmedico);
	            // Llama servicio para eliminarlo
	            imedicoservicio.EliminarMedico(tblmed);
	            // Agrega mensaje de éxito
	            redirectAttributes.addFlashAttribute("mensaje", "Registro eliminado correctamente.");
	           
	        } catch (Exception e) {
	        	// Agrega mensaje de error
	            redirectAttributes.addFlashAttribute("mensaje", "Error al eliminar el registro.");
	        }
	        return "redirect:/vistas/ListadoMedicos";		
		}

	
		
}
