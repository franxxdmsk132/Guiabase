/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 
 */
public class Camionero extends Persona{
    
    private int cam_cod;
    private double sueldo;
    private String tipolic;
    private int aniosexperiencia;
    private String estado;

    public Camionero() {
    }

    public Camionero(int cam_cod, double sueldo, String tipolic, int aniosexperiencia, String estado) {
        this.cam_cod = cam_cod;
        this.sueldo = sueldo;
        this.tipolic = tipolic;
        this.aniosexperiencia = aniosexperiencia;
        this.estado = estado;
    }

    public Camionero(int cam_cod, double sueldo, String tipolic, int aniosexperiencia, String estado, int per_cod, String per_cd, String per_nombre1, String per_nombre2, String per_apellido1, String per_apellido2, String per_dir, String per_tel, String per_email, String per_gen) {
        super(per_cod, per_cd, per_nombre1, per_nombre2, per_apellido1, per_apellido2, per_dir, per_tel, per_email, per_gen);
        this.cam_cod = cam_cod;
        this.sueldo = sueldo;
        this.tipolic = tipolic;
        this.aniosexperiencia = aniosexperiencia;
        this.estado = estado;
    }

    public int getCam_cod() {
        return cam_cod;
    }

    public void setCam_cod(int cam_cod) {
        this.cam_cod = cam_cod;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getTipolic() {
        return tipolic;
    }

    public void setTipolic(String tipolic) {
        this.tipolic = tipolic;
    }

    public int getAniosexperiencia() {
        return aniosexperiencia;
    }

    public void setAniosexperiencia(int aniosexperiencia) {
        this.aniosexperiencia = aniosexperiencia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


}
