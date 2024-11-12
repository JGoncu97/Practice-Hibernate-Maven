package com.jgoncu.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jgoncu.controlador.*;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame implements ActionListener {

	
	private JPanel panelPrincipal;
	private JLabel lblTitulo;
	private JButton btnPersonas;
	private JButton btnMascotas;
	private Controlador miControlador;
	private JButton btnProductos;
	


	public VentanaPrincipal() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		iniciarComponentes();
		
		setTitle("Ventana Principal");
		setLocationRelativeTo(null);
		setResizable(false);				
		
	}
	
	
	

	private void iniciarComponentes() {
		setBounds(100, 100, 657, 491);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);		
		
		lblTitulo = new JLabel("Veterinaria JPA");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 30));
		lblTitulo.setBounds(10, 40, 623, 37);
		panelPrincipal.add(lblTitulo);
		
		btnPersonas = new JButton("Gestionar Personas");
		btnPersonas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPersonas.setBounds(79, 353, 180, 40);
		panelPrincipal.add(btnPersonas);
		btnPersonas.addActionListener(this);
		
		btnMascotas = new JButton("Gestionar Mascotas");
		btnMascotas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMascotas.setBounds(384, 353, 180, 40);
		panelPrincipal.add(btnMascotas);
		btnMascotas.addActionListener(this);
		
		btnProductos = new JButton("Gestion de Productos");
		btnProductos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnProductos.setBounds(230, 400, 180, 40);
		panelPrincipal.add(btnProductos);
		btnProductos.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnPersonas) {
			miControlador.ventanaPersona();
		} else if (e.getSource() == btnMascotas) {
			miControlador.ventanaMascota();
		}else if ( e.getSource() == btnProductos) {
			miControlador.ventanaProducto();
		}
	}





	public void setCoordinador(Controlador miControlador) {
		this.miControlador = miControlador;
		
	}






}
