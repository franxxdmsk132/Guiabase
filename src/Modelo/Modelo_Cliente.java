package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Modelo_Cliente extends Cliente {

    ConectOC conoc = new ConectOC();

    public Modelo_Cliente() {
    }

    public Modelo_Cliente(int codigocli, String ruc, String profesion, String estado) {
        super(codigocli, ruc, profesion, estado);
    }

    public Modelo_Cliente(int codigocli, String ruc, String profesion, String estado, int codigo, String dni, String prinombre, String segnombre, String apellidopat, String apellidomat, String direccion, String telefono, String email, String fechanac, int edad, String genero) {
        super(codigocli, ruc, profesion, estado, codigo, dni, prinombre, segnombre, apellidopat, apellidomat, direccion, telefono, email, fechanac, edad, genero);
    }

    public boolean crearPersona() {

        String sql = "insert into persona (per_dni, per_prinombre, per_segnombre, per_apellidopat, per_apellidomat, per_direccion, per_telefono, per_email, per_fechanac, per_edad, per_genero) values ('" + getDni() + "','" + getPrinombre() + "','" + getSegnombre() + "','" + getApellidopat() + "','" + getApellidomat() + "','" + getDireccion() + "','" + getTelefono() + "','" + getEmail() + "','" + getFechanac() + "'," + getEdad() + ",'" + getGenero() + "')";
        return conoc.accion(sql);
    }

    public boolean crearCliente() {

        Modelo_Persona mipersona = new Modelo_Persona(); //Creo un objeto de la clase Modelo_Persona 

        if (crearPersona()) { //Si la persona ya existe entonces puedo crear un cliente

            String sql = "insert into cliente (cli_percodigo, cli_ruc, cli_profesion, cli_estado) values (" + mipersona.traerCodigoDePersonaCrear() + ",'" + getRuc() + "','" + getProfesion() + "','A')";
            return conoc.accion(sql);
        } else {
            return false;
        }
    }

    public boolean modificarPersonaYCliente() { //Modificar la instancia en la BD
        Modelo_Persona mipersona = new Modelo_Persona(); //Creo un objeto de la clase Modelo_Persona 

        String sqlP = "UPDATE persona set per_prinombre = '" + getPrinombre() + "',per_segnombre = '" + getSegnombre() + "', per_apellidopat = '" + getApellidopat() + "', per_apellidomat = '" + getApellidomat() + "', per_direccion = '" + getDireccion() + "', per_telefono = '" + getTelefono() + "', per_email = '" + getEmail() + "', per_fechanac = '" + getFechanac() + "', per_edad = " + getEdad() + ", per_genero = '" + getGenero() + "' where per_dni = '" + getDni() + "'"; //Modifica los datos en la tabla persona

        String sqlC = "UPDATE cliente SET cli_ruc = '" + getRuc() + "',cli_profesion = '" + getProfesion() + "' WHERE cli_percodigo = '" + mipersona.traerCodigoDePersonaModificar(getDni()) + "'"; //Modifica los datos de la tabla cliente
        return conoc.accion(sqlP) && conoc.accion(sqlC);
    }

    public boolean eliminarCliente(String cedula) { //Modificar el estado del cliente
        Modelo_Persona mipersona = new Modelo_Persona(); //Creo un objeto de la clase Modelo_Persona 

        String sqlC = "UPDATE cliente SET cli_estado = 'I' WHERE cli_percodigo = '" + mipersona.traerCodigoDePersonaModificar(cedula) + "'";
        return conoc.accion(sqlC);
    }

    public List<Cliente> listaClientesTabla() {
        try {
            //Me retorna un "List" de "persona"
            List<Cliente> lista = new ArrayList<>();

            String sql = "select cli_codigo, per_dni,per_prinombre,per_segnombre,per_apellidopat,per_apellidomat,per_direccion,per_telefono,per_email,per_fechanac,per_edad,per_genero,cli_ruc,cli_profesion from persona p, cliente c where p.per_codigo = c.cli_percodigo and c.cli_estado = 'A'";

            ResultSet rs = conoc.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                //Crear las instancias de las personas
                Cliente cli = new Cliente();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
                cli.setCodigocli(rs.getInt("cli_codigo"));
                cli.setDni(rs.getString("per_dni"));
                cli.setPrinombre(rs.getString("per_prinombre"));
                cli.setSegnombre(rs.getString("per_segnombre"));
                cli.setApellidopat(rs.getString("per_apellidopat"));
                cli.setApellidomat(rs.getString("per_apellidomat"));
                cli.setDireccion(rs.getString("per_direccion"));
                cli.setTelefono(rs.getString("per_telefono"));
                cli.setEmail(rs.getString("per_email"));
                cli.setFechanac(rs.getString("per_fechanac"));
                cli.setEdad(rs.getInt("per_edad"));
                cli.setGenero(rs.getString("per_genero"));
                cli.setRuc(rs.getString("cli_ruc"));
                cli.setProfesion(rs.getString("cli_profesion"));

                lista.add(cli); //Agrego los datos a la lista
            }

            //Cierro la conexion a la BD
            rs.close();
            //Retorno la lista
            return lista;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Cliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Cliente> listabuscarPersonasYClientes(String cedula) {
        try {
            //Me retorna un "List" de "persona"
            List<Cliente> lista = new ArrayList<>();

            String sql = "select per_dni,per_prinombre,per_segnombre,per_apellidopat,per_apellidomat,per_direccion,per_telefono,per_email,per_fechanac,per_edad,per_genero,cli_ruc,cli_profesion from persona p, cliente c where p.per_codigo = c.cli_percodigo and c.cli_estado = 'A' and per_dni Like '" + cedula + "%'";

            ResultSet rs = conoc.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                //Crear las instancias de las personas
                Cliente cli = new Cliente();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
                cli.setDni(rs.getString("per_dni"));
                cli.setPrinombre(rs.getString("per_prinombre"));
                cli.setSegnombre(rs.getString("per_segnombre"));
                cli.setApellidopat(rs.getString("per_apellidopat"));
                cli.setApellidomat(rs.getString("per_apellidomat"));
                cli.setDireccion(rs.getString("per_direccion"));
                cli.setTelefono(rs.getString("per_telefono"));
                cli.setEmail(rs.getString("per_email"));
                cli.setFechanac(rs.getString("per_fechanac"));
                cli.setEdad(rs.getInt("per_edad"));
                cli.setGenero(rs.getString("per_genero"));
                cli.setRuc(rs.getString("cli_ruc"));
                cli.setProfesion(rs.getString("cli_profesion"));

                lista.add(cli); //Agrego los datos a la lista
            }

            //Cierro la conexion a la BD
            rs.close();
            //Retorno la lista
            return lista;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Cliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
