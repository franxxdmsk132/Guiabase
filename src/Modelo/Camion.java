
package Modelo;


public class Camion {
    
    private int codigoCmi;
    private String placa;
    private String matricula;
    private String modelo;
    private String tipo;
    private double potencia;
    private char estado;

    public Camion() {
    }

    public Camion(int codigoCmi, String placa, String matricula, String modelo, String tipo, double potencia, char estado) {
        this.codigoCmi = codigoCmi;
        this.placa = placa;
        this.matricula = matricula;
        this.modelo = modelo;
        this.tipo = tipo;
        this.potencia = potencia;
        this.estado = estado;
    }

    public int getCodigoCmi() {
        return codigoCmi;
    }

    public void setCodigoCmi(int codigoCmi) {
        this.codigoCmi = codigoCmi;
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
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
