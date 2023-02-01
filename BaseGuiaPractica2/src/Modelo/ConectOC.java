package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConectOC {

    //Comando para crear un nuevo usuario en la bd de oracle
    /*alter session set "_ORACLE_SCRIPT"=TRUE;
    Create user administrador identified by "1234";
    Grant create session to administrador;
    Grant all privileges to administrador; */
    Connection con;

    private final String URL = "jdbc:oracle:thin:@//localhost:1521/XE";
    private final String USER = "GUIA";
    private final String PASWORD = "1235";

    public ConectOC() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            
            //System.out.println("Conexion exitosa");
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error:" + ex.getMessage());
        }

        try {
            con = DriverManager.getConnection(URL, USER, PASWORD);
        } catch (SQLException ex) {
            Logger.getLogger(ConectOC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet consulta(String sql) {

        try {
            Statement st = con.createStatement(); //recive como parametro la consulta
            return st.executeQuery(sql);//Ejecuto la consulta y me devuelve un 'Resultset'

        } catch (SQLException ex) {
            Logger.getLogger(ConectOC.class.getName()).log(Level.SEVERE, null, ex);
            return null; //Si se da la excepcion me retorna un null
        }
    }

    /*Metodo generico cuando no devuelve datos. FORMA 1*/
    public boolean accion(String sql) {
        boolean correcto;
        try {
            Statement st = con.createStatement();
            st.execute(sql);
            st.close();
            correcto = true;
        } catch (SQLException ex) {
            Logger.getLogger(ConectOC.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            correcto = false;
        }

        return correcto;
    }

    public Connection getCon() {
        return con;
    }
}
