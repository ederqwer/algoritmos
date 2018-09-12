import java.util.LinkedList;
import java.util.Queue;

public class arbol{
    nodo raiz;
    public arbol(){
        raiz = null;
    }
    public void insertar(int info){
         nodo x = new nodo(info);
         if(raiz == null) raiz = x;
         else insertar(x, raiz);
    }
    public nodo insertar(nodo x, nodo aux){
        if(aux == null) return x;
        if(x.info<aux.info){//izq
            aux.izq = insertar(x,aux.izq);
        }else{ //der
            aux.der = insertar(x,aux.der);
        }
        return aux;
        
    }

    public void buscar(int info){
        buscar(info, raiz);
    }

    public void buscar(int info, nodo aux){
        if(aux == null) System.out.println("No encontrado!");
        else if(info == aux.info) System.out.println("Encontrado!");
        else if(info<aux.info) buscar(info, aux.izq);
        else buscar(info, aux.der);
    }

    public void eliminar(int info){
        eliminar(info, raiz, null, null, null);
        System.out.println("Elminado!");
    }

    public void eliminar(int info, nodo x, nodo xpadre, nodo y, nodo ypadre){
        if(x == null) System.out.println("No encontrado!");
        else if(info == x.info){//Eliminalo!
            if(x.izq != null){//¿Hay de donde agarrar?
                y = x.izq;
                ypadre = x;
                while(y.der!=null){ //Recorro al mayor
                    ypadre = y;
                    y = y.der;
                }
                x.info = y.info; //Subo información
                if(x != ypadre)
                    ypadre.der = y.izq;//Salva los hijos
                else x.izq = y.izq;
            }else{ //No hay, redirección directa...
                if(xpadre != null){ //
                    if(xpadre.izq == x) xpadre.izq = x.der;
                    else xpadre.der = x.der;
                }else raiz = x.der;
            }
        }else if(info<x.info) eliminar(info, x.izq, x, y, ypadre);
        else eliminar(info, x.der, x, y, ypadre);
    }

    
    public void mostrar(){
        Queue<nodo> q = new LinkedList<nodo>();
        if(raiz!=null)q.add(raiz);
        else System.out.println("Sin datos");
        while(!q.isEmpty()){
            if(q.element().izq!=null) q.add(q.element().izq);
            if(q.element().der!=null) q.add(q.element().der);
            System.out.println(q.poll().info);
        }
    }
}