package Controlador;

import Modelo.Modelo_Provincia;
import Modelo.Provincia;
import Modelo.Validaciones;
import Vista.VistaProvincia;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;

public class ControladorProvincia {

    Modelo.Modelo_Provincia modelo;
    Vista.VistaProvincia vista;

    public ControladorProvincia(Modelo_Provincia modelo, VistaProvincia vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
        cargarTabla();
    }

    public void iniciarControl() {
        vista.getBtncrear().addActionListener(l -> abrirDialogCrear());
        vista.getBtnmodificar().addActionListener(l -> abrirYCargarDatosEnElDialog());
        vista.getBtnguardar().addActionListener(l -> crearOModificarProvincia());
        vista.getBtneliminar().addActionListener(l -> eliminarProvinciaContr());
        buscarProvincia();
    }

    public void abrirDialogCrear() {
        vista.getjDlgprovincias().setName("Crear nueva provincia");
        vista.getjDlgprovincias().setLocationRelativeTo(vista);
        vista.getjDlgprovincias().setSize(429, 387);
        vista.getjDlgprovincias().setTitle("Crear nueva provincia");
        vista.getjDlgprovincias().setVisible(true);
        limpiarDatos();
        desaparecerCampos();//Es Invisible el campo de codigo
    }

    public void cargarTabla() {
        vista.getTblprovincias().setRowHeight(25);
        DefaultTableModel estructuraTabla = (DefaultTableModel) vista.getTblprovincias().getModel();
        estructuraTabla.setRowCount(0);

        List<Provincia> listap = modelo.listaProvincias();

        Holder<Integer> i = new Holder<>(0);

        listap.stream().forEach(persona -> {

            estructuraTabla.addRow(new Object[8]);

            vista.getTblprovincias().setValueAt(persona.getCodigoPro(), i.value, 0);
            vista.getTblprovincias().setValueAt(persona.getNombre(), i.value, 1);
            vista.getTblprovincias().setValueAt(persona.getRegion(), i.value, 2);
            vista.getTblprovincias().setValueAt(persona.getNumcanton(), i.value, 3);

            i.value++;
        });
    }

    public void abrirYCargarDatosEnElDialog() {

        int seleccion = vista.getTblprovincias().getSelectedRow();

        if (seleccion == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {

            String codigo = vista.getTblprovincias().getValueAt(seleccion, 0).toString();

            modelo.listaProvincias().forEach((pe) -> {
                if (pe.getCodigoPro() == Integer.parseInt(codigo)) {

                    //Abre el jDialog y carga los datos en el jDialog
                    vista.getjDlgprovincias().setName("Editar");
                    vista.getjDlgprovincias().setLocationRelativeTo(vista);
                    vista.getjDlgprovincias().setSize(429, 387);
                    vista.getjDlgprovincias().setTitle("Editar");
                    vista.getjDlgprovincias().setVisible(true);
                    vista.getTxtcodigo().setEditable(false); //Bloqueo el campo
                    aparecerCampos(); //Es visible el campo de codigo

                    //Seteo los datos en los campos de texto
                    vista.getTxtcodigo().setText(String.valueOf(pe.getCodigoPro()));
                    vista.getTxtnombre().setText(pe.getNombre());
                    vista.getTxtregion().setText(pe.getRegion());
                    vista.getSpinnercantones().setValue(pe.getNumcanton());
                }
            });
        }
    }

    public void crearOModificarProvincia() {

        if (vista.getjDlgprovincias().getName().equals("Crear nueva provincia")) { //CREAR

            if (modelo.validarRepetidosNombre(vista.getTxtnombre().getText()) == 0) {

                if (validarDatos()) {
                    String nombre = vista.getTxtnombre().getText();
                    String region = vista.getTxtregion().getText();
                    int cantones = Integer.parseInt(vista.getSpinnercantones().getValue().toString());

                    Modelo_Provincia provincia = new Modelo_Provincia();

                    provincia.setNombre(nombre);
                    provincia.setRegion(region);
                    provincia.setNumcanton(cantones);

                    if (provincia.crearProvincia()) {
                        vista.getjDlgprovincias().setVisible(false);
                        JOptionPane.showMessageDialog(vista, "Provincia Creada Satisfactoriamente");
                        cargarTabla();
                    } else {
                        JOptionPane.showMessageDialog(vista, "No se pudo crear la provincia");
                    }
                }

            } else {
                JOptionPane.showMessageDialog(vista, "La provincia ya se encuentra registrada");
            }
        } else {//EDITAR 

            if (validarDatos()) {

                int codigo = Integer.valueOf(vista.getTxtcodigo().getText());
                String nombre = vista.getTxtnombre().getText();
                String region = vista.getTxtregion().getText();
                int cantones = Integer.parseInt(vista.getSpinnercantones().getValue().toString());

                Modelo_Provincia provincia = new Modelo_Provincia();
                provincia.setCodigoPro(codigo);
                provincia.setNombre(nombre);
                provincia.setRegion(region);
                provincia.setNumcanton(cantones);

                if (provincia.modificarProvincia()) {
                    vista.getjDlgprovincias().setVisible(false);
                    JOptionPane.showMessageDialog(vista, "Provincia Modificada Satisfactoriamente");
                    cargarTabla();
                } else {
                    JOptionPane.showMessageDialog(vista, "Error: No se pudo modificar la provincia");
                }
            } else {
                JOptionPane.showMessageDialog(vista, "Faltan campos por llenar o estan llenados de forma incorrecta");
            }

        }
    }

    public void buscarProvincia() {
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

                vista.getTblprovincias().setRowHeight(25);
                DefaultTableModel estructuraTabla = (DefaultTableModel) vista.getTblprovincias().getModel();
                estructuraTabla.setRowCount(0);

                List<Provincia> listap = modelo.listabuscarProvincia(vista.getTxtbuscar().getText());

                Holder<Integer> i = new Holder<>(0);

                listap.stream().forEach(persona -> {

                    estructuraTabla.addRow(new Object[8]);

                    vista.getTblprovincias().setValueAt(persona.getCodigoPro(), i.value, 0);
                    vista.getTblprovincias().setValueAt(persona.getNombre(), i.value, 1);
                    vista.getTblprovincias().setValueAt(persona.getRegion(), i.value, 2);
                    vista.getTblprovincias().setValueAt(persona.getNumcanton(), i.value, 3);

                    i.value++;
                });
            }
        };

        vista.getTxtbuscar().addKeyListener(eventoTeclado); //"addKeyListener" es un metodo que se le tiene que pasar como argumento un objeto de tipo keyListener 
    }

    public void eliminarProvinciaContr() {
        int fila = vista.getTblprovincias().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {

            int response = JOptionPane.showConfirmDialog(vista, "¿Seguro que desea eliminar esta información?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {

                int codigo;
                codigo = Integer.parseInt(vista.getTblprovincias().getValueAt(fila, 0).toString());

                if (modelo.eliminarProvincia(codigo)) {
                    JOptionPane.showMessageDialog(null, "La provincia fue eliminada exitosamente");
                    cargarTabla();//Actualizo la tabla con los datos
                } else {
                    JOptionPane.showMessageDialog(null, "Error: La provincia no se pudo eliminar");
                }
            }
        }
    }

    public boolean validarDatos() {
        Validaciones mivalidacion = new Validaciones();

        boolean validar = true;

        if (vista.getTxtnombre().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el nombre");
            validar = false;
        } else {
            if (!mivalidacion.validarTextoConEspacio(vista.getTxtnombre().getText())) {
                JOptionPane.showMessageDialog(null, "Nombre incorrecto");
                validar = false;
            }
        }

        if (vista.getTxtregion().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese la region");
            validar = false;
        } else {
            if (!mivalidacion.validarTextoSinEspacio(vista.getTxtregion().getText())) {
                JOptionPane.showMessageDialog(null, "Region incorrecta");
                validar = false;
            }
        }


        return validar;
    }

    public void limpiarDatos() {
        vista.getTxtnombre().setText("");
        vista.getTxtregion().setText("");
        vista.getSpinnercantones().setValue(1);
    }

    public void desaparecerCampos() {
        vista.getLbcodigo().setVisible(false);
        vista.getTxtcodigo().setVisible(false);
    }

    public void aparecerCampos() {
        vista.getLbcodigo().setVisible(true);
        vista.getTxtcodigo().setVisible(true);
    }
}
