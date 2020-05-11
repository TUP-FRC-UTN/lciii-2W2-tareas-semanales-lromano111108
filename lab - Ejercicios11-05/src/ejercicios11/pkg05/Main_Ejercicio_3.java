/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios11.pkg05;

import java.util.Scanner;

/**
  Desarrolle un programa principal que permita ingresar los datos de un
producto, cree un objeto de esa clase y luego posibilite mediante un menú
llamar a los métodos de los puntos 4 a 8 todas las veces y en el orden que el
usuario quiera.

 * @author Lucas
 */
public class Main_Ejercicio_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner lector = new Scanner(System.in);
        String descripcionProducto;
        int cantElementos;
        
        System.out.println("Ingrese la descripcion del Producto: ");
        descripcionProducto = lector.next();
        
        System.out.println("Ingrese la cantidad de Materiales");
        cantElementos=lector.nextInt();
        
        Producto p = new Producto(descripcionProducto, cantElementos);
        
        for (int i = 0; i < cantElementos; i++) {
            
            System.out.println("Ingrese el Material");
            String descripcion = lector.next();
            
            System.out.println("Ingrese el Codigo de Material");
            int codigo= lector.nextInt();
            lector.nextLine();
            
            System.out.println("Ingrese el Valor Unitario del Material");
            float valorUnitario=lector.nextFloat();
            
            Material nuevo= new Material(descripcion, codigo, valorUnitario);
            
            p.agregarMaterial(nuevo);  
            
            System.out.println("material: " + nuevo.toString());
            
        }
        
       
                      
        System.out.println("Nombre Producto: \n" + descripcionProducto + " \nCantidad Materiales: " + cantElementos);
        System.out.println("Costo total del Producto " + p.calcularCostoTotal());

        int opcion = 0;
        while (opcion != 5) {
            System.out.println("\n***MENU***");
            System.out.println("1-Calcular costo total del producto");
            System.out.println("2-Ingresar codigo de material para ver si es parte de producto");
            System.out.println("3-Ingrese un precio para ver los productos menores a este ");
            System.out.println("4-Ver cantidad de materiales por precio ");
            System.out.println("5-Salir");
            System.out.println("\n\nIngrese una opcion: ");
            
            
            opcion = lector.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("\nopcion 1");
                    System.out.println("Costo Total" +p.calcularCostoTotal());
                    break;
                case 2:
                    System.out.println("\nopcion 2");
                    System.out.println("\nIngrese Codigo: ");
                    int codigo=lector.nextInt();
                    System.out.println(p.formaParteProducto(codigo));
                    break;
                case 3:
                    System.out.println("\nopcion 3");
                    System.out.println("\nIngrese precio: ");
                    double precio = lector.nextInt();
                    System.out.println("" + p.listaMaterialesMenorParametro((float)precio));
                    break;
                case 4:
                    System.out.println("\nopcion 4");
                    System.out.println(p.materialPorPrecio());
                    break;
                case 5:
                    System.out.println("\nLUCAS LA CONCHA DE TU MADREEEEEEEE");
                    break;
                default:
                    System.out.println("\n*****ATENCION!! ha ingresado una opcion incorrecta!!*****");
            }

        }
        
                     
    }
    
    
    
}
