package com.jgoncu.entidades;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="personas_productos")
public class PersonasProductos implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "persona_id", nullable = false)
	private String personaId;
	@Column(name = "producto_id", nullable = false)
	private int productoId;
	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;
	@Column(name = "fecha_compra", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fechaCompra;

	public PersonasProductos() {}

	public PersonasProductos(String personaId, int productoId, Integer cantidad, Date fechaCompra) {
		this.personaId = personaId;
		this.productoId = productoId;
		this.cantidad = cantidad;
		this.fechaCompra = fechaCompra;
	}

	public int getId() {
		return id;
	}
	
	public String getPersonaId() {
		return personaId;
	}
	
	public void setPersonaId(String personaId) {
		this.personaId = personaId;
	}
	
	public int getProductoId() {
		return productoId;
	}

	public void setProductoId(int productoId) {
		this.productoId = productoId;
	}
	
	public Integer getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public Date getFechaCompra() {
		return fechaCompra;
	}
	
	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	@Override
	public String toString() {
		return "PersonasProductos [id=" + id + ", personaId=" + personaId + ", productoId=" + productoId + ", cantidad=" + cantidad + ", fechaCompra=" + fechaCompra + "]";
	}
}
