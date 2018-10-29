package classes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;


public final class Evento {
	
//	O sistema requer assim:
//		� A cria��o, consulta e remo��o de agendas.
//		� A adi��o, remo��o e consulta de eventos presentes em agendas espec�ficas.
//		� Visualiza��o de agenda em modos diferentes (Di�rio, Semanal, Mensal, Anual)
//	
    //atributos
    private static int id = 0;
    private String nomeEvento;
    private Calendar data;


    //contrutor 
    public Evento(String nomeEvento, int dia, int mes, int ano, int horas,int minutos) {
        id++;
        this.setNome(nomeEvento);
        this.setData(dia, mes, ano, horas, minutos);
    }

    public int getId() {
        return id;
    }
    
    public String getNome() {
        return nomeEvento;
    }

    public void setNome(String nomeEvento) {
        if(nomeEvento.isEmpty()){
            throw new RuntimeException("Nome do evento não pode ficar em branco!");
        }
        else{
            this.nomeEvento = nomeEvento;
        }
    }
    //retorna data do tipo String
    public String dataToString() {
        final DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String s = df.format(data.getTime());
        return s;
    }
    public Calendar getData(){
        return data;
    }
    
    //define a data separando dia, mes, ano, horas, minutos
    public void setData(int dia, int mes, int ano, int horas, int minutos) {
        Calendar c1 = GregorianCalendar.getInstance();
        c1.set(Calendar.YEAR, ano);
        c1.set(Calendar.MONTH, mes);
        c1.set(Calendar.DAY_OF_MONTH, dia);
        c1.set(Calendar.HOUR_OF_DAY, horas);
        c1.set(Calendar.MINUTE, minutos);
        this.data= c1;
    }
    


}


