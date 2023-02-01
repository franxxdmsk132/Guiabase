package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Modelo_Camion extends Camion {

    ConectOC conoc = new ConectOC();

    public Modelo_Camion() {
    }

    public Modelo_Camion(int codigoCmi, String placa, String matricula, String modelo, String tipo, double potencia, char estado) {
        super(codigoCmi, placa, matricula, modelo, tipo, potencia, estado);
    }

    public boolean crearCamion() {
        String sql = "insert into camion (cmi_placa, cmi_matricula, cmi_modelo, cmi_tipo, cmi_potencia, cmi_estado) values ('" + getPlaca() + "','" + getMatricula() + "','" + getModelo() + "','" + getTipo() + "'," + getPotencia() + ",'A')";
        return conoc.accion(sql);
    }

    public boolean modificarCamion() {

        String sql = "UPDATE camion SET cmi_matricula = '" + getMatricula() + "', cmi_modelo = '" + getModelo() + "', cmi_tipo = '" + getTipo() + "', cmi_potencia = " + getPotencia() + " WHERE cmi_placa = '" + getPlaca() + "'";
        return conoc.accion(sql);
    }

    public boolean eliminarCamion(String placa) {

        String sqlC = "UPDATE camion SET cmi_estado = 'I' WHERE cmi_placa = '" + placa + "'";
        return conoc.accion(sqlC);
    }

    public List<Camion> listaCamiones() {
        try {
            //Me retorna un "List" de "persona"
            List<Camion> lista = new ArrayList<>();

            String sql = "select * from camion where cmi_estado = 'A'";

            ResultSet rs = conoc.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                Camion cam = new Camion();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
                cam.setCodigoCmi(rs.getInt("cmi_codigo"));
                cam.setPlaca(rs.getString("cmi_placa"));
                cam.setMatricula(rs.getString("cmi_matricula"));
                cam.setModelo(rs.getString("cmi_modelo"));
                cam.setTipo(rs.getString("cmi_tipo"));
                cam.setPotencia(rs.getDouble("cmi_potencia"));

                lista.add(cam); //Agrego los datos a la lista
            }

            //Cierro la conexion a la BD
            rs.close();
            //Retorno la lista
            return lista;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Camionero.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Camion> listabuscarCamion(String placa) {
        try {
            //Me retorna un "List" de "persona"
            List<Camion> lista = new ArrayList<>();

            String sql = "select * from camion where cmi_estado = 'A' and cmi_placa like '" + placa + "%'";

            ResultSet rs = conoc.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                Camion cam = new Camion();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
                cam.setCodigoCmi(rs.getInt("cmi_codigo"));
                cam.setPlaca(rs.getString("cmi_placa"));
                cam.setMatricula(rs.getString("cmi_matricula"));
                cam.setModelo(rs.getString("cmi_modelo"));
                cam.setTipo(rs.getString("cmi_tipo"));
                cam.setPotencia(rs.getDouble("cmi_potencia"));

                lista.add(cam); //Agrego los datos a la lista
            }

            //Cierro la conexion a la BD
            rs.close();
            //Retorno la lista
            return lista;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Camionero.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int validarRepetidosPlaca(String placa) {
        int cantidad = 0;
        try {

            String sql = "select COUNT(*) from camion where cmi_placa = '" + placa + "'";

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

    public int validarRepetidosMatricula(String matricula) {
        int cantidad = 0;
        try {

            String sql = "select COUNT(*) from camion where cmi_matricula = '" + matricula + "'";

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
