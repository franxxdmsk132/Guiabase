
package Modelo;


public class Camion {

    private int codigo_camion;
    private String placa;
    private String matricula;
    private String modelo;
    private String Tipo;
    private double potencia;
    private char estado;

    public Camion() {
    }

    public Camion(int codigo_camion, String placa, String matricula, String modelo, String Tipo, double potencia, char estado) {
        this.codigo_camion = codigo_camion;
        this.placa = placa;
        this.matricula = matricula;
        this.modelo = modelo;
        this.Tipo = Tipo;
        this.potencia = potencia;
        this.estado = estado;
    }

    public int getCodigo_camion() {
        return codigo_camion;
    }

    public void setCodigo_camion(int codigo_camion) {
        this.codigo_camion = codigo_camion;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

}
