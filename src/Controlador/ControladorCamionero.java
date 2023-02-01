package Controlador;

import Modelo.Camionero;
import Modelo.Modelo_Camionero;
import Modelo.Modelo_Persona;
import Modelo.Validaciones;
import Vista.VistaCamionero;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//import static javafx.scene.paint.Color.color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;

public class ControladorCamionero {

    Modelo_Camionero modelo;
    VistaCamionero vista;

    public ControladorCamionero(Modelo_Camionero modelo, VistaCamionero vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
        cargarTabla();
    }

    public void iniciarControl() {
        vista.getBtncrear().addActionListener(l -> abrirDialogCrear());
        vista.getBtnactualizar().addActionListener(l -> cargarTabla());
        vista.getBtnguardar().addActionListener(l -> crearOModificarPersonaYCamionero());
        vista.getBtnmodificar().addActionListener(l -> abrirYCargarDatosEnElDialog());
        vista.getBtneliminar().addActionListener(l -> eliminarPersonaYCamionero());
        buscarPersona(); //Metodo para buscar personas       
    }

    public void abrirDialogCrear() {
        vista.getjDlgCamionero().setName("CREACIÓN DE UNA NUEVA PERSONA");
        vista.getjDlgCamionero().setLocationRelativeTo(vista);
        vista.getjDlgCamionero().setSize(1049, 740);
        vista.getjDlgCamionero().setTitle("CREAR NUEVA PERSONA");
        vista.getjDlgCamionero().setVisible(true);
        vista.getTxtdni().setEditable(true); //Desbloqueo el campo de la cedula
        limpiarDatos(); //Limpia la informacion de los campos
    }

    public void limpiarColorrojo() {

        vista.getTxtemail().setBackground(Color.WHITE);
        vista.getTxttelefono().setBackground(Color.WHITE);
        vista.getTxtdireccion().setBackground(Color.WHITE);
        vista.getTxtsegapellido().setBackground(Color.WHITE);
        vista.getTxtpriapellido().setBackground(Color.WHITE);
        vista.getTxtdni().setBackground(Color.WHITE);
    }

    public void cargarTabla() {
        vista.getTablacamioneros().setRowHeight(25);
        DefaultTableModel estructuraTabla = (DefaultTableModel) vista.getTablacamioneros().getModel();
        estructuraTabla.setRowCount(0);

        List<Camionero> listap = modelo.listaCamionerosTabla();

        Holder<Integer> i = new Holder<>(0);

        listap.stream().forEach(persona -> {

            estructuraTabla.addRow(new Object[8]);

            vista.getTablacamioneros().setValueAt(persona.getDni(), i.value, 0);
            vista.getTablacamioneros().setValueAt(persona.getPrinombre(), i.value, 1);
            vista.getTablacamioneros().setValueAt(persona.getApellidopat(), i.value, 2);
            vista.getTablacamioneros().setValueAt(persona.getEdad(), i.value, 3);
            vista.getTablacamioneros().setValueAt(persona.getGenero(), i.value, 4);
            vista.getTablacamioneros().setValueAt(persona.getTelefono(), i.value, 5);
            vista.getTablacamioneros().setValueAt(persona.getSalario(), i.value, 6);

            i.value++;
        });
    }

    public void abrirYCargarDatosEnElDialog() {

        int seleccion = vista.getTablacamioneros().getSelectedRow();

        if (seleccion == -1) {
            JOptionPane.showMessageDialog(null, "Por favor: Seleccionar una fila");
        } else {

            String cedula = vista.getTablacamioneros().getValueAt(seleccion, 0).toString();
            modelo.listaCamionerosTabla().forEach((pe) -> {
                if (pe.getDni().equals(cedula)) {

                    //Abre el jDialog y carga los datos en el jDialog
                    vista.getjDlgCamionero().setName("Editar");
                    vista.getjDlgCamionero().setLocationRelativeTo(vista);
                    vista.getjDlgCamionero().setSize(1049, 740);
                    vista.getjDlgCamionero().setTitle("Editar");
                    vista.getjDlgCamionero().setVisible(true);
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
                    vista.getTxttipodelicencia().setText(pe.getTipolicencia());

                    if (pe.getGenero().equalsIgnoreCase("M")) {
                        vista.getMasculino().setSelected(true);
                    } else {
                        if (pe.getGenero().equalsIgnoreCase("F")) {
                            vista.getFemenino().setSelected(true);
                        }
                    }

                    vista.getSpinneredad().setValue(pe.getEdad());
                    vista.getSpinneraniosexperiencia().setValue(pe.getAniosexperiencia());
                    vista.getSpinnerSalario().setValue(pe.getSalario());

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

    public void crearOModificarPersonaYCamionero() {

        Modelo_Persona mipersona = new Modelo_Persona();

        if (vista.getjDlgCamionero().getName().equals("Creacion de nueva persona")) { //CREAR

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
                    String tipodelicencia = vista.getTxttipodelicencia().getText();
                    int edad = Integer.parseInt(vista.getSpinneredad().getValue().toString());
                    double salario = Double.parseDouble(vista.getSpinnerSalario().getValue().toString());
                    int aniosexperiencia = Integer.parseInt(vista.getSpinneraniosexperiencia().getValue().toString());
                    Date fecha = vista.getJfechanacimiento().getDate(); //Obtengo la fecha del jDateChooser y la paso a date

                    Modelo_Camionero camionero = new Modelo_Camionero();
                    camionero.setDni(dni);
                    camionero.setPrinombre(prinombre);
                    camionero.setSegnombre(segnombre);
                    camionero.setApellidopat(priapellido);
                    camionero.setApellidomat(segapellido);
                    camionero.setDireccion(direccion);
                    camionero.setTelefono(telefono);
                    camionero.setEmail(email);
                    camionero.setTipolicencia(tipodelicencia);
                    camionero.setEdad(edad);
                    camionero.setSalario(salario);
                    camionero.setAniosexperiencia(aniosexperiencia);

                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); //Doy formato a la fecha
                    String fechaTexto = formato.format(fecha); //La fecha tiene el formato indicado y es de tipo String
                    camionero.setFechanac(fechaTexto);

                    String genero = "";
                    if (vista.getMasculino().isSelected()) {
                        genero = "M";
                    } else {
                        if (vista.getFemenino().isSelected()) {
                            genero = "F";
                        }
                    }

                    camionero.setGenero(genero);

                    if (camionero.crearCamionero()) {
                        vista.getjDlgCamionero().setVisible(false);
                        JOptionPane.showMessageDialog(vista, "La persona ha sido creada correctamente ");
                        cargarTabla();
                    } else {
                        JOptionPane.showMessageDialog(vista, "ERROR :Al crear a la persona");
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
                String tipodelicencia = vista.getTxttipodelicencia().getText();
                int edad = Integer.parseInt(vista.getSpinneredad().getValue().toString());
                double salario = Double.parseDouble(vista.getSpinnerSalario().getValue().toString());
                int aniosexperiencia = Integer.parseInt(vista.getSpinneraniosexperiencia().getValue().toString());
                Date fecha = vista.getJfechanacimiento().getDate(); //Obtengo la fecha del jDateChooser y la paso a date

                Modelo_Camionero camionero = new Modelo_Camionero();
                camionero.setDni(dni);
                camionero.setPrinombre(prinombre);
                camionero.setSegnombre(segnombre);
                camionero.setApellidopat(priapellido);
                camionero.setApellidomat(segapellido);
                camionero.setDireccion(direccion);
                camionero.setTelefono(telefono);
                camionero.setEmail(email);
                camionero.setTipolicencia(tipodelicencia);
                camionero.setEdad(edad);
                camionero.setSalario(salario);
                camionero.setAniosexperiencia(aniosexperiencia);

                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); //Doy formato a la fecha
                String fechaTexto = formato.format(fecha); //La fecha tiene el formato indicado y es de tipo String
                camionero.setFechanac(fechaTexto);

                String genero = "";
                if (vista.getMasculino().isSelected()) {
                    genero = "M";
                } else {
                    if (vista.getFemenino().isSelected()) {
                        genero = "F";
                    }
                }

                camionero.setGenero(genero);

                if (camionero.modificarPersonaYCamionero()) {

                    vista.getjDlgCamionero().setVisible(false);
                    JOptionPane.showMessageDialog(vista, "Moficacion de persona exitosa");
                    cargarTabla();
                } else {
                    JOptionPane.showMessageDialog(vista, "ERROR: Al modificar a la persona");
                }
            }
        }
    }

    public void eliminarPersonaYCamionero() {

        int fila = vista.getTablacamioneros().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Por favor: Seleccionar una persona");
        } else {

            int response = JOptionPane.showConfirmDialog(vista, "¿Desea eliminar esta información?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {

                String cedula;
                cedula = vista.getTablacamioneros().getValueAt(fila, 0).toString();

                if (modelo.eliminarCamionero(cedula)) {
                    JOptionPane.showMessageDialog(null, " Persona  eliminada correctamente");
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

                vista.getTablacamioneros().setRowHeight(25);
                DefaultTableModel estructuraTabla = (DefaultTableModel) vista.getTablacamioneros().getModel();
                estructuraTabla.setRowCount(0);

                List<Camionero> listap = modelo.listabuscarPersonasYCamioneros(vista.getTxtbuscar().getText());

                Holder<Integer> i = new Holder<>(0);

                listap.stream().forEach(persona -> {

                    estructuraTabla.addRow(new Object[8]);

                    vista.getTablacamioneros().setValueAt(persona.getDni(), i.value, 0);
                    vista.getTablacamioneros().setValueAt(persona.getPrinombre(), i.value, 1);
                    vista.getTablacamioneros().setValueAt(persona.getApellidopat(), i.value, 2);
                    vista.getTablacamioneros().setValueAt(persona.getEdad(), i.value, 3);
                    vista.getTablacamioneros().setValueAt(persona.getGenero(), i.value, 4);
                    vista.getTablacamioneros().setValueAt(persona.getTelefono(), i.value, 5);
                    vista.getTablacamioneros().setValueAt(persona.getSalario(), i.value, 6);

                    i.value++;
                });
            }
        };

        vista.getTxtbuscar().addKeyListener(eventoTeclado); //"addKeyListener" es un metodo que se le tiene que pasar como argumento un objeto de tipo keyListener 
    }

    public boolean validacionDeDatos() {
        Validaciones mivalidacion = new Validaciones();

        boolean validar = true;

        if (vista.getTxtdni().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese una cedula");
            validar = false;
        } else {
            if (!mivalidacion.validarCedula(vista.getTxtdni().getText())) {
                JOptionPane.showMessageDialog(null, "Ingrese una cedula correcta");
                validar = false;
            }
        }

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

        if (vista.getTxttipodelicencia().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el tipo de licencia");
            validar = false;
        } else {
            if (!mivalidacion.validarTextoSinEspacio(vista.getTxttipodelicencia().getText())) {
                JOptionPane.showMessageDialog(null, "Tipo de licencia Incorrecto");
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
        }

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
        vista.getTxttipodelicencia().setText("");
        vista.getSpinneredad().setValue(18);
        vista.getSpinnerSalario().setValue(0);
        vista.getSpinneraniosexperiencia().setValue(0);
        vista.getJfechanacimiento().setDate(null);
        vista.getGenero().clearSelection();
    }
}
