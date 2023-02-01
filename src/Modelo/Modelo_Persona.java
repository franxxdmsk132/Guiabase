package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Modelo_Persona extends Persona {

    ConectOC conoc = new ConectOC();

    public Modelo_Persona() {
    }

    public Modelo_Persona(int codigo, String dni, String prinombre, String segnombre, String apellidopat, String apellidomat, String direccion, String telefono, String email, String fechanac, int edad, String genero) {
        super(codigo, dni, prinombre, segnombre, apellidopat, apellidomat, direccion, telefono, email, fechanac, edad, genero);
    }

    public int traerCodigoDePersonaCrear() { //Retorna el codigo maximo. Este codigo sirve para crear una persona en la BD
        int codigo = 0;
        try {

            String sql = "select max(per_codigo) from persona";

            ResultSet rs = conoc.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                codigo = rs.getInt("max(per_codigo)"); //Trae el codigo de la persona recien creada

            }

            //Cierro la conexion a la BD
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Camionero.class.getName()).log(Level.SEVERE, null, ex);

        }

        return codigo;
    }

    public int traerCodigoDePersonaModificar(String cedula) { //Trae el codigo de la persona dependiendo el numero de cedula pasado como parametro
        int codigo = 0;
        try {

            String sql = "select per_codigo from persona where per_dni = '" + cedula + "'";

            ResultSet rs = conoc.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                codigo = rs.getInt("per_codigo"); //Trae el codigo de la persona recien creada

            }

            //Cierro la conexion a la BD
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Camionero.class.getName()).log(Level.SEVERE, null, ex);

        }

        return codigo;
    }

    public int validarRepetidos(String cedula) { //Metodo que sirve para validar la cantidad de cedulas existentes en la BD
        int cantidad = 0;
        try {

            String sql = "select COUNT(*) from persona where per_dni='"+cedula+"'";

            ResultSet rs = conoc.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                cantidad = rs.getInt("COUNT(*)"); //Trae la cantidad de dni repetidos

            }

            //Cierro la conexion a la BD
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Camionero.class.getName()).log(Level.SEVERE, null, ex);

        }

        return cantidad;
    }
}
