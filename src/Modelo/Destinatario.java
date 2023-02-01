package Modelo;

public class Destinatario extends Persona{

    private int codigodes;
    private String codpostal;
    private String infocomplement;
    private String calleprinc;
    private String callesecun;

    public Destinatario() {
    }

    public Destinatario(int codigodes, String codpostal, String infocomplement, String calleprinc, String callesecun) {
        this.codigodes = codigodes;
        this.codpostal = codpostal;
        this.infocomplement = infocomplement;
        this.calleprinc = calleprinc;
        this.callesecun = callesecun;
    }

    public Destinatario(int codigodes, String codpostal, String infocomplement, String calleprinc, String callesecun, int codigo, String dni, String prinombre, String segnombre, String apellidopat, String apellidomat, String direccion, String telefono, String email, String fechanac, int edad, String genero) {
        super(codigo, dni, prinombre, segnombre, apellidopat, apellidomat, direccion, telefono, email, fechanac, edad, genero);
        this.codigodes = codigodes;
        this.codpostal = codpostal;
        this.infocomplement = infocomplement;
        this.calleprinc = calleprinc;
        this.callesecun = callesecun;
    }

    public int getCodigodes() {
        return codigodes;
    }

    public void setCodigodes(int codigodes) {
        this.codigodes = codigodes;
    }

    public String getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(String codpostal) {
        this.codpostal = codpostal;
    }

    public String getInfocomplement() {
        return infocomplement;
    }

    public void setInfocomplement(String infocomplement) {
        this.infocomplement = infocomplement;
    }

    public String getCalleprinc() {
        return calleprinc;
    }

    public void setCalleprinc(String calleprinc) {
        this.calleprinc = calleprinc;
    }

    public String getCallesecun() {
        return callesecun;
    }

    public void setCallesecun(String callesecun) {
        this.callesecun = callesecun;
    }
}
