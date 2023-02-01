
package Modelo;


public class Provincia {
    private  int cod_prov;
    private String nombre;
    private String region;
    private int num_canton;

    public Provincia() {
    }

    public Provincia(int cod_prov, String nombre, String region, int num_canton) {
        this.cod_prov = cod_prov;
        this.nombre = nombre;
        this.region = region;
        this.num_canton = num_canton;
    }

    public int getCod_prov() {
        return cod_prov;
    }

    public void setCod_prov(int cod_prov) {
        this.cod_prov = cod_prov;
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

    public int getNum_canton() {
        return num_canton;
    }

    public void setNum_canton(int num_canton) {
        this.num_canton = num_canton;
    }
    
    
    
}
