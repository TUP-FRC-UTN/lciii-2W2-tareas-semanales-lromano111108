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
public class Libro {

    private String titulo;
    private int precio;
    private int estadoLibro;
    Prestamo[] prestamos;

    public String getTitulo() {
        return titulo;
    }

    public int getPrecio() {
        return precio;
    }

    public int getEstadoLibro() {
        return estadoLibro;
    }

    public Libro(String titulo, int precio, int estadoLibro, int cantPrestamos) {
        this.titulo = titulo;
        this.precio = precio;
        this.estadoLibro = estadoLibro;
        this.prestamos = new Prestamo[cantPrestamos];
    }

    //METODO QUE AGREGA PRESTAMOS A UN LIBRO
    public void agregarPrestamos(Prestamo nuevoPrestamo) {
        for (int i = 0; i < prestamos.length; i++) {
            if (prestamos[i] == null) { //si el espacio [i] esta vacio
                prestamos[i] = nuevoPrestamo; //carga el prestamo
                break; //corte para que no siga corriendo el FOR una vez cargado el prestamo
            }
        }
    }

    //METODO QUE CUENTA LA CANTIDAD DE PRESTAMOS DE UN LIBRO
    public int cantPrestamosLibro() {
        int contador = 0; //inicializamos el contador
        for (int i = 0; i < prestamos.length; i++) {
            if (prestamos[i] != null) { //si el espacio [i] NO esta vacio, lo cuenta
                contador++;// aumenta el contador
            }
        }
        return contador;
    }

    //METODO QUE RETORNA LOS SOLICITANTES DEL LIBRO
    public String listadoSolicitantes() {
        String lista = "";
        for (int i = 0; i < prestamos.length; i++) {
            if (prestamos[i] != null) { //si el arreglo no esta vacio
                lista += " - "+  prestamos[i].getSolicitante() + "\n";//obtiene y acumula el solicitante del arreglo (.getSolicitante)      
            }
        }
        return lista;
    }

    
    public boolean libroDevuelto(int valor) {
        boolean devuelto = false;
        if (valor == 1) {
            devuelto = true;

        } else if (valor == 2) {
            devuelto = false;
        }
        return devuelto;
    }
}
