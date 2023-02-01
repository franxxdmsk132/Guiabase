package Modelo;

public class Conduce {

    private int codigoCon;
    private String fechaSalida;
    private int codigoCam;
    private int codigoCmi;

    public Conduce() {
    }

    public Conduce(int codigoCon, String fechaSalida, int codigoCam, int codigoCmi) {
        this.codigoCon = codigoCon;
        this.fechaSalida = fechaSalida;
        this.codigoCam = codigoCam;
        this.codigoCmi = codigoCmi;
    }

    public int getCodigoCon() {
        return codigoCon;
    }

    public void setCodigoCon(int codigoCon) {
        this.codigoCon = codigoCon;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getCodigoCam() {
        return codigoCam;
    }

    public void setCodigoCam(int codigoCam) {
        this.codigoCam = codigoCam;
    }

    public int getCodigoCmi() {
        return codigoCmi;
    }

    public void setCodigoCmi(int codigoCmi) {
        this.codigoCmi = codigoCmi;
    }
}
