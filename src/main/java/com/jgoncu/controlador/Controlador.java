package com.jgoncu.controlador;

import java.util.List;

import com.jgoncu.dao.MascotaDao;
import com.jgoncu.dao.PersonaDao;
import com.jgoncu.entidades.Mascota;
import com.jgoncu.entidades.Persona;
import com.jgoncu.vistas.VentanaMascotas;
import com.jgoncu.vistas.VentanaPersonas;
import com.jgoncu.vistas.VentanaPrincipal;



public class Controlador {

	private VentanaPrincipal ventanaPpal;
	private VentanaMascotas vMascota;
	private Mascota miMascota;
	private MascotaDao mascotaDao;
	private PersonaDao miPersonaDao;
	private VentanaPersonas vPersona;
	private Persona miPersona;




	public void setVentanaPrincipal(VentanaPrincipal ventanaPpal) {
		this.ventanaPpal= ventanaPpal;
		
	}

	public void setVentanaMascota(VentanaMascotas vMascota) {
		
		this.vMascota = vMascota;		
	}

	public List<Mascota> consultarListaMascota() {
		
		return mascotaDao.consultarListaMascotas();
	}

	public String registrarMascota(Mascota miMascota) {
		
		return mascotaDao.registrarMascota(miMascota);
	}

	public String actualizarMascota(Mascota miMascota) {
		
		return mascotaDao.actualizarMascota(miMascota);
	}

	public Mascota consultarMascota(String id) {
		
		return mascotaDao.consultarMascota(id);
	}

	public String eliminarMascota(Mascota miMascota) {
		
		return mascotaDao.eliminarMascota(miMascota);
	}

	

	public void ventanaMascota() {
		
		vMascota.setVisible(true);
		
	}
	
	public void ventanaMascotaPersona(Persona persona) {
        
        vMascota.setPersona(persona);
        vMascota.setVisible(true);
    }
	
	public void ventanaPersona() {
		
		vPersona.setVisible(true);
		
	}

	public void setMascota(Mascota miMascota) {
		
		this.miMascota=miMascota;
		
	}

	public void setMascotaDao(MascotaDao mascotaDao) {
		
		this.mascotaDao=mascotaDao;
		
	}

	public void setPersonaDao(PersonaDao miPersonaDao) {
		
		this.miPersonaDao = miPersonaDao;
		
	}

	public void setVentanaPersona(VentanaPersonas vPersona) {
		
		this.vPersona=vPersona;
		
	}

	public String registrarPersona(Persona miPersona) {
			
		return miPersonaDao.registrarPersona(miPersona);
		
	}

	public String actualizarPersona(Persona miPersona) {
		
		return miPersonaDao.actualizarPersona(miPersona);
		
	}

	public Persona consultarPersona(String documento) {
		
		return miPersonaDao.consultarPersona(documento);
	}

	public String eliminarPersona(Persona miPersona) {
		
		return miPersonaDao.eliminarPersona(miPersona);
	}

	public List<Persona> consultarListaPersonas() {
		
		return miPersonaDao.consultarListaPersonas();
	}

}
