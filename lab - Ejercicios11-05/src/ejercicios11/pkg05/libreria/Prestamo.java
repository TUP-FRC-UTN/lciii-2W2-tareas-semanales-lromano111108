/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios11.pkg05.libreria;

/**
 *
 * @author Lucas
 */
public class Prestamo {

    private String solicitante;
    private int cantidadDias;
    private boolean devuelto;

    public Prestamo(String solicitante, int cantidadDias, boolean devuelto) {
        this.solicitante = solicitante;
        this.cantidadDias = cantidadDias;
        this.devuelto = devuelto;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public int getCantidadDias() {
        return cantidadDias;
    }

    public void setCantidadDias(int cantidadDias) {
        this.cantidadDias = cantidadDias;
    }

    public boolean isDevuelto() {
        return devuelto;
    }

    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }

    private String devolucion() { //METODO PARA TRANSFORMAR EN SI O NO EL BOOLEAN
        String d = "";
        if (devuelto == true) {
            d = "SI";
        } else {
            d = "NO";
        }
        return d;
    }
    
    /*public boolean libroDevuelto(String parametro){//METODO PARA CONVERTIR EL TRUE/FALSE

        if (parametro == "Si") {
                    boolean devuelto = true;

                } else if (parametro == "No") {
                    boolean devuelto = false;
                }
         return devuelto;
    }*/

    @Override
    public String toString() {
        return "Persona solicitante del prestamo: " + solicitante
                + "\n Cantidad de Dias: " + cantidadDias
                + "\n Libro Devuelto: " + devolucion();
    }

}
