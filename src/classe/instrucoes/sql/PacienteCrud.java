package classe.instrucoes.sql;

import classe.modell.Conexao;
import java.sql.Connection;
import classe.modell.PacienteClinica;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PacienteCrud {

    Conexao conexao = new Conexao();
    Connection conex = conexao.criarConexao();

    public int salvarUsuario(PacienteClinica paciente) {
        String sqlInsert = "insert"
                + "into"
                + "tb_paciente(nome, cpf, endereco, rg, sexo, telefone, medico_responsavel,data_nascimento)"
                + "values(?,?,?,?,?,?,?,?)";

        try {

            PreparedStatement preparacaoSalvar = conex.prepareStatement(sqlInsert);
            preparacaoSalvar.setString(1, paciente.getNome());
            preparacaoSalvar.setString(2, paciente.getCpf());
            preparacaoSalvar.setString(3, paciente.getEndereco());
            preparacaoSalvar.setString(4, paciente.getRg());
            preparacaoSalvar.setString(5, paciente.getSexo());
            preparacaoSalvar.setString(6, paciente.getTelefone());
            preparacaoSalvar.setString(7, paciente.getMedicoResponsavel());
            preparacaoSalvar.setString(8, paciente.getDataNascimento());
        } catch (SQLException ex) {
            Logger.getLogger(PacienteCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public List<PacienteClinica> listarPaciente() {
        String sqlSelect = "select"
                + "from tb_paciente";
        List<PacienteClinica> listaDePaciente = new ArrayList<PacienteClinica>();
        try {

            PreparedStatement preparacaoSelect = conex.prepareStatement(sqlSelect);
            ResultSet resultadoLista = preparacaoSelect.executeQuery();

            while (resultadoLista.next()) {
                PacienteClinica paciente = new PacienteClinica();
                paciente.setIdPaciente(resultadoLista.getInt("id_paciente"));
                paciente.setNome(resultadoLista.getString("nome"));
                paciente.setCpf(resultadoLista.getString("cpf"));
                paciente.setEndereco(resultadoLista.getString("endereco"));
                paciente.setRg(resultadoLista.getString("rg"));
                paciente.setSexo(resultadoLista.getString("sexo"));
                paciente.setTelefone(resultadoLista.getString("telefone"));
                paciente.setMedicoResponsavel(resultadoLista.getString("medico_responsavel"));
                paciente.setDataNascimento(resultadoLista.getString("data_nascimento"));

                listaDePaciente.add(paciente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PacienteCrud.class.getName()).log(Level.SEVERE, null, ex);

            return null;

        }
        return listaDePaciente;
    }

    public void atualizarPerfil(PacienteClinica paciente) {
        String sqlUpdate = "update tb_paciente "
                + "set nome = ?, cpf = ?, endereco = ?, rg = ?, sexo = ?, telefone = ?, medico_responsavel = ?, data_nascimento = ? "
                + "where id_paciente = ? ";
        try {

            PreparedStatement preparacaoUpdate = conex.prepareStatement(sqlUpdate);
            preparacaoUpdate.setString(1, paciente.getNome());
            preparacaoUpdate.setString(2, paciente.getCpf());
            preparacaoUpdate.setString(3, paciente.getEndereco());
            preparacaoUpdate.setString(4, paciente.getRg());
            preparacaoUpdate.setString(5, paciente.getSexo());
            preparacaoUpdate.setString(6, paciente.getTelefone());
            preparacaoUpdate.setString(7, paciente.getMedicoResponsavel());
            preparacaoUpdate.setString(8, paciente.getDataNascimento());
            preparacaoUpdate.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PacienteCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ExcluirPaciente(PacienteClinica paciente) {
        String sqlDelete = "delete from convenio"
                + " where id_paciente = ?;"
                + "delete from consulta"
                + "where id_paciente = ?;"
                + "delete from paciente"
                + "where id_paciente = ?;";

        try {
            PreparedStatement preparacaoDelete = conex.prepareStatement(sqlDelete);
            preparacaoDelete.setInt(1, paciente.getIdPaciente());
            preparacaoDelete.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PacienteCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
