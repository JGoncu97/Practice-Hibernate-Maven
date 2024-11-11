package com.jgoncu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.jgoncu.aplicacion.JPAUtil;
import com.jgoncu.controlador.Controlador;
import com.jgoncu.entidades.Mascota;

import jakarta.persistence.*;

public class MascotaDao {
	
	EntityManager entityManager=JPAUtil.getEntityManagerFactory().createEntityManager();
	private Controlador miControlador;
	
		public String registrarMascota(Mascota miMascota) {
			String resp="";
			
			try {
				
				entityManager.getTransaction().begin();
				entityManager.persist(miMascota);
				entityManager.getTransaction().commit();
				resp="Mascota Registrada!";
				
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null,"No se puede registrar "
				+ "la mascota verifique qué el dueño exista",
				"ERROR",JOptionPane.ERROR_MESSAGE);

			}
			return resp;
		}
		
		public Mascota consultarMascota(String idMascota) {
			
			Mascota miMascota=entityManager.find(Mascota.class,idMascota);
			if (miMascota!=null) {
				return miMascota;
			}else {
				return null;
			}
		}
		
		public List<Mascota> consultarListaMascotas() {

			List<Mascota> listaMascotas=new ArrayList<Mascota>();
			Query query=entityManager.createQuery("SELECT m FROM Mascota m");
			
			listaMascotas=query.getResultList();
			
			return listaMascotas;
		}
		
		public List<Mascota> consultarListaMascotasPorSexo(String sexo) {
			
			List<Mascota> listaMascotas=new ArrayList<Mascota>();
			String sentencia="SELECT m FROM Mascota m WHERE m.sexo= :sexoMascota";
			Query query=entityManager.createQuery(sentencia);
				query.setParameter("sexoMascota", sexo);
			listaMascotas=query.getResultList();
			
			return listaMascotas;
		}
		
		public String actualizarMascota(Mascota miMascota) {
			
			entityManager.getTransaction().begin();
			entityManager.merge(miMascota);
			entityManager.getTransaction().commit();
			String resp="Mascota Actualizada!";
			
				return resp;
		}
		
		public String eliminarMascota(Mascota miMascota) {
			
			entityManager.getTransaction().begin();
			entityManager.remove(miMascota);
			entityManager.getTransaction().commit();
			String resp="Mascota Eliminada!";
			
				return resp;
		}
		
		public void close() {
			   if (entityManager != null && entityManager.isOpen()) {
			        entityManager.close();
			    }
		}

		public void setCoordinador(Controlador miControlador) {
			this.miControlador=miControlador;
		}
	
}
