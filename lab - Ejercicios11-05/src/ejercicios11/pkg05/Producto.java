/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios11.pkg05;

/**
 * Desarrolle la clase Producto de manera que contenga en su interior los
atributos descripción (String) y Materiales (Material[]).

 Desarrolle en la clase Producto un constructor que reciba por parámetro una
cantidad de elementos y dimensione el vector de materiales.

 Desarrolle en la clase Producto un método que permita agregar un Material
recibido por parámetro al vector.

 Desarrolle en la clase Producto un método que retorne el costo total. Dicho
valor se calcula sumando todos los valores unitarios de los Materiales que
componen el Producto.

 Desarrolle en la clase Producto un método que reciba por parámetro un código
de material y retorne true si dicho material forma parte del Producto.

 Desarrolle en la clase producto un método que retorne un vector con todos los
materiales que tengan un valor unitario menor a un parámetro.

 Desarrolle en la clase producto un método que retorne un vector donde cada casillero contenga la cantida de materiales por precio, 
siguiendo las siguiente regla:

Si 0 < precio ≤ 10 contarlo en el primer casillero. 
Si 10 < precio ≤ 20 contarlo en el segundo casillero. 
Si 20 < precio ≤ 30 contarlo en el tercer casillero. 
Si precio > 30 contarlo en el cuarto casillero.

 * @author Lucas
 */
public class Producto {

    private String descripcion;
    private Material[] materiales;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Producto(String descripcion, int cantElementos) {
        this.descripcion = descripcion;
        this.materiales = new Material[cantElementos];
    }

    public void agregarMaterial(Material nuevoMaterial) {
        for (int i = 0; i < materiales.length; i++) {
            if (materiales[i] == null) {
                materiales[i] = nuevoMaterial;
                break;
            }
        }
    }

    public float calcularCostoTotal() {
        float acumuladorCosto = 0f;

        for (int i = 0; i < materiales.length; i++) {
            if (materiales[i] != null) {
                acumuladorCosto =acumuladorCosto+ materiales[i].getValorUnitario();
            }
        }
        return acumuladorCosto;
    }
    
    
    public boolean formaParteProducto (int codigo){
        boolean bandera = false;
        for (int i = 0; i < materiales.length; i++) {
            if (materiales[i]!= null && materiales[i].getCodigo()==codigo) {
                bandera= true;
            }            
        }
        return bandera;
    }
    
           
    public String listaMaterialesMenorParametro(float valor){
        String lista="";
        for (int i = 0; i < materiales.length; i++) {
            if (materiales[i] != null && materiales[i].getValorUnitario()<valor) {
                lista += (i+1) + "- "+ materiales[i].toString() + "\n";                  
            }                       
        }
        return  lista;
    }
    
    public String materialToString(){
        String lista="";
        for (int i = 0; i < materiales.length; i++) {
            if (materiales[i] != null) {
                lista += (i+1) + "- "+ materiales[i].toString() + "\n";                  
            }                       
        }
        return  
                lista;
    }

    public String materialPorPrecio(){
        int precio010=0;
        int precio1020=0;
        int precio2030=0;
        int precioMas30=0;
        String mensaje= "";
        
        for (int i = 0; i < materiales.length; i++) {
            if (materiales[i] != null && materiales[i].getValorUnitario()>0) {
                if (materiales[i].getValorUnitario()<=10) {
                    precio010++;                   
                }
                else if (materiales[i].getValorUnitario()<=20) {
                    precio1020++;                    
                }
                else if (materiales[i].getValorUnitario()<=30) {
                    precio2030++;                    
                }
                else if (materiales[i].getValorUnitario()<30) {
                    precioMas30++;                    
                }                
            }            
        }
              return mensaje= " cantidad entre 0 y 10: "+ precio010 + 
                            " cantidad entre 10 y 20: "+ precio1020 +
                            " cantidad entre 20 y 30: "+ precio2030 +
                            " cantidad mayor a 30: "+ precioMas30 ;  
    }
    
    
    
}
