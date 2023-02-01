
package Modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Modelo_Destinatario extends Destinatario{
    ConectOC conoc = new ConectOC();

    public Modelo_Destinatario() {
    }

    public Modelo_Destinatario(int codigodes, String codpostal, String infocomplement, String calleprinc, String callesecun) {
        super(codigodes, codpostal, infocomplement, calleprinc, callesecun);
    }

    public Modelo_Destinatario(int codigodes, String codpostal, String infocomplement, String calleprinc, String callesecun, int codigo, String dni, String prinombre, String segnombre, String apellidopat, String apellidomat, String direccion, String telefono, String email, String fechanac, int edad, String genero) {
        super(codigodes, codpostal, infocomplement, calleprinc, callesecun, codigo, dni, prinombre, segnombre, apellidopat, apellidomat, direccion, telefono, email, fechanac, edad, genero);
    }
    
    public boolean crearPersona() {

        String sql = "insert into persona (per_dni, per_prinombre, per_segnombre, per_apellidopat, per_apellidomat, per_direccion, per_telefono, per_email, per_fechanac, per_edad, per_genero) values ('" + getDni() + "','" + getPrinombre() + "','" + getSegnombre() + "','" + getApellidopat() + "','" + getApellidomat() + "','" + getDireccion() + "','" + getTelefono() + "','" + getEmail() + "','" + getFechanac() + "'," + getEdad() + ",'" + getGenero() + "')";
        return conoc.accion(sql);
    }

    public boolean crearDestinatario() {

        Modelo_Persona mipersona = new Modelo_Persona(); //Creo un objeto de la clase Modelo_Persona 

        if (crearPersona()) { //Si la persona ya existe entonces puedo crear un destinatario

            String sql = "insert into destinatario (des_percodigo, des_codpostal, des_infocomplement, des_calleprinc, des_callesecun) values (" + mipersona.traerCodigoDePersonaCrear() + ",'" + getCodpostal() + "','" + getInfocomplement() + "','"+getCalleprinc()+"','"+getCallesecun()+"')";
            return conoc.accion(sql);
        } else {
            return false;
        }
    }
    
    public boolean modificarPersonaYDestinatario() { //Modificar la instancia en la BD
        Modelo_Persona mipersona = new Modelo_Persona(); //Creo un objeto de la clase Modelo_Persona 

        String sqlP = "UPDATE persona set per_prinombre = '" + getPrinombre() + "',per_segnombre = '" + getSegnombre() + "', per_apellidopat = '" + getApellidopat() + "', per_apellidomat = '" + getApellidomat() + "', per_direccion = '" + getDireccion() + "', per_telefono = '" + getTelefono() + "', per_email = '" + getEmail() + "', per_fechanac = '" + getFechanac() + "', per_edad = " + getEdad() + ", per_genero = '" + getGenero() + "' where per_dni = '" + getDni() + "'"; //Modifica los datos en la tabla persona

        String sqlC = "UPDATE destinatario SET des_codpostal = '" + getCodpostal() + "',des_infocomplement = '" + getInfocomplement() + "', des_calleprinc = '" + getCalleprinc() + "', des_callesecun = '" + getCallesecun() +  "' WHERE des_percodigo = '" + mipersona.traerCodigoDePersonaModificar(getDni()) + "'"; //Modifica los datos de la tabla camionero
        return conoc.accion(sqlP) && conoc.accion(sqlC);
    }

    public boolean eliminarDestinatario(String cedula) { //Modificar el estado del destinatario
        Modelo_Persona mipersona = new Modelo_Persona(); //Creo un objeto de la clase Modelo_Persona 

        String sqlC = "DELETE destinatario WHERE des_percodigo = '" + mipersona.traerCodigoDePersonaModificar(cedula) + "'";
        return conoc.accion(sqlC);
    }
    
    public List<Destinatario> listaDestinatariosTabla() {
        try {
            //Me retorna un "List" de "persona"
            List<Destinatario> lista = new ArrayList<>();

            String sql = "select des_codigo, per_dni,per_prinombre,per_segnombre,per_apellidopat,per_apellidomat,per_direccion,per_telefono,per_email,per_fechanac,per_edad,per_genero,des_codpostal,des_infocomplement,des_calleprinc,des_callesecun from persona p, destinatario d where p.per_codigo = d.des_percodigo";

            ResultSet rs = conoc.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                //Crear las instancias de las personas
                Destinatario des = new Destinatario();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
                des.setCodigodes(rs.getInt("des_codigo"));
                des.setDni(rs.getString("per_dni"));
                des.setPrinombre(rs.getString("per_prinombre"));
                des.setSegnombre(rs.getString("per_segnombre"));
                des.setApellidopat(rs.getString("per_apellidopat"));
                des.setApellidomat(rs.getString("per_apellidomat"));
                des.setDireccion(rs.getString("per_direccion"));
                des.setTelefono(rs.getString("per_telefono"));
                des.setEmail(rs.getString("per_email"));
                des.setFechanac(rs.getString("per_fechanac"));
                des.setEdad(rs.getInt("per_edad"));
                des.setGenero(rs.getString("per_genero"));
                des.setCodpostal(rs.getString("des_codpostal"));
                des.setInfocomplement(rs.getString("des_infocomplement"));
                des.setCalleprinc(rs.getString("des_calleprinc"));
                des.setCallesecun(rs.getString("des_callesecun"));

                lista.add(des); //Agrego los datos a la lista
            }

            //Cierro la conexion a la BD
            rs.close();
            //Retorno la lista
            return lista;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Destinatario.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Destinatario> listabuscarPersonasYDestinatarios(String cedula) {
        try {
            //Me retorna un "List" de "persona"
            List<Destinatario> lista = new ArrayList<>();

            String sql = "select per_dni,per_prinombre,per_segnombre,per_apellidopat,per_apellidomat,per_direccion,per_telefono,per_email,per_fechanac,per_edad,per_genero,des_codpostal,des_infocomplement,des_calleprinc,des_callesecun from persona p, destinatario d where p.per_codigo =d.des_percodigo and per_dni Like '" + cedula + "%'";

            ResultSet rs = conoc.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                //Crear las instancias de las personas
                Destinatario des = new Destinatario();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
                des.setDni(rs.getString("per_dni"));
                des.setPrinombre(rs.getString("per_prinombre"));
                des.setSegnombre(rs.getString("per_segnombre"));
                des.setApellidopat(rs.getString("per_apellidopat"));
                des.setApellidomat(rs.getString("per_apellidomat"));
                des.setDireccion(rs.getString("per_direccion"));
                des.setTelefono(rs.getString("per_telefono"));
                des.setEmail(rs.getString("per_email"));
                des.setFechanac(rs.getString("per_fechanac"));
                des.setEdad(rs.getInt("per_edad"));
                des.setGenero(rs.getString("per_genero"));
                des.setCodpostal(rs.getString("des_codpostal"));
                des.setInfocomplement(rs.getString("des_infocomplement"));
                des.setCalleprinc(rs.getString("des_calleprinc"));
                des.setCallesecun(rs.getString("des_callesecun"));

                lista.add(des); //Agrego los datos a la lista
            }

            //Cierro la conexion a la BD
            rs.close();
            //Retorno la lista
            return lista;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Destinatario.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
