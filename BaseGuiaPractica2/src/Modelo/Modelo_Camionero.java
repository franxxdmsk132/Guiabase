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

    public Modelo_Camionero(int cam_cod, double sueldo, String tipolic, int aniosexperiencia, String estado) {
        super(cam_cod, sueldo, tipolic, aniosexperiencia, estado);
    }

    public Modelo_Camionero(int cam_cod, double sueldo, String tipolic, int aniosexperiencia, String estado, int per_cod, String per_cd, String per_nombre1, String per_nombre2, String per_apellido1, String per_apellido2, String per_dir, String per_tel, String per_email, String fechanac, int edad, String per_gen) {
        super(cam_cod, sueldo, tipolic, aniosexperiencia, estado, per_cod, per_cd, per_nombre1, per_nombre2, per_apellido1, per_apellido2, per_dir, per_tel, per_email, fechanac, edad, per_gen);
    }

    public Modelo_Camionero(int per_cod, String per_cd, String per_nombre1, String per_nombre2, String per_apellido1, String per_apellido2, String per_dir, String per_tel, String per_email, String fechanac, int edad, String per_gen) {
        super(per_cod, per_cd, per_nombre1, per_nombre2, per_apellido1, per_apellido2, per_dir, per_tel, per_email, fechanac, edad, per_gen);
    }

    

   

   

    

    public boolean crearPersona() {

        String sql = "insert into persona (per_CD, per_nombre1, per_nombre2, per_apellido1, per_apellido2, per_dir, per_tel, per_email, per_fechanac, per_edad, per_gen) values ('" + getPer_cd()+ "','" + getPer_nombre1() + "','" + getPer_nombre2()+ "','" + getPer_apellido1() + "','" + getPer_apellido2() + "','" + getPer_dir() + "','" + getPer_tel() + "','" + getPer_email() + "','" + getFechanac() + "'," + getEdad() + ",'" + getPer_gen()+ "')";
        return conoc.accion(sql);
    }

    public boolean crearCamionero() {

        Modelo_Persona mipersona = new Modelo_Persona(); //Creo un objeto de la clase Modelo_Persona 

        if (crearPersona()) { //Si la persona ya existe entonces puedo crear un camionero

            String sql = "insert into camionero (cam_percod, cam_sueldo, cam_tipolicencia, cam_aniosexperi, cam_est) values (" + mipersona.traerCodigoDePersonaCrear() + "," + getSueldo()+ ",'" + getTipolic()+ "'," + getAniosexperiencia() + ",'A')";
            return conoc.accion(sql);
        } else {
            return false;
        }
    }

    public boolean modificarPersonaYCamionero() { //Modificar la instancia en la BD
        Modelo_Persona mipersona = new Modelo_Persona(); //Creo un objeto de la clase Modelo_Persona 

        String sqlP = "UPDATE persona set per_nombre1 = '" + getPer_nombre1()+ "',per_nombre2 = '" + getPer_nombre2()+ "', per_apellidopat = '" + getPer_apellido1() + "', per_apellido2 = '" + getPer_apellido2() + "', per_direccion = '" + getPer_dir() + "', per_telefono = '" + getPer_tel() + "', per_email = '" + getPer_email() + "', per_fechanac = '" + getFechanac() + "', per_edad = " + getEdad() + ", per_genero = '" + getPer_gen() + "' where per_cd = '" + getPer_cd() + "'"; //Modifica los datos en la tabla persona

        String sqlC = "UPDATE camionero SET cam_sueldo= " + getSueldo()+ ",cam_tipolicencia = '" + getTipolic()+ "', cam_aniosexperi = " + getAniosexperiencia() + " WHERE cam_percodigo = '" + mipersona.traerCodigoDePersonaModificar(getPer_cd()) + "'"; //Modifica los datos de la tabla camionero
        return conoc.accion(sqlP) && conoc.accion(sqlC);
    }

    public boolean eliminarCamionero(String cedula) { //Modificar el estado del camionero
        Modelo_Persona mipersona = new Modelo_Persona(); //Creo un objeto de la clase Modelo_Persona 

        String sqlC = "UPDATE camionero SET cam_est = 'I' WHERE cam_percod = '" + mipersona.traerCodigoDePersonaModificar(cedula) + "'";
        return conoc.accion(sqlC);
    }

    public List<Camionero> listaCamionerosTabla() {
        try {
            //Me retorna un "List" de "persona"
            List<Camionero> lista = new ArrayList<>();

            String sql = "select cam_cod, per_CD, per_nombre1, per_nombre2, per_apellido1, per_apellido2, per_dir, per_tel, per_email, per_fechanac, per_edad, per_gen,cam_sueldo,cam_tipolicencia,cam_aniosexp from persona p, camionero c where p.per_cod = c.cam_percod and c.cam_est = 'A'";

            ResultSet rs = conoc.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                //Crear las instancias de las personas
                Camionero cam = new Camionero();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
                cam.setCam_cod(rs.getInt("cam_cod"));
                cam.setPer_cd(rs.getString("per_cd"));
                cam.setPer_nombre1(rs.getString("per_nombre1"));
                cam.setPer_nombre2(rs.getString("per_nombre2"));
                cam.setPer_apellido1(rs.getString("per_apellido1"));
                cam.setPer_apellido2(rs.getString("per_apellido2"));
                cam.setPer_dir(rs.getString("per_dir"));
                cam.setPer_tel(rs.getString("per_tel"));
                cam.setPer_email(rs.getString("per_email"));
                cam.setFechanac(rs.getString("per_fechanac"));
                cam.setEdad(rs.getInt("per_edad"));
                cam.setPer_gen(rs.getString("per_gen"));
                cam.setSueldo(rs.getDouble("cam_sueldo"));
                cam.setTipolic(rs.getString("cam_tipolicencia"));
                cam.setAniosexperiencia(rs.getInt("cam_aniosexp"));

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

            String sql = "select per_CD, per_nombre1, per_nombre2, per_apellido1, per_apellido2, per_dir, per_tel, per_email, per_fechanac, per_edad, per_gen,cam_tipolicencia,cam_aniosexp from persona p, camionero c where p.per_cod = c.cam_percod and c.cam_est = 'A' and per_cd Like '"+cedula+"%'";

            ResultSet rs = conoc.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                //Crear las instancias de las personas
                Camionero cam = new Camionero();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
                cam.setPer_cd(rs.getString("per_cd"));
                cam.setPer_nombre1(rs.getString("per_nombre1"));
                cam.setPer_nombre2(rs.getString("per_nombre2"));
                cam.setPer_apellido1(rs.getString("per_apellido1"));
                cam.setPer_apellido2(rs.getString("per_apellido2"));
                cam.setPer_dir(rs.getString("per_dir"));
                cam.setPer_tel(rs.getString("per_tel"));
                cam.setPer_email(rs.getString("per_email"));
                cam.setFechanac(rs.getString("per_fechanac"));
                cam.setEdad(rs.getInt("per_edad"));
                cam.setPer_gen(rs.getString("per_gen"));
                cam.setSueldo(rs.getDouble("cam_sueldo"));
                cam.setTipolic(rs.getString("cam_tipolicencia"));
                cam.setAniosexperiencia(rs.getInt("cam_aniosexp"));

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
