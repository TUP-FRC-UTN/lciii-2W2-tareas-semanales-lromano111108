/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios11.pkg05.libreria;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Lucas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        int tamañoBiblioteca;

        System.out.println("ingrese la Cantidad de libros de la Biblioteca");
        tamañoBiblioteca = lector.nextInt();

        Biblioteca biblioteca = new Biblioteca(tamañoBiblioteca); //creamos la biblioteca ingresandole el tamaño a traves del lector

        if (tamañoBiblioteca != 0) {
            
            for (int i = 0; i < tamañoBiblioteca; i++) { //recorre la biblioteca a traves del tamaño que le ingresamos por el lector
                
                lector.nextLine();
               
                System.out.println("Ingrese Titulo del Libro N°: " +(i+1));
                String titulo = lector.nextLine();

                System.out.println("Ingrese Precio del Libro");
                int precio = lector.nextInt();

                System.out.println("Seleccione el Estado");
                System.out.println("1- Disponible" + "\n2-Prestado" + "\n3-Extraviado");
                int estado = lector.nextInt();

                System.out.println("Ingrese la Cantidad de veces que fue prestado el libro");
                int prestamos = lector.nextInt();
                Libro nuevo = new Libro(titulo, precio, estado, prestamos);

                if (prestamos != 0) {
                    for (int j = 0; j < prestamos; j++) {
                        System.out.println("Ingrese el nombre de del solicitante nro " + (1+j) );
                        String solicitante = lector.next();

                        System.out.println("Ingrese la Cantidad de dias");
                        int cantidadDias = lector.nextInt();
                        lector.nextLine();

                        System.out.println("Fue devuelto el libro?: \n0- NO \n1- SI ");
                        
                        int dev = lector.nextInt(); //INGRESAMOS UN STRING 0 (CERO) o 1(UNO)
                  
                        
                        Prestamo nuevoPrestamo = new Prestamo(solicitante, cantidadDias, nuevo.libroDevuelto(dev)); //CREA EL PRESTAMO

                        nuevo.agregarPrestamos(nuevoPrestamo); //AGREGA UN NUEVO PRESTAMO EN EL LIBRO NUEVO
                    }

                }

                biblioteca.agregarLibros(nuevo);

            }

        } else {
            System.out.println("La Biblioteca esta vacia ");
        }
        
        //PARA OBTENER LOS RESULTADOS DE LA CARGA
        for (Libro libro : biblioteca.libros) {
            System.out.println("DATOS CARGADOS: "+ "\nTitulo : " + libro.getTitulo() + "\nPrecio: $" + libro.getPrecio() + "\nPrestamos: " + Arrays.toString(libro.prestamos) +"\n" );
            }
        
        System.out.println("\nCantidad de Libros por Estado: " + biblioteca.cantidadLibrosPorEstado());
        
        System.out.println("\nCantidad de Libros por Estado: " + biblioteca.arreglosCantidadLibrosPorEstado());
        
        System.out.println("\nEl Precio Total de Reposicion de todos los libros extraviados es de: $" + biblioteca.sumaPrecioExtraviado());
        
        int contador = 0;//PARA OBTENER LA POSICION Y MOSTRARLA
        for (Libro libro : biblioteca.libros) { 
            System.out.println("\nEl nombre de todos los solicitantes del Libro "+(contador+1)+"  2" + libro.listadoSolicitantes());
            contador++;
            }   
        
        System.out.println("\nPromedio de Veces que prestaron los libros de la biblioteca: "+biblioteca.promedioPrestamos());
    }

}
