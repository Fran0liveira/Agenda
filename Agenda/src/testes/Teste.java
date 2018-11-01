/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import classes.Agenda;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

public class Teste {

    
    public static void main(String[] args) {
        
        Calendar c1 = GregorianCalendar.getInstance();
        int ano = c1.get(Calendar.YEAR);
        System.out.println(ano);
        
        Agenda agenda = new Agenda("JOSIAS");
        
        System.out.println(agenda.toStringByMonth(5));
        
        
        
    }
}
