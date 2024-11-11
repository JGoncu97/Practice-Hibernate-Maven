package com.jgoncu.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.jgoncu.controlador.Controlador;
import com.jgoncu.entidades.Persona;
import com.jgoncu.entidades.Nacimiento;

public class VentanaPersonas extends JFrame implements ActionListener {

	  private JPanel miPanel;
	    private JTextField txtDoc, txtTelefono, txtNombre, txtProfesion, txtCiudad, txtDepartamento, txtPais, txtFecha;
	    private JLabel lblDoc, lblTitulo, lblTelefono, lblNombre, lblProfesion, lblTipo, lblNacimiento, lblCiudad, lblDepartamento, lblPais, lblFecha;
	    private JButton btnRegistrar, btnConsultar, btnActualizar, btnEliminar, btnConsultarLista;
	    private JScrollPane scrollPane;
	    private JTextArea textArea;
	    private JSeparator separator;
	    private JComboBox<String> comboTipo;
	    private Controlador miControlador;
	

	
	public VentanaPersonas() {
		 	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        iniciarComponentes();
	        setTitle("Ventana Gestionar Personas");
	        setLocationRelativeTo(null);
	        setResizable(false);
	}
	

	private void iniciarComponentes() {
		 setBounds(100, 100, 1300, 1000);
	        miPanel = new JPanel();
	        miPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(miPanel);
	        miPanel.setLayout(null);

	        lblTitulo = new JLabel("Gestionar Personas");
	        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
	        lblTitulo.setFont(new Font("Verdana", Font.BOLD, 30));
	        lblTitulo.setBounds(10, 20, 676, 40);
	        miPanel.add(lblTitulo);

	     
	        lblDoc = new JLabel("Documento:");
	        lblDoc.setFont(new Font("Tahoma", Font.PLAIN, 18));
	        lblDoc.setBounds(30, 80, 110, 30);
	        miPanel.add(lblDoc);
	        txtDoc = new JTextField();
	        txtDoc.setBounds(150, 80, 160, 30);
	        miPanel.add(txtDoc);

	   
	        lblNombre = new JLabel("Nombre:");
	        lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
	        lblNombre.setBounds(30, 130, 110, 30);
	        miPanel.add(lblNombre);
	        txtNombre = new JTextField();
	        txtNombre.setBounds(150, 130, 160, 30);
	        miPanel.add(txtNombre);

	
	        lblTelefono = new JLabel("Telefono:");
	        lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 18));
	        lblTelefono.setBounds(30, 180, 110, 30);
	        miPanel.add(lblTelefono);
	        txtTelefono = new JTextField();
	        txtTelefono.setBounds(150, 180, 160, 30);
	        miPanel.add(txtTelefono);

	 
	        lblProfesion = new JLabel("Profesión:");
	        lblProfesion.setFont(new Font("Tahoma", Font.PLAIN, 18));
	        lblProfesion.setBounds(30, 230, 110, 30);
	        miPanel.add(lblProfesion);
	        txtProfesion = new JTextField();
	        txtProfesion.setBounds(150, 230, 160, 30);
	        miPanel.add(txtProfesion);


	        lblTipo = new JLabel("Tipo:");
	        lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 18));
	        lblTipo.setBounds(30, 280, 110, 30);
	        miPanel.add(lblTipo);
	        comboTipo = new JComboBox<>(new String[]{"1", "2", "3"});
	        comboTipo.setBounds(150, 280, 160, 30);
	        miPanel.add(comboTipo);

	      
	        lblNacimiento = new JLabel("Nacimiento");
	        lblNacimiento.setFont(new Font("Tahoma", Font.BOLD, 18));
	        lblNacimiento.setBounds(30, 330, 200, 30);
	        miPanel.add(lblNacimiento);

	        lblFecha = new JLabel("Fecha (dd-MM-yyyy):");
	        lblFecha.setBounds(30, 380, 160, 30);
	        miPanel.add(lblFecha);
	        txtFecha = new JTextField();
	        txtFecha.setBounds(200, 380, 160, 30);
	        miPanel.add(txtFecha);

	        lblCiudad = new JLabel("Ciudad:");
	        lblCiudad.setBounds(30, 430, 160, 30);
	        miPanel.add(lblCiudad);
	        txtCiudad = new JTextField();
	        txtCiudad.setBounds(200, 430, 160, 30);
	        miPanel.add(txtCiudad);

	        lblDepartamento = new JLabel("Departamento:");
	        lblDepartamento.setBounds(30, 480, 160, 30);
	        miPanel.add(lblDepartamento);
	        txtDepartamento = new JTextField();
	        txtDepartamento.setBounds(200, 480, 160, 30);
	        miPanel.add(txtDepartamento);

	        lblPais = new JLabel("País:");
	        lblPais.setBounds(30, 530, 160, 30);
	        miPanel.add(lblPais);
	        txtPais = new JTextField();
	        txtPais.setBounds(200, 530, 160, 30);
	        miPanel.add(txtPais);
			
			btnRegistrar = new JButton("Registrar");
			btnConsultar = new JButton("Consultar");
			btnActualizar = new JButton("Actualizar");
			btnEliminar = new JButton("Eliminar");
			btnConsultarLista = new JButton("Consultar Lista");
			
			btnRegistrar = new JButton("Registrar");
		    btnRegistrar.setBounds(320, 600, 150, 40);
		    btnRegistrar.addActionListener(this);
		    miPanel.add(btnRegistrar);
			
		
			btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnConsultar.setBounds(480, 600, 180, 40);
			miPanel.add(btnConsultar);
			btnConsultar.addActionListener(this);
			
			
			btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnActualizar.setBounds(670, 600, 180, 40);
			miPanel.add(btnActualizar);
			btnActualizar.addActionListener(this);
			
			
			btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnEliminar.setBounds(860, 600, 180, 40);
			miPanel.add(btnEliminar);
			btnEliminar.addActionListener(this);
		
		
			btnConsultarLista.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnConsultarLista.setBounds(450, 660, 421, 40);
			miPanel.add(btnConsultarLista);
			btnConsultarLista.addActionListener(this);
			
			scrollPane = new JScrollPane();
			scrollPane.setBounds(600, 80, 600, 400);
			miPanel.add(scrollPane);
			
			textArea = new JTextArea();
			textArea.setEditable(false);
			scrollPane.setViewportView(textArea);
		
			separator = new JSeparator();
			separator.setBounds(30, 330, 532, 2);
			miPanel.add(separator);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrar) {
			registrarPersona();
		} else if (e.getSource() == btnConsultar) {
			consultarPersona();
		} else if (e.getSource() == btnActualizar) {
			actualizarPersona();
		} else if (e.getSource() == btnEliminar) {
			eliminacionPersona();
		}else if ( e.getSource() == btnConsultarLista) {
			consultarListPersona();
		}
		
		
	}
	
	public void registrarPersona() {
		int registerMascota;
		String resultado="";
		String documento = txtDoc.getText().trim();
        String nombre = txtNombre.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String profesion = txtProfesion.getText().trim();
        int tipo = Integer.parseInt((String) comboTipo.getSelectedItem());
        String fechaTexto = txtFecha.getText().trim();
        String ciudad = txtCiudad.getText().trim();
        String departamento = txtDepartamento.getText().trim();
        String pais = txtPais.getText().trim();
        
        if (documento.isEmpty() || nombre.isEmpty() || telefono.isEmpty() || profesion.isEmpty() || fechaTexto.isEmpty() || ciudad.isEmpty() || departamento.isEmpty() || pais.isEmpty()) {
        	
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar diligenciados obligatoriamente");
            return; 
			
		} else {
	
			LocalDate fechaNacimiento = LocalDate.parse(fechaTexto, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
				
	        Nacimiento nacimiento = new Nacimiento(null, fechaNacimiento, ciudad, departamento, pais);
	        Persona persona = new Persona(documento, nombre, telefono, profesion, tipo, nacimiento);
	        
	        registerMascota= Integer.parseInt(JOptionPane.showInputDialog("¿Desea Registrar una mascota? \n"
	        		+ "Escriba el numero de su eleccion : \n"
	        		+ "1. Si \n"
	        		+ "2. No \n\n"));
	        
	        switch (registerMascota) {
	        
	        	case 1:
	        		resultado = miControlador.registrarPersona(persona);
	        		miControlador.ventanaMascotaPersona(persona);

	        		break;
	        	case 2:
	        		resultado = miControlador.registrarPersona(persona);
	        		JOptionPane.showMessageDialog(this, resultado);
	    	        limpiarCampos();
	        		break;
	        	
	        	default:
	        		JOptionPane.showMessageDialog(this, "Opción inválida.");
	        		break;
	        
	        }
	        
	       
	
	        
	        
		}
	}
	
	public void actualizarPersona() {
		String resultado="";
		String documento = txtDoc.getText().trim();
        String nombre = txtNombre.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String profesion = txtProfesion.getText().trim();
        int tipo = Integer.parseInt((String) comboTipo.getSelectedItem());
        String fechaTexto = txtFecha.getText().trim();
        String ciudad = txtCiudad.getText().trim();
        String departamento = txtDepartamento.getText().trim();
        String pais = txtPais.getText().trim();
        
		
        if (documento.isEmpty() || nombre.isEmpty() || telefono.isEmpty() || profesion.isEmpty() || fechaTexto.isEmpty() || ciudad.isEmpty() || departamento.isEmpty() || pais.isEmpty()) {
        	
                JOptionPane.showMessageDialog(null, "Todos los campos deben estar diligenciados obligatoriamente");
                return; 
				
			} else {
				
				LocalDate fechaNacimiento = LocalDate.parse(fechaTexto, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
				
				Nacimiento nacimiento = new Nacimiento(null, fechaNacimiento, ciudad, departamento, pais);
		        Persona miPersona = new Persona(documento, nombre, telefono, profesion, tipo, nacimiento);
				miPersona.setIdPersona(documento);
				miPersona.setNombre(nombre);
				miPersona.setTelefono(telefono);
				miPersona.setProfesion(profesion);
				miPersona.setTipo(tipo);
				miPersona.setNacimiento(nacimiento);
				

				resultado = miControlador.actualizarPersona(miPersona);
				
				JOptionPane.showMessageDialog(null, resultado);
				
				limpiarCampos();
				
			}
	}
	
	public void consultarPersona() {
		String documento = txtDoc.getText();
		
		if (documento.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Ingrese un documento para verificar la existencia en los registros");
			
		} else {
			try {
				Persona miPersona = miControlador.consultarPersona(documento);
				if (miPersona == null) {
					textArea.setText("La Persona no se encuentra en los registros");
					
				} else {
					textArea.setText(miPersona.toString());
					
				}
				
			} catch (RuntimeException e) {
				JOptionPane.showMessageDialog(null, "Error al consultar la persona: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			
		}
	}
	
	public void eliminacionPersona() {
		String resultado="";
		String documento = txtDoc.getText();
		if(documento.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Ingrese un documento para verificar la existencia en los registros");
		}else {
			try {
				Persona miPersona= miControlador.consultarPersona(documento);
				if(miPersona== null) {
					textArea.setText("La Persona no se encuentra en los registros");
				}else {
					resultado= miControlador.eliminarPersona(miPersona);
					textArea.setText(resultado);
					
				}
				
			}catch(RuntimeException e) {
				
			}
		}
	}
	
	public void consultarListPersona() {
		StringBuilder listaPersona = new StringBuilder();
		for(Persona persona: miControlador.consultarListaPersonas()) {
			listaPersona.append("Usuario: ").append("\n")
						.append("Documento: ").append(persona.getIdPersona()).append("\n")
						.append("Nombre: ").append(persona.getNombre()).append("\n")
						.append("Telefono: ").append(persona.getTelefono()).append("\n")
						.append("Profesion: ").append(persona.getProfesion()).append("\n")
						.append("Tipo de usuario: ").append(persona.getTipo()).append("\n\n");
			
		}
		
		textArea.setText(!listaPersona.isEmpty() ? listaPersona.toString() : "No hay personas registradas");
	}
	
	private void limpiarCampos() {
			txtDoc.setText("");
	        txtNombre.setText("");
	        txtTelefono.setText("");
	        txtProfesion.setText("");
	        txtFecha.setText("");
	        txtCiudad.setText("");
	        txtDepartamento.setText("");
	        txtPais.setText("");
		
	}

	


	public void setCoordinador(Controlador miControlador) {
		this.miControlador=miControlador;
		
	}

	
}
