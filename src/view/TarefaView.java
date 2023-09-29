package view;

import model.Tarefa;

import java.util.ArrayList;
import java.util.Scanner;

public class TarefaView {
    Scanner input = new Scanner(System.in);

    //EXIBIR TAREFAS
    public void exibirListaTarefas(ArrayList<Tarefa> listaTarefas){
        System.out.println("== LISTA DE TAREFAS ==");
        for (Tarefa t : listaTarefas){
            System.out.println("ID: "+t.getId());
            System.out.println("Titulo: "+ t.getTitulo());
            System.out.println("Descricao: "+t.getDescricao());
            System.out.println("Status: "+t.getStatus());
            System.out.println("=================\n");
        }
    }

    //MENU
    public void menu(){
        System.out.println("\n== MENU ==");
        System.out.println("1 - Adiciona tarefa");
        System.out.println("2 - Atualiza tarefa");
        System.out.println("3 - finaliza tarefa");
        System.out.println("4 - Lista tarefa");
        System.out.println("5 - Deleta tarefa");
        System.out.println("0 - Sair");

        System.out.print("\nSelecione uma das opcoes: ");
    }

    //SYSOUT DE INSERÇÃO
    public void insiraTitulo(){ System.out.print("Insira o titulo da tarefa: "); }

    public void insiraDescricao(){
        System.out.print("Insira a descricao da tarefa: ");
    }

    public void insiraStatus(){
        System.out.print("Insira os status da tarefa (A, P ou C): ");
    }

    //SYSOUT PARA ADICIONAR TAREFA
    public void adicionaTarefa(){ System.out.println("== ADICIONAR =="); }

    public void tarefaAdicionada(){ System.out.println("Tarefa adicionada com sucesso!"); }

    //SYSOUT PARA ALTERAR TAREFA
    public void alteraTarefa(){ System.out.println("== ALTERAR =="); }

    public void alteraTarefaId(){ System.out.print("Insira o id da Tarefa que você deseja alterar: "); }

    public void tarefaAlterada(){ System.out.print("Tarefa alterada com sucesso!"); }

    //SYSOUT PARA FINALIZAR TAREFA
    public void finalizaTarefa(){ System.out.println("== FINALIZAR =="); }

    public void finalizaTarefaId(){ System.out.print("Insira o id da Tarefa que você deseja finalizar: "); }

    public void tarefaFinalizada(){ System.out.print("Tarefa finalizada com sucesso!"); }

    //SYSOUT PARA DELETAR TAREFA
    public void deletaTarefa(){ System.out.println("== DELETA =="); }

    public void deletaTarefaId(){ System.out.print("Insira o id da tarefa que você deseja deletar: "); }

    public void tarefaDeletada(){ System.out.print("Tarefa deletada com sucesso!"); }

    //VERIFICACAO DO BANCO DE DADOS
    public void tarefaNaoEncontrada(){ System.out.print("Tarefa nao encontrada!"); }

    public void listaVazia(){ System.out.println("O banco de dados está vazio, adicione novas tarefas!"); }

    //TRATAMENTO DE ERROS
    public void inputMismatchException(){ System.err.println("Insira um numero!"); }

    public void statusInvalido(){ System.out.println("Status inválido!"); }

    //FECHANDO SISTEMA
    public void sair(){ System.out.println("Saindo..."); }


}
