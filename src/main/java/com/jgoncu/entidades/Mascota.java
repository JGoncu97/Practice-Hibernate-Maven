package com.jgoncu.entidades;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name = "mascotas")
public class Mascota implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota")
    private String idMascota;

    @Column(nullable = false, length = 45)
    private String nombre;

    @Column(length = 45)
    private String raza;

    @Column(name = "color", length = 45)
    private String colorMascota;

    @Column(length = 45)
    private String sexo;
    
    public Mascota() {
		
  	}

    // Constructor con parámetros sin el id
    public Mascota(String nombre, String raza, String colorMascota, String sexo) {
        super();
        this.nombre = nombre;
        this.raza = raza;
        this.colorMascota = colorMascota;
        this.sexo = sexo;
    }

  

	// Generamos los setters y getters
    public String getIdMascota() {
        return idMascota;
    }

  
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColorMascota() {
        return colorMascota;
    }

    public void setColorMascota(String colorMascota) {
        this.colorMascota = colorMascota;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Mascota: \n"
        		+"idMascota: " + idMascota + "\n "
        		+ "nombre: " + nombre +"\n"
                +"raza: " + raza + "\n "
                +"colorMascota: " + colorMascota + "\n"
                +"sexo: " + sexo + " \n\n";
    }

	public void setIdDueño(String idMascota) {
		this.idMascota = idMascota;
		
	}
}
