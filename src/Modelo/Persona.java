package Modelo;

public class Persona {

    private int codigoPer;
    private String dni;
    private String prinombre;
    private String segnombre;
    private String apellidopat;
    private String apellidomat;
    private String direccion;
    private String telefono;
    private String email;
    private String fechanac; //Si seteo la fecha de tipo Date no funciona
    private int edad;
    private String genero;

    public Persona() {
    }

    public Persona(int codigoPer, String dni, String prinombre, String segnombre, String apellidopat, String apellidomat, String direccion, String telefono, String email, String fechanac, int edad, String genero) {
        this.codigoPer = codigoPer;
        this.dni = dni;
        this.prinombre = prinombre;
        this.segnombre = segnombre;
        this.apellidopat = apellidopat;
        this.apellidomat = apellidomat;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.fechanac = fechanac;
        this.edad = edad;
        this.genero = genero;
    }

    public int getCodigoPer() {
        return codigoPer;
    }

    public void setCodigoPer(int codigoPer) {
        this.codigoPer = codigoPer;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPrinombre() {
        return prinombre;
    }

    public void setPrinombre(String prinombre) {
        this.prinombre = prinombre;
    }

    public String getSegnombre() {
        return segnombre;
    }

    public void setSegnombre(String segnombre) {
        this.segnombre = segnombre;
    }

    public String getApellidopat() {
        return apellidopat;
    }

    public void setApellidopat(String apellidopat) {
        this.apellidopat = apellidopat;
    }

    public String getApellidomat() {
        return apellidomat;
    }

    public void setApellidomat(String apellidomat) {
        this.apellidomat = apellidomat;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
