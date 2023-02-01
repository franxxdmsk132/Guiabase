package Controlador;

import Modelo.Destinatario;
import Modelo.Modelo_Destinatario;
import Modelo.Modelo_Persona;
import Modelo.Validaciones;
import Vista.VistaDestinatario;
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

public class ControladorDestinatario {

    Modelo_Destinatario modelo;
    VistaDestinatario vista;

    public ControladorDestinatario(Modelo_Destinatario modelo, VistaDestinatario vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
        cargarTabla();
    }

    public void iniciarControl() {
        vista.getBtncrear().addActionListener(l -> abrirDialogCrear());
        vista.getBtnactualizar().addActionListener(l -> cargarTabla());
        vista.getBtnguardar().addActionListener(l -> crearOModificarPersonaYDestinatario());
        vista.getBtnmodificar().addActionListener(l -> abrirYCargarDatosEnElDialog());
        vista.getBtneliminar().addActionListener(l -> eliminarPersonaYDestinatario());
        buscarPersona(); //Metodo para buscar personas
    }

    public void abrirDialogCrear() {
        vista.getjDlgDestinatarios().setName("Creacion nuevo destinatario");
        vista.getjDlgDestinatarios().setLocationRelativeTo(vista);
        vista.getjDlgDestinatarios().setSize(945, 796);
        vista.getjDlgDestinatarios().setTitle("CREACION DE UNA PERSONA NUEVA");
        vista.getjDlgDestinatarios().setVisible(true);
        vista.getTxtdni().setEditable(true); //Desbloqueo el campo de la cedula
        limpiarDatos(); //Limpia la informacion de los campos
    }

    public void cargarTabla() {
        vista.getTabladestinatarios().setRowHeight(25);
        DefaultTableModel estructuraTabla = (DefaultTableModel) vista.getTabladestinatarios().getModel();
        estructuraTabla.setRowCount(0);

        List<Destinatario> listap = modelo.listaDestinatariosTabla();

        Holder<Integer> i = new Holder<>(0);

        listap.stream().forEach(persona -> {

            estructuraTabla.addRow(new Object[8]);

            vista.getTabladestinatarios().setValueAt(persona.getDni(), i.value, 0);
            vista.getTabladestinatarios().setValueAt(persona.getPrinombre(), i.value, 1);
            vista.getTabladestinatarios().setValueAt(persona.getApellidopat(), i.value, 2);
            vista.getTabladestinatarios().setValueAt(persona.getEdad(), i.value, 3);
            vista.getTabladestinatarios().setValueAt(persona.getTelefono(), i.value, 4);
            vista.getTabladestinatarios().setValueAt(persona.getCodpostal(), i.value, 5);

            i.value++;
        });
    }

    public void abrirYCargarDatosEnElDialog() {

        int seleccion = vista.getTabladestinatarios().getSelectedRow();

        if (seleccion == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {

            String cedula = vista.getTabladestinatarios().getValueAt(seleccion, 0).toString();
            modelo.listaDestinatariosTabla().forEach((pe) -> {
                if (pe.getDni().equals(cedula)) {

                    //Abre el jDialog y carga los datos en el jDialog
                    vista.getjDlgDestinatarios().setName("Editar");
                    vista.getjDlgDestinatarios().setLocationRelativeTo(vista);
                    vista.getjDlgDestinatarios().setSize(945, 796);
                    vista.getjDlgDestinatarios().setTitle("Editar");
                    vista.getjDlgDestinatarios().setVisible(true);
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
                    vista.getTxtcodpostal().setText(pe.getCodpostal());
                    vista.getTxtArea().setText(pe.getInfocomplement());
                    vista.getTxtcalleprinc().setText(pe.getCalleprinc());
                    vista.getTxtcallesecun().setText(pe.getCallesecun());

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

    public void crearOModificarPersonaYDestinatario() {

        Modelo_Persona mipersona = new Modelo_Persona();

        if (vista.getjDlgDestinatarios().getName().equals("Crear nuevo destinatario")) { //CREAR

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
                    String codpostal = vista.getTxtcodpostal().getText();
                    String infocomplement = vista.getTxtArea().getText();
                    String calleprinc = vista.getTxtcalleprinc().getText();
                    String callesecun = vista.getTxtcallesecun().getText();
                    int edad = Integer.parseInt(vista.getSpinneredad().getValue().toString());

                    Date fecha = vista.getJfechanacimiento().getDate(); //Obtengo la fecha del jDateChooser y la paso a date

                    Modelo_Destinatario destinatario = new Modelo_Destinatario();
                    destinatario.setDni(dni);
                    destinatario.setPrinombre(prinombre);
                    destinatario.setSegnombre(segnombre);
                    destinatario.setApellidopat(priapellido);
                    destinatario.setApellidomat(segapellido);
                    destinatario.setDireccion(direccion);
                    destinatario.setTelefono(telefono);
                    destinatario.setEmail(email);
                    destinatario.setCodpostal(codpostal);
                    destinatario.setEdad(edad);
                    destinatario.setCodpostal(codpostal);
                    destinatario.setInfocomplement(infocomplement);
                    destinatario.setCalleprinc(calleprinc);
                    destinatario.setCallesecun(callesecun);

                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); //Doy formato a la fecha
                    String fechaTexto = formato.format(fecha); //La fecha tiene el formato indicado y es de tipo String
                    destinatario.setFechanac(fechaTexto);

                    String genero = "";
                    if (vista.getMasculino().isSelected()) {
                        genero = "M";
                    } else {
                        if (vista.getFemenino().isSelected()) {
                            genero = "F";
                        }
                    }

                    destinatario.setGenero(genero);

                    if (destinatario.crearDestinatario()) {
                        vista.getjDlgDestinatarios().setVisible(false);
                        JOptionPane.showMessageDialog(vista, "LA PERSONA FUE CREADA DE MANERA CORRECDTA");
                        cargarTabla();
                    } else {
                        JOptionPane.showMessageDialog(vista, "HUBO UN ERROR EN LA CREACION DE PERSONA");
                    }
                } else {

                    JOptionPane.showMessageDialog(vista, "EXISTEN CAMPOS SIN LLENAR O LLENADOS DE MANERA INCORRECTA ");
                }
            } else {
                JOptionPane.showMessageDialog(vista, "EL NUMERO DE CEDILA YA ESTA EN USO");
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
                String codpostal = vista.getTxtcodpostal().getText();
                String infocomplement = vista.getTxtArea().getText();
                String calleprinc = vista.getTxtcalleprinc().getText();
                String callesecun = vista.getTxtcallesecun().getText();
                int edad = Integer.parseInt(vista.getSpinneredad().getValue().toString());

                Date fecha = vista.getJfechanacimiento().getDate(); //Obtengo la fecha del jDateChooser y la paso a date

                Modelo_Destinatario destinatario = new Modelo_Destinatario();
                destinatario.setDni(dni);
                destinatario.setPrinombre(prinombre);
                destinatario.setSegnombre(segnombre);
                destinatario.setApellidopat(priapellido);
                destinatario.setApellidomat(segapellido);
                destinatario.setDireccion(direccion);
                destinatario.setTelefono(telefono);
                destinatario.setEmail(email);
                destinatario.setCodpostal(codpostal);
                destinatario.setEdad(edad);
                destinatario.setCodpostal(codpostal);
                destinatario.setInfocomplement(infocomplement);
                destinatario.setCalleprinc(calleprinc);
                destinatario.setCallesecun(callesecun);

                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); //Doy formato a la fecha
                String fechaTexto = formato.format(fecha); //La fecha tiene el formato indicado y es de tipo String
                destinatario.setFechanac(fechaTexto);

                String genero = "";
                if (vista.getMasculino().isSelected()) {
                    genero = "M";
                } else {
                    if (vista.getFemenino().isSelected()) {
                        genero = "F";
                    }
                }

                destinatario.setGenero(genero);

                if (destinatario.modificarPersonaYDestinatario()) {

                    vista.getjDlgDestinatarios().setVisible(false);
                    JOptionPane.showMessageDialog(vista, "PERSONA ACTUALIZADA CORRECTAMENTE");
                    cargarTabla();
                } else {
                    JOptionPane.showMessageDialog(vista, "ERROR EN LA CTUALIZACION DE PERSONA");
                }
            } else {
                JOptionPane.showMessageDialog(vista, "CAMPOS VACIOS O LLENADOS DE MANERA INCORRECTA");
            }
        }
    }

    public void eliminarPersonaYDestinatario() {

        int fila = vista.getTabladestinatarios().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "AUN NO SE A SELECCIONADO UN ELEMENTO");
        } else {

            int response = JOptionPane.showConfirmDialog(vista, "¿DESEA ELIMINAR LA INFORMACION SELECCIONADA?", "CONFIRMAR", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {

                String cedula;
                cedula = vista.getTabladestinatarios().getValueAt(fila, 0).toString();

                if (modelo.eliminarDestinatario(cedula)) {
                    JOptionPane.showMessageDialog(null, "SE ELIMINO A LA PERSONA DE MANERA CORRECTA");
                    cargarTabla();//Actualizo la tabla con los datos
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR EN LA ELIMINACION DE PERSONAr");
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

                vista.getTabladestinatarios().setRowHeight(25);
                DefaultTableModel estructuraTabla = (DefaultTableModel) vista.getTabladestinatarios().getModel();
                estructuraTabla.setRowCount(0);

                List<Destinatario> listap = modelo.listabuscarPersonasYDestinatarios(vista.getTxtbuscar().getText());

                Holder<Integer> i = new Holder<>(0);

                listap.stream().forEach(persona -> {

                    estructuraTabla.addRow(new Object[8]);

                    vista.getTabladestinatarios().setValueAt(persona.getDni(), i.value, 0);
                    vista.getTabladestinatarios().setValueAt(persona.getPrinombre(), i.value, 1);
                    vista.getTabladestinatarios().setValueAt(persona.getApellidopat(), i.value, 2);
                    vista.getTabladestinatarios().setValueAt(persona.getEdad(), i.value, 3);
                    vista.getTabladestinatarios().setValueAt(persona.getTelefono(), i.value, 4);
                    vista.getTabladestinatarios().setValueAt(persona.getCodpostal(), i.value, 5);

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
            JOptionPane.showMessageDialog(null, "INGRESO DEL PRIMER NOMBRE");
            validar = false;
        } else {
            if (!mivalidacion.validarTextoSinEspacio(vista.getTxtprinombre().getText())) {
                JOptionPane.showMessageDialog(null, "NOMBRE INGRESADO DE MANERA ERRONEA");
                validar = false;
            }
        }

        if (vista.getTxtsegnombre().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "INGRESO DEL SEGUNDO NOMBRE");
            validar = false;
        } else {
            if (!mivalidacion.validarTextoSinEspacio(vista.getTxtsegnombre().getText())) {
                JOptionPane.showMessageDialog(null, "NOMBRE INGRESADO DE MANERA ERRONEA");
                validar = false;
            }
        }

        if (vista.getTxtpriapellido().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "INGRESO DEL APELLIDO PATERNO");
            validar = false;
        } else {
            if (!mivalidacion.validarTextoSinEspacio(vista.getTxtpriapellido().getText())) {
                JOptionPane.showMessageDialog(null, "APELLIDO PATERNO INGRESADO DE MANERA ERRONEA");
                validar = false;
            }
        }

        if (vista.getTxtsegapellido().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "INGRESO DE APELLIDO MATERNO");
            validar = false;
        } else {
            if (!mivalidacion.validarTextoSinEspacio(vista.getTxtsegapellido().getText())) {
                JOptionPane.showMessageDialog(null, "APELLIDO MATERNO INGRESADO DE MANERA ERRONEA");
                validar = false;
            }
        }

        if (vista.getTxtdireccion().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "INGRESO DE DOMICILIO(DIRECCION)");
            validar = false;
        } else {
            if (!mivalidacion.validarDireccion(vista.getTxtdireccion().getText())) {
                JOptionPane.showMessageDialog(null, "DOMICILIO INCORRECTO");
                validar = false;
            }
        }

        if (vista.getTxttelefono().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "INGRESO DE NUMERO TELEFONICO");
            validar = false;
        } else {
            if (!mivalidacion.validarTelefono(vista.getTxttelefono().getText())) {
                JOptionPane.showMessageDialog(null, "NUMERO TELEFONICO INVALIDO");
                validar = false;
            }
        }

        if (vista.getTxtemail().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "INGRESO DE SU CORREO ELECTRONICO");
            validar = false;
        } else {
            if (!mivalidacion.validarCorreo(vista.getTxtemail().getText())) {
                JOptionPane.showMessageDialog(null, "CORREO ELECTRONICO INVALIDO");
                validar = false;
            }
        }

        if (vista.getTxtcodpostal().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "IGRESO DE CODIGO POSTAL");
            validar = false;
        } else {
            if (!mivalidacion.validarCodigoPostal(vista.getTxtcodpostal().getText())) {
                JOptionPane.showMessageDialog(null, "CODIGO POSTAL INCORRECTO");
                validar = false;
            }
        }

        if (vista.getTxtArea().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "IGRESO DE AREA");
            validar = false;
        } else {
            if (!mivalidacion.validarTextoConEspacio(vista.getTxtArea().getText())) {
                JOptionPane.showMessageDialog(null, "AREA INVALIDA");
                validar = false;
            }
        }

        if (vista.getTxtcalleprinc().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "INGRESO DE CALLE PRINCIPAL");
            validar = false;
        } else {
            if (!mivalidacion.validarDireccion(vista.getTxtcalleprinc().getText())) {
                JOptionPane.showMessageDialog(null, "HUBO UN ERROR EN EL INGRESO DE CALLE PRINCIPAL");
                validar = false;
            }
        }

        if (vista.getTxtcallesecun().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "INGRESO DE CALLE SECUNDARIA");
            validar = false;
        } else {
            if (!mivalidacion.validarDireccion(vista.getTxtcallesecun().getText())) {
                JOptionPane.showMessageDialog(null, "ERROR EN EL REGISTRO DE CALLE SECUNDARIA");
                validar = false;
            }
        }

        if (vista.getJfechanacimiento().getDate() == null) {
            JOptionPane.showMessageDialog(null, "INGRESO DE LA FECHA");
            validar = false;
        }

        if (vista.getMasculino() == null && vista.getFemenino() == null) {
             JOptionPane.showMessageDialog(null, "SELECCIONA TU GENERO");
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
        vista.getTxtcodpostal().setText("");
        vista.getTxtArea().setText("");
        vista.getTxtcalleprinc().setText("");
        vista.getTxtcallesecun().setText("");
        vista.getSpinneredad().setValue(18);
        vista.getJfechanacimiento().setDate(null);
        vista.getGenero().clearSelection();
    }

}
