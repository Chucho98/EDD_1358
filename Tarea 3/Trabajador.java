package Trabajador;

 public class Trabajador {
    private String cuenta;
    private String nombre;
    private String aPaterno;
    private String aMaterno;
    private double horas ;
    private double extra;
    private double sueldo;
    private int año;
    
    public Trabajador(String cuenta,String nombre,String aPaterno,String aMaterno,double horas,double sueldo,int año){
        this.cuenta = cuenta;
        this.nombre = nombre;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.horas = horas;
        this.extra = 276.5;
        this.sueldo = sueldo;
        this.año = año;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getaPaterno() {
        return aPaterno;
    }

    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public String getaMaterno() {
        return aMaterno;
    }

    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    public double getHoras() {
        return horas;
    }

    public void setHoras(double horas) {
        this.horas = horas;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    @Override
    public String toString() {
        return "Trabajador{" + "cuenta=" + cuenta + ", nombre=" + nombre + ", aPaterno=" + aPaterno + ", aMaterno=" + aMaterno + ", horas=" + horas + ", sueldo=" + sueldo + ", a\u00f1o=" + año + '}';
    }
    
    public double calcularSueldo(){
        int antiguedad = 2022 - this.año;
        double total = this.sueldo + (this.sueldo*(antiguedad*0.03))+(this.horas*this.extra);
        return total;
    }
}
