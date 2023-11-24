/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arbol;

import javax.swing.JOptionPane;

/**
 *
 * @author miara
 */
public class Arbol {

    public static void main(String[] args) {
        int opcion = 0, elemento;
        String nombre;
        arbolito arbolBinario = new arbolito();
        do{ //Ciclo para mostrar el menu hasta que el usuario eliga salirse
            try{
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. Agregar nodo\n"
                        + "2. Recorrer InOrden\n"
                        + "3. Recorrer PreOrden\n"
                        + "4. Recorrer PostOrden\n"
                        + "5. Buscar Nodo en el árbol\n"
                        + "6. Eliminar Nodo en el árbol\n"
                        + "7. Salir\n"
                        + "Elige una opción:", "Árboles Binarios"
                ,JOptionPane.QUESTION_MESSAGE));
                switch(opcion){
                    case 1: //AGREGA un nodo
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null, 
                                "Ingresa el NUMERO del nodo", "Agregando nodo",
                                JOptionPane.QUESTION_MESSAGE));
                        nombre = JOptionPane.showInputDialog(null,
                                "Ingresa el NOMBRE del nodo","Agregando nodo",
                                JOptionPane.QUESTION_MESSAGE);
                        arbolBinario.agregarNodo(elemento, nombre);
                        break;
                    case 2: // Recorre en INORDEN
                        if (!arbolBinario.estaVacio()){
                            System.out.println();
                            arbolBinario.inOrden(arbolBinario.raiz);
                        }else{
                            JOptionPane.showMessageDialog(null, "El árbol está vacío",
                                "Alerta", JOptionPane.INFORMATION_MESSAGE); 
                        }
                        break;
                        
                    case 3: //recorre en PREORDEN
                        if (!arbolBinario.estaVacio()){
                            System.out.println();
                            arbolBinario.preOrden(arbolBinario.raiz);
                        }else{
                            JOptionPane.showMessageDialog(null, "El árbol está vacío",
                                "Alerta", JOptionPane.INFORMATION_MESSAGE); 
                        }
                    case 4:
                        // Recorre en POSTORDEN
                        if (!arbolBinario.estaVacio()){
                            System.out.println();
                            arbolBinario.postOrden(arbolBinario.raiz);
                        }else{
                            JOptionPane.showMessageDialog(null, "El árbol está vacío",
                                "Alerta", JOptionPane.INFORMATION_MESSAGE); 
                        }
                        break;
                    case 5:
                        //BUSCA un nodo en el arbol
                        if(!arbolBinario.estaVacio()){
                            elemento = Integer.parseInt(JOptionPane.showInputDialog(null, 
                                "Ingresa el NUMERO del nodo a buscar", "Buscando nodo",
                                JOptionPane.QUESTION_MESSAGE));
                            if(arbolBinario.buscarNodo(elemento) == null){
                                JOptionPane.showMessageDialog(null, "No existe ese nodo",
                                "Alerta", JOptionPane.INFORMATION_MESSAGE);
                            }else{
                                System.out.println("Se encontró el nodo:" + arbolBinario.buscarNodo(elemento));
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "El árbol está vacío",
                                "Alerta", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 6: //si no esta vacio ... hay algo q ELIMINAR 
                        if(!arbolBinario.estaVacio()){
                            elemento = Integer.parseInt(JOptionPane.showInputDialog(null, 
                                "Ingresa el NUMERO del nodo a eliminar", "Eliminando nodo",
                                JOptionPane.QUESTION_MESSAGE));
                            if(arbolBinario.eliminar(elemento) == false){
                                JOptionPane.showMessageDialog(null, "No existe ese nodo",
                                "Alerta", JOptionPane.INFORMATION_MESSAGE);
                            }else{
                                JOptionPane.showMessageDialog(null, "Nodo eliminado",
                                "Eliminado", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "El árbol está vacío",
                                "Alerta", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 7: 
                        JOptionPane.showMessageDialog(null, "Se ha cerrado la aplicación",
                                "Adiós", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no existente",
                                "Alerta", JOptionPane.INFORMATION_MESSAGE);
                }
            }catch(NumberFormatException n){ //Manda un error si el usuario no ingresa un numero
                JOptionPane.showMessageDialog(null, "Error " + n.getMessage());
            }
        }while(opcion != 7); 
    }
}
