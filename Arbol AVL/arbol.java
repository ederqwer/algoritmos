import java.util.*;
import java.math.*;
public class arbol{
    nodo raiz;
    public arbol(){
        raiz = null;
    }
    public void insertar(int info){
        nodo x = new nodo(info);
        if(raiz == null) raiz = x;
        else raiz = insertar(x, raiz);
    }
    public nodo insertar(nodo x, nodo aux){
        if(aux == null) return x;
        if(x.info<aux.info){//izq
            aux.izq = insertar(x, aux.izq);
            aux.w = aux.izq.w+1;
            aux = equilibrar(aux);
        }else{ //der
            aux.der = insertar(x, aux.der);
            aux.w = aux.der.w+1;
            aux = equilibrar(aux);
        }
        return aux;
    }
    private nodo equilibrar(nodo x){
        if(x.factorb()<-1){//RI
            System.out.print("Rot izq en: "+x.info);
            if(x.der.factorb()>=1){
                System.out.print(" DOBLE!");
                x.der = RD(x.der);
            }
            System.out.println("");
            return RI(x);
        }else if(x.factorb()>1){//RD
            System.out.print("Rot der en: "+x.info);
            if(x.izq.factorb()<=-1){
                x.izq = RI(x.izq);
                System.out.print(" DOBLE!");
            }
            System.out.println("");
            return RD(x);
        } return x;
    }

    private nodo RI(nodo x){
        nodo aux = x.der;
        x.der = aux.izq;
        aux.izq = x;
        x.w = Math.max(altura(x.izq), altura(x.der)) + 1;
        aux.w = Math.max(altura(aux.der), x.w) + 1;
        return aux;
    }

    private nodo RD(nodo x){
        nodo aux = x.izq;
        x.izq = aux.der;
        aux.der=x;
        x.w = Math.max(altura(x.izq), altura(x.der)) + 1;
        aux.w = Math.max(altura(aux.izq), x.w) + 1;
        return aux;
    }


    public void mostrar(){
        Queue<nodo> q = new LinkedList<nodo>();
        if(raiz!=null)q.add(raiz);
        else System.out.println("Sin datos");
        while(!q.isEmpty()){
            if(q.element().izq!=null) q.add(q.element().izq);
            if(q.element().der!=null) q.add(q.element().der);
            nodo n = q.poll();
            System.out.println(n.info+" w = "+n.w);
        }
    }

    private int altura(nodo x){
        return (x==null)?0:x.w;
    }
}