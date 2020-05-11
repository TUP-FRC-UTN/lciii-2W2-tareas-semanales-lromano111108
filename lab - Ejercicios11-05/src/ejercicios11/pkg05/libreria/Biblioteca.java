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
public class Biblioteca {

    Libro[] libros;

    public Biblioteca(int cantLibros) {
        this.libros = new Libro[cantLibros];
    }

    public void agregarLibros(Libro nuevoLibro) {
        for (int i = 0; i < libros.length; i++) {
            if (libros[i] == null) { //si el arrreglo libros en [i] es null o esta vacio
                libros[i] = nuevoLibro; //carga el libro
                break; //corta para no seguir recorriendo el ciclo for
            }
        }
    }

    public int cantidadLibros() {
        int contador = 0;
        for (int i = 0; i < libros.length; i++) {
            if (libros[i] != null) {
                contador++;
            }
        }
        return contador;
    }

    public String cantidadLibrosPorEstado() {
        int estado1 = 0;
        int estado2 = 0;
        int estado3 = 0;
        String mensaje = "";

        for (int i = 0; i < libros.length; i++) {
            if (libros[i] != null) {

                if (libros[i].getEstadoLibro() == 1) {
                    estado1++;
                } else if (libros[i].getEstadoLibro() == 2) {
                    estado2++;
                } else if (libros[i].getEstadoLibro() == 3) {
                    estado3++;
                }
            }

        }
        return mensaje = "\nCantidad Libros Disponibles: " + estado1
                + "\nCantidad libros Prestados: " + estado2
                + "\nCantidad libros Extraviados: " + estado3;
    }

    public String arreglosCantidadLibrosPorEstado() {
        int[] contadorEstado = new int[3];//declaramos un arreglo INT de tamaño 3
        for (int i = 0; i < libros.length; i++) { //recorre el arreglo LIBROS 
            if (libros[i] != null) { //si el espacio [I] del arreglo no esta vacio
                switch (libros[i].getEstadoLibro()) { //obtiene de el estado del libro
                    case 1:
                        contadorEstado[0]++; // en caso de que el estaado sea 1 - cuenta y guarda la cantidad de Estados que hay en la primera posicion
                        break;
                    case 2:
                        contadorEstado[1]++;//en caso de que el estaado sea 2 -cuenta y guarda la cantidad de Estados que hay en la segunda posicion
                        break;
                    case 3:
                        contadorEstado[2]++;//en caso de que el estaado sea 3 -cuenta y guarda la cantidad de Estados que hay en la tercera posicion
                        break;
                }
            }
        }
        return "\nCantidad Libros Disponibles: " + contadorEstado[0]
                + "\nCantidad libros Prestados: " + contadorEstado[1]
                + "\nCantidad libros Extraviados: " + contadorEstado[2];
    }

    public float promedioPrestamos() {
        int contador = 0;
        int acumulador = 0;
        float promedio = 0f;
        for (int i = 0; i < libros.length; i++) {
            if (libros[i] != null) {

                acumulador += libros[i].cantPrestamosLibro();
                contador++;
            }
        }
        return promedio = (float) acumulador / contador;
    }

    public float sumaPrecioExtraviado() {
        float suma = 0f;
        for (int i = 0; i < libros.length; i++) {
            if (libros[i] != null && libros[i].getEstadoLibro() == 3) {
                suma += libros[i].getPrecio();
            }
        }
        return suma;
    }

}
