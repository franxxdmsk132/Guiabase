
package Modelo;

public class Conduce {
    private int cod_conductor;
    private String fecha_Salida;
    private String Fecha_llegada;
    private int cod_camion;
    private int cod_camionero;

    public Conduce() {
    }

    public Conduce(int cod_conductor, String fecha_Salida, String Fecha_llegada, int cod_camion, int cod_camionero) {
        this.cod_conductor = cod_conductor;
        this.fecha_Salida = fecha_Salida;
        this.Fecha_llegada = Fecha_llegada;
        this.cod_camion = cod_camion;
        this.cod_camionero = cod_camionero;
    }

    public int getCod_conductor() {
        return cod_conductor;
    }

    public void setCod_conductor(int cod_conductor) {
        this.cod_conductor = cod_conductor;
    }

    public String getFecha_Salida() {
        return fecha_Salida;
    }

    public void setFecha_Salida(String fecha_Salida) {
        this.fecha_Salida = fecha_Salida;
    }

    public String getFecha_llegada() {
        return Fecha_llegada;
    }

    public void setFecha_llegada(String Fecha_llegada) {
        this.Fecha_llegada = Fecha_llegada;
    }

    public int getCod_camion() {
        return cod_camion;
    }

    public void setCod_camion(int cod_camion) {
        this.cod_camion = cod_camion;
    }

    public int getCod_camionero() {
        return cod_camionero;
    }

    public void setCod_camionero(int cod_camionero) {
        this.cod_camionero = cod_camionero;
    }
    
    
}
