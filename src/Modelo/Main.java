package Modelo;

import Controlador.ControladorPrincipal;
import Vista.VistaPrincipal;

public class Main {

    public static void main(String[] args) {

        VistaPrincipal vistaPrincipal = new VistaPrincipal();

        ControladorPrincipal control = new ControladorPrincipal(vistaPrincipal);
        control.iniciaControl();
    }
}
