
package Modelo;


public class Destinatario extends Persona {
    private int cod_destinatario;
    private String cod_postal;
    private String descripcion;
    private String calle_primaria;
    private String call_secundaria;

    public Destinatario(int cod_destinatario, String cod_postal, String descripcion, String calle_primaria, String call_secundaria) {
        this.cod_destinatario = cod_destinatario;
        this.cod_postal = cod_postal;
        this.descripcion = descripcion;
        this.calle_primaria = calle_primaria;
        this.call_secundaria = call_secundaria;
    }
    
    //0402841688 aqui sale error

    public Destinatario(int cod_destinatario, String cod_postal, String descripcion, String calle_primaria, String call_secundaria, int per_cod, String per_cd, String per_nombre1, String per_nombre2, String per_apellido1, String per_apellido2, String per_dir, String per_tel, String per_email, String per_gen) {
        super(per_cod, per_cd, per_nombre1, per_nombre2, per_apellido1, per_apellido2, per_dir, per_tel, per_email, per_gen);
        this.cod_destinatario = cod_destinatario;
        this.cod_postal = cod_postal;
        this.descripcion = descripcion;
        this.calle_primaria = calle_primaria;
        this.call_secundaria = call_secundaria;
    }

    public int getCod_destinatario() {
        return cod_destinatario;
    }

    public void setCod_destinatario(int cod_destinatario) {
        this.cod_destinatario = cod_destinatario;
    }

    public String getCod_postal() {
        return cod_postal;
    }

    public void setCod_postal(String cod_postal) {
        this.cod_postal = cod_postal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCalle_primaria() {
        return calle_primaria;
    }

    public void setCalle_primaria(String calle_primaria) {
        this.calle_primaria = calle_primaria;
    }

    public String getCall_secundaria() {
        return call_secundaria;
    }

    public void setCall_secundaria(String call_secundaria) {
        this.call_secundaria = call_secundaria;
    }
    
}
