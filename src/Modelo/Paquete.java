package Modelo;


public class Paquete {

    private int codigoPaq;
    private int codcliente;
    private int codprovincia;
    private int coddestina;
    private int codcamionero;
    private String salidaprogra;
    private String llegadaprogra;
    private double peso;
    private String fecharegistro;

    public Paquete() {
    }

    public Paquete(int codigoPaq, int codcliente, int codprovincia, int coddestina, int codcamionero, String salidaproga, String llegadaprogra, double peso, String fecharegistro) {
        this.codigoPaq = codigoPaq;
        this.codcliente = codcliente;
        this.codprovincia = codprovincia;
        this.coddestina = coddestina;
        this.codcamionero = codcamionero;
        this.salidaprogra = salidaproga;
        this.llegadaprogra = llegadaprogra;
        this.peso = peso;
        this.fecharegistro = fecharegistro;
    }

    public int getCodigoPaq() {
        return codigoPaq;
    }

    public void setCodigoPaq(int codigoPaq) {
        this.codigoPaq = codigoPaq;
    }

    public int getCodcliente() {
        return codcliente;
    }

    public void setCodcliente(int codcliente) {
        this.codcliente = codcliente;
    }

    public int getCodprovincia() {
        return codprovincia;
    }

    public void setCodprovincia(int codprovincia) {
        this.codprovincia = codprovincia;
    }

    public int getCoddestina() {
        return coddestina;
    }

    public void setCoddestina(int coddestina) {
        this.coddestina = coddestina;
    }

    public int getCodcamionero() {
        return codcamionero;
    }

    public void setCodcamionero(int codcamionero) {
        this.codcamionero = codcamionero;
    }

    public String getSalidaprogra() {
        return salidaprogra;
    }

    public void setSalidaprogra(String salidaprogra) {
        this.salidaprogra = salidaprogra;
    }

    public String getLlegadaprogra() {
        return llegadaprogra;
    }

    public void setLlegadaprogra(String llegadaprogra) {
        this.llegadaprogra = llegadaprogra;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(String fecharegistro) {
        this.fecharegistro = fecharegistro;
    }
}
