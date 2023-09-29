package dao;

import model.Tarefa;
import view.TarefaView;

import java.sql.*;
import java.util.ArrayList;


public class TarefaDAO {
    private Tarefa tarefa;
    private TarefaView tarefaView = new TarefaView();

    private String url = "jdbc:mysql://localhost:3306/projeto_revisao";

    private String usuario = "root";

    private String senha = "aluno";

    /* obtemListaTarefas
    Obtem as tarefas que estao no banco de dados

    Se check for igual a true então ele executa o metodo inteiro, inclusive o insert
    na tabela log_tarefa. Se for false significa que ele está checando se há itens
    no banco, logo não é necessario executar o insert em log_tarefa
     */
    public ArrayList<Tarefa> obtemListaTarefas(boolean check){
        ArrayList<Tarefa> lista = new ArrayList<>();
        try(Connection c = DriverManager.getConnection(url, usuario, senha)){
            String query = "SELECT * FROM tarefa;";

            PreparedStatement ps = c.prepareStatement(query);

            ResultSet resultSet = ps.executeQuery();

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String titulo = resultSet.getString("titulo");
                String descricao = resultSet.getString("descricao");
                String statusNaoTratado = resultSet.getString("status");
                char status = statusNaoTratado.charAt(0);
                Tarefa tarefa = new Tarefa(id, titulo, descricao, status);

                lista.add(tarefa);
            }

            if (check){
                for (Tarefa tarefa: lista) {

                    String log_query = "INSERT INTO log_tarefa (id_tarefa, operacao, mensagem) VALUES (?, 'LISTADO', 'Uma tarefa foi listada');";

                    PreparedStatement ps_log = c.prepareStatement(log_query);

                    ps_log.setInt(1, tarefa.getId());

                    ps_log.executeUpdate();
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }

    /* adicionaTarefa
    Adiciona uma tarefa no banco e tambem insere na tabela log_tarefa

    retornaID_log serve para receber o ultimo id adicionado em tarefa, após a
    tarefa ser adicionada
     */
    public void adicionaTarefa(Tarefa t){
        try(Connection c = DriverManager.getConnection(url, usuario, senha)){
            String query = "INSERT INTO tarefa (titulo, descricao, status) VALUES (?, ?, ?);";

            PreparedStatement ps = c.prepareStatement(query);

            ps.setString(1, t.getTitulo());
            ps.setString(2, t.getDescricao());
            ps.setString(3, String.valueOf(t.getStatus()));

            ps.executeUpdate();

            String log_query = "INSERT INTO log_tarefa (id_tarefa, operacao, mensagem) VALUES (?, 'ADICIONADO', 'Uma tarefa foi adicionada');";

            PreparedStatement ps_log = c.prepareStatement(log_query);

            ps_log.setInt(1, retornaID_log());

            ps_log.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    /* alteraTarefa
    altera uma tarefa de acordo com o id dentro do objeto tarefa inserido nos parametros

    checa se existe o id procurado
     */
    public boolean alteraTarefa(Tarefa t){
        try(Connection c = DriverManager.getConnection(url, usuario, senha)){

            if (!checkSeExiste(t.getId())){
                return false;
            }

            String query = "UPDATE tarefa SET titulo = ?, descricao = ?, status = ? WHERE id = ?;";

            PreparedStatement ps = c.prepareStatement(query);

            ps.setString(1, t.getTitulo());
            ps.setString(2, t.getDescricao());
            ps.setString(3, String.valueOf(t.getStatus()));
            ps.setInt(4, t.getId());

            ps.executeUpdate();

            String log_query = "INSERT INTO log_tarefa (id_tarefa, operacao, mensagem) VALUES (?, 'ALTERADO', 'Uma tarefa foi alterada');";

            PreparedStatement ps_log = c.prepareStatement(log_query);

            ps_log.setInt(1, t.getId());

            ps_log.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    /* finalizaTarefa
    Altera o status independente de seu valor para 'C' de uma tarefa especifica

    checa se existe o id procurado
     */
    public boolean finalizaTarefa(int id){
        try(Connection c = DriverManager.getConnection(url, usuario, senha)){

            if (!checkSeExiste(id)){
                return false;
            }

            String query = "UPDATE tarefa SET status = 'C' WHERE id = ?;";

            PreparedStatement ps = c.prepareStatement(query);

            ps.setInt(1, id);

            ps.executeUpdate();

            String log_query = "INSERT INTO log_tarefa (id_tarefa, operacao, mensagem) VALUES (?, 'FINALIZADO', 'Uma tarefa foi finalizada');";

            PreparedStatement ps_log = c.prepareStatement(log_query);

            ps_log.setInt(1, id);

            ps_log.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    /* deletaTarefa
    deleta a tarefa de acordo com o id especificado

    checa se existe o id procurado
     */
    public boolean deletaTarefa(int id){
        try(Connection c = DriverManager.getConnection(url, usuario, senha)){

            if (!checkSeExiste(id)){
                return false;
            }

            String query = "DELETE FROM tarefa WHERE id = ?;";

            PreparedStatement ps = c.prepareStatement(query);

            ps.setInt(1, id);

            ps.executeUpdate();

            String log_query = "INSERT INTO log_tarefa (id_tarefa, operacao, mensagem) VALUES (?, 'DELETADO', 'Uma tarefa foi deletada');";

            PreparedStatement ps_log = c.prepareStatement(log_query);

            ps_log.setInt(1, id);

            ps_log.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    /* checkSeExiste
    Procura se existe no banco o id inserido pelo usuario
     */
    public boolean checkSeExiste(int id){
        int idProcurar = 0;
        try (Connection c = DriverManager.getConnection(url, usuario, senha)) {
            String query_auxiliar = "SELECT id FROM tarefa WHERE id = ?;";

            PreparedStatement ps_aux = c.prepareStatement(query_auxiliar);

            ps_aux.setInt(1, id);

            ResultSet resultSet = ps_aux.executeQuery();

            while (resultSet.next()) {
                idProcurar = resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (idProcurar == 0){
            return false;
        }else {
            return true;
        }
    }

    /* retornaID_log
    retorna o id da ultima tarefa que foi adicionada, auxilia
    o metodo adicionaTarefa para poder inserir na tabela log_tarefa
    o id da ultima tarefa adicionada
     */
    public int retornaID_log() {
        int id = 0;
        try (Connection c = DriverManager.getConnection(url, usuario, senha)) {
            String query_auxiliar = "SELECT id FROM tarefa ORDER BY id DESC LIMIT 1;";

            PreparedStatement ps_aux = c.prepareStatement(query_auxiliar);

            ResultSet resultSet = ps_aux.executeQuery();

            while (resultSet.next()) {
                id = resultSet.getInt("id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    /* obtemTodosID
    obtem todos os ID's de tarefas que estão na tabela tarefa
     */
    public ArrayList<Integer> obtemTodosID(){
        ArrayList<Integer> lista = new ArrayList<>();
        try (Connection c = DriverManager.getConnection(url, usuario, senha)) {
            String query = "SELECT id FROM tarefa;";

            PreparedStatement ps = c.prepareStatement(query);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");

                lista.add(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
