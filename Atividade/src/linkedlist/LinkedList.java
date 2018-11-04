package linkedlist;

import interfaces.DataStructure;
import interfaces.Navigator;

public class LinkedList implements DataStructure{
    
    private NodoLigado inicio = null;
    private NodoLigado lastNode;
    
    public LinkedList(){
        
    }
    @Override
    public int length(){
        return 0;
    }
    // método de adição no início da lista
    public void adicionarInicio (Object e) {
        NodoLigado novo = new NodoLigado (e); 
        novo.proximo = inicio; 
        inicio = novo; 
        
        
    } 
    public NodoLigado getLastNode(){
        return this.lastNode;
    }
    
    // método de inserção após o nó dado
    public void inserir (Object e, NodoLigado no) {
        NodoLigado novo = new NodoLigado (e);
        novo.proximo = no.proximo;
        no.proximo = novo;
    }
    
    // método de adição no final da lista
    public void adicionarFim (Object e) {
        NodoLigado no = new NodoLigado(e); // (2)
        no.proximo = lastNode.proximo; // (3)
        lastNode.proximo = no;// (4)
    }

    @Override
    public Navigator getNavigator() {
        return new LinkedListNavigator();
    }
    private class LinkedListNavigator implements Navigator{
        
        private int lastIndex;
        private NodoLigado lastNode;
        
        @Override
        public boolean hasNext(){
            NodoLigado aux = new NodoLigado();
            aux = lastNode;
            while (aux != null) {
                aux = aux.proximo;
                return true;
            }
            return false;
        }
        @Override
        public Object getElement(){
            
            return lastNode.dado;
        }
    }  
}
