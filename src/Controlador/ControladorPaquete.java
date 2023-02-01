package Controlador;

import Modelo.Camion;
import Modelo.Camionero;
import Modelo.Cliente;
import Modelo.Conduce;
import Modelo.Destinatario;
import Modelo.Modelo_Camion;
import Modelo.Modelo_Camionero;
import Modelo.Modelo_Cliente;
import Modelo.Modelo_Destinatario;
import Modelo.Modelo_Paquete;
import Modelo.Modelo_Provincia;
import Modelo.Paquete;
import Modelo.Provincia;
import Vista.VistaPaquete;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;

public class ControladorPaquete {

    Modelo_Paquete modelo;
    VistaPaquete vista;

    public ControladorPaquete(Modelo_Paquete modelo, VistaPaquete vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
        cargarTablaPaquetes();
    }

    public void iniciarControl() {
        vista.getBtncrear().addActionListener(l -> abrirDialogCrear());
        vista.getBtnbuscarcliente().addActionListener(l -> abrirjDialogCliente());
        vista.getBtnbuscarcamionero().addActionListener(l -> abrirjDialogCamionero());
        vista.getBtnbuscardestinatario().addActionListener(l -> abrirjDialogDestinatario());
        vista.getBtnbuscarProvincia().addActionListener(l -> abrirjDialogProvincias());
        vista.getBtncargarCliente().addActionListener(l -> cargarDatosClienteEnTXT());
        vista.getBtncargarCamionero().addActionListener(l -> cargarDatosCamioneroEnTXT());
        vista.getBtncargarDestinatario().addActionListener(l -> cargarDatosDestinatarioEnTXT());
        vista.getBtncargarProvincias().addActionListener(l -> cargarDatosProvinciaEnTXT());
        vista.getBtnactualizar().addActionListener(l -> cargarTablaPaquetes());
        vista.getBtnmodificar().addActionListener(l -> abrirYCargarDatosEnElDialogPaquete());
        vista.getBtnguardar().addActionListener(l -> crearOModificarConduccion());
        buscarRegistros();
    }

    public void abrirDialogCrear() {
        vista.getjDlgPaquetes().setName("Registrar nuevo Paquete");
        vista.getjDlgPaquetes().setLocationRelativeTo(vista);
        vista.getjDlgPaquetes().setSize(1017, 521);
        vista.getjDlgPaquetes().setTitle("Registrar nuevo Paquete");
        vista.getjDlgPaquetes().setVisible(true);
        limpiarDatosYDespacerCampos();
    }

    public void cargarTablaPaquetes() {

        Modelo_Camionero modeloCamionero = new Modelo_Camionero();
        Modelo_Destinatario modeloDestinatario = new Modelo_Destinatario();
        Modelo_Cliente modeloCliente = new Modelo_Cliente();
        Modelo_Provincia modeloProvincia = new Modelo_Provincia();

        DefaultTableModel tabla = (DefaultTableModel) vista.getTablapaquetes().getModel();
        tabla.setNumRows(0);

        List<Paquete> listapaq = modelo.listaPaquetes();
        List<Camionero> listacam = modeloCamionero.listaCamionerosTabla();
        List<Destinatario> listades = modeloDestinatario.listaDestinatariosTabla();
        List<Cliente> listacli = modeloCliente.listaClientesTabla();
        List<Provincia> listaprov = modeloProvincia.listaProvincias();

        listapaq.stream().forEach(p -> {

            String fechaRegistro = p.getFecharegistro().substring(0, 10);
            listacam.stream().forEach(ca -> {

                if (p.getCodcamionero() == ca.getCodigoCam()) {

                    listades.stream().forEach(de -> {

                        if (p.getCoddestina() == de.getCodigodes()) {

                            listacli.stream().forEach(cl -> {

                                if (p.getCodcliente() == cl.getCodigocli()) {

                                    listaprov.stream().forEach(pr -> {

                                        if (p.getCodprovincia() == pr.getCodigoPro()) {

                                            String[] datos = {String.valueOf(p.getCodigoPaq()), fechaRegistro, String.valueOf(p.getCoddestina()), de.getPrinombre() + " " + de.getApellidopat(), String.valueOf(p.getCodcliente()), cl.getPrinombre() + " " + cl.getApellidopat()};
                                            tabla.addRow(datos);
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
            });
        });
    }

    public void abrirYCargarDatosEnElDialogPaquete() {

        //Creo objetos de los modelos de camionero y de camion
        Modelo_Camionero modeloCamionero = new Modelo_Camionero();
        Modelo_Destinatario modeloDestinatario = new Modelo_Destinatario();
        Modelo_Cliente modeloCliente = new Modelo_Cliente();
        Modelo_Provincia modeloProvincia = new Modelo_Provincia();

        //Cargar los list con los registros
        List<Camionero> listacam = modeloCamionero.listaCamionerosTabla();
        List<Destinatario> listades = modeloDestinatario.listaDestinatariosTabla();
        List<Cliente> listacli = modeloCliente.listaClientesTabla();
        List<Provincia> listaprov = modeloProvincia.listaProvincias();

        int seleccion = vista.getTablapaquetes().getSelectedRow();

        if (seleccion == -1) {
            JOptionPane.showMessageDialog(null, "NO SE A SELECCIONADO NINGUN ELEMENTO");
        } else {

            int codigo = Integer.parseInt(vista.getTablapaquetes().getValueAt(seleccion, 0).toString());
            modelo.listaPaquetes().forEach((p) -> {
                if (p.getCodigoPaq() == codigo) {

                    //Abre el jDialog y carga los datos en el jDialog
                    vista.getjDlgPaquetes().setName("Editar");
                    vista.getjDlgPaquetes().setLocationRelativeTo(vista);
                    vista.getjDlgPaquetes().setSize(1017, 521);
                    vista.getjDlgPaquetes().setTitle("Editar");
                    vista.getjDlgPaquetes().setVisible(true);

                    //Visibilizo y bloqueo campos
                    setearFechaActual(); //Seteo la fecha actual en el jDateChooser
                    vista.getLblCodigoPaquete().setVisible(true);
                    vista.getTxtcodigoPaquete().setVisible(true);
                    vista.getTxtcodigoPaquete().setEditable(false);
                    vista.getJclfecharegistro().setEnabled(false);

                    //Seteo los datos en los campos de texto
                    vista.getTxtcodigoPaquete().setText(String.valueOf(p.getCodigoPaq()));
                    vista.getTxtcodigoCliente().setText(String.valueOf(p.getCodcliente()));
                    vista.getTxtcodigoDestinatario().setText(String.valueOf(p.getCoddestina()));
                    vista.getTxtCodigoProvincia().setText(String.valueOf(p.getCodprovincia()));
                    vista.getTxtcodigoCamionero().setText(String.valueOf(p.getCodcamionero()));
                    vista.getSpinnerPeso().setValue(p.getPeso());

                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); //Doy formato a la fecha
                    try {
                        Date fechaR = formato.parse(p.getFecharegistro()); //La fecha la paso de String a Date
                        Date fechaS = formato.parse(p.getSalidaprogra());
                        Date fechaL = formato.parse(p.getLlegadaprogra());

                        vista.getJclfecharegistro().setDate(fechaR);
                        vista.getJclsalidapro().setDate(fechaS);
                        vista.getJclllegadapro().setDate(fechaL);

                    } catch (ParseException ex) {
                        Logger.getLogger(ControladorPaquete.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    listacli.stream().forEach(cl -> {
                        if (p.getCodcliente() == cl.getCodigocli()) {

                            vista.getTxtcedcliente().setText(cl.getDni());
                            vista.getTxtnomcliente().setText(cl.getPrinombre() + " " + cl.getApellidopat());
                        }
                    });

                    listades.stream().forEach(de -> {
                        if (p.getCoddestina() == de.getCodigodes()) {

                            vista.getTxtceddestinatario().setText(de.getDni());
                            vista.getTxtnomdestinatario().setText(de.getPrinombre() + " " + de.getApellidopat());
                        }
                    });

                    listaprov.stream().forEach(pr -> {
                        if (p.getCodprovincia() == pr.getCodigoPro()) {

                            vista.getTxtnombreprovincia().setText(pr.getNombre());
                        }
                    });

                    listacam.stream().forEach(ca -> {
                        if (p.getCodcamionero() == ca.getCodigoCam()) {

                            vista.getTxtcedcamionero().setText(ca.getDni());
                            vista.getTxtnomcamionero().setText(ca.getPrinombre() + " " + ca.getApellidopat());
                        }
                    });
                }
            });
        }
    }

    public void crearOModificarConduccion() {

        if (vista.getjDlgPaquetes().getName().equals("Registrar nuevo Paquete")) { //CREAR

            if (validarDatos()) {

                int codigoCliente = Integer.parseInt(vista.getTxtcodigoCliente().getText());
                int codigoCamionero = Integer.parseInt(vista.getTxtcodigoCamionero().getText());
                int codigoDestinatario = Integer.parseInt(vista.getTxtcodigoDestinatario().getText());

                int codigoProvincia = Integer.parseInt(vista.getTxtCodigoProvincia().getText());

                double peso = Double.parseDouble(vista.getSpinnerPeso().getValue().toString());

                Date fechasalida = vista.getJclsalidapro().getDate();
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                String fechasalidaT = formato.format(fechasalida);

                Date fechallegada = vista.getJclllegadapro().getDate();
                String fechallegadaT = formato.format(fechallegada);

                Date fecharegistro = vista.getJclfecharegistro().getDate();
                String fecharegistroT = formato.format(fecharegistro);

                //Seteo los datos
                Modelo_Paquete paquete = new Modelo_Paquete();

                paquete.setCodcliente(codigoCliente);
                paquete.setCodcamionero(codigoCamionero);
                paquete.setCoddestina(codigoDestinatario);
                paquete.setCodprovincia(codigoProvincia);
                paquete.setPeso(peso);
                paquete.setSalidaprogra(fechasalidaT);
                paquete.setLlegadaprogra(fechallegadaT);
                paquete.setFecharegistro(fecharegistroT);

                if (paquete.crearPaquete()) {
                    vista.getjDlgPaquetes().setVisible(false);
                    JOptionPane.showMessageDialog(vista, "Se registro exitosamente el envio del paquete");
                    cargarTablaPaquetes();
                } else {
                    JOptionPane.showMessageDialog(vista, "No se pudo enviar el paquete");
                }

            } else {

                JOptionPane.showMessageDialog(vista, "Faltan campos por llenar o estan llenados de forma incorrecta");
            }

        } else {//EDITAR 

            if (validarDatos()) {

                int codigoPaquete = Integer.parseInt(vista.getTxtcodigoPaquete().getText());
                int codigoCliente = Integer.parseInt(vista.getTxtcodigoCliente().getText());
                int codigoCamionero = Integer.parseInt(vista.getTxtcodigoCamionero().getText());
                int codigoDestinatario = Integer.parseInt(vista.getTxtcodigoDestinatario().getText());
                int codigoProvincia = Integer.parseInt(vista.getTxtCodigoProvincia().getText());

                double peso = Double.parseDouble(vista.getSpinnerPeso().getValue().toString());

                Date fechasalida = vista.getJclsalidapro().getDate();
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                String fechasalidaT = formato.format(fechasalida);

                Date fechallegada = vista.getJclllegadapro().getDate();
                String fechallegadaT = formato.format(fechallegada);

                Date fecharegistro = vista.getJclfecharegistro().getDate();
                String fecharegistroT = formato.format(fecharegistro);

                //Seteo los datos
                Modelo_Paquete paquete = new Modelo_Paquete();

                paquete.setCodigoPaq(codigoPaquete);
                paquete.setCodcliente(codigoCliente);
                paquete.setCodcamionero(codigoCamionero);
                paquete.setCoddestina(codigoDestinatario);
                paquete.setCodprovincia(codigoProvincia);
                paquete.setPeso(peso);
                paquete.setSalidaprogra(fechasalidaT);
                paquete.setLlegadaprogra(fechallegadaT);
                paquete.setFecharegistro(fecharegistroT);

                if (paquete.modificarPaquete()) {
                    vista.getjDlgPaquetes().setVisible(false);
                    JOptionPane.showMessageDialog(vista, "EL PAQUETE FUE ALTERADO EXITOSAMENTE");
                    cargarTablaPaquetes();
                } else {
                    JOptionPane.showMessageDialog(vista, "ERROR EN MODIFICACION DE PAQUETE");
                }

            } else {
                JOptionPane.showMessageDialog(vista, "CAMPOS VACIOS O LLENADOS DE MANERA INCORRECTA ");
            }

        }
    }

    //TODO SOBRE CLIENTE
    public void abrirjDialogCliente() {
        vista.getjDlgClientes().setLocationRelativeTo(vista);
        vista.getjDlgClientes().setSize(565, 324);
        vista.getjDlgClientes().setTitle("Seleccionar cliente");
        vista.getjDlgClientes().setVisible(true);
        cargarDatosDeClientes();
    }

    public void cargarDatosDeClientes() {

        Modelo_Cliente modeloCliente = new Modelo_Cliente();
        vista.getTblclientes().setRowHeight(25);
        DefaultTableModel estructuraTabla = (DefaultTableModel) vista.getTblclientes().getModel();
        estructuraTabla.setRowCount(0);

        List<Cliente> listap = modeloCliente.listaClientesTabla();

        Holder<Integer> i = new Holder<>(0);

        listap.stream().forEach(persona -> {

            estructuraTabla.addRow(new Object[8]);

            vista.getTblclientes().setValueAt(persona.getCodigocli(), i.value, 0);
            vista.getTblclientes().setValueAt(persona.getDni(), i.value, 1);
            vista.getTblclientes().setValueAt(persona.getPrinombre(), i.value, 2);
            vista.getTblclientes().setValueAt(persona.getApellidopat(), i.value, 3);

            i.value++;
        });
    }

    public void cargarDatosClienteEnTXT() {
        int fila = vista.getTblclientes().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {

            String codigo;
            String cedula;
            String nombre;
            String apellido;

            codigo = vista.getTblclientes().getValueAt(fila, 0).toString();
            cedula = vista.getTblclientes().getValueAt(fila, 1).toString();
            nombre = vista.getTblclientes().getValueAt(fila, 2).toString();
            apellido = vista.getTblclientes().getValueAt(fila, 3).toString();

            vista.getTxtcodigoCliente().setText(codigo);
            vista.getTxtcedcliente().setText(cedula);
            vista.getTxtnomcliente().setText(nombre + " " + apellido);

            vista.getjDlgClientes().dispose();//Cierro la ventana luego de cargar los datos
        }
    }

    //TODO SOBRE EL DESTINATARIO
    public void abrirjDialogDestinatario() {
        vista.getjDlgDestinatario().setLocationRelativeTo(vista);
        vista.getjDlgDestinatario().setSize(565, 324);
        vista.getjDlgDestinatario().setTitle("Seleccionar destinatario");
        vista.getjDlgDestinatario().setVisible(true);
        cargarDatosDeDestinatario();
    }

    public void cargarDatosDeDestinatario() {

        Modelo_Destinatario modeloDestinatario = new Modelo_Destinatario();
        vista.getTbldestinatarios().setRowHeight(25);
        DefaultTableModel estructuraTabla = (DefaultTableModel) vista.getTbldestinatarios().getModel();
        estructuraTabla.setRowCount(0);

        List<Destinatario> listap = modeloDestinatario.listaDestinatariosTabla();

        Holder<Integer> i = new Holder<>(0);

        listap.stream().forEach(persona -> {

            estructuraTabla.addRow(new Object[8]);

            vista.getTbldestinatarios().setValueAt(persona.getCodigodes(), i.value, 0);
            vista.getTbldestinatarios().setValueAt(persona.getDni(), i.value, 1);
            vista.getTbldestinatarios().setValueAt(persona.getPrinombre(), i.value, 2);
            vista.getTbldestinatarios().setValueAt(persona.getApellidopat(), i.value, 3);

            i.value++;
        });
    }

    public void cargarDatosDestinatarioEnTXT() {
        int fila = vista.getTbldestinatarios().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "NINGUN ELEMENTO SELECCIONADO");
        } else {

            String codigo;
            String cedula;
            String nombre;
            String apellido;

            codigo = vista.getTbldestinatarios().getValueAt(fila, 0).toString();
            cedula = vista.getTbldestinatarios().getValueAt(fila, 1).toString();
            nombre = vista.getTbldestinatarios().getValueAt(fila, 2).toString();
            apellido = vista.getTbldestinatarios().getValueAt(fila, 3).toString();

            vista.getTxtcodigoDestinatario().setText(codigo);
            vista.getTxtceddestinatario().setText(cedula);
            vista.getTxtnomdestinatario().setText(nombre + " " + apellido);

            vista.getjDlgDestinatario().dispose();//Cierro la ventana luego de cargar los datos
        }
    }

    //TODO SOBRE CAMIONERO
    public void abrirjDialogCamionero() {
        vista.getjDlgCamionero().setLocationRelativeTo(vista);
        vista.getjDlgCamionero().setSize(565, 324);
        vista.getjDlgCamionero().setTitle("Seleccionar camionero");
        vista.getjDlgCamionero().setVisible(true);
        cargarDatosDelCamionero();
    }

    public void cargarDatosDelCamionero() {

        Modelo_Camionero modeloCamionero = new Modelo_Camionero();
        vista.getTblcamioneros().setRowHeight(25);
        DefaultTableModel estructuraTabla = (DefaultTableModel) vista.getTblcamioneros().getModel();
        estructuraTabla.setRowCount(0);

        List<Camionero> listap = modeloCamionero.listaCamionerosTabla();

        Holder<Integer> i = new Holder<>(0);

        listap.stream().forEach(persona -> {

            estructuraTabla.addRow(new Object[8]);

            vista.getTblcamioneros().setValueAt(persona.getCodigoCam(), i.value, 0);
            vista.getTblcamioneros().setValueAt(persona.getDni(), i.value, 1);
            vista.getTblcamioneros().setValueAt(persona.getPrinombre(), i.value, 2);
            vista.getTblcamioneros().setValueAt(persona.getApellidopat(), i.value, 3);

            i.value++;
        });
    }

    public void cargarDatosCamioneroEnTXT() {
        int fila = vista.getTblcamioneros().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "NINGUN ELEMENTO SELCCIONADO");
        } else {

            String codigo;
            String cedula;
            String nombre;
            String apellido;

            codigo = vista.getTblcamioneros().getValueAt(fila, 0).toString();
            cedula = vista.getTblcamioneros().getValueAt(fila, 1).toString();
            nombre = vista.getTblcamioneros().getValueAt(fila, 2).toString();
            apellido = vista.getTblcamioneros().getValueAt(fila, 3).toString();

            vista.getTxtcodigoCamionero().setText(codigo);
            vista.getTxtcedcamionero().setText(cedula);
            vista.getTxtnomcamionero().setText(nombre + " " + apellido);

            vista.getjDlgCamionero().dispose();//Cierro la ventana luego de cargar los datos
        }
    }

    //TODO DE PROVINCIAS
    public void abrirjDialogProvincias() {
        vista.getjDlgProvincias().setLocationRelativeTo(vista);
        vista.getjDlgProvincias().setSize(502, 326);
        vista.getjDlgProvincias().setTitle("Seleccionar provincia");
        vista.getjDlgProvincias().setVisible(true);
        cargarDatosDelLasProvincias();
    }

    public void cargarDatosDelLasProvincias() {

        Modelo_Provincia modeloProvincia = new Modelo_Provincia();
        vista.getJtblaProvinciasjDlg().setRowHeight(25);
        DefaultTableModel estructuraTabla = (DefaultTableModel) vista.getJtblaProvinciasjDlg().getModel();
        estructuraTabla.setRowCount(0);

        List<Provincia> listap = modeloProvincia.listaProvincias();

        Holder<Integer> i = new Holder<>(0);

        listap.stream().forEach(p -> {

            estructuraTabla.addRow(new Object[8]);

            vista.getJtblaProvinciasjDlg().setValueAt(p.getCodigoPro(), i.value, 0);
            vista.getJtblaProvinciasjDlg().setValueAt(p.getNombre(), i.value, 1);

            i.value++;
        });
    }

    public void cargarDatosProvinciaEnTXT() {
        int fila = vista.getJtblaProvinciasjDlg().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "NINGUN ELEMENTO SELCCIONADO");
        } else {

            String codigo;
            String nombre;

            codigo = vista.getJtblaProvinciasjDlg().getValueAt(fila, 0).toString();
            nombre = vista.getJtblaProvinciasjDlg().getValueAt(fila, 1).toString();

            vista.getTxtCodigoProvincia().setText(codigo);
            vista.getTxtnombreprovincia().setText(nombre);

            vista.getjDlgProvincias().dispose();//Cierro la ventana luego de cargar los datos
        }
    }

    public void setearFechaActual() {
        Date fecha = null;
        LocalDate ahora = LocalDate.now();

        SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");

        try {
            fecha = formatofecha.parse(ahora.toString());
        } catch (ParseException ex) {
            Logger.getLogger(ControladorPaquete.class.getName()).log(Level.SEVERE, null, ex);
        }
        vista.getJclfecharegistro().setDate(fecha);
        vista.getJclfecharegistro().setEnabled(false);
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

                try {

                    Modelo_Camionero modeloCamionero = new Modelo_Camionero();
                    Modelo_Destinatario modeloDestinatario = new Modelo_Destinatario();
                    Modelo_Cliente modeloCliente = new Modelo_Cliente();
                    Modelo_Provincia modeloProvincia = new Modelo_Provincia();

                    DefaultTableModel tabla = (DefaultTableModel) vista.getTablapaquetes().getModel();
                    tabla.setNumRows(0);

                    List<Paquete> listapaq = modelo.buscarPaquetes(Integer.parseInt(vista.getTxtbuscar().getText()));
                    List<Camionero> listacam = modeloCamionero.listaCamionerosTabla();
                    List<Destinatario> listades = modeloDestinatario.listaDestinatariosTabla();
                    List<Cliente> listacli = modeloCliente.listaClientesTabla();
                    List<Provincia> listaprov = modeloProvincia.listaProvincias();

                    listapaq.stream().forEach(p -> {

                        String fechaRegistro = p.getFecharegistro().substring(0, 10);
                        listacam.stream().forEach(ca -> {

                            if (p.getCodcamionero() == ca.getCodigoCam()) {

                                listades.stream().forEach(de -> {

                                    if (p.getCoddestina() == de.getCodigodes()) {

                                        listacli.stream().forEach(cl -> {

                                            if (p.getCodcliente() == cl.getCodigocli()) {

                                                listaprov.stream().forEach(pr -> {

                                                    if (p.getCodprovincia() == pr.getCodigoPro()) {

                                                        String[] datos = {String.valueOf(p.getCodigoPaq()), fechaRegistro, String.valueOf(p.getCoddestina()), de.getPrinombre() + " " + de.getApellidopat(), String.valueOf(p.getCodcliente()), cl.getPrinombre() + " " + cl.getApellidopat()};
                                                        tabla.addRow(datos);
                                                    }
                                                });
                                            }
                                        });
                                    }
                                });
                            }
                        });
                    });
                } catch (NumberFormatException ex) {
                    //System.out.println("Error");
                }
            }
        };

        vista.getTxtbuscar().addKeyListener(eventoTeclado); //"addKeyListener" es un metodo que se le tiene que pasar como argumento un objeto de tipo keyListener 
    }

    public boolean validarDatos() {
        boolean validar = true;

        if (vista.getTxtcodigoCliente().getText().isEmpty()) {

            validar = false;
        }

        if (vista.getTxtcodigoDestinatario().getText().isEmpty()) {
            validar = false;
        }

        if (vista.getTxtcodigoCamionero().getText().isEmpty()) {
            validar = false;
        }

        if (vista.getTxtCodigoProvincia().getText().isEmpty()) {
            validar = false;
        }

        if (vista.getJclsalidapro().getDate() == null) {
            validar = false;
        }

        if (vista.getJclllegadapro().getDate() == null) {
            validar = false;
        }

        return validar;
    }

    public void limpiarDatosYDespacerCampos() {
        vista.getTxtcodigoCliente().setText("");
        vista.getTxtcedcliente().setText("");
        vista.getTxtnomcliente().setText("");
        vista.getTxtcodigoDestinatario().setText("");
        vista.getTxtcodigoDestinatario().setText("");
        vista.getTxtnomdestinatario().setText("");
        vista.getTxtCodigoProvincia().setText("");
        vista.getTxtnombreprovincia().setText("");
        vista.getTxtcodigoCamionero().setText("");
        vista.getTxtcodigoCamionero().setText("");
        vista.getTxtnomcamionero().setText("");
        vista.getSpinnerPeso().setValue(1);
        vista.getJclfecharegistro().setDate(null);// Limpio la fecha de registro
        vista.getJclsalidapro().setDate(null);
        vista.getJclllegadapro().setDate(null);

        vista.getTxtcodigoPaquete().setVisible(false);
        vista.getLblCodigoPaquete().setVisible(false);
        setearFechaActual();
    }
}
