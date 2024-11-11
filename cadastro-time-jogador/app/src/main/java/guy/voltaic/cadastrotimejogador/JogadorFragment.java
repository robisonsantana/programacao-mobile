package guy.voltaic.cadastrotimejogador;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import guy.voltaic.cadastrotimejogador.controller.JogadorController;
import guy.voltaic.cadastrotimejogador.model.Jogador;
import guy.voltaic.cadastrotimejogador.persistence.JogadorDao;

import java.sql.SQLException;
import java.util.List;


/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
public class JogadorFragment extends Fragment {

    private EditText editTextId, editTextNome, editTextDataNasc, editTextAltura, editTextPeso, editTextTime;
    private Button buttonCadastrar, buttonAtualizar, buttonDeletar, buttonBuscar, buttonListar;
    private TextView textViewResultados;
    private JogadorController jogadorController;

    public JogadorFragment() { super(); }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jogador, container, false);

        editTextId = view.findViewById(R.id.editTextId);
        editTextNome = view.findViewById(R.id.editTextNome);
        editTextDataNasc = view.findViewById(R.id.editTextDataNasc);
        editTextAltura = view.findViewById(R.id.editTextAltura);
        editTextPeso = view.findViewById(R.id.editTextPeso);
        editTextTime = view.findViewById(R.id.editTextTime);
        textViewResultados = view.findViewById(R.id.textViewResultados);

        jogadorController = new JogadorController(new JogadorDao(view.getContext()));

        buttonCadastrar = view.findViewById(R.id.buttonCadastrar);
        buttonAtualizar = view.findViewById(R.id.buttonAtualizar);
        buttonDeletar = view.findViewById(R.id.buttonDeletar);
        buttonBuscar = view.findViewById(R.id.buttonBuscar);
        buttonListar = view.findViewById(R.id.buttonListar);

        buttonCadastrar.setOnClickListener(op -> cadastrarJogador());
        buttonAtualizar.setOnClickListener(op -> atualizarJogador());
        buttonDeletar.setOnClickListener(op -> deletarJogador());
        buttonBuscar.setOnClickListener(op -> buscarJogador());
        buttonListar.setOnClickListener(op -> listarJogadores());

        return view;
    }

    private void cadastrarJogador() {
        try {
            Jogador jogador = criarJogador();
            jogadorController.inserir(jogador);
            mostrarMensagem("Jogador cadastrado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            mostrarMensagem("Erro ao cadastrar jogador!");
        }
    }

    private void atualizarJogador() {
        try {
            Jogador jogador = criarJogador();
            jogadorController.atualizar(jogador);
        } catch (SQLException e) {
            e.printStackTrace();
            mostrarMensagem("Erro ao atualizar jogador!");
        }
    }

    private void deletarJogador() {
        try {
            Jogador jogador = criarJogador();
            jogadorController.deletar(jogador);
            mostrarMensagem("Jogador deletado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            mostrarMensagem("Erro ao deletar jogador!");
        }
    }

    private void buscarJogador() {
        try {
            Jogador jogador = criarJogador();
            Jogador resultado = jogadorController.procurarUm(jogador);
            if (resultado != null) {
                textViewResultados.setText(resultado.toString());
            } else {
                mostrarMensagem("Jogador não encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            mostrarMensagem("Erro ao buscar jogador!");
        }
    }

    private void listarJogadores() {
        try {
            List<Jogador> jogadores = jogadorController.procurarTodos();
            StringBuilder resultados = new StringBuilder();
            for (Jogador jogador : jogadores) {
                resultados.append(jogador.toString()).append("\n");
            }
            textViewResultados.setText(resultados.toString());
        } catch (SQLException e) {
            e.printStackTrace();
            mostrarMensagem("Erro ao listar jogadores!");
        }
    }

    private Jogador criarJogador() {
        Jogador j = new Jogador();
        j.setId(Integer.parseInt(editTextId.getText().toString()));
        j.setNome(editTextNome.getText().toString());
        j.setDataNasc(editTextDataNasc.getText().toString());
        j.setAltura(Float.parseFloat(editTextAltura.getText().toString()));
        j.setPeso(Float.parseFloat(editTextPeso.getText().toString()));
        j.setTime(editTextTime.getText().toString());

        return j;
    }

    private void mostrarMensagem(String mensagem) {
        Toast.makeText(getActivity(), mensagem, Toast.LENGTH_SHORT).show();
    }
}