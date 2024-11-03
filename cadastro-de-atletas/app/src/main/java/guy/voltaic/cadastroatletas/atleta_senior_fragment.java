package guy.voltaic.cadastroatletas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.List;

import guy.voltaic.cadastroatletas.control.ControleAtletaSenior;
import guy.voltaic.cadastroatletas.model.AtletaSenior;

/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
public class atleta_senior_fragment extends Fragment {

    private EditText nomeInput, nascimentoInput, bairroInput, problemasInput;
    private TextView tvLista;
    private ControleAtletaSenior controleAtletaSenior = new ControleAtletaSenior();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_atleta_senior_fragment, container, false);

        nomeInput = view.findViewById(R.id.editTextNome);
        nascimentoInput = view.findViewById(R.id.editTextNascimento);
        bairroInput = view.findViewById(R.id.editTextBairro);
        problemasInput = view.findViewById(R.id.editTextProblemasCardiacos);
        tvLista = view.findViewById((R.id.textViewResultado));
        Button cadastrarButton = view.findViewById(R.id.buttonCadastrar);

        cadastrarButton.setOnClickListener(v -> {
            AtletaSenior atleta = new AtletaSenior();
            atleta.setNome(nomeInput.getText().toString());
            atleta.setDataNascimento(nascimentoInput.getText().toString());
            atleta.setBairro(bairroInput.getText().toString());
            atleta.setTemProblemasCardiacos(problemasInput.getText().toString());

            controleAtletaSenior.cadastrar(atleta);

            List<AtletaSenior> lista = controleAtletaSenior.listar();
            StringBuffer buffer = new StringBuffer();
            for(AtletaSenior as : lista) {
                buffer.append(as.toString() + "\n");
            }
            tvLista.setText(buffer.toString());

            nomeInput.setText("");
            nascimentoInput.setText("");
            bairroInput.setText("");
            problemasInput.setText("");

            Toast.makeText(view.getContext(), atleta.toString(), Toast.LENGTH_LONG).show();
        });

        return view;
    }
}