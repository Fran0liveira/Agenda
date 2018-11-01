/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Principal {

    private static final List<Agenda> agendas = new ArrayList<Agenda>();
    
    static int indice = 0;
        // cria um menu de interacao para adicionar, excluir, visualizar agendas
    public static int menu(){
        
        Scanner tec = new Scanner(System.in);
        int opcao;
            System.out.println("------SISTEMA DE AGENDA------");
            System.out.println("Digite 1 para adicionar agendas");
            System.out.println("Digite 2 para excluir agendas"); 
            System.out.println("Digite 3 para manipular agendas");
            System.out.println("Digite 0 para encerrar");   
            opcao = tec.nextInt();
        return opcao;
    }
    //cria um menu para adicionar eventos
    public static Evento criarEvento(Agenda agenda){
        
        Scanner tec = new Scanner(System.in);
        String opcao;
        
        String nomeEvento;
        int dia;
        int mes;
        int ano;
        int hora;
        int minuto;
        int duracaoHora;
        int duracaoMinuto = 0;
        
        
        
        System.out.println("Digite o nome do Evento");
        nomeEvento = tec.nextLine();
        Evento evento = new Evento(nomeEvento);

        System.out.println("Digite o dia do Evento");
        dia = tec.nextInt();

        System.out.println("Digite o mes do Evento");
        mes = tec.nextInt();

        System.out.println("Digite o ano do Evento");
        ano = tec.nextInt();

        System.out.println("Digite a hora do Evento");
        hora = tec.nextInt();
        
        System.out.println("Digite os minutos do Evento");
        minuto = tec.nextInt();
        
        System.out.println("Digite a quantidade de horas do Evento (24 para dia todo)");
        duracaoHora = tec.nextInt();
        
        if(duracaoHora != 24){
            System.out.println("Digite a quantidade de minutos do Evento");
            duracaoMinuto = tec.nextInt();
        }
        
        do{
            System.out.println("Este evento é global (para todas agendas existentes) (s/n)?");
            opcao = tec.next();
                if(!"s".equals(opcao.toLowerCase()) && !"n".equals(opcao.toLowerCase())){
                    System.out.println("Valor inválido. Digite novamente!");
                }
        }while(!"s".equals(opcao.toLowerCase()) && !"n".equals(opcao.toLowerCase()));
        
            try{
                if("s".equals(opcao)){
                    for(Agenda agenda2 : agendas){
                        agenda2.addEvento(nomeEvento, dia, mes, ano, hora, minuto, true, duracaoHora, duracaoMinuto);  
                    }
                }
                else{
                    agenda.addEvento(nomeEvento, dia, mes, ano, hora, minuto, false,duracaoHora, duracaoMinuto);
                }
                System.out.println("Evento criado com sucesso!");
            }catch(Exception e){
                System.err.println("Ocorreu um erro ao adicionar o evento. "+e);
            }
        return evento;
        
    }
    public static Agenda criarAgenda(String proprietario){
        Agenda a = new Agenda(proprietario);
        return a;
    }
    public static void exibirAgenda(){
        System.out.println("----------AGENDAS----------"); //exibe todas as Agendas cadastradas
        for(Agenda agenda: agendas){
            System.out.println("ID = "+agenda.getIdAgenda()+ "  Proprietário= "+agenda.getNomeAgenda());
        }
    }

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        
        int opcao=1;
        String opcao2;
        String proprietario;
        String nomeEvento;
        int dia;
        int mes;
        int ano;
        int hora;
        int minuto;
        int id;

        
        //oferece opção para o usuário manipular Agenda (adicionar, excluir)
        while(opcao!=0){
            switch (menu()) {
                case 0:
                    System.exit(0);
                case 1:
                    System.out.println("Digite o nome do proprietário da Agenda");
                    proprietario = tec.nextLine();
                    //criacao da Agenda
                    try{
                        agendas.add(indice, criarAgenda(proprietario));
                        System.out.println("Agenda criada com sucesso!");  
                        indice++;
                    }catch(Exception e){
                        System.err.println("Ocorreu um erro ao criar a Agenda. "+e);
                    }
                    continue;
                case 2:
                    if(agendas.isEmpty()){
                        System.out.println("Nenhuma agenda registrada!");
                    } else{
                        exibirAgenda();
                        System.out.println("Digite o ID da Agenda que deseja excluir");
                        id = tec.nextInt();
                        try{
                            for(Agenda agenda: agendas){
                                if(agenda.hashCode() == id){
                                    agendas.remove(agenda);
                                    System.out.println("Agenda excluída com sucesso!");
                                    indice--;
                                    break;
                                }
                            }
                        }catch(Exception e){
                            System.err.println("Ocorreu um erro ao tentar excluir a Agenda. "+e);
                        }
                    }   continue;
                case 3:
                    if(agendas.isEmpty()){
                        System.out.println("Nenhuma agenda registrada!");
                    }
                    else{
                        exibirAgenda();
                        System.out.println("Selecione uma agenda pelo ID");
                        id = tec.nextInt();
                        for(Agenda agenda: agendas){
                            if(agenda.getIdAgenda() == id){
                                if(agenda.isEmpty()){
                                    System.out.println("Nenhum evento registrado!");
                                }
                            
                                do{
                                    System.out.println("Você quer adicionar eventos (1), excluir eventos (2) ou visualizar eventos (3) desta agenda?");
                                    opcao = tec.nextInt();
                                        if(opcao != 1 && opcao != 2 && opcao != 3){
                                            System.out.println("Valor inválido. Digite novamente!");
                                        }
                                }while(opcao != 1 && opcao != 2 && opcao !=3);
                            
                                switch (opcao) {
                                    case 1:
                                        criarEvento(agenda);
                                        continue;
                                    case 2:
                                        System.out.println("Digite o ID do evento que deseja excluir");
                                        id = tec.nextInt();
                                        System.out.println(agenda.toString());
                                            try{
                                                if(agenda.getEvento(id)!= null){
                                                    agenda.removeEvento(id);
                                                }
                                                System.out.println("Evento excluído com sucesso!");
                                            }
                                            catch(Exception e){
                                                System.err.println("Ocorreu um erro ao remover evento da Agenda"+e);
                                            }   
                                    case 3:
                                        do{
                                            System.out.println("Selecionar eventos pelo dia(d), mês(m) ou exibir todos(t)?");
                                            opcao2 = tec.next();
                                        }while(!"d".equals(opcao2.toLowerCase()) && !"m".equals(opcao2.toLowerCase()) && !"t".equals(opcao2.toLowerCase()));

                                    switch (opcao2) {
                                        case "m":
                                            do{
                                                System.out.println("Selecione o mês a ser pesquisado");
                                                opcao = tec.nextInt();
                                            }while(opcao < 1 || opcao > 12);
                                            System.out.println(agenda.toStringByMonth(opcao));
                                            continue;

                                        case "d":
                                            do{
                                                System.out.println("Selecione o dia a ser pesquisado");
                                                opcao = tec.nextInt();
                                            }while(opcao < 0 || opcao > 31);
                                            System.out.println(agenda.toStringByDay(opcao));
                                            continue;

                                        case "t":
                                            System.out.println(agenda.toString());
                                    }
                                } 
                            }
                        }
                        break;
                    }
                    continue;
                default:
                    System.out.println("Valor inválido. Digite novamente!");
            }
        }
    }
}
