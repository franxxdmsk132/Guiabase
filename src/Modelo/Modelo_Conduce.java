package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Modelo_Conduce extends Conduce {

    ConectOC conoc = new ConectOC();

    public Modelo_Conduce() {
    }

    public Modelo_Conduce(int codigoCon, String fechaSalida, int codigoCam, int codigoCmi) {
        super(codigoCon, fechaSalida, codigoCam, codigoCmi);
    }

    public boolean crearConduccion() {

        String sql = "insert into conduce (con_codcamionero, con_codcamion, con_fechaini, con_estado) values (" + getCodigoCam() + "," + getCodigoCmi() + ",'" + getFechaSalida() + "', 'A')";
        return conoc.accion(sql);
    }

    public boolean modificarConduccion() {

        String sql = "Update conduce set con_codcamionero = " + getCodigoCam() + ", con_codcamion = " + getCodigoCmi() + ", con_fechaini = '" + getFechaSalida() + "' where con_codigo = " + getCodigoCon() + "";
        return conoc.accion(sql);
    }

    public boolean eliminarConduce(int codigo) {
        String sql = "Update conduce set con_estado = 'I' where con_codigo = " + codigo + "";
        return conoc.accion(sql);

    }

    public List<Conduce> listaTurnosDeConduccion() {
        try {
            //Me retorna un "List" de "persona"
            List<Conduce> lista = new ArrayList<>();

            String sql = "select * from conduce where con_estado = 'A'";

            ResultSet rs = conoc.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                //Crear las instancias de las personas
                Conduce con = new Conduce();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
                con.setCodigoCon(rs.getInt("con_codigo"));
                con.setCodigoCam(rs.getInt("con_codcamionero"));
                con.setCodigoCmi(rs.getInt("con_codcamion"));
                con.setFechaSalida(rs.getString("con_fechaini"));

                lista.add(con); //Agrego los datos a la lista
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

    public List<Conduce> buscarTurnosDeConduccion(int codigo) {
        try {
            //Me retorna un "List" de "persona"
            List<Conduce> lista = new ArrayList<>();

            String sql = "select * from conduce where con_codigo like '" + codigo + "%'";

            ResultSet rs = conoc.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                //Crear las instancias de las personas
                Conduce con = new Conduce();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
                con.setCodigoCon(rs.getInt("con_codigo"));
                con.setCodigoCam(rs.getInt("con_codcamionero"));
                con.setCodigoCmi(rs.getInt("con_codcamion"));
                con.setFechaSalida(rs.getString("con_fechaini"));

                lista.add(con); //Agrego los datos a la lista
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
}
