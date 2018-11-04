
package linkedlist;

public class NodoLigado {
    public Object dado;
    public NodoLigado proximo;
    
    public NodoLigado () {
        
    }
    
    public NodoLigado (Object d){
        dado =d;
    }
    
    public NodoLigado (Object d, NodoLigado p) {
        dado = d;
        proximo = p;
    }
}
