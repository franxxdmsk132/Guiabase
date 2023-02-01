/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author frank
 */
public class Persona {
     private int per_cod;
    private String per_cd;
    private String per_nombre1;
    private String per_nombre2;
    private String per_apellido1;
    private String per_apellido2;
    private String per_dir;
    private String per_tel;
    private String per_email;
    private String fechanac; 
    private int edad;
    private String per_gen;

    public Persona() {
    }

    public Persona(int per_cod, String per_cd, String per_nombre1, String per_nombre2, String per_apellido1, String per_apellido2, String per_dir, String per_tel, String per_email, String fechanac, int edad, String per_gen) {
        this.per_cod = per_cod;
        this.per_cd = per_cd;
        this.per_nombre1 = per_nombre1;
        this.per_nombre2 = per_nombre2;
        this.per_apellido1 = per_apellido1;
        this.per_apellido2 = per_apellido2;
        this.per_dir = per_dir;
        this.per_tel = per_tel;
        this.per_email = per_email;
        this.fechanac = fechanac;
        this.edad = edad;
        this.per_gen = per_gen;
    }

    public String getFechanac() {
        return fechanac;
    }

    public void setFechanac(String fechanac) {
        this.fechanac = fechanac;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    

    public int getPer_cod() {
        return per_cod;
    }

    public void setPer_cod(int per_cod) {
        this.per_cod = per_cod;
    }

    public String getPer_cd() {
        return per_cd;
    }

    public void setPer_cd(String per_cd) {
        this.per_cd = per_cd;
    }

    public String getPer_nombre1() {
        return per_nombre1;
    }

    public void setPer_nombre1(String per_nombre1) {
        this.per_nombre1 = per_nombre1;
    }

    public String getPer_nombre2() {
        return per_nombre2;
    }

    public void setPer_nombre2(String per_nombre2) {
        this.per_nombre2 = per_nombre2;
    }

    public String getPer_apellido1() {
        return per_apellido1;
    }

    public void setPer_apellido1(String per_apellido1) {
        this.per_apellido1 = per_apellido1;
    }

    public String getPer_apellido2() {
        return per_apellido2;
    }

    public void setPer_apellido2(String per_apellido2) {
        this.per_apellido2 = per_apellido2;
    }

    public String getPer_dir() {
        return per_dir;
    }

    public void setPer_dir(String per_dir) {
        this.per_dir = per_dir;
    }

    public String getPer_tel() {
        return per_tel;
    }

    public void setPer_tel(String per_tel) {
        this.per_tel = per_tel;
    }

    public String getPer_email() {
        return per_email;
    }

    public void setPer_email(String per_email) {
        this.per_email = per_email;
    }

    public String getPer_gen() {
        return per_gen;
    }

    public void setPer_gen(String per_gen) {
        this.per_gen = per_gen;
    }
}
