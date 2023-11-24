/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arbol;

/**
 *
 * @author miara
 */
public class arbolito {
    NodoArbol raiz;
    // constructor para inicializar raiz en null, 
    public arbolito (){
        raiz= null;
    }
    //Metodo para inserción (evalua y donde es null se inserta)
    public void agregarNodo(int d, String nom){
        NodoArbol nuevo = new NodoArbol(d, nom);
        if (raiz == null){
            raiz=nuevo;
        }else{
            NodoArbol auxiliar = raiz;
            NodoArbol padre;
            while(true){
                padre = auxiliar;
                if(d < auxiliar.dato){
                    auxiliar = auxiliar.hijoIzquierdo;
                    if(auxiliar == null){
                        padre.hijoIzquierdo = nuevo;
                        return; //p finalizar se sale del metodo
                    }
                }else{
                    auxiliar = auxiliar.hijoDerecho;
                    if (auxiliar == null){
                        padre.hijoDerecho = nuevo;
                        return;
                    }
                }
            }
        }
    }
    
    //Metodo para saber si el arbol esta vacio
    public boolean estaVacio(){
        return raiz == null;
    }
    //Metodo para reccorer INORDEN
    public void inOrden(NodoArbol r){
        if (r != null){
            inOrden(r.hijoIzquierdo);
            System.out.print(r.dato + ", "); // raiz en medio
            inOrden(r.hijoDerecho);
        }
    }
    //METODO para recorrido en PREORDEN
    public void preOrden(NodoArbol r){
        if (r != null){
            System.out.print(r.dato + ", "); //primero raiz
            preOrden(r.hijoIzquierdo);
            preOrden(r.hijoDerecho);
        }
    }
    
    //METODO para recorrer el arbol en POST ORDEN
    public void postOrden(NodoArbol r){
        if (r != null){
            postOrden(r.hijoIzquierdo);
            postOrden(r.hijoDerecho);
            System.out.print(r.dato + ", "); //ultimo raiz
        }
    }
    //Metodo para BUSVAR
    public NodoArbol buscarNodo(int d){
        NodoArbol aux = raiz;
        while(aux.dato != d){
            if(d < aux.dato){
                aux = aux.hijoIzquierdo;
            }else{
                aux = aux.hijoDerecho;
            }
            if(aux == null){
                return null;
            }
        }
        return aux; //se encontro algo
    }
    //ELIMINAR nodo de arbol
    public boolean eliminar(int d){
        NodoArbol auxiliar = raiz;
        NodoArbol padre = raiz;
        boolean esHijoIzq= true;
        while (auxiliar.dato != d){
            padre = auxiliar;
            if(d < auxiliar.dato){
                esHijoIzq= true;
                auxiliar = auxiliar.hijoIzquierdo;
            }else{
                esHijoIzq=false;
                auxiliar = auxiliar.hijoDerecho;
            }
            if(auxiliar == null){
                return false;
            }
        }
        // Diferentes situaciones para eliminar el nodo:
        // Cuando el nodo no tiene hijos
        if(auxiliar.hijoIzquierdo == null && auxiliar.hijoDerecho == null){
            if(auxiliar == raiz){
                raiz = null;
            }else if(esHijoIzq){
                padre.hijoIzquierdo = null;
            }else{
                padre.hijoDerecho = null;
            }
        //Cuando tiene un hijo izquierdo
        }else if(auxiliar.hijoDerecho == null){
            if(auxiliar == raiz){
                raiz = auxiliar.hijoIzquierdo;
            }else if(esHijoIzq){
                padre.hijoIzquierdo = auxiliar.hijoIzquierdo;
            }else{
                padre.hijoDerecho = auxiliar.hijoIzquierdo;
            }
        //Cuando tiene un hijo derecho
        }else if(auxiliar.hijoIzquierdo == null){
            if(auxiliar == raiz){
                raiz = auxiliar.hijoDerecho;
            }else if(esHijoIzq){
                padre.hijoDerecho = auxiliar.hijoDerecho;
            }else{
                padre.hijoIzquierdo = auxiliar.hijoDerecho;
            }
        }else{ //Cuando tiene los dos hijos
            NodoArbol reemplazo = obtenerReemplazo(auxiliar);
            if(auxiliar == raiz){
                raiz = reemplazo;
            }else if(esHijoIzq){
                padre.hijoIzquierdo = reemplazo;
            }else{
                padre.hijoDerecho = reemplazo;
            }
            reemplazo.hijoIzquierdo = auxiliar.hijoIzquierdo;
        }
        return true;
    }
    //Metodo para regresar el reemplazo del nodo q se eliminó
    public NodoArbol obtenerReemplazo(NodoArbol nodoR){
        NodoArbol reemplazarPadre = nodoR;
        NodoArbol reemplazo=nodoR;
        NodoArbol auxiliar = nodoR.hijoDerecho;
        while(auxiliar != null){
            reemplazarPadre = reemplazo;
            reemplazo = auxiliar;
            auxiliar = auxiliar.hijoIzquierdo;
        }
        if(reemplazo != nodoR.hijoDerecho){
            reemplazarPadre.hijoIzquierdo = reemplazo.hijoDerecho;
            reemplazo.hijoDerecho = nodoR.hijoDerecho;
        }
        System.out.println("El reemplazo es: " + reemplazo);
        return reemplazo;
    }
}
