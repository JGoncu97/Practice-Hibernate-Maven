package com.jgoncu.aplicacion;

import com.jgoncu.controlador.Controlador;
import com.jgoncu.dao.MascotaDao;
import com.jgoncu.dao.PersonaDao;
import com.jgoncu.dao.ProductoDao;
import com.jgoncu.entidades.Mascota;
import com.jgoncu.vistas.VentanaMascotas;
import com.jgoncu.vistas.VentanaPersonas;
import com.jgoncu.vistas.VentanaPrincipal;
import com.jgoncu.vistas.VentanaProductos;

public class Principal {
	
	public static void main(String[] args) {
		
		Controlador miControlador = new Controlador();
		Mascota miMascota= new Mascota();
		MascotaDao mascotaDao = new MascotaDao();
		VentanaPrincipal vPpal = new VentanaPrincipal();
		VentanaMascotas vMascota = new VentanaMascotas();
		PersonaDao miPersonaDao = new PersonaDao();
		VentanaPersonas vPersona = new VentanaPersonas();
		VentanaProductos vProducto = new VentanaProductos();
		ProductoDao miProductoDao = new ProductoDao();
		
		miControlador.setMascota(miMascota);
		miControlador.setMascotaDao(mascotaDao);
		miControlador.setVentanaPrincipal(vPpal);
		miControlador.setVentanaMascota(vMascota);
		miControlador.setPersonaDao(miPersonaDao);
		miControlador.setVentanaPersona(vPersona);
		miControlador.setVentanaProducto(vProducto);
		miControlador.setProductoDao(miProductoDao);
		
		vPpal.setCoordinador(miControlador);
		vMascota.setCoordinador(miControlador);
		mascotaDao.setCoordinador(miControlador);
		miPersonaDao.setCoordinador(miControlador);
		vPersona.setCoordinador(miControlador);
		vProducto.setCoordinador(miControlador);
		miProductoDao.setCoordinador(miControlador);
		
		vPpal.setVisible(true);
		
		
		/*Aplicacion miAplicacion=new Aplicacion();
		
			miAplicacion.iniciar();*/
		}
			
}
