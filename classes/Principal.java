/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
public class Principal {

    
    public static void main(String[] args) {
        Agenda agenda = new Agenda("JOSIAS");
        Agenda agenda2 = new Agenda("PEDRO");
        
        agenda.addEvento("FESTA", 18,11,1999, 15,00 );
        agenda.addEvento("FESTA2", 19,11,1999, 14,30 );
        agenda.addEvento("FESTA3",19,11,1999, 16,45 );
        agenda2.addEvento("FESTA4", 18,11,1999, 15,00 );
        agenda2.addEvento("FESTA5", 19,11,1999, 14,30 );
        agenda2.addEvento("FESTA6",19,11,1999, 16,45 );
        System.out.println(agenda.toString());
        System.out.println(agenda2.toString());

    
    }
}
