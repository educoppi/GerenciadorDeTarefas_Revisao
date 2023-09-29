package controller;

import dao.TarefaDAO;
import model.Tarefa;
import view.TarefaView;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TarefaController {
    private ArrayList<Tarefa> listaTarefas;
    private TarefaDAO tarefaDAO = new TarefaDAO();
    private TarefaView tarefaView = new TarefaView();
    public TarefaController() {
        menu();
    }

    //ADICIONA TAREFA
    public void adiciona(String titulo, String descricao, char status){
        Tarefa tarefa = new Tarefa(titulo, descricao, status);
        tarefaDAO.adicionaTarefa(tarefa);
    }

    //ALTERA TAREFA
    public void altera(int id, String titulo, String descricao, char status){
        Tarefa tarefa = new Tarefa(id, titulo, descricao, status);
        if (tarefaDAO.alteraTarefa(tarefa)){
            tarefaView.tarefaAlterada();
        }else{
            tarefaView.tarefaNaoEncontrada();
        }
    }

    //EXIBE TAREFAS
    public void exibe(){
        if (tarefaDAO.obtemListaTarefas(false).isEmpty()){
            tarefaView.listaVazia();
            return;
        }
        tarefaView.exibirListaTarefas(tarefaDAO.obtemListaTarefas(true));
    }

    //FINALIZA TAREFA
    public void finaliza(int id){
        if (tarefaDAO.finalizaTarefa(id)){
            tarefaView.tarefaFinalizada();
        }else{
            tarefaView.tarefaNaoEncontrada();
        }
    }

    //DELETA TAREFA
    public void deleta(int id){
        if(tarefaDAO.deletaTarefa(id)){
            tarefaView.tarefaDeletada();
        }else{
            tarefaView.tarefaNaoEncontrada();
        }

    }

    //MENU
    public void menu(){
        var input = new Scanner(System.in);

        int opcao = -1;
        while(opcao != 0){
            tarefaView.menu();
            try{
                opcao = input.nextInt();
                switch (opcao){
                    case 1 -> {
                        tarefaView.adicionaTarefa();
                        tarefaView.insiraTitulo();
                        input.nextLine();
                        String titulo = input.nextLine();
                        tarefaView.insiraDescricao();
                        String descricao = input.nextLine();
                        tarefaView.insiraStatus();
                        char status = input.next().charAt(0);
                        checaStatus(status);

                        adiciona(titulo, descricao, status);
                        tarefaView.tarefaAdicionada();
                    }
                    case 2 ->{
                        tarefaView.alteraTarefa();
                        tarefaView.alteraTarefaId();
                        int id = input.nextInt();
                        input.nextLine();
                        tarefaView.insiraTitulo();
                        String titulo = input.nextLine();
                        tarefaView.insiraDescricao();
                        String descricao = input.nextLine();
                        tarefaView.insiraStatus();
                        char status = input.next().charAt(0);
                        checaStatus(status);

                        altera(id, titulo, descricao, status);
                    }
                    case 3 -> {
                        tarefaView.finalizaTarefa();
                        tarefaView.finalizaTarefaId();
                        int id = input.nextInt();
                        finaliza(id);
                    }
                    case 4 -> {
                        exibe();
                    }
                    case 5 ->{
                        tarefaView.deletaTarefa();
                        tarefaView.deletaTarefaId();
                        int id = input.nextInt();
                        deleta(id);
                    }
                    case 0 ->{
                        tarefaView.sair();
                    }
                }
            }catch(InputMismatchException e){
                tarefaView.inputMismatchException();
                menu();
            }
        }
    }

    //CONFERE SE O STATUS INSERIDO É VALIDO
    public void checaStatus(char status){
        if (!(Character.toUpperCase(status) == 'A' || Character.toUpperCase(status) == 'P' || Character.toUpperCase(status) == 'C')){
            tarefaView.statusInvalido();
            menu();
        }
    }
}
