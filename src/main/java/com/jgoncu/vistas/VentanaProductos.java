package com.jgoncu.vistas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.jgoncu.controlador.Controlador;

import java.awt.*;
import java.awt.event.*;

public class VentanaProductos extends JFrame implements ActionListener {
	
    private JTextField txtIdProducto, txtNombreProducto, txtPrecioProducto, txtCantidadProducto;
    private JTextArea textAreaResultado;
    private JTable tablaProductos;
    private DefaultTableModel modeloTabla;
    private JButton btnRegistrar, btnActualizar, btnConsultar, btnComprar, btnEliminar, btnConsultarLista;
    private JPanel panelFormulario, panelBotones, panelTabla;
    private Controlador miControlador;

    public VentanaProductos() {
        setTitle("Gestión de Productos");
        setSize(820, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); 
        iniciarComplementos();
    }

    private void iniciarComplementos() {
       
        panelFormulario = new JPanel(null);
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Datos del Producto"));
        panelFormulario.setBounds(20, 20, 350, 250);

        JLabel lblIdProducto = new JLabel("ID Producto:");
        lblIdProducto.setBounds(10, 30, 100, 25);
        panelFormulario.add(lblIdProducto);
        txtIdProducto = new JTextField();
        txtIdProducto.setBounds(120, 30, 200, 25);
        panelFormulario.add(txtIdProducto);

        JLabel lblNombreProducto = new JLabel("Nombre:");
        lblNombreProducto.setBounds(10, 70, 100, 25);
        panelFormulario.add(lblNombreProducto);
        txtNombreProducto = new JTextField();
        txtNombreProducto.setBounds(120, 70, 200, 25);
        panelFormulario.add(txtNombreProducto);

        JLabel lblPrecioProducto = new JLabel("Precio:");
        lblPrecioProducto.setBounds(10, 110, 100, 25);
        panelFormulario.add(lblPrecioProducto);
        txtPrecioProducto = new JTextField();
        txtPrecioProducto.setBounds(120, 110, 200, 25);
        panelFormulario.add(txtPrecioProducto);

        JLabel lblCantidadProducto = new JLabel("Cantidad:");
        lblCantidadProducto.setBounds(10, 150, 100, 25);
        panelFormulario.add(lblCantidadProducto);
        txtCantidadProducto = new JTextField();
        txtCantidadProducto.setBounds(120, 150, 200, 25);
        panelFormulario.add(txtCantidadProducto);

        // Panel de botones
        panelBotones = new JPanel(null);
        panelBotones.setBounds(10, 280, 780, 60);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(10, 10, 120, 40);
        panelBotones.add(btnRegistrar);

        btnConsultar = new JButton("Consultar");
        btnConsultar.setBounds(140, 10, 120, 40);
        panelBotones.add(btnConsultar);

        btnConsultarLista = new JButton("Consultar Lista");
        btnConsultarLista.setBounds(270, 10, 120, 40);
        panelBotones.add(btnConsultarLista);

        btnComprar = new JButton("Comprar");
        btnComprar.setBounds(400, 10, 120, 40);
        panelBotones.add(btnComprar);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(530, 10, 120, 40);
        panelBotones.add(btnActualizar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(660, 10, 120, 40);
        panelBotones.add(btnEliminar);

        // Panel de tabla
        panelTabla = new JPanel(null);
        panelTabla.setBorder(BorderFactory.createTitledBorder("Lista de Productos"));
        panelTabla.setBounds(20, 350, 760, 250);

        modeloTabla = new DefaultTableModel(new String[]{"ID", "Nombre", "Precio", "Cantidad"}, 0);
        tablaProductos = new JTable(modeloTabla);
        JScrollPane scrollTabla = new JScrollPane(tablaProductos);
        scrollTabla.setBounds(10, 30, 740, 180);
        panelTabla.add(scrollTabla);

        textAreaResultado = new JTextArea();
        textAreaResultado.setBounds(10, 210, 740, 30);
        textAreaResultado.setEditable(false);
        panelTabla.add(new JScrollPane(textAreaResultado));

        // Añadir los paneles al JFrame
        add(panelFormulario);
        add(panelBotones);
        add(panelTabla);

        // Acciones de los botones
        btnRegistrar.addActionListener(this);
        btnConsultar.addActionListener(this);
        btnConsultarLista.addActionListener(this);
        btnComprar.addActionListener(this);
        btnActualizar.addActionListener(this);
        btnEliminar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegistrar) {
            registrarProducto();
        } else if (e.getSource() == btnConsultar) {
            consultarProducto();
        } else if (e.getSource() == btnActualizar) {
            actualizarProducto();
        } else if (e.getSource() == btnEliminar) {
            eliminarProducto();
        } else if (e.getSource() == btnConsultarLista) {
            consultarListaProductos();
        } else if (e.getSource() == btnComprar) {
            comprarProducto();
        }
    }

    private void registrarProducto() {
        String id = txtIdProducto.getText();
        String nombre = txtNombreProducto.getText();
        String precio = txtPrecioProducto.getText();
        String cantidad = txtCantidadProducto.getText();

        if (id.isEmpty() || nombre.isEmpty() || precio.isEmpty() || cantidad.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos deben estar diligenciados.");
            return;
        }

        modeloTabla.addRow(new Object[]{id, nombre, precio, cantidad});
        textAreaResultado.setText("Producto registrado exitosamente.");
        limpiarCampos();
    }

    private void consultarProducto() {
        String id = txtIdProducto.getText();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el ID del producto a consultar.");
            return;
        }
        
        textAreaResultado.setText("Producto consultado: " + id);
    }

    private void consultarListaProductos() {
        textAreaResultado.setText("Lista completa de productos cargada.");
    }

    private void comprarProducto() {
        String id = txtIdProducto.getText();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el ID del producto a comprar.");
            return;
        }
        
        textAreaResultado.setText("Producto comprado: " + id);
    }

    private void actualizarProducto() {
        String id = txtIdProducto.getText();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el ID del producto a actualizar.");
            return;
        }
     
        textAreaResultado.setText("Producto actualizado: " + id);
    }

    private void eliminarProducto() {
        String id = txtIdProducto.getText();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el ID del producto a eliminar.");
            return;
        }
        
        textAreaResultado.setText("Producto eliminado: " + id);
    }

    private void limpiarCampos() {
        txtIdProducto.setText("");
        txtNombreProducto.setText("");
        txtPrecioProducto.setText("");
        txtCantidadProducto.setText("");
    }

   

    public void setCoordinador(Controlador miControlador) {
        this.miControlador = miControlador;
    }
}
