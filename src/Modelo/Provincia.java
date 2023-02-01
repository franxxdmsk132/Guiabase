
package Modelo;

public class Provincia {
    
    private int codigoPro;
    private String nombre;
    private String region;
    private int numcanton;

    public Provincia() {
    }

    public Provincia(int codigoPro, String nombre, String region, int numcanton) {
        this.codigoPro = codigoPro;
        this.nombre = nombre;
        this.region = region;
        this.numcanton = numcanton;
    }

    public int getCodigoPro() {
        return codigoPro;
    }

    public void setCodigoPro(int codigoPro) {
        this.codigoPro = codigoPro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getNumcanton() {
        return numcanton;
    }

    public void setNumcanton(int numcanton) {
        this.numcanton = numcanton;
    }
}
