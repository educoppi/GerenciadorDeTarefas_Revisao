package model;

public class Tarefa {
    //ATRIBUTOS
    private int id;
    private String titulo;
    private String descricao;
    private char status;

    //CONSTRUTORES
    public Tarefa (){}
    public Tarefa(int id, String titulo, String descricao, char status) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
    }
    public Tarefa(String titulo, String descricao, char status) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
    }

    //GETS E SETS
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public char getStatus() {
        return status;
    }
}
