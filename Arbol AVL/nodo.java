public class nodo{
    public int info, w;
    public nodo izq, der;
    public nodo(int info){
        this.info = info;
        w = 1;
        izq = der = null;
    }
    public int factorb(){
        int suma = 0;
        if(izq!=null) suma+=izq.w;
        if(der!=null) suma-=der.w;
        return suma;
    }
}