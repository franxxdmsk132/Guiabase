
package Modelo;
import java.time.LocalDate;
import java.util.Date;


public class Paquete {
    private int cod_paquete;
    private int cod_cliente;
    private int cod_provinicia;
    private int cod_destino;
    private int cod_camionero;
    private LocalDate hora_llegada;
    private LocalDate salida;
    private double peso;
    private Date fecha_registro;

    public Paquete() {
    }

    public Paquete(int cod_paquete, int cod_cliente, int cod_provinicia, int cod_destino, int cod_camionero, LocalDate hora_llegada, LocalDate salida, double peso, Date fecha_registro) {
        this.cod_paquete = cod_paquete;
        this.cod_cliente = cod_cliente;
        this.cod_provinicia = cod_provinicia;
        this.cod_destino = cod_destino;
        this.cod_camionero = cod_camionero;
        this.hora_llegada = hora_llegada;
        this.salida = salida;
        this.peso = peso;
        this.fecha_registro = fecha_registro;
    }

    public int getCod_paquete() {
        return cod_paquete;
    }

    public void setCod_paquete(int cod_paquete) {
        this.cod_paquete = cod_paquete;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public int getCod_provinicia() {
        return cod_provinicia;
    }

    public void setCod_provinicia(int cod_provinicia) {
        this.cod_provinicia = cod_provinicia;
    }

    public int getCod_destino() {
        return cod_destino;
    }

    public void setCod_destino(int cod_destino) {
        this.cod_destino = cod_destino;
    }

    public int getCod_camionero() {
        return cod_camionero;
    }

    public void setCod_camionero(int cod_camionero) {
        this.cod_camionero = cod_camionero;
    }

    public LocalDate getHora_llegada() {
        return hora_llegada;
    }

    public void setHora_llegada(LocalDate hora_llegada) {
        this.hora_llegada = hora_llegada;
    }

    public LocalDate getSalida() {
        return salida;
    }

    public void setSalida(LocalDate salida) {
        this.salida = salida;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
    
    
}
