import java.util.*;
public class arbol{
    nodo raiz;
    int grado;
    public arbol(int grado){
        raiz = null;
        this.grado = grado;
    }
    public void insertar(int info){
        raiz = insertar(info, raiz, null);
    }
    public nodo insertar(int info, nodo aux, nodo padre){
        if(aux == null){
            nodo x = new nodo(grado);
            x.agregar(info);
            return x;
        }else{
            if(aux.hoja==true){
                aux.agregar(info);
            }else{
                int ruta = aux.ruta(info);
                aux.hijos[ruta] = insertar(info, aux.hijos[ruta], aux);
            }
        }
        if(aux.desborda()){ //necesito partirme
            aux = partir(padre, aux);
        }
        return aux;
    }

    public nodo partir(nodo padre, nodo aux){
            int app = 0;
            int tam = aux.valores.length;
            int medio = tam%2==0? tam/2-1: tam/2;
            nodo parte1, parte2;

            parte1 = new nodo(grado);
            parte2 = new nodo(grado);

            for(app = 0; app<medio; app++){
                parte1.agregar(aux.valores[app]);
                parte1.hijos[app] = aux.hijos[app];
            }
            parte1.hijos[app] = aux.hijos[app];

            for(app = medio+1; app<tam; app++){
                parte2.agregar(aux.valores[app]);
                parte2.hijos[app-medio-1] = aux.hijos[app];
            }
            parte2.hijos[app-medio-1] = aux.hijos[app];

            if(aux.hoja==false){
                parte1.hoja = false;
                parte2.hoja = false;
            }

            if(padre!=null){
                padre.agregar(aux.valores[medio]);
                padre.agregarh(parte2, aux);
                aux = parte1;
            }else{
                nodo nuevo = new nodo(grado);
                nuevo.agregar(aux.valores[medio]);
                nuevo.agregarh(parte1, null);
                nuevo.agregarh(parte2, parte1);
                aux = nuevo;
                aux.hoja = false;
            }
            return aux;
    }

    public void mostrar(){
        Queue<nodo> cola = new LinkedList<nodo>();
        if(raiz == null){
            System.out.println("Sin datos");
            return;
        }
        cola.add(raiz);
        while(!cola.isEmpty()){
            nodo aux = cola.element();
            System.out.println(Arrays.toString(aux.valores)+" Hoja="+aux.hoja);
            for(int i =0; i<aux.hijos.length; i++){
                if(aux.hijos[i]!=null) cola.add(aux.hijos[i]);
            }
            cola.remove();
        }
    }
}