package Controlador;

import Modelo.Camionero;
import Modelo.Cliente;
import Modelo.Modelo_Camionero;
import Modelo.Modelo_Cliente;
import Modelo.Modelo_Persona;
import Modelo.Validaciones;
import Vista.VistaCliente;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;

public class ControladorCliente {

    Modelo_Cliente modelo;
    VistaCliente vista;

    public ControladorCliente(Modelo_Cliente modelo, VistaCliente vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
        cargarTabla();
    }

    public void iniciarControl() {
        vista.getBtncrear().addActionListener(l -> abrirDialogCrear());
        vista.getBtnactualizar().addActionListener(l -> cargarTabla());
        vista.getBtnguardar().addActionListener(l -> crearOModificarPersonaYCliente());
        vista.getBtnmodificar().addActionListener(l -> abrirYCargarDatosEnElDialog());
        vista.getBtneliminar().addActionListener(l -> eliminarPersonaYCliente());
        buscarPersona(); //Metodo para buscar personas
    }

    public void abrirDialogCrear() {
        vista.getjDlgClientes().setName("Creacion de nueva persona ");
        vista.getjDlgClientes().setLocationRelativeTo(vista);
        vista.getjDlgClientes().setSize(1000, 748);
        vista.getjDlgClientes().setTitle("CREAR NUEVA PERSONA");
        vista.getjDlgClientes().setVisible(true);
        vista.getTxtdni().setEditable(true); //Desbloqueo el campo de la cedula
        limpiarDatos(); //Limpia la informacion de los campos
    }

    public void cargarTabla() {
        vista.getTablaclientes().setRowHeight(25);
        DefaultTableModel estructuraTabla = (DefaultTableModel) vista.getTablaclientes().getModel();
        estructuraTabla.setRowCount(0);

        List<Cliente> listap = modelo.listaClientesTabla();

        Holder<Integer> i = new Holder<>(0);

        listap.stream().forEach(persona -> {

            estructuraTabla.addRow(new Object[8]);

            vista.getTablaclientes().setValueAt(persona.getDni(), i.value, 0);
            vista.getTablaclientes().setValueAt(persona.getPrinombre(), i.value, 1);
            vista.getTablaclientes().setValueAt(persona.getApellidopat(), i.value, 2);
            vista.getTablaclientes().setValueAt(persona.getEdad(), i.value, 3);
            vista.getTablaclientes().setValueAt(persona.getGenero(), i.value, 4);
            vista.getTablaclientes().setValueAt(persona.getTelefono(), i.value, 5);
            vista.getTablaclientes().setValueAt(persona.getRuc(), i.value, 6);

            i.value++;
        });
    }

    public void abrirYCargarDatosEnElDialog() {

        int seleccion = vista.getTablaclientes().getSelectedRow();

        if (seleccion == -1) {
            JOptionPane.showMessageDialog(null, "POR FAVOR: Seleccionar una fila");
        } else {

            String cedula = vista.getTablaclientes().getValueAt(seleccion, 0).toString();
            modelo.listaClientesTabla().forEach((pe) -> {
                if (pe.getDni().equals(cedula)) {

                    //Abre el jDialog y carga los datos en el jDialog
                    vista.getjDlgClientes().setName("Editar");
                    vista.getjDlgClientes().setLocationRelativeTo(vista);
                    vista.getjDlgClientes().setSize(1000, 748);
                    vista.getjDlgClientes().setTitle("Editar");
                    vista.getjDlgClientes().setVisible(true);
                    vista.getTxtdni().setEditable(false); //Bloqueo el campo de cedula

                    //Seteo los datos en los campos de texto
                    vista.getTxtdni().setText(pe.getDni());
                    vista.getTxtprinombre().setText(pe.getPrinombre());
                    vista.getTxtsegnombre().setText(pe.getSegnombre());
                    vista.getTxtpriapellido().setText(pe.getApellidopat());
                    vista.getTxtsegapellido().setText(pe.getApellidomat());
                    vista.getTxtdireccion().setText(pe.getDireccion());
                    vista.getTxttelefono().setText(pe.getTelefono());
                    vista.getTxtemail().setText(pe.getEmail());
                    vista.getTxtruc().setText(pe.getRuc());
                    vista.getTxtprofesion().setText(pe.getProfesion());

                    if (pe.getGenero().equalsIgnoreCase("M")) {
                        vista.getMasculino().setSelected(true);
                    } else {
                        if (pe.getGenero().equalsIgnoreCase("F")) {
                            vista.getFemenino().setSelected(true);
                        }
                    }

                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); //Doy formato a la fecha
                    try {
                        Date fecha = formato.parse(pe.getFechanac()); //La fecha la paso de String a Date

                        vista.getJfechanacimiento().setDate(fecha);
                    } catch (ParseException ex) {
                        Logger.getLogger(ControladorCamionero.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        }
    }

    public void crearOModificarPersonaYCliente() {

        Modelo_Persona mipersona = new Modelo_Persona();

        if (vista.getjDlgClientes().getName().equals("Creacion de nueva persona")) { //CREAR

            if (mipersona.validarRepetidos(vista.getTxtdni().getText()) == 0) {
                if (validacionDeDatos()) {
                    String dni = vista.getTxtdni().getText();
                    String prinombre = vista.getTxtprinombre().getText();
                    String segnombre = vista.getTxtsegnombre().getText();
                    String priapellido = vista.getTxtpriapellido().getText();
                    String segapellido = vista.getTxtsegapellido().getText();
                    String direccion = vista.getTxtdireccion().getText();
                    String telefono = vista.getTxttelefono().getText();
                    String email = vista.getTxtemail().getText();
                    String ruc = vista.getTxtruc().getText();
                    String profesion = vista.getTxtprofesion().getText();
                    int edad = Integer.parseInt(vista.getSpinneredad().getValue().toString());

                    Date fecha = vista.getJfechanacimiento().getDate(); //Obtengo la fecha del jDateChooser y la paso a date

                    Modelo_Cliente cliente = new Modelo_Cliente();
                    cliente.setDni(dni);
                    cliente.setPrinombre(prinombre);
                    cliente.setSegnombre(segnombre);
                    cliente.setApellidopat(priapellido);
                    cliente.setApellidomat(segapellido);
                    cliente.setDireccion(direccion);
                    cliente.setTelefono(telefono);
                    cliente.setEmail(email);
                    cliente.setRuc(ruc);
                    cliente.setEdad(edad);
                    cliente.setProfesion(profesion);

                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); //Doy formato a la fecha
                    String fechaTexto = formato.format(fecha); //La fecha tiene el formato indicado y es de tipo String
                    cliente.setFechanac(fechaTexto);

                    String genero = "";
                    if (vista.getMasculino().isSelected()) {
                        genero = "M";
                    } else {
                        if (vista.getFemenino().isSelected()) {
                            genero = "F";
                        }
                    }

                    cliente.setGenero(genero);

                    if (cliente.crearCliente()) {
                        vista.getjDlgClientes().setVisible(false);
                        JOptionPane.showMessageDialog(vista, "Persona Creada correctamente");
                        cargarTabla();
                    } else {
                        JOptionPane.showMessageDialog(vista, "ERROR: Al crear a la persona");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(vista, "Cedula ya registrada");
            }

        } else {//EDITAR 
            if (validacionDeDatos()) {
                String dni = vista.getTxtdni().getText();
                String prinombre = vista.getTxtprinombre().getText();
                String segnombre = vista.getTxtsegnombre().getText();
                String priapellido = vista.getTxtpriapellido().getText();
                String segapellido = vista.getTxtsegapellido().getText();
                String direccion = vista.getTxtdireccion().getText();
                String telefono = vista.getTxttelefono().getText();
                String email = vista.getTxtemail().getText();
                String ruc = vista.getTxtruc().getText();
                String profesion = vista.getTxtprofesion().getText();
                int edad = Integer.parseInt(vista.getSpinneredad().getValue().toString());

                Date fecha = vista.getJfechanacimiento().getDate(); //Obtengo la fecha del jDateChooser y la paso a date

                Modelo_Cliente cliente = new Modelo_Cliente();
                cliente.setDni(dni);
                cliente.setPrinombre(prinombre);
                cliente.setSegnombre(segnombre);
                cliente.setApellidopat(priapellido);
                cliente.setApellidomat(segapellido);
                cliente.setDireccion(direccion);
                cliente.setTelefono(telefono);
                cliente.setEmail(email);
                cliente.setRuc(ruc);
                cliente.setProfesion(profesion);
                cliente.setEdad(edad);

                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); //Doy formato a la fecha
                String fechaTexto = formato.format(fecha); //La fecha tiene el formato indicado y es de tipo String
                cliente.setFechanac(fechaTexto);

                String genero = "";
                if (vista.getMasculino().isSelected()) {
                    genero = "M";
                } else {
                    if (vista.getFemenino().isSelected()) {
                        genero = "F";
                    }
                }

                cliente.setGenero(genero);

                if (cliente.modificarPersonaYCliente()) {

                    vista.getjDlgClientes().setVisible(false);
                    JOptionPane.showMessageDialog(vista, "Persona Modificada correctamente ");
                    cargarTabla();
                } else {
                    JOptionPane.showMessageDialog(vista, "ERROR: Al modificar la persona");
                }
            } else {
                JOptionPane.showMessageDialog(vista, "Se encuentran campos vacios o falta completar");
            }
        }
    }

    public void eliminarPersonaYCliente() {

        int fila = vista.getTablaclientes().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {

            int response = JOptionPane.showConfirmDialog(vista, "¿Desea eliminar esta información?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {

                String cedula;
                cedula = vista.getTablaclientes().getValueAt(fila, 0).toString();

                if (modelo.eliminarCliente(cedula)) {
                    JOptionPane.showMessageDialog(null, "La persona fue eliminada Correctamente");
                    cargarTabla();//Actualizo la tabla con los datos
                } else {
                    JOptionPane.showMessageDialog(null, "Error: La persona no se pudo eliminar");
                }
            }
        }
    }

    public void buscarPersona() {

        KeyListener eventoTeclado = new KeyListener() {//Crear un objeto de tipo keyListener(Es una interface) por lo tanto se debe implementar sus metodos abstractos

            @Override
            public void keyTyped(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {

                vista.getTablaclientes().setRowHeight(25);
                DefaultTableModel estructuraTabla = (DefaultTableModel) vista.getTablaclientes().getModel();
                estructuraTabla.setRowCount(0);

                List<Cliente> listap = modelo.listabuscarPersonasYClientes(vista.getTxtbuscar().getText());

                Holder<Integer> i = new Holder<>(0);

                listap.stream().forEach(persona -> {

                    estructuraTabla.addRow(new Object[8]);

                    vista.getTablaclientes().setValueAt(persona.getDni(), i.value, 0);
                    vista.getTablaclientes().setValueAt(persona.getPrinombre(), i.value, 1);
                    vista.getTablaclientes().setValueAt(persona.getApellidopat(), i.value, 2);
                    vista.getTablaclientes().setValueAt(persona.getEdad(), i.value, 3);
                    vista.getTablaclientes().setValueAt(persona.getGenero(), i.value, 4);
                    vista.getTablaclientes().setValueAt(persona.getTelefono(), i.value, 5);
                    vista.getTablaclientes().setValueAt(persona.getRuc(), i.value, 6);

                    i.value++;
                });
            }
        };

        vista.getTxtbuscar().addKeyListener(eventoTeclado); //"addKeyListener" es un metodo que se le tiene que pasar como argumento un objeto de tipo keyListener 
    }

    public boolean validacionDeDatos() {
        Validaciones mivalidacion = new Validaciones();

        boolean validar = true;

        /*if (vista.getTxtdni().getText().isEmpty() || !mivalidacion.validarCedula(vista.getTxtdni().getText())) {

            validar = false;
        }*/
        if (vista.getTxtprinombre().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el primer nombre");
            validar = false;
        } else {
            if (!mivalidacion.validarTextoSinEspacio(vista.getTxtprinombre().getText())) {
                JOptionPane.showMessageDialog(null, "Primer nombre incorrecto");
                validar = false;
            }
        }

        if (vista.getTxtsegnombre().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el segundo nombre");
            validar = false;
        } else {
            if (!mivalidacion.validarTextoSinEspacio(vista.getTxtsegnombre().getText())) {
                JOptionPane.showMessageDialog(null, "Segundo nombre incorrecto");
                validar = false;
            }
        }

        if (vista.getTxtpriapellido().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el primer apellido");
            validar = false;
        } else {
            if (!mivalidacion.validarTextoSinEspacio(vista.getTxtpriapellido().getText())) {
                JOptionPane.showMessageDialog(null, "Primer apellido incorrecto");
                validar = false;
            }
        }

        if (vista.getTxtsegapellido().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el segundo apellido");
            validar = false;
        } else {
            if (!mivalidacion.validarTextoSinEspacio(vista.getTxtsegapellido().getText())) {
                JOptionPane.showMessageDialog(null, "Segundo apellido incorrecto");
                validar = false;
            }
        }

        if (vista.getTxtdireccion().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese la direccion");
            validar = false;
        } else {
            if (!mivalidacion.validarDireccion(vista.getTxtdireccion().getText())) {
                JOptionPane.showMessageDialog(null, "Direccion incorrecta");
                validar = false;
            }
        }

        if (vista.getTxttelefono().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el numero de telefono");
            validar = false;
        } else {
            if (!mivalidacion.validarTelefono(vista.getTxttelefono().getText())) {
                JOptionPane.showMessageDialog(null, "Telefono incorrecto");
                validar = false;
            }
        }

        if (vista.getTxtemail().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el correo");
            validar = false;
        } else {
            if (!mivalidacion.validarCorreo(vista.getTxtemail().getText())) {
                JOptionPane.showMessageDialog(null, "Correo incorrecto");
                validar = false;
            }
        }

        if (vista.getTxtruc().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el RUC");
            validar = false;
        } else {
            if (!mivalidacion.validarRuc(vista.getTxtruc().getText())) {
                JOptionPane.showMessageDialog(null, "RUC incorrecto");
                validar = false;
            }
        }

        if (vista.getTxtprofesion().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese la profesion");
            validar = false;
        } else {
            if (!mivalidacion.validarTextoSinEspacio(vista.getTxtprofesion().getText())) {
                JOptionPane.showMessageDialog(null, "Profesion incorrecta");
                validar = false;
            }
        }

        if (vista.getJfechanacimiento().getDate() == null) {
            JOptionPane.showMessageDialog(null, "Ingrese la fecha");
            validar = false;
        }

        if (vista.getMasculino() == null && vista.getFemenino() == null) {
            JOptionPane.showMessageDialog(null, "Seleccione el genero");
            validar = false;
        }////

        return validar;
    }

    public void limpiarDatos() {
        vista.getTxtdni().setText("");
        vista.getTxtprinombre().setText("");
        vista.getTxtsegnombre().setText("");
        vista.getTxtpriapellido().setText("");
        vista.getTxtsegapellido().setText("");
        vista.getTxtdireccion().setText("");
        vista.getTxttelefono().setText("");
        vista.getTxtemail().setText("");
        vista.getTxtruc().setText("");
        vista.getTxtprofesion().setText("");
        vista.getSpinneredad().setValue(18);
        vista.getJfechanacimiento().setDate(null);
        vista.getGenero().clearSelection();
    }
}
