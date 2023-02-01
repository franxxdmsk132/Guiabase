package Controlador;

import Modelo.Modelo_Camion;
import Modelo.Modelo_Camionero;
import Modelo.Modelo_Cliente;
import Modelo.Modelo_Conduce;
import Modelo.Modelo_Destinatario;
import Modelo.Modelo_Paquete;
import Modelo.Modelo_Provincia;
import Vista.VistaCamion;
import Vista.VistaCamionero;
import Vista.VistaCliente;
import Vista.VistaConduce;
import Vista.VistaDestinatario;
import Vista.VistaPaquete;
import Vista.VistaPrincipal;
import Vista.VistaProvincia;

public class ControladorPrincipal {

    VistaPrincipal vistaPrincipal;

    public ControladorPrincipal(VistaPrincipal vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;
        vistaPrincipal.setVisible(true);
    }

    public void iniciaControl() {

        vistaPrincipal.getBtnCamionero().addActionListener(l -> crudCamioneros());
        vistaPrincipal.getBtncamion().addActionListener(l -> crudCamiones());
        vistaPrincipal.getBtnprovincia().addActionListener(l -> crudProvincias());
        vistaPrincipal.getBtnCliente().addActionListener(l -> crudClientes());
        vistaPrincipal.getBtndestinatario().addActionListener(l -> crudDestinatarios());
        vistaPrincipal.getBtnconduce().addActionListener(l-> crudConduce());
        vistaPrincipal.getBtnpaquetes().addActionListener(l-> crudPaquetes());
    }

    private void crudCamioneros() {
        //Instancio las clases del Modelo y la Vista.
        VistaCamionero vista = new VistaCamionero();
        Modelo_Camionero modelo = new Modelo_Camionero();

        //Agregar VistaCamionero al Desktop Pane.
        vistaPrincipal.getEscritorio().add(vista);

        ControladorCamionero control = new ControladorCamionero(modelo, vista);
        control.iniciarControl();//Empezamos las escuchas a los eventos de la vista, Listeners.
    }

    private void crudCamiones() {
        VistaCamion vista = new VistaCamion();
        Modelo_Camion modelo = new Modelo_Camion();

        vistaPrincipal.getEscritorio().add(vista);

        ControladorCamion control = new ControladorCamion(modelo, vista);
        control.iniciarControl();
    }

    private void crudConduce() {
        VistaConduce vista = new VistaConduce();
        Modelo_Conduce modelo = new Modelo_Conduce();

        vistaPrincipal.getEscritorio().add(vista);

        ControladorConduce control = new ControladorConduce(modelo, vista);
        control.iniciarControl();
    }

    private void crudClientes() {
        VistaCliente vista = new VistaCliente();
        Modelo_Cliente modelo = new Modelo_Cliente();

        vistaPrincipal.getEscritorio().add(vista);

        ControladorCliente control = new ControladorCliente(modelo, vista);
        control.iniciarControl();
    }

    private void crudDestinatarios() {
        VistaDestinatario vista = new VistaDestinatario();
        Modelo_Destinatario modelo = new Modelo_Destinatario();

        vistaPrincipal.getEscritorio().add(vista);

        ControladorDestinatario control = new ControladorDestinatario(modelo, vista);
        control.iniciarControl();
    }

    private void crudProvincias() {
        VistaProvincia vista = new VistaProvincia();
        Modelo_Provincia modelo = new Modelo_Provincia();

        vistaPrincipal.getEscritorio().add(vista);

        ControladorProvincia control = new ControladorProvincia(modelo, vista);
        control.iniciarControl();
    }
    
    private void crudPaquetes() {
        //Instancio las clases del Modelo y la Vista.
        VistaPaquete vista = new VistaPaquete();
        Modelo_Paquete modelo = new Modelo_Paquete();

        //Agregar VistaCamionero al Desktop Pane.
        vistaPrincipal.getEscritorio().add(vista);

        ControladorPaquete control = new ControladorPaquete(modelo, vista);
        control.iniciarControl();//Empezamos las escuchas a los eventos de la vista, Listeners.
    }
}
