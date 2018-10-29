package classes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public final class Agenda {
	
//	O sistema requer assim:
//	� A cria��o, consulta e remo��o de agendas.
//	� A adi��o(ok), remo��o(ok) e consulta(ok) de eventos presentes em agendas espec�ficas.
//	� Visualiza��o de agenda em modos diferentes (Di�rio, Semanal, Mensal, Anual)
//
	
    //atributos
    private String nomeAgenda;
    private static int id = 0 ;
    private  List<Evento> eventos;
    
    //construtores
    public Agenda(String nomeAgenda) {
        this.setNomeAgenda(nomeAgenda);
        eventos = new ArrayList<>();
        id++;
    }
    
    //retorna o nome da Agenda
    public String getNomeAgenda() {
        return nomeAgenda;
    }

    //define o nome da Agenda
    public void setNomeAgenda(String nomeAgenda) {
        if(!nomeAgenda.trim().equals("")){
            this.nomeAgenda = nomeAgenda;
        }
        else{
            throw new RuntimeException("Nome da agenda não pode ficar em branco!");
        }
    }
    
    //remove o evento da Agenda
    public void removeEvento(Evento evento) {
        this.eventos.remove(evento);
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
    
    //obter id da Agenda
    public static int getIdAgenda() {
        return id;
    }
    
    //retorna o número de eventos da agenda
    public int totalEventos(){
        return this.eventos.size();
    }
    
    //verifica se a agenda está vazia
    public boolean isEmpty(){
        return totalEventos()==0;
    }
    
    //imprime todos eventos da agenda
    @Override
    public String toString(){
        
        StringBuilder sb = new StringBuilder();
        System.out.print("Agenda do "+this.getNomeAgenda());
        sb.append("\n");
        sb.append("ID da Agenda:");
        sb.append(Agenda.getIdAgenda());
        sb.append("\n");
        sb.append("------EVENTOS------");
        sb.append("\n");
        for(int i = 0; i < this.totalEventos(); i++){
            sb.append("ID do Evento: ");
            sb.append(eventos.get(i).getId());
            sb.append("\n");
            sb.append("Nome do Evento: ");
            sb.append(eventos.get(i).getNome());
            sb.append("\n");
            sb.append("Data do Evento: ");
            sb.append(eventos.get(i).dataToString());
            sb.append("\n");
            sb.append("\n");

        }
        return sb.toString();
    }
    
    //retorna eventos por mês
    public List<Evento> retornaPorMes (Calendar mes, Agenda agenda) {
        return null;
    }
    public List<Evento> retornoPorDia (Calendar dia, Agenda agenda){
        return null;
    }
        //adiciona evento informando dia mes, ano, horas e minutos
    public Evento addEvento(String nomeEvento, int dia, int mes, int ano, int horas, int minutos) {
        Evento e = new Evento(nomeEvento, dia, mes, ano, horas, minutos);
        this.eventos.add(e);
        return e;
    }
}
	
	
	


