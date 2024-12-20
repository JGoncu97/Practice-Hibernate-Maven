package com.jgoncu.controlador;

import java.time.LocalDate;
import java.util.List;

import com.jgoncu.dao.MascotaDao;
import com.jgoncu.dao.PersonaDao;
import com.jgoncu.dao.ProductoDao;
import com.jgoncu.entidades.Mascota;
import com.jgoncu.entidades.Persona;
import com.jgoncu.entidades.PersonasProductos;
import com.jgoncu.entidades.Producto;
import com.jgoncu.vistas.VentanaMascotas;
import com.jgoncu.vistas.VentanaPersonas;
import com.jgoncu.vistas.VentanaPrincipal;
import com.jgoncu.vistas.VentanaProductos;



public class Controlador {

	private VentanaPrincipal ventanaPpal;
	private VentanaMascotas vMascota;
	private Mascota miMascota;
	private MascotaDao mascotaDao;
	private PersonaDao miPersonaDao;
	private VentanaPersonas vPersona;
	private Persona miPersona;
	private VentanaProductos vProducto;
	private ProductoDao miProductoDao;




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

	public void ventanaProducto() {
			
		vProducto.setVisible(true);
		
	}

	public void setVentanaProducto(VentanaProductos vProducto) {
		
		this.vProducto = vProducto;
		
	}

	public String registrarProducto(Producto miProducto) {
		
		return miProductoDao.registrarProducto(miProducto);
		
	}

	public void setProductoDao(ProductoDao miProductoDao) {
		
		this.miProductoDao=miProductoDao;
		
	}

	public Producto consultarProducto(int id) {
				return miProductoDao.consultarProducto(id);
	}

	public List<Producto> consultarTodosLosProductos() {
		
		return miProductoDao.consultarListaProductos();
	}

	public String actualizarProducto(Producto miProducto) {
		
		return miProductoDao.actualizarProducto(miProducto);
	}

	public String eliminarProducto(Producto miProducto) {
		
		return miProductoDao.eliminarProducto(miProducto);
	}

	public String registrarCompra(String idPersona, int idProducto, LocalDate fechaCompra, int cantidad) {
		
		return miProductoDao.registrarCompra(idPersona, idProducto, fechaCompra, cantidad);
	}

	public List<PersonasProductos> consultarTodasLasCompras() {
		
		return miProductoDao.consultarTodasLasCompras();
	}

}
