package com.jgoncu.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jgoncu.controlador.*;
import com.jgoncu.entidades.Mascota;
import com.jgoncu.entidades.Persona;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JSeparator;

public class VentanaMascotas extends JFrame implements ActionListener {

	private JPanel contentPane;
    private JTextField txtId;
    private JTextField txtRaza;
    private JTextField txtNombre;
    private JTextField txtSexo;
    private JTextField txtColor; 
    private JLabel lblId;
    private JLabel lblTitulo;
    private JLabel lblRaza;
    private JLabel lblNombre;
    private JLabel lblSexo;
    private JLabel lblColor;  
    private JButton btnRegistrar;
    private JButton btnConsultar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnConsultarLista;
    private JScrollPane scrollPane;
    private JTextArea textArea;
    private JSeparator separator;
    private Controlador miControlador;
    private Persona persona;

    /**
     * Create the frame.
     */
    public VentanaMascotas() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        iniciarComponentes();

        setTitle("Ventana Gestionar Mascotas");
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void iniciarComponentes() {
        setBounds(100, 100, 600, 800);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblTitulo = new JLabel("Gestionar Mascotas");
        lblId = new JLabel("Consultar Mascota por ID :");
        lblNombre = new JLabel("Nombre:");
        lblRaza = new JLabel("Raza:");
        lblSexo = new JLabel("Sexo:");
        lblColor = new JLabel("Color:");  

        txtId = new JTextField();
        txtNombre = new JTextField();
        txtRaza = new JTextField();
        txtSexo = new JTextField();
        txtColor = new JTextField(); 

        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Verdana", Font.BOLD, 30));
        lblTitulo.setBounds(10, 20, 576, 40);
        contentPane.add(lblTitulo);
        
        lblId.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblId.setBounds(30, 240, 400, 30);
        contentPane.add(lblId);

        txtId.setBounds(280, 240, 175, 30);
        contentPane.add(txtId);
        txtId.setColumns(10);

        lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNombre.setBounds(30, 100, 95, 30);
        contentPane.add(lblNombre);

        txtNombre.setColumns(10);
        txtNombre.setBounds(110, 100, 165, 30);
        contentPane.add(txtNombre);

        lblRaza.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblRaza.setBounds(295, 100, 60, 30);
        contentPane.add(lblRaza);

        txtRaza.setColumns(10);
        txtRaza.setBounds(356, 100, 200, 30);
        contentPane.add(txtRaza);

        lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblSexo.setBounds(295, 170, 81, 30);
        contentPane.add(lblSexo);

        txtSexo.setColumns(10);
        txtSexo.setBounds(356, 170, 200, 30);
        contentPane.add(txtSexo);

        lblColor.setFont(new Font("Tahoma", Font.PLAIN, 18));  
        lblColor.setBounds(30, 170, 81, 30);
        contentPane.add(lblColor);

        txtColor.setColumns(10);
        txtColor.setBounds(90, 170, 175, 30);
        contentPane.add(txtColor);

        btnRegistrar = new JButton("Registrar");
        btnConsultar = new JButton("Consultar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");
        btnConsultarLista = new JButton("Consultar Lista");

        btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnRegistrar.setBounds(80, 300, 180, 40);
        contentPane.add(btnRegistrar);
        btnRegistrar.addActionListener(this);

        btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnConsultar.setBounds(321, 300, 180, 40);
        contentPane.add(btnConsultar);
        btnConsultar.addActionListener(this);

        btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnActualizar.setBounds(80, 360, 180, 40);
        contentPane.add(btnActualizar);
        btnActualizar.addActionListener(this);

        btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnEliminar.setBounds(321, 360, 180, 40);
        contentPane.add(btnEliminar);
        btnEliminar.addActionListener(this);

        btnConsultarLista.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnConsultarLista.setBounds(80, 420, 421, 40);
        contentPane.add(btnConsultarLista);
        btnConsultarLista.addActionListener(this);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(40, 480, 500, 280);
        contentPane.add(scrollPane);

        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);

        separator = new JSeparator();
        separator.setBounds(30, 220, 532, 2);
        contentPane.add(separator);
        
    }




	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== btnRegistrar) {
			registrarMascota();
		}else if ( e.getSource()== btnActualizar) {
			actualizarMascota();
		}else if( e.getSource()== btnConsultar) {
			consultarMascota();
		}else if ( e.getSource()== btnEliminar) {
			eliminacionMascota();
		}else if( e.getSource() == btnConsultarLista) {
			consultarListMascota();
		}
		
	}
	
	public void registrarMascota() {
	    int duenio;
	    String resultado = "";
	    String nombre = txtNombre.getText();
	    String raza = txtRaza.getText();
	    String sexo = txtSexo.getText();
	    String color = txtColor.getText();
	    
	    if (nombre.isEmpty() || raza.isEmpty() || sexo.isEmpty() || color.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Todos los campos deben estar diligenciados obligatoriamente");
	    } else {
	        Mascota miMascota = new Mascota();
	        miMascota.setNombre(nombre);
	        miMascota.setRaza(raza);
	        miMascota.setSexo(sexo);
	        miMascota.setColorMascota(color);
	        
	        if (persona != null) {
	           
	            miMascota.setDuenio(persona);
	            resultado = miControlador.registrarMascota(miMascota); 
	            limpiarCampos();
	        } else {
	            duenio = Integer.parseInt(JOptionPane.showInputDialog("¿Desea asociar un dueño a la mascota? \n"
	                + "Escriba el numero de su eleccion : \n"
	                + "1. Si \n"
	                + "2. No \n\n"));
	            
	            switch (duenio) {
	                case 1:
	                    String documento = JOptionPane.showInputDialog("Escriba el documento del dueño");
	                    Persona idDuenio = miControlador.consultarPersona(documento);
	                    
	                    if (idDuenio == null) {
	                        textArea.setText("La Persona no se encuentra en los registros");
	                    } else {
	                        miMascota.setDuenio(idDuenio);  
	                        resultado = miControlador.registrarMascota(miMascota);
	                        limpiarCampos();
	                    }
	                    break;
	                case 2:
	                    resultado = miControlador.registrarMascota(miMascota);
	                    JOptionPane.showMessageDialog(this, resultado);
	                    limpiarCampos();
	                    break;
	                default:
	                    JOptionPane.showMessageDialog(this, "Opción inválida.");
	                    break;
	            }
	        }
	    }
	}

	
	
	public void actualizarMascota() {
		String resultado = "";
		
		String id= txtId.getText();
		String nombre= txtNombre.getText();
		String raza= txtRaza.getText();
		String sexo= txtSexo.getText();
		String color = txtColor.getText();
		
		
		
		if (id.isEmpty() || nombre.isEmpty() || raza.isEmpty() || sexo.isEmpty() || color.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Todos los campos deben estar diligenciados obligatoriamente");
				
			} else {
				Mascota miMascota = new Mascota();
				miMascota.setIdDueño(Integer.parseInt(id));
				miMascota.setNombre(nombre);
				miMascota.setRaza(raza);
				miMascota.setSexo(sexo);
				miMascota.setColorMascota(color);
				
					 resultado = miControlador.actualizarMascota(miMascota);
		        		JOptionPane.showMessageDialog(this, resultado);
		    	        limpiarCampos();
					 
					 
					
				}
		
	}
				 
			
	
	public void consultarMascota() {
		String id = txtId.getText();
		
		if (id.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Ingrese el id de la mascota  para verificar la existencia en los registros");
			
		} else {
			try {
				Mascota miMascota = miControlador.consultarMascota(id);
				if (miMascota == null) {
					textArea.setText("La Mascota no se encuentra en los registros");
					
				} else {
					textArea.setText(miMascota.toString());
					
				}
				
			} catch (RuntimeException e) {
				JOptionPane.showMessageDialog(null, "Error al consultar la Mascota: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			
		}
	}
	
	
	public void eliminacionMascota() {
		 String resultado = "";
		    String id = txtId.getText();
		    if (id.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "Ingrese id para verificar la existencia en los registros");
		    } else {
		        try {
		            Mascota miMascota = miControlador.consultarMascota(id);
		            if (miMascota == null) {
		                textArea.setText("La mascota no se encuentra en los registros");
		            } else {
		                resultado = miControlador.eliminarMascota(miMascota);
		                textArea.setText(resultado);
		            }
		        } catch (Exception e) {
		            JOptionPane.showMessageDialog(null, "Error al eliminar la mascota: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        }
		    
		}
	}
	
	
	public void consultarListMascota() {
		StringBuilder listaMascota = new StringBuilder();
		for(Mascota mascota: miControlador.consultarListaMascota()) {
			listaMascota.append("Mascota: ").append("\n")
						.append("Id Mascota: ").append(mascota.getIdMascota()).append("\n")
						.append("Nombre: ").append(mascota.getNombre()).append("\n")
						.append("Raza: ").append(mascota.getRaza()).append("\n")
						.append("Sexo: ").append(mascota.getSexo()).append("\n")
						.append("Color: ").append(mascota.getColorMascota()).append("\n\n");
		}	
		
		textArea.setText(!listaMascota.isEmpty() ? listaMascota.toString() : "No hay mascotas registradas");
	}
	
	
	private void limpiarCampos() {
		txtId.setText("");
		txtRaza.setText("");
		txtNombre.setText("");
		txtSexo.setText("");
		txtColor.setText("");
	}


	public void setCoordinador(Controlador miControlador) {
		this.miControlador = miControlador;
		
	}
	
	 public void setPersona(Persona persona) {
	        this.persona = persona;
	    }



}
