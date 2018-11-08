package classes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
//modificado
public final class Agenda{
	
//	O sistema requer assim:
//	� A cria��o, consulta e remo��o de agendas.
//	� A adi��o(ok), remo��o(ok) e consulta(ok) de eventos presentes em agendas espec�ficas.
//	� Visualiza��o de agenda em modos diferentes (Di�rio, Semanal, Mensal, Anual)
//
	
    //atributos
    private String nomeAgenda;
    public List<Evento> eventos;
    private int id = 0;
    private int numEventos = 0;
    
    
    //construtores
    public Agenda(String nomeAgenda) {
        this.setNomeAgenda(nomeAgenda);
        eventos = new ArrayList<>();
        this.setIdAgenda();
    }
    
    //retorna o nome da Agenda
    public String getNomeAgenda() {
        return nomeAgenda;
    }

    //define o nome da Agenda
    public void setNomeAgenda(String nomeAgenda) {
        if(nomeAgenda.trim().equals("")){
            throw new RuntimeException("Nome da agenda não pode ficar em branco!");
        }
        this.nomeAgenda = nomeAgenda;
            
    }
    
    //remove o evento da Agenda
    public void removeEvento(int id) {
        this.eventos.remove(this.getEvento(id));
        numEventos--;
    }


    //retorna evento pelo id
    public Evento getEvento(int id){
            for (Evento item: eventos) {
                if (item.getId() == id) {
                        return item;
                }
            }
        return null;
    }
    public Evento getEventoByIndex(int i){  
        return eventos.get(i);
    }

    
    //obter id da Agenda
    public int getIdAgenda() {
        return this.hashCode();
    }
    private void setIdAgenda(){
        id = this.hashCode();
    }
    
    //retorna o número de eventos da agenda
    public int totalEventos(){
        return this.eventos.size();
    }
    
    //verifica se a agenda está vazia
    public boolean isEmpty(){
        return totalEventos() == 0;
    }
    
    //imprime todos eventos da agenda
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        System.out.print("Agenda do "+this.getNomeAgenda());
        sb.append("\n");
        sb.append("ID da Agenda:");
        sb.append(this.getIdAgenda());
        sb.append("\n");
        sb.append("------EVENTOS------");
        sb.append("\n");
        for(Evento evento : eventos){
            sb.append(evento.eventoToString());
            this.getNumEventos();
        }
        sb.append(numEventos).append(" evento(s) foram encontrados");
        return sb.toString();
    }
    
    //retorna eventos por mês
    public List<Evento> getByMonth (int mes) {
        List<Evento> eventoAUX = new ArrayList<>();
        Calendar c1 = GregorianCalendar.getInstance();
        for (Evento evento : eventos) {

                if(evento.getMes()== mes){
                    eventoAUX.add(evento);
                }
                return eventoAUX;
            }
            
        return null;
    }
    public String toStringByMonth (int mes) {
        StringBuilder sb = new StringBuilder();
        if(this.getByDay(mes) == null){
            sb.append("Nenhum evento registrado nesse mês!");
        }
        for(int i = 0; i < this.getByMonth(mes).size(); i++){
            sb.append(this.getByMonth(mes).get(i).eventoToString());
        }
        return sb.toString();
    } 
    public List<Evento> getByDay (int dia){
        List<Evento> eventoAUX = new ArrayList<>();
        Calendar c1 = GregorianCalendar.getInstance();
        for (Evento evento : eventos) {

                if(evento.getDia()== dia){
                    eventoAUX.add(evento);
                }
                return eventoAUX;
            }
            
        return null;
    }
    public String toStringByDay (int dia) {
        StringBuilder sb = new StringBuilder();
        if(this.getByDay(dia) == null){
            sb.append("Nenhum evento registrado nesse dia!");
        }
        else{
            for(int i = 0; i < this.getByDay(dia).size(); i++){
                sb.append(this.getByDay(dia).get(i).eventoToString());
            }
        }
        return sb.toString();
    } 
    
        //adiciona evento informando dia mes, ano, horas e minutos
    public Evento addEvento(String nomeEvento, int dia, int mes, int ano, int hora, int minuto, boolean global, int duracaoHora, int duracaoMinuto) {
        Evento e = new Evento(nomeEvento, dia, mes, ano, hora, minuto, global, duracaoHora, duracaoMinuto);
        this.eventos.add(e);
        numEventos++;
        return e;
    }
    public Evento addEvento(String nomeEvento, Calendar data, String horario, String duracao, boolean global) {
        Evento e = new Evento(nomeEvento, data, horario, duracao, global);
        this.eventos.add(e);
        numEventos++;
        return e;
    }
    public Evento addEvento(Evento evento){
        this.eventos.add(evento);
        numEventos++;
        return evento;
    }
    public int getNumEventos(){
        return numEventos;
    }
    

}
	
	
	


