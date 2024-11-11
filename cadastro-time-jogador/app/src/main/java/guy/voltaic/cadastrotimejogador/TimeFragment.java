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

import guy.voltaic.cadastrotimejogador.controller.TimeController;
import guy.voltaic.cadastrotimejogador.model.Time;
import guy.voltaic.cadastrotimejogador.persistence.TimeDao;

import java.sql.SQLException;
import java.util.List;

/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
public class TimeFragment extends Fragment {

    private EditText editTextCodigo, editTextNome, editTextCidade;
    private Button buttonCadastrar, buttonAtualizar, buttonDeletar, buttonBuscar, buttonListar;
    private TextView textViewResultados;
    private TimeController timeController;

    public TimeFragment() { super(); }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_time, container, false);

        editTextCodigo = view.findViewById(R.id.editTextCodigo);
        editTextNome = view.findViewById(R.id.editTextNome);
        editTextCidade = view.findViewById(R.id.editTextCidade);
        textViewResultados = view.findViewById(R.id.textViewResultados);

        buttonCadastrar = view.findViewById(R.id.buttonCadastrar);
        buttonAtualizar = view.findViewById(R.id.buttonAtualizar);
        buttonDeletar = view.findViewById(R.id.buttonDeletar);
        buttonBuscar = view.findViewById(R.id.buttonBuscar);
        buttonListar = view.findViewById(R.id.buttonListar);

        timeController = new TimeController(new TimeDao(view.getContext()));

        buttonCadastrar.setOnClickListener(op -> cadastrarTime());
        buttonAtualizar.setOnClickListener(op -> atualizarTime());
        buttonDeletar.setOnClickListener(op -> deletarTime());
        buttonBuscar.setOnClickListener(op -> buscarTime());
        buttonListar.setOnClickListener(op -> listarTimes());

        return view;
    }

    private void cadastrarTime() {
        try {
            Time time = criarTime();
            timeController.inserir(time);
            mostrarMensagem("Time cadastrado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            mostrarMensagem("Erro ao cadastrar time!");
        }
    }

    private void atualizarTime() {
        try {
            Time time = criarTime();
            timeController.inserir(time);
        } catch (SQLException e) {
            e.printStackTrace();
            mostrarMensagem("Erro ao atualizar time!");
        }
    }

    private void deletarTime() {
        try {
            Time time = criarTime();
            timeController.deletar(time);
            mostrarMensagem("Time deletado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            mostrarMensagem("Erro ao deletar time!");
        }
    }

    private void buscarTime() {
        try {
            Time time = criarTime();
            Time resultado = timeController.procurarUm(time);
            if (resultado != null) {
                textViewResultados.setText(resultado.toString());
            } else {
                mostrarMensagem("Time não encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            mostrarMensagem("Erro ao buscar time!");
        }
    }

    private void listarTimes() {
        try {
            List<Time> times = timeController.procurarTodos();
            StringBuilder resultados = new StringBuilder();
            for (Time time : times) {
                resultados.append(time.toString()).append("\n");
            }
            textViewResultados.setText(resultados.toString());
        } catch (SQLException e) {
            e.printStackTrace();
            mostrarMensagem("Erro ao listar times!");
        }
    }

    private Time criarTime() {
        Time t = new Time();
        t.setCodigo(Integer.parseInt(editTextCodigo.getText().toString()));
        t.setNome(editTextNome.getText().toString());
        t.setCidade(editTextCidade.getText().toString());

        return t;
    }

    private void mostrarMensagem(String mensagem) {
        Toast.makeText(getActivity(), mensagem, Toast.LENGTH_SHORT).show();
    }
}
