
package Modelo;


public class Cliente  extends Persona{
    private int cod_cliente;
    private String ruc;
    private String profesion;
    private String estado;

    public Cliente() {
    }

    public Cliente(int cod_cliente, String ruc, String profesion, String estado) {
        this.cod_cliente = cod_cliente;
        this.ruc = ruc;
        this.profesion = profesion;
        this.estado = estado;
    }

    public Cliente(int cod_cliente, String ruc, String profesion, String estado, int per_cod, String per_cd, String per_nombre1, String per_nombre2, String per_apellido1, String per_apellido2, String per_dir, String per_tel, String per_email, String per_gen) {
        super(per_cod, per_cd, per_nombre1, per_nombre2, per_apellido1, per_apellido2, per_dir, per_tel, per_email, per_gen);
        this.cod_cliente = cod_cliente;
        this.ruc = ruc;
        this.profesion = profesion;
        this.estado = estado;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
    
