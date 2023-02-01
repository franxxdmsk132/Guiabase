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

    public Modelo_Conduce(int codigoCon, String fechaSalida, String fechaLlegada, int codigoCam, int codigoCmi) {
        super(codigoCon, fechaSalida, fechaLlegada, codigoCam, codigoCmi);
    }

    public boolean crearConduccion() {

        String sql = "insert into conduce (con_codconductor, con_codcamion, con_fecini, con_fecfin) values (" + getCod_conductor()+ "," + getCod_camion()+ ",'" + getFecha_Salida()+ "','" + getFecha_llegada()+ "')";
        return conoc.accion(sql);
    }

    public List<Conduce> listaTurnosDeConduccion() {
        try {
            //Me retorna un "List" de "persona"
            List<Conduce> lista = new ArrayList<>();

            String sql = "select * from conduce";

            ResultSet rs = conoc.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                //Crear las instancias de las personas
                Conduce con = new Conduce();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
                con.setCod_conductor(rs.getInt("con_cod"));
                con.setCod_camionero(rs.getInt("con_codcamionero"));
                con.setCod_camion(rs.getInt("con_codcamion"));
                con.setFecha_Salida(rs.getString("con_fecini"));
                con.setFecha_llegada(rs.getString("con_fecfin"));


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
