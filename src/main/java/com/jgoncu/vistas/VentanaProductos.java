package com.jgoncu.vistas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.jgoncu.controlador.Controlador;
import com.jgoncu.entidades.Mascota;
import com.jgoncu.entidades.Nacimiento;
import com.jgoncu.entidades.Persona;
import com.jgoncu.entidades.PersonasProductos;
import com.jgoncu.entidades.Producto;



import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class VentanaProductos extends JFrame implements ActionListener {
	
    private JTextField txtIdProducto, txtNombreProducto, txtPrecioProducto, txtCantidadProducto;
    private JTextArea textAreaResultado;
    private JTable tablaProductos;
    private DefaultTableModel modeloTabla;
    private JButton btnRegistrar, btnActualizar, btnConsultar, btnComprar, btnEliminar, btnConsultarLista;
    private JPanel panelFormulario, panelBotones, panelTabla;
    private Controlador miControlador;
    private JLabel lblIdProducto;
    private JLabel lblNombreProducto;
    private JLabel lblPrecioProducto;
    private JLabel lblCantidadProducto;
    private JLabel lblConsultaId;
    private JTextField txtConsulta;
    private JLabel formRegistro;
    private JLabel formCompra;
    private JLabel lblFecha;
    private JTextField txtFecha;
    private JScrollPane scrollTabla;
    private JTable tablaPersonaProducto;
    private DefaultTableModel modeloTablaPersonaProducto;
    private JScrollPane scrollTablaPersonaProducto;
    private JPanel panelTablaPersonaProducto;
    private JButton btnConsultarPersonaProducto;
    
    
    public VentanaProductos() {
        setTitle("Gestión de Productos");
        setSize(1200, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null); 
        iniciarComplementos();
    }

    private void iniciarComplementos() {

        
        panelFormulario = new JPanel(null);
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Datos del Producto"));
        panelFormulario.setBounds(20, 20, 800, 220);
        add(panelFormulario);

        lblIdProducto = new JLabel("ID Producto:");
        lblIdProducto.setBounds(350, 30, 100, 25);
        panelFormulario.add(lblIdProducto);

        txtIdProducto = new JTextField();
        txtIdProducto.setBounds(460, 30, 200, 25);
        panelFormulario.add(txtIdProducto);

        lblNombreProducto = new JLabel("Nombre:");
        lblNombreProducto.setBounds(20, 70, 100, 25);
        panelFormulario.add(lblNombreProducto);

        txtNombreProducto = new JTextField();
        txtNombreProducto.setBounds(130, 70, 200, 25);
        panelFormulario.add(txtNombreProducto);

        lblPrecioProducto = new JLabel("Precio:");
        lblPrecioProducto.setBounds(20, 110, 100, 25);
        panelFormulario.add(lblPrecioProducto);

        txtPrecioProducto = new JTextField();
        txtPrecioProducto.setBounds(130, 110, 200, 25);
        panelFormulario.add(txtPrecioProducto);

        lblCantidadProducto = new JLabel("Cantidad:");
        lblCantidadProducto.setBounds(350, 70, 100, 25);
        panelFormulario.add(lblCantidadProducto);

        txtCantidadProducto = new JTextField();
        txtCantidadProducto.setBounds(460, 70, 200, 25);
        panelFormulario.add(txtCantidadProducto);

        lblFecha = new JLabel("Fecha Compra (dd-MM-yyyy):");
        lblFecha.setBounds(350, 110, 200, 25);
        panelFormulario.add(lblFecha);

        txtFecha = new JTextField();
        txtFecha.setBounds(520, 110, 140, 25);
        panelFormulario.add(txtFecha);

        lblConsultaId = new JLabel("Consulta por ID:");
        lblConsultaId.setBounds(220, 160, 150, 25);
        panelFormulario.add(lblConsultaId);

        txtConsulta = new JTextField();
        txtConsulta.setBounds(330, 160, 200, 25);
        panelFormulario.add(txtConsulta);

      
        panelBotones = new JPanel(null);
        panelBotones.setBounds(20, 250, 800, 60);
        add(panelBotones);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(10, 10, 120, 40);
        panelBotones.add(btnRegistrar);

        btnConsultar = new JButton("Consultar");
        btnConsultar.setBounds(140, 10, 120, 40);
        panelBotones.add(btnConsultar);

        btnConsultarLista = new JButton("Consultar Lista");
        btnConsultarLista.setBounds(920, 400, 120, 40);
        add(btnConsultarLista);

        btnComprar = new JButton("Comprar");
        btnComprar.setBounds(400, 10, 120, 40);
        panelBotones.add(btnComprar);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(530, 10, 120, 40);
        panelBotones.add(btnActualizar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(660, 10, 120, 40);
        panelBotones.add(btnEliminar);
        
        
        btnConsultarPersonaProducto = new JButton("Consultar Compras");
        btnConsultarPersonaProducto.setBounds(900, 600, 180, 40);
        add(btnConsultarPersonaProducto);

     
        panelTabla = new JPanel(null);
        panelTabla.setBorder(BorderFactory.createTitledBorder("Lista de Productos"));
        panelTabla.setBounds(20, 320, 800, 200);
        add(panelTabla);

        String[] columnasProductos = {"ID", "Nombre", "Precio"};
        modeloTabla = new DefaultTableModel(null, columnasProductos);
        tablaProductos = new JTable(modeloTabla);
        scrollTabla = new JScrollPane(tablaProductos);
        scrollTabla.setBounds(10, 30, 780, 150);
        panelTabla.add(scrollTabla);

       
        panelTablaPersonaProducto = new JPanel(null);
        panelTablaPersonaProducto.setBorder(BorderFactory.createTitledBorder("Lista de Compras Persona-Producto"));
        panelTablaPersonaProducto.setBounds(20, 530, 800, 200);
        add(panelTablaPersonaProducto);

        String[] columnasPersonaProducto = {"ID Persona", "ID Producto", "Fecha Compra", "Cantidad"};
        modeloTablaPersonaProducto = new DefaultTableModel(null, columnasPersonaProducto);
        tablaPersonaProducto = new JTable(modeloTablaPersonaProducto);
        scrollTablaPersonaProducto = new JScrollPane(tablaPersonaProducto);
        scrollTablaPersonaProducto.setBounds(10, 30, 780, 150);
        panelTablaPersonaProducto.add(scrollTablaPersonaProducto);

      
        btnRegistrar.addActionListener(this);
        btnConsultar.addActionListener(this);
        btnConsultarLista.addActionListener(this);
        btnComprar.addActionListener(this);
        btnActualizar.addActionListener(this);
        btnEliminar.addActionListener(this);
        btnConsultarPersonaProducto.addActionListener(this); 
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
        }else if (e.getSource() == btnConsultarPersonaProducto) {
            consultarListaCompras(); 
        }
    }

    private void registrarProducto() {
        /*String id = txtIdProducto.getText();*/
    	String resultado="";
        String nombre = txtNombreProducto.getText();
        String precio = txtPrecioProducto.getText();
        

        if ( nombre.isEmpty() || precio.isEmpty() ) {
            JOptionPane.showMessageDialog(this, "Todos los campos deben estar diligenciados(Nombre y Precio) para registrar el producto.");
            return;
        }
        	Producto miProducto = new Producto();
        	miProducto.setNombreProducto(nombre);
        	miProducto.setPrecioProducto(Double.parseDouble(precio));
        	
        	 resultado=miControlador.registrarProducto(miProducto);
        	 JOptionPane.showMessageDialog(this, resultado);
             limpiarCampos();
        	
        

       
    }

    private void consultarProducto() {
    	String id = txtConsulta.getText();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el ID del producto a consultar.");
            return;
        }
        
        
        
    	
      	 DefaultTableModel modeloTabla = (DefaultTableModel) tablaProductos.getModel();
   	     modeloTabla.setRowCount(0); 
   	    

	   	 try {
	         
	         Producto miProducto = miControlador.consultarProducto(Integer.parseInt(id));
	
	         if (miProducto != null) {
	         
	             Object[] fila = {
	                 miProducto.getIdProducto(),
	                 miProducto.getNombreProducto(),
	                 miProducto.getPrecioProducto()
	             };
	             modeloTabla.addRow(fila);
	         } else {
	            
	             JOptionPane.showMessageDialog(this, "No se encontró ningún producto con el ID proporcionado.");
	         }
	     } catch (NumberFormatException e) {
	         JOptionPane.showMessageDialog(this, "Por favor ingrese un ID válido (número).");
	     }
	            limpiarCampos();
    }

    private void consultarListaProductos() {
    	
    	
   	 DefaultTableModel modeloTabla = (DefaultTableModel) tablaProductos.getModel();
	    modeloTabla.setRowCount(0); 
	    

	   
	    List<Producto> listaProductos = miControlador.consultarTodosLosProductos();
	   
	   
	    for (Producto miProducto : listaProductos) {
	        Object[] fila = {
	        		miProducto.getIdProducto(),
	        		miProducto.getNombreProducto(),
	        		miProducto.getPrecioProducto()
	            
	        };
	        modeloTabla.addRow(fila);
	    }
         limpiarCampos();
    }
    
    private void consultarListaCompras() {
        modeloTablaPersonaProducto.setRowCount(0); 

        List<PersonasProductos> listaPersonaProducto = miControlador.consultarTodasLasCompras();

        for (PersonasProductos compra : listaPersonaProducto) {
            Object[] fila = {
                    compra.getPersonaId(),
                    compra.getProductoId(),
                    compra.getFechaCompra(),
                    compra.getCantidad()
            };
            modeloTablaPersonaProducto.addRow(fila);
        }
    }


    private void comprarProducto() {
        String id = txtIdProducto.getText();
        String cantidad = txtCantidadProducto.getText();
        String fechaTexto = txtFecha.getText();
        String idPersona = "";
        String resultado = "";

        if (id.isEmpty() || cantidad.isEmpty() || fechaTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el ID, la cantidad del producto y la fecha de la compra.");
            return;
        }

     
        Producto productoExistente = miControlador.consultarProducto(Integer.parseInt(id));
        if (productoExistente == null) {
            JOptionPane.showMessageDialog(this, "No se encontró un producto con el ID proporcionado.");
            return;
        }

    
        LocalDate fechaCompra;
        try {
            fechaCompra = LocalDate.parse(fechaTexto, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Formato de fecha incorrecto. Use dd-MM-yyyy.");
            return;
        }

      
        idPersona = JOptionPane.showInputDialog("Ingrese el Documento del comprador");
        if (idPersona == null || idPersona.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un documento válido.");
            return;
        }

       
        Persona pComprador = miControlador.consultarPersona(idPersona);
        if (pComprador == null) {
            JOptionPane.showMessageDialog(this, "No se encontró un comprador con el documento proporcionado.");
            return;
        }

      
        int cantidadCompra;
        try {
            cantidadCompra = Integer.parseInt(cantidad);
            if (cantidadCompra <= 0) {
                JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor a cero.");
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un valor numérico válido para la cantidad.");
            return;
        }

        // Registrar la compra
        try {
            resultado = miControlador.registrarCompra(pComprador.getIdPersona(), productoExistente.getIdProducto(), fechaCompra, cantidadCompra);
            if (resultado != null && !resultado.isEmpty()) {
                JOptionPane.showMessageDialog(this, resultado);
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar la compra.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al realizar la compra: " + ex.getMessage());
        }

        limpiarCampos();
    }


    private void actualizarProducto() {
    	String resultado = "";
        String id = txtConsulta.getText();
        String nombre = txtNombreProducto.getText();
        String precio = txtPrecioProducto.getText();
        
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el ID del producto a actualizar.");
            return;
        }
        Producto productoExistente= miControlador.consultarProducto(Integer.parseInt(id));
        	
        	if (productoExistente == null) {
        		
        		 JOptionPane.showMessageDialog(this, "No existente Producto con el ID ingresado");
        		 return;
        	}
        
	        Producto miProducto = new Producto();
	        miProducto.setIdProducto(productoExistente.getIdProducto());
	    	miProducto.setNombreProducto(nombre);
	    	miProducto.setPrecioProducto(Double.parseDouble(precio));
	    	
	    	resultado=miControlador.actualizarProducto(miProducto);
        
	    	 JOptionPane.showMessageDialog(this, resultado);
             limpiarCampos();
    }

    private void eliminarProducto() {
    	String resultado ="";
        String id = txtConsulta.getText();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el ID del producto a eliminar.");
            return;
        }else {
	        try {
	            Producto miProducto = miControlador.consultarProducto(Integer.parseInt(id));
	            if (miProducto == null) {
	            	JOptionPane.showMessageDialog(null,"La mascota no se encuentra en los registros");
	            } else {
	                resultado = miControlador.eliminarProducto(miProducto);
	                
	            }
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "Error al eliminar la mascota: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        }
        	
	        JOptionPane.showMessageDialog(this, resultado);
            limpiarCampos();
        }
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
