package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Modelo_Provincia extends Provincia {

    ConectOC conoc = new ConectOC();

    public Modelo_Provincia() {
    }

    public Modelo_Provincia(int codigoPro, String nombre, String region, int numcanton) {
        super(codigoPro, nombre, region, numcanton);
    }

    public boolean crearProvincia() {
        String sql = "insert into provincia (pro_nombre, pro_region, pro_numcanton, pro_estado) values ('" + getNombre() + "','" + getRegion() + "'," + getNum_canton()+ ",'A')";
        return conoc.accion(sql);
    }

    public boolean modificarProvincia() {

        String sql = "UPDATE provincia SET pro_nombre = '" + getNombre() + "', pro_region = '" + getRegion() + "', pro_numcanton = " + getNum_canton() + " WHERE pro_codigo = " + getCod_prov()+ "";
        return conoc.accion(sql);
    }

    public boolean eliminarProvincia(int codigo) {

        String sqlC = "UPDATE provincia SET pro_estado = 'I' WHERE pro_codigo = '" + codigo + "'";
        return conoc.accion(sqlC);
    }

    public List<Provincia> listaProvincias() {
        try {
            //Me retorna un "List" de "persona"
            List<Provincia> lista = new ArrayList<>();

            String sql = "select * from provincia where pro_estado = 'A'";

            ResultSet rs = conoc.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                Provincia pro = new Provincia();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
                pro.setCod_prov(rs.getInt("pro_cod"));
                pro.setNombre(rs.getString("pro_nombre"));
                pro.setRegion(rs.getString("pro_region"));
                pro.setNum_canton(rs.getInt("pro_numcanton"));

                lista.add(pro); //Agrego los datos a la lista
            }

            //Cierro la conexion a la BD
            rs.close();
            //Retorno la lista
            return lista;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Provincia.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Provincia> listabuscarProvincia(String nombre) {
        try {
            //Me retorna un "List" de "persona"
            List<Provincia> lista = new ArrayList<>();

            String sql = "select * from provincia where pro_estado = 'A' and Upper(pro_nombre) like '" + nombre.toUpperCase() + "%'";

            ResultSet rs = conoc.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                Provincia pro = new Provincia();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
                pro.setCod_prov(rs.getInt("pro_cod"));
                pro.setNombre(rs.getString("pro_nombre"));
                pro.setRegion(rs.getString("pro_region"));
                pro.setNum_canton(rs.getInt("pro_numcanton"));

                lista.add(pro); //Agrego los datos a la lista
            }

            //Cierro la conexion a la BD
            rs.close();
            //Retorno la lista
            return lista;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Provincia.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int validarRepetidosNombre(String nombre) {
        int cantidad = 0;
        try {

            String sql = "select COUNT(*) from provincia where pro_nombre = '" + nombre + "'";

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
