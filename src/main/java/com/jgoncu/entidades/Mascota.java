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
    private Integer idMascota;

    @Column(nullable = false, length = 45)
    private String nombre;

    @Column(length = 45)
    private String raza;

    @Column(name = "color", length = 45)
    private String colorMascota;

    @Column(length = 45)
    private String sexo;
    
    @ManyToOne
    @JoinColumn(name="persona_id",referencedColumnName = "id_persona")
    private Persona duenio;
    
    public Mascota() {
		
  	}

    // Constructor con parámetros sin el id
    public Mascota(String nombre, String raza, String colorMascota, String sexo ,Persona duenio) {
        super();
        this.nombre = nombre;
        this.raza = raza;
        this.colorMascota = colorMascota;
        this.sexo = sexo;
        this.duenio=duenio;
    }

  

	// Generamos los setters y getters
    public Integer getIdMascota() {
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
    
    public Persona getDuenio() {
    	return duenio;
    }
    
    public void setDuenio(Persona duenio) {
    	this.duenio = duenio;
    }

    @Override
    public String toString() {
        return "Mascota: \n"
        		+"Id de Mascota: " + idMascota + "\n"
        		+"Nombre: " + nombre +"\n"
                +"Raza: " + raza + "\n "
                +"Color de la Mascota: " + colorMascota + "\n"
                +"Sexo: " + sexo + " \n\n"
                +"Dueño: \n"
                + "Documento : "+duenio.getIdPersona()+" \n"
                		+ "Nombre : "+duenio.getNombre();
    }

	public void setIdMascota(Integer idMascota) {
		this.idMascota = idMascota;
		
	}
}
