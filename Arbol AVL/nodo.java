public class nodo{
    public int info, w;
    public nodo izq, der;
    public nodo(int info){
        this.info = info;
        w = 1;
        izq = der = null;
    }
}