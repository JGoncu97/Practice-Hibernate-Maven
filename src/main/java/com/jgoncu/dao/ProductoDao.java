package com.jgoncu.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import com.jgoncu.aplicacion.JPAUtil;
import com.jgoncu.controlador.Controlador;
import com.jgoncu.entidades.Persona;
import com.jgoncu.entidades.PersonasProductos;
import com.jgoncu.entidades.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class ProductoDao {
	
	EntityManager entityManager=JPAUtil.getEntityManagerFactory().createEntityManager();
	private Controlador miControlador;
	
		public String registrarProducto(Producto miProducto) {
			String resp="";
			try {
				entityManager.getTransaction().begin();
				entityManager.persist(miProducto);
				entityManager.getTransaction().commit();
				resp="Producto Registrado!";
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null,"No se puede registrar "
				+ "el Producto",
				"ERROR",JOptionPane.ERROR_MESSAGE);
	
			}
			return resp;
		}
		
		public Producto consultarProducto(int idProducto) {
			
			Producto miProducto=entityManager.find(Producto.class,idProducto);
			
				if (miProducto!=null) {
					return miProducto;
				}else {
					return null;
				}
			}
		
		public List<Producto> consultarListaProductos() {
			List<Producto> listaProductos=new ArrayList<Producto>();
			Query query=entityManager.createQuery("SELECT p FROM Producto p");
			listaProductos=query.getResultList();
			
			return listaProductos;
		}
		
		public String actualizarProducto(Producto miProducto) {
			String resp="";
			try {
				entityManager.getTransaction().begin();
				entityManager.merge(miProducto);
				entityManager.getTransaction().commit();
				resp="Producto Actualizado!";
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"No se puede actualizar "
				+ "el Producto ",
				"ERROR",JOptionPane.ERROR_MESSAGE);
		
			}
			return resp;
		}
		
	public String eliminarProducto(Producto miProducto) {
		
		entityManager.getTransaction().begin();
		entityManager.remove(miProducto);
		entityManager.getTransaction().commit();
		String resp="Producto Actualizado!";
		return resp;
		
	}
	
	public String registrarCompra(String personaId, int productoId, LocalDate fechaCompra, int cantidad) {
		String resp = "";
			try {
				entityManager.getTransaction().begin();
				Persona persona = entityManager.find(Persona.class, personaId);
				Producto producto = entityManager.find(Producto.class, productoId);
				
				if (persona == null || producto == null) {
				
					throw new Exception("Persona o producto no encontrados.");
				
				}
					// Crear una nueva instancia de PersonasProductos
					PersonasProductos compra = new PersonasProductos();
					
					compra.setPersonaId(personaId);
					compra.setProductoId(productoId);
					compra.setCantidad(cantidad);
					// Convertir LocalDate a java.sql.Date
					
					compra.setFechaCompra(java.sql.Date.valueOf(fechaCompra));
					// Persistir la compra en la base de datos
					entityManager.persist(compra);
					entityManager.getTransaction().commit();
					resp = "Se realizó la compra del producto!";
					
			} catch (Exception e) {
				
				if (entityManager.getTransaction().isActive()) {
					
					entityManager.getTransaction().rollback();
				}
				
				JOptionPane.showMessageDialog(null,
				"No se puede registrar la compra del Producto",
				"ERROR", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
			return resp;
		}
	
	public void close() {
		
		entityManager.close();
		JPAUtil.shutdown();
		
	}

	public void setCoordinador(Controlador miControlador) {
		this.miControlador=miControlador;
		
	}

	public List<PersonasProductos> consultarTodasLasCompras() {
		List<PersonasProductos> compras = new ArrayList<>();
	    try {
	        Query query = entityManager.createQuery("SELECT pp FROM PersonasProductos pp");
	        compras = query.getResultList();
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null,
	            "No se pudieron obtener las compras",
	            "ERROR", JOptionPane.ERROR_MESSAGE);
	        e.printStackTrace();
	    }
	    return compras;
	}
	
}



