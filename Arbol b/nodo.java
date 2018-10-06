public class nodo {
    int valores[];
    nodo hijos[];
    int cont_valores;
    int grado;
    boolean hoja;

    public nodo(int grado) {
        valores = new int[grado];
        hijos = new nodo[grado + 1];
        cont_valores = 0;
        this.grado = grado;
        hoja = true;
    }

    public void agregar(int info) {
        for (int i = 0; i < valores.length; i++) {
            if (valores[i] > info || valores[i] == 0) {
                int temp = valores[i];
                valores[i] = info;
                info = temp;
            }
        }
        cont_valores++;
    }
    public void agregarh(nodo parte, nodo hermano){
        if(hermano == null){
            hijos[0] = parte;
        }else{
            for(int i =0 ;i<hijos.length; i++){
                if(hijos[i] == hermano){
                    emupjarhijos(hijos[i+1],i+1);
                    hijos[i+1] = parte;
                    break;
                }
            }
        }
    }

    public void emupjarhijos(nodo aux, int i){
        for(; i<hijos.length-1; i++){
            nodo temp = hijos[i+1];
            hijos[i+1] = aux;
            aux = temp;
        }
    }

    public boolean lleno(){
        return cont_valores == grado-1 ? true: false;
    }

    public boolean desborda(){
        return cont_valores == grado ? true: false;
    }
    //                 |44|0|0|
    //                /    \
    //         |24|0|0|      | 70 |0|0|
    //        /   \         /      \
    // |10|13|0|  |33|0|0| |65|0|0| |105|600|0|
    public int ruta(int info){
        int i = 0;
        for(i =0; i<valores.length-1; i++){
            if(info<valores[i] || valores[i]==0) return i;
        }
        return i;
    }
   

}