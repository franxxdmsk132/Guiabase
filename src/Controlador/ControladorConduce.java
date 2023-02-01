package Controlador;

import Modelo.Camion;
import Modelo.Camionero;
import Modelo.Conduce;
import Modelo.Modelo_Camion;
import Modelo.Modelo_Camionero;
import Modelo.Modelo_Conduce;
import Vista.VistaConduce;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//import javax.swing.RowFilter; //NO ELIMNAR. IMPORTANTE PARA EL METODO DE FILTAR COMENTADO
import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableRowSorter;//NO ELIMINAR. IMPORTANTE PARA EL METODO DE FILTAR COMENTADO
import javax.xml.ws.Holder;

public class ControladorConduce {

    Modelo_Conduce modelo;
    VistaConduce vista;

    public ControladorConduce(Modelo_Conduce modelo, VistaConduce vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
        cargarTablaTurnosDeConduccion();
    }

    public void iniciarControl() {
        vista.getBtncrear().addActionListener(l -> abrirDialogCrear());
        vista.getBtnbuscarcamionero().addActionListener(l -> abrirjDialogCamionero());
        vista.getBtnbuscarcamion().addActionListener(l -> abrirjDialogCamion());
        vista.getBtncargarCamionero().addActionListener(l -> cargarDatosCamioneroEnTXT());
        vista.getBtncargarCamion().addActionListener(l -> cargarDatosCamionEnTXT());
        vista.getBtnguardar().addActionListener(l -> crearOModificarConduccion());
        vista.getBtnmodificar().addActionListener(l -> abrirYCargarDatosEnElDialogConduce());
        vista.getBtnactualizar().addActionListener(l -> cargarTablaTurnosDeConduccion());
        vista.getBtneliminar().addActionListener(l -> eliminarRegistros());
        buscarRegistros();
    }

    public void abrirDialogCrear() {
        vista.getjDlgConduce().setName("Creacion del nuevo conductor");
        vista.getjDlgConduce().setLocationRelativeTo(vista);
        vista.getjDlgConduce().setSize(960, 527);
        vista.getjDlgConduce().setTitle("CREAR NUEVO CONDUCTOR");
        vista.getjDlgConduce().setVisible(true);
        limpiarDatosYDespacerCampos();
    }

    public void cargarTablaTurnosDeConduccion() {

        Modelo_Camionero modeloCamionero = new Modelo_Camionero();
        Modelo_Camion modeloCamion = new Modelo_Camion();

        DefaultTableModel tabla = (DefaultTableModel) vista.getTablaconduccion().getModel();
        tabla.setNumRows(0);

        List<Conduce> listacon = modelo.listaTurnosDeConduccion();
        List<Camionero> listacam = modeloCamionero.listaCamionerosTabla();
        List<Camion> listacmi = modeloCamion.listaCamiones();

        listacon.stream().forEach(c -> {

            String fechaInicio = c.getFechaSalida().substring(0, 10);

            listacam.stream().forEach(ca -> {

                if (c.getCodigoCam() == ca.getCodigoCam()) {

                    listacmi.stream().forEach(ci -> {

                        if (c.getCodigoCmi() == ci.getCodigoCmi()) {

                            String[] datos = {String.valueOf(c.getCodigoCon()), fechaInicio, String.valueOf(c.getCodigoCam()), ca.getDni(), ca.getPrinombre() + " " + ca.getApellidopat(), String.valueOf(c.getCodigoCmi()), ci.getPlaca()};
                            tabla.addRow(datos);
                        }
                    });
                }
            });
        });
    }

    public void abrirYCargarDatosEnElDialogConduce() {

        //Creo objetos de los modelos de camionero y de camion
        Modelo_Camionero modeloCamionero = new Modelo_Camionero();
        Modelo_Camion modeloCamion = new Modelo_Camion();

        //Cargo las listas con los registros de la BD
        List<Camionero> listacam = modeloCamionero.listaCamionerosTabla();
        List<Camion> listacmi = modeloCamion.listaCamiones();

        int seleccion = vista.getTablaconduccion().getSelectedRow();

        if (seleccion == -1) {
            JOptionPane.showMessageDialog(null, "POR FAVOR: Seleccionar una fila");
        } else {

            int codigo = Integer.parseInt(vista.getTablaconduccion().getValueAt(seleccion, 0).toString());
            modelo.listaTurnosDeConduccion().forEach((c) -> {
                if (c.getCodigoCon() == codigo) {

                    //Abre el jDialog y carga los datos en el jDialog
                    vista.getjDlgConduce().setName("Editar");
                    vista.getjDlgConduce().setLocationRelativeTo(vista);
                    vista.getjDlgConduce().setSize(960, 527);
                    vista.getjDlgConduce().setTitle("Editar");
                    vista.getjDlgConduce().setVisible(true);
                    vista.getTxtcodigoconduce().setEditable(false); //Bloqueo el campo
                    //Hago visible el label y el txt del codigo de conduce
                    vista.getTxtcodigoconduce().setVisible(true);
                    vista.getLblcodigoconduce().setVisible(true);

                    //Seteo los datos en los campos de texto
                    vista.getTxtcodigoconduce().setText(String.valueOf(c.getCodigoCon()));
                    vista.getTxtcodigocamionero().setText(String.valueOf(c.getCodigoCam()));
                    vista.getTxtcodigocamion().setText(String.valueOf(c.getCodigoCmi()));

                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); //Doy formato a la fecha
                    try {
                        Date fecha = formato.parse(c.getFechaSalida()); //La fecha la paso de String a Date

                        vista.getjFechainicio().setDate(fecha);
                    } catch (ParseException ex) {
                        Logger.getLogger(ControladorCamionero.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    listacam.stream().forEach(ca -> {
                        if (ca.getCodigoCam() == c.getCodigoCam()) {

                            vista.getTxtcedula().setText(ca.getDni());
                            vista.getTxtnombreyapellido().setText(ca.getPrinombre() + " " + ca.getApellidopat());
                        }

                    });

                    listacmi.stream().forEach(ci -> {
                        if (ci.getCodigoCmi() == c.getCodigoCmi()) {

                            vista.getTxtplaca().setText(ci.getPlaca());
                        }
                    });
                }
            });
        }
    }

    //TODO SOBRE CAMIONERO
    public void abrirjDialogCamionero() {
        vista.getjDlgConduceCamionero().setLocationRelativeTo(vista);
        vista.getjDlgConduceCamionero().setSize(565, 324);
        vista.getjDlgConduceCamionero().setTitle("Seleccionar un camionero");
        vista.getjDlgConduceCamionero().setVisible(true);
        cargarDatosDelCamionero();
    }

    public void cargarDatosDelCamionero() {

        Modelo_Camionero modeloCamionero = new Modelo_Camionero();
        vista.getTblcamionerosDlg().setRowHeight(25);
        DefaultTableModel estructuraTabla = (DefaultTableModel) vista.getTblcamionerosDlg().getModel();
        estructuraTabla.setRowCount(0);

        List<Camionero> listap = modeloCamionero.listaCamionerosTabla();

        Holder<Integer> i = new Holder<>(0);

        listap.stream().forEach(persona -> {

            estructuraTabla.addRow(new Object[8]);

            vista.getTblcamionerosDlg().setValueAt(persona.getCodigoCam(), i.value, 0);
            vista.getTblcamionerosDlg().setValueAt(persona.getDni(), i.value, 1);
            vista.getTblcamionerosDlg().setValueAt(persona.getPrinombre(), i.value, 2);
            vista.getTblcamionerosDlg().setValueAt(persona.getApellidopat(), i.value, 3);

            i.value++;
        });
    }

    public void cargarDatosCamioneroEnTXT() {
        int fila = vista.getTblcamionerosDlg().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "ERROR: Debe seleccionar una fila");
        } else {

            String codigo;
            String cedula;
            String nombre;
            String apellido;

            codigo = vista.getTblcamionerosDlg().getValueAt(fila, 0).toString();
            cedula = vista.getTblcamionerosDlg().getValueAt(fila, 1).toString();
            nombre = vista.getTblcamionerosDlg().getValueAt(fila, 2).toString();
            apellido = vista.getTblcamionerosDlg().getValueAt(fila, 3).toString();

            vista.getTxtcodigocamionero().setText(codigo);
            vista.getTxtcedula().setText(cedula);
            vista.getTxtnombreyapellido().setText(nombre + " " + apellido);

            vista.getjDlgConduceCamionero().dispose();//Cierro la ventana luego de cargar los datos
        }
    }

    //TODO SOBRE CAMION
    public void abrirjDialogCamion() {
        vista.getjDlgConduceCamion().setLocationRelativeTo(vista);
        vista.getjDlgConduceCamion().setSize(536, 247);
        vista.getjDlgConduceCamion().setTitle("Seleccionar camion");
        vista.getjDlgConduceCamion().setVisible(true);
        cargarDatosDelCamion();
    }

    public void cargarDatosDelCamion() {

        Modelo_Camion modeloCamion = new Modelo_Camion();

        vista.getTblcamionesDlg().setRowHeight(25);
        DefaultTableModel estructuraTabla = (DefaultTableModel) vista.getTblcamionesDlg().getModel();
        estructuraTabla.setRowCount(0);

        List<Camion> listap = modeloCamion.listaCamiones();

        Holder<Integer> i = new Holder<>(0);

        listap.stream().forEach(c -> {

            estructuraTabla.addRow(new Object[8]);

            vista.getTblcamionesDlg().setValueAt(c.getCodigoCmi(), i.value, 0);
            vista.getTblcamionesDlg().setValueAt(c.getPlaca(), i.value, 1);

            i.value++;
        });
    }

    public void cargarDatosCamionEnTXT() {
        int fila = vista.getTblcamionesDlg().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "ERROR: Seleccionar una fila");
        } else {

            String codigo;
            String placa;

            codigo = vista.getTblcamionesDlg().getValueAt(fila, 0).toString();
            placa = vista.getTblcamionesDlg().getValueAt(fila, 1).toString();

            vista.getTxtcodigocamion().setText(codigo);
            vista.getTxtplaca().setText(placa);

            vista.getjDlgConduceCamion().dispose();//Cierro la ventana luego de cargar los datos
        }
    }

    public void crearOModificarConduccion() {

        if (vista.getjDlgConduce().getName().equals("Crear un nuevo conductor")) { //CREAR

            if (validarDatos()) {

                int codigoCamionero = Integer.parseInt(vista.getTxtcodigocamionero().getText());
                int codigoCamion = Integer.parseInt(vista.getTxtcodigocamion().getText());
                Date fechainicio = vista.getjFechainicio().getDate(); //Obtengo la fecha del jDateChooser y la paso a date

                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); //Doy formato a la fecha
                String fechainicioTexto = formato.format(fechainicio); //La fecha tiene el formato indicado y es de tipo String

                //Seteo los datos
                Modelo_Conduce conduce = new Modelo_Conduce();

                conduce.setCodigoCam(codigoCamionero);
                conduce.setCodigoCmi(codigoCamion);
                conduce.setFechaSalida(fechainicioTexto);

                if (conduce.crearConduccion()) {
                    vista.getjDlgConduce().setVisible(false);
                    JOptionPane.showMessageDialog(vista, "Turno de conduccion Creado Satisfactoriamente");
                    cargarTablaTurnosDeConduccion();
                } else {
                    JOptionPane.showMessageDialog(vista, "No se pudo crear la el turno de conduccion");
                }
            } else {

                JOptionPane.showMessageDialog(vista, "Faltan campos por llenar o estan llenados de forma incorrecta");
            }

        } else {//EDITAR 

            if (validarDatos()) {

                int codigoConduce = Integer.parseInt(vista.getTxtcodigoconduce().getText());
                int codigoCamionero = Integer.parseInt(vista.getTxtcodigocamionero().getText());
                int codigoCamion = Integer.parseInt(vista.getTxtcodigocamion().getText());
                Date fechainicio = vista.getjFechainicio().getDate(); //Obtengo la fecha del jDateChooser y la paso a date

                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); //Doy formato a la fecha
                String fechainicioTexto = formato.format(fechainicio); //La fecha tiene el formato indicado y es de tipo String

                //Seteo los datos
                Modelo_Conduce conduce = new Modelo_Conduce();

                conduce.setCodigoCon(codigoConduce);
                conduce.setCodigoCam(codigoCamionero);
                conduce.setCodigoCmi(codigoCamion);
                conduce.setFechaSalida(fechainicioTexto);

                if (conduce.modificarConduccion()) {
                    vista.getjDlgConduce().setVisible(false);
                    JOptionPane.showMessageDialog(vista, "El turno de conduccion se ha Modificado Satisfactoriamente");
                    cargarTablaTurnosDeConduccion();
                } else {
                    JOptionPane.showMessageDialog(vista, "Error: El turno de conduccion no se pudo modificar");
                }
            } else {
                JOptionPane.showMessageDialog(vista, "Faltan campos por llenar o estan llenados de forma incorrecta");
            }
        }
    }

    public void eliminarRegistros() {
        int fila = vista.getTablaconduccion().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "ERROR:Seleccionar una fila");
        } else {

            int response = JOptionPane.showConfirmDialog(vista, "¿Desea eliminar esta información?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {

                int codigo;
                codigo = Integer.parseInt(vista.getTablaconduccion().getValueAt(fila, 0).toString());

                if (modelo.eliminarConduce(codigo)) {
                    JOptionPane.showMessageDialog(null, "Los registros fueron eliminados correctamente");
                    cargarTablaTurnosDeConduccion();//Actualizo la tabla con los datos
                } else {
                    JOptionPane.showMessageDialog(null, "Error: No se pudo eliminar los registros");
                }
            }
        }
    }

    public void buscarRegistros() {

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

                //CODIGO PARA FILTRAR LOS DATOS DIRECTAMENTE DE LA TABLA. NO ELIMINAR. SI FUNCIONA. ES MUY IMPORTANTE
//                TableRowSorter<DefaultTableModel> filtrar;
//
//                DefaultTableModel tabla = (DefaultTableModel) vista.getTablaconduccion().getModel();
//
//                //vista.getTablaconduccion().setAutoCreateRowSorter(true);
//                filtrar = new TableRowSorter<>(tabla);
//                vista.getTablaconduccion().setRowSorter(filtrar);
//
//                try {
//
//                    filtrar.setRowFilter(RowFilter.regexFilter(vista.getTxtbuscar().getText())); //Se pasa como parametro el campo de donde se va a obtener la informacion y el (3) es la columna con la cual va a buscar las coincidencias
//                } catch (Exception ex) {
//                    System.out.println("Error: " + ex);
//                }
                try {

                    Modelo_Camionero modeloCamionero = new Modelo_Camionero();
                    Modelo_Camion modeloCamion = new Modelo_Camion();

                    DefaultTableModel tabla = (DefaultTableModel) vista.getTablaconduccion().getModel();
                    tabla.setNumRows(0);

                    List<Conduce> listacon = modelo.buscarTurnosDeConduccion(Integer.parseInt(vista.getTxtbuscar().getText()));
                    List<Camionero> listacam = modeloCamionero.listaCamionerosTabla();
                    List<Camion> listacmi = modeloCamion.listaCamiones();

                    listacon.stream().forEach(c -> {

                        String fechaInicio = c.getFechaSalida().substring(0, 10);

                        listacam.stream().forEach(ca -> {

                            if (c.getCodigoCam() == ca.getCodigoCam()) {

                                listacmi.stream().forEach(ci -> {

                                    if (c.getCodigoCmi() == ci.getCodigoCmi()) {

                                        String[] datos = {String.valueOf(c.getCodigoCon()), fechaInicio, String.valueOf(c.getCodigoCam()), ca.getDni(), ca.getPrinombre() + " " + ca.getApellidopat(), String.valueOf(c.getCodigoCmi()), ci.getPlaca()};
                                        tabla.addRow(datos);
                                    }
                                });
                            }
                        });
                    });
                } catch (NumberFormatException n) {

                    //System.out.println("Error: No se puede pasar a un numero");
                }
            }
        };

        vista.getTxtbuscar().addKeyListener(eventoTeclado); //"addKeyListener" es un metodo que se le tiene que pasar como argumento un objeto de tipo keyListener 
    }

    public boolean validarDatos() {
        boolean validar = true;

        if (vista.getTxtcodigocamionero().getText().isEmpty()) {

            validar = false;
        }

        if (vista.getTxtcodigocamion().getText().isEmpty()) {
            validar = false;
        }

        if (vista.getjFechainicio().getDate() == null) {
            validar = false;
        }

        return validar;
    }

    public void limpiarDatosYDespacerCampos() {

        vista.getTxtcodigocamionero().setText("");
        vista.getTxtcedula().setText("");
        vista.getTxtnombreyapellido().setText("");
        vista.getTxtcodigocamion().setText("");
        vista.getTxtplaca().setText("");
        vista.getjFechainicio().setDate(null);

        vista.getTxtcodigoconduce().setVisible(false);
        vista.getLblcodigoconduce().setVisible(false);
    }
}
