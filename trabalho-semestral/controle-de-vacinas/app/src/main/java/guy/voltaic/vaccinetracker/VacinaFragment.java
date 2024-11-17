package guy.voltaic.vaccinetracker;

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

import java.sql.SQLException;
import java.util.List;

import guy.voltaic.vaccinetracker.controller.VacinaController;
import guy.voltaic.vaccinetracker.model.Vacina;
import guy.voltaic.vaccinetracker.model.VacinaAdulto;
import guy.voltaic.vaccinetracker.model.VacinaInfantil;
import guy.voltaic.vaccinetracker.persistence.DatabaseHelper;
import guy.voltaic.vaccinetracker.persistence.VacinaDao;

/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
public class VacinaFragment extends Fragment {

    private EditText edtNome, edtDataAplicacao, edtLote, edtResponsavel, edtId, edtExtra;
    private Button btnCadastrar, btnAtualizar, btnDeletar, btnProcurar, btnListar;
    private TextView txtResultados;
    private VacinaController vacinaController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vacina, container, false);

        edtNome = view.findViewById(R.id.edtNome);
        edtDataAplicacao = view.findViewById(R.id.edtDataAplicacao);
        edtLote = view.findViewById(R.id.edtLote);
        edtResponsavel = view.findViewById(R.id.edtResponsavel);
        edtId = view.findViewById(R.id.edtId);
        edtExtra = view.findViewById(R.id.edtExtra);

        btnCadastrar = view.findViewById(R.id.btnCadastrar);
        btnAtualizar = view.findViewById(R.id.btnAtualizar);
        btnDeletar = view.findViewById(R.id.btnDeletar);
        btnProcurar = view.findViewById(R.id.btnProcurar);
        btnListar = view.findViewById(R.id.btnListar);

        txtResultados = view.findViewById(R.id.txtResultados);

        DatabaseHelper dbHelper = new DatabaseHelper(getContext());
        vacinaController = new VacinaController(new VacinaDao(dbHelper.getWritableDatabase()));

        btnCadastrar.setOnClickListener(op -> cadastrarVacina());
        btnAtualizar.setOnClickListener(op -> atualizarVacina());
        btnDeletar.setOnClickListener(op -> deletarVacina());
        btnProcurar.setOnClickListener(op -> procurarVacina());
        btnListar.setOnClickListener(op -> listarVacinas());

        return view;
    }

    private void cadastrarVacina() {
        try {
            String nome = edtNome.getText().toString();
            String dataAplicacao = edtDataAplicacao.getText().toString();
            String lote = edtLote.getText().toString();
            String responsavel = edtResponsavel.getText().toString();
            String extra = edtExtra.getText().toString();

            Vacina vacina;
            if (extra.isEmpty()) {
                vacina = new VacinaAdulto();
                ((VacinaAdulto) vacina).setNecessitaReforco(false);
            } else {
                vacina = new VacinaInfantil();
                ((VacinaInfantil) vacina).setIdadeAplicacao(Integer.parseInt(extra));
            }

            vacina.setNome(nome);
            vacina.setDataAplicacao(dataAplicacao);
            vacina.setLote(lote);
            vacina.setResponsavelAplicacao(responsavel);

            vacinaController.inserir(vacina);
            Toast.makeText(getContext(), "Vacina cadastrada com sucesso!", Toast.LENGTH_SHORT).show();
            limparCampos();
        } catch (Exception e) {
            Toast.makeText(getContext(), "Erro ao cadastrar vacina: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void atualizarVacina() {
        try {
            int id = Integer.parseInt(edtId.getText().toString());
            Vacina vacina = vacinaController.procurarUm(id);
            if (vacina == null) {
                Toast.makeText(getContext(), "Vacina não encontrada!", Toast.LENGTH_SHORT).show();
                return;
            }

            vacina.setNome(edtNome.getText().toString());
            vacina.setDataAplicacao(edtDataAplicacao.getText().toString());
            vacina.setLote(edtLote.getText().toString());
            vacina.setResponsavelAplicacao(edtResponsavel.getText().toString());

            vacinaController.atualizar(vacina);
            Toast.makeText(getContext(), "Vacina atualizada com sucesso!", Toast.LENGTH_SHORT).show();
            limparCampos();
        } catch (Exception e) {
            Toast.makeText(getContext(), "Erro ao atualizar vacina: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void deletarVacina() {
        try {
            int id = Integer.parseInt(edtId.getText().toString());
            Vacina vacina = vacinaController.procurarUm(id);
            if (vacina == null) {
                Toast.makeText(getContext(), "Vacina não encontrada!", Toast.LENGTH_SHORT).show();
                return;
            }

            vacinaController.deletar(vacina);
            Toast.makeText(getContext(), "Vacina deletada com sucesso!", Toast.LENGTH_SHORT).show();
            limparCampos();
        } catch (Exception e) {
            Toast.makeText(getContext(), "Erro ao deletar vacina: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void procurarVacina() {
        try {
            int id = Integer.parseInt(edtId.getText().toString());
            Vacina vacina = vacinaController.procurarUm(id);
            if (vacina == null) {
                txtResultados.setText("Vacina não encontrada!");
            } else {
                txtResultados.setText(vacina.toString());
            }
        } catch (Exception e) {
            Toast.makeText(getContext(), "Erro ao procurar vacina: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void listarVacinas() {
        try {
            List<Vacina> vacinas = vacinaController.procurarTodos();
            StringBuilder resultado = new StringBuilder();
            for (Vacina vacina : vacinas) {
                resultado.append(vacina).append("\n");
            }
            txtResultados.setText(resultado.toString());
        } catch (SQLException e) {
            Toast.makeText(getContext(), "Erro ao listar vacinas: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void limparCampos() {
        edtNome.setText("");
        edtDataAplicacao.setText("");
        edtLote.setText("");
        edtResponsavel.setText("");
        edtId.setText("");
        edtExtra.setText("");
    }
}



