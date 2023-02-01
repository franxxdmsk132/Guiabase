package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Modelo_Paquete extends Paquete {

    ConectOC conoc = new ConectOC();

    public Modelo_Paquete() {
    }

    public Modelo_Paquete(int codigoPaq, int codcliente, int codprovincia, int coddestina, int codcamionero, String salidaproga, String llegadaprogra, double peso, String fecharegistro) {
        super(codigoPaq, codcliente, codprovincia, coddestina, codcamionero, salidaproga, llegadaprogra, peso, fecharegistro);
    }

    public boolean crearPaquete() {

        String sql = "insert into paquete (paq_codcliente,paq_codprovincia, paq_coddestina, paq_codcamionero, paq_salidaproga, paq_llegadaprogra,paq_peso, paq_fecharegistro) values (" + getCodcliente() + "," + getCodprovincia() + "," + getCoddestina() + "," + getCodcamionero() + ",'" + getSalidaprogra() + "','" + getLlegadaprogra() + "'," + getPeso() + ",'" + getFecharegistro() + "')";
        return conoc.accion(sql);
    }

    public boolean modificarPaquete() { //Modificar la instancia en la BD

        String sqlP = "UPDATE paquete SET paq_codcliente = " + getCodcliente() + ", paq_codprovincia = " + getCodprovincia() + ",paq_coddestina = " + getCoddestina() + ",paq_codcamionero = " + getCodcamionero() + ", paq_peso = " + getPeso() + ",paq_salidaproga = '" + getSalidaprogra() + "',paq_llegadaprogra = '" + getLlegadaprogra() + "' WHERE paq_codigo = " + getCodigoPaq() + ""; //Modifica los datos de la tabla paquete...Solo modifica peso, llegadaprogra, salidaprogra
        return conoc.accion(sqlP);
    }

    public boolean eliminarPaquete(String cedula) { //Eliminar un paquete

        String sqlC = "DELETE paquete WHERE paq_codigo = " + getCodigoPaq() + "";
        return conoc.accion(sqlC);
    }

    public List<Paquete> listaPaquetes() {
        try {
            //Me retorna un "List" de "persona"
            List<Paquete> lista = new ArrayList<>();

            String sql = "select * from paquete";

            ResultSet rs = conoc.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                //Crear las instancias de las personas
                Paquete paq = new Paquete();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
                paq.setCodigoPaq(rs.getInt("paq_codigo"));
                paq.setCodcliente(rs.getInt("paq_codcliente"));
                paq.setCodprovincia(rs.getInt("paq_codprovincia"));
                paq.setCoddestina(rs.getInt("paq_coddestina"));
                paq.setCodcamionero(rs.getInt("paq_codcamionero"));
                paq.setPeso(rs.getDouble("paq_peso"));
                paq.setFecharegistro(rs.getString("paq_fecharegistro"));
                paq.setLlegadaprogra(rs.getString("paq_llegadaprogra"));
                paq.setSalidaprogra(rs.getString("paq_salidaproga"));

                lista.add(paq); //Agrego los datos a la lista
            }

            //Cierro la conexion a la BD
            rs.close();
            //Retorno la lista
            return lista;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Paquete.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Paquete> buscarPaquetes(int codigo) {
        try {
            //Me retorna un "List" de "persona"
            List<Paquete> lista = new ArrayList<>();

            String sql = "select * from paquete where paq_codigo like '"+codigo+"%'";

            ResultSet rs = conoc.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                //Crear las instancias de las personas
                Paquete paq = new Paquete();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
                paq.setCodigoPaq(rs.getInt("paq_codigo"));
                paq.setCodcliente(rs.getInt("paq_codcliente"));
                paq.setCodprovincia(rs.getInt("paq_codprovincia"));
                paq.setCoddestina(rs.getInt("paq_coddestina"));
                paq.setCodcamionero(rs.getInt("paq_codcamionero"));
                paq.setPeso(rs.getDouble("paq_peso"));
                paq.setFecharegistro(rs.getString("paq_fecharegistro"));
                paq.setLlegadaprogra(rs.getString("paq_llegadaprogra"));
                paq.setSalidaprogra(rs.getString("paq_salidaproga"));

                lista.add(paq); //Agrego los datos a la lista
            }

            //Cierro la conexion a la BD
            rs.close();
            //Retorno la lista
            return lista;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Paquete.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
