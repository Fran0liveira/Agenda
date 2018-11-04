/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TesteLinkedList;



import interfaces.Navigator;
import linkedlist.LinkedList;

public class testeLinkedList {
    public static void main(String[] args) {
        
        LinkedList l = new LinkedList();
        l.adicionarInicio(5);
        System.out.println(l.getLastNode());
        Navigator nav = l.getNavigator();
       while ( nav.hasNext() ) {
           System.out.println( nav.getElement() );
       }
    }
    
}
