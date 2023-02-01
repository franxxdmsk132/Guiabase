
package Modelo;


public class Cliente extends Persona{
    
    private int codigocli;
    private String ruc;
    private String profesion;
    private String estado;

    public Cliente() {
    }

    public Cliente(int codigocli, String ruc, String profesion, String estado) {
        this.codigocli = codigocli;
        this.ruc = ruc;
        this.profesion = profesion;
        this.estado = estado;
    }

    public Cliente(int codigocli, String ruc, String profesion, String estado, int codigo, String dni, String prinombre, String segnombre, String apellidopat, String apellidomat, String direccion, String telefono, String email, String fechanac, int edad, String genero) {
        super(codigo, dni, prinombre, segnombre, apellidopat, apellidomat, direccion, telefono, email, fechanac, edad, genero);
        this.codigocli = codigocli;
        this.ruc = ruc;
        this.profesion = profesion;
        this.estado = estado;
    }

    public int getCodigocli() {
        return codigocli;
    }

    public void setCodigocli(int codigocli) {
        this.codigocli = codigocli;
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
