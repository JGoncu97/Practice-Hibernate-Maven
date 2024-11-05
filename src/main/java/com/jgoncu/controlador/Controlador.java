package com.jgoncu.controlador;

import com.jgoncu.dao.MascotaDao;
import com.jgoncu.entidades.Mascota;
import com.jgoncu.vistas.VentanaMascotas;
import com.jgoncu.vistas.VentanaPrincipal;

public class Controlador {

	private VentanaPrincipal ventanaPpal;
	private VentanaMascotas vMascota;
	private Mascota miMascota;
	private MascotaDao mascotaDao;




	public void setVentanaPrincipal(VentanaPrincipal ventanaPpal) {
		this.ventanaPpal= ventanaPpal;
		
	}

	public void setVentanaMascota(VentanaMascotas vMascota) {
		
		this.vMascota = vMascota;		
	}

	public Mascota[] consultarListaMascota() {
		// TODO Auto-generated method stub
		return null;
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

	public void setMascota(Mascota miMascota) {
		
		this.miMascota=miMascota;
		
	}

	public void setMascotaDao(MascotaDao mascotaDao) {
		
		this.mascotaDao=mascotaDao;
		
	}

}
