package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Modelo_Camionero extends Camionero {

    ConectOC conoc = new ConectOC();

    public Modelo_Camionero() {
    }

    public Modelo_Camionero(int codigoCam, double salario, String tipolicencia, int aniosexperiencia, String estado) {
        super(codigoCam, salario, tipolicencia, aniosexperiencia, estado);
    }

    public Modelo_Camionero(int codigoCam, double salario, String tipolicencia, int aniosexperiencia, String estado, int codigo, String dni, String prinombre, String segnombre, String apellidopat, String apellidomat, String direccion, String telefono, String email, String fechanac, int edad, String genero) {
        super(codigoCam, salario, tipolicencia, aniosexperiencia, estado, codigo, dni, prinombre, segnombre, apellidopat, apellidomat, direccion, telefono, email, fechanac, edad, genero);
    }

    public boolean crearPersona() {

        String sql = "insert into persona (per_dni, per_prinombre, per_segnombre, per_apellidopat, per_apellidomat, per_direccion, per_telefono, per_email, per_fechanac, per_edad, per_genero) values ('" + getDni() + "','" + getPrinombre() + "','" + getSegnombre() + "','" + getApellidopat() + "','" + getApellidomat() + "','" + getDireccion() + "','" + getTelefono() + "','" + getEmail() + "','" + getFechanac() + "'," + getEdad() + ",'" + getGenero() + "')";
        return conoc.accion(sql);
    }

    public boolean crearCamionero() {

        Modelo_Persona mipersona = new Modelo_Persona(); //Creo un objeto de la clase Modelo_Persona 

        if (crearPersona()) { //Si la persona ya existe entonces puedo crear un camionero

            String sql = "insert into camionero (cam_percodigo, cam_salario, cam_tipolicencia, cam_aniosexperi, cam_estado) values (" + mipersona.traerCodigoDePersonaCrear() + "," + getSalario() + ",'" + getTipolicencia() + "'," + getAniosexperiencia() + ",'A')";
            return conoc.accion(sql);
        } else {
            return false;
        }
    }

    public boolean modificarPersonaYCamionero() { //Modificar la instancia en la BD
        Modelo_Persona mipersona = new Modelo_Persona(); //Creo un objeto de la clase Modelo_Persona 

        String sqlP = "UPDATE persona set per_prinombre = '" + getPrinombre() + "',per_segnombre = '" + getSegnombre() + "', per_apellidopat = '" + getApellidopat() + "', per_apellidomat = '" + getApellidomat() + "', per_direccion = '" + getDireccion() + "', per_telefono = '" + getTelefono() + "', per_email = '" + getEmail() + "', per_fechanac = '" + getFechanac() + "', per_edad = " + getEdad() + ", per_genero = '" + getGenero() + "' where per_dni = '" + getDni() + "'"; //Modifica los datos en la tabla persona

        String sqlC = "UPDATE camionero SET cam_salario = " + getSalario() + ",cam_tipolicencia = '" + getTipolicencia() + "', cam_aniosexperi = " + getAniosexperiencia() + " WHERE cam_percodigo = '" + mipersona.traerCodigoDePersonaModificar(getDni()) + "'"; //Modifica los datos de la tabla camionero
        return conoc.accion(sqlP) && conoc.accion(sqlC);
    }

    public boolean eliminarCamionero(String cedula) { //Modificar el estado del camionero
        Modelo_Persona mipersona = new Modelo_Persona(); //Creo un objeto de la clase Modelo_Persona 

        String sqlC = "UPDATE camionero SET cam_estado = 'I' WHERE cam_percodigo = '" + mipersona.traerCodigoDePersonaModificar(cedula) + "'";
        return conoc.accion(sqlC);
    }

    public List<Camionero> listaCamionerosTabla() {
        try {
            //Me retorna un "List" de "persona"
            List<Camionero> lista = new ArrayList<>();

            String sql = "select cam_codigo, per_dni,per_prinombre,per_segnombre,per_apellidopat,per_apellidomat,per_direccion,per_telefono,per_email,per_fechanac,per_edad,per_genero,cam_salario,cam_tipolicencia,cam_aniosexperi from persona p, camionero c where p.per_codigo = c.cam_percodigo and c.cam_estado = 'A'";

            ResultSet rs = conoc.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                //Crear las instancias de las personas
                Camionero cam = new Camionero();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
                cam.setCodigoCam(rs.getInt("cam_codigo"));
                cam.setDni(rs.getString("per_dni"));
                cam.setPrinombre(rs.getString("per_prinombre"));
                cam.setSegnombre(rs.getString("per_segnombre"));
                cam.setApellidopat(rs.getString("per_apellidopat"));
                cam.setApellidomat(rs.getString("per_apellidomat"));
                cam.setDireccion(rs.getString("per_direccion"));
                cam.setTelefono(rs.getString("per_telefono"));
                cam.setEmail(rs.getString("per_email"));
                cam.setFechanac(rs.getString("per_fechanac"));
                cam.setEdad(rs.getInt("per_edad"));
                cam.setGenero(rs.getString("per_genero"));
                cam.setSalario(rs.getDouble("cam_salario"));
                cam.setTipolicencia(rs.getString("cam_tipolicencia"));
                cam.setAniosexperiencia(rs.getInt("cam_aniosexperi"));

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

    public List<Camionero> listabuscarPersonasYCamioneros(String cedula) {
        try {
            //Me retorna un "List" de "persona"
            List<Camionero> lista = new ArrayList<>();

            String sql = "select per_dni,per_prinombre,per_segnombre,per_apellidopat,per_apellidomat,per_direccion,per_telefono,per_email,per_fechanac,per_edad,per_genero,cam_salario,cam_tipolicencia,cam_aniosexperi from persona p, camionero c where p.per_codigo = c.cam_percodigo and c.cam_estado = 'A' and per_dni Like '"+cedula+"%'";

            ResultSet rs = conoc.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                //Crear las instancias de las personas
                Camionero cam = new Camionero();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
                cam.setDni(rs.getString("per_dni"));
                cam.setPrinombre(rs.getString("per_prinombre"));
                cam.setSegnombre(rs.getString("per_segnombre"));
                cam.setApellidopat(rs.getString("per_apellidopat"));
                cam.setApellidomat(rs.getString("per_apellidomat"));
                cam.setDireccion(rs.getString("per_direccion"));
                cam.setTelefono(rs.getString("per_telefono"));
                cam.setEmail(rs.getString("per_email"));
                cam.setFechanac(rs.getString("per_fechanac"));
                cam.setEdad(rs.getInt("per_edad"));
                cam.setGenero(rs.getString("per_genero"));
                cam.setSalario(rs.getDouble("cam_salario"));
                cam.setTipolicencia(rs.getString("cam_tipolicencia"));
                cam.setAniosexperiencia(rs.getInt("cam_aniosexperi"));

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
}
