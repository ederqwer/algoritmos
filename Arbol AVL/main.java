public class main{
    public static void main(String[] args) {
        arbol a = new arbol();
        a.insertar(15);
        a.insertar(20);
        a.insertar(17);
        a.insertar(30);
        a.insertar(35);
        a.insertar(18);
        a.insertar(11);
        a.insertar(13);
        a.insertar(4);
        a.insertar(12);
        a.eliminar(20);
        a.eliminar(18);
        a.eliminar(17);
        a.eliminar(11);
        a.eliminar(35);
        a.eliminar(4);
        a.eliminar(30);
        a.eliminar(13);
        a.eliminar(15);
        a.eliminar(12);
        a.eliminar(100);
        a.mostrar();
    }
}