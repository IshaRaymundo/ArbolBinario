/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arbol;

/**
 *
 * @author miara
 */
public class NodoArbol {
    // variables para alacenar el dato y nombre de cada nodo
    int dato;
    String nombre;
    NodoArbol hijoIzquierdo, hijoDerecho;
    
    // Constructor, inicializo las variables con los datos que se proporcionaron
    public NodoArbol (int d, String nom){
        this.dato=d;
        this.nombre=nom;
        this.hijoIzquierdo=null;
        this.hijoDerecho=null;
    }
    // metodo para conocer la información del nodo
    public String toString(){
        return nombre + " con número " + dato;
    }
}
