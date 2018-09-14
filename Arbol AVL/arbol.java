import java.util.*;
public class arbol{
    nodo raiz;
    public arbol(){
        raiz = null;
    }
    public void insertar(int info){
        nodo x = new nodo(info);
        if(raiz == null) raiz = x;
        else insertar(x, raiz, null);
    }
    public nodo insertar(nodo x, nodo aux, nodo padre){
        if(aux == null) return x;
        if(x.info<aux.info){//izq
            aux.izq = insertar(x, aux.izq, aux);
            aux.w = aux.izq.w+1;
            if(aux.factorb()<-1){//RI
                System.out.println("Rot izq en:"+aux.info);
            }else if(aux.factorb()>1){//RD
                System.out.println("Rot der en:"+aux.info);
            }
        }else{ //der
            aux.der = insertar(x, aux.der, aux);
            aux.w = aux.der.w+1;
            if(aux.factorb()<-1){//RI
                System.out.println("Rot izq en:"+aux.info);
            }else if(aux.factorb()>1){//RD
                System.out.println("Rot der en:"+aux.info);
            }
        }
        return aux;
    }

    private void equilibrar(nodo x, nodo padre){

    }

    public void mostrar(){
        Queue<nodo> q = new LinkedList<nodo>();
        if(raiz!=null)q.add(raiz);
        else System.out.println("Sin datos");
        while(!q.isEmpty()){
            if(q.element().izq!=null) q.add(q.element().izq);
            if(q.element().der!=null) q.add(q.element().der);
            nodo x = q.poll();
            System.out.println(x.info+" w = "+x.w);
        }
    }
}