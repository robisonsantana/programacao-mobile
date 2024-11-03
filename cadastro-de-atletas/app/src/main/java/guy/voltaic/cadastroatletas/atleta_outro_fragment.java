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

import guy.voltaic.cadastroatletas.control.ControleAtletaOutro;
import guy.voltaic.cadastroatletas.model.AtletaOutro;

public class atleta_outro_fragment extends Fragment {

    private EditText nomeInput, nascimentoInput, bairroInput, academiaInput, recordInput;
    private TextView tvLista;
    private ControleAtletaOutro controleAtletaOutro = new ControleAtletaOutro();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_atleta_outro, container, false);

        nomeInput = view.findViewById(R.id.editTextNome);
        nascimentoInput = view.findViewById(R.id.editTextNascimento);
        bairroInput = view.findViewById(R.id.editTextBairro);
        academiaInput = view.findViewById(R.id.editTextAcademia);
        recordInput = view.findViewById(R.id.editTextRecorde);
        tvLista = view.findViewById(R.id.textViewResultado);
        Button cadastrarButton = view.findViewById(R.id.buttonCadastrar);

        cadastrarButton.setOnClickListener(v -> {
            AtletaOutro atleta = new AtletaOutro();
            atleta.setNome(nomeInput.getText().toString());
            atleta.setDataNascimento(nascimentoInput.getText().toString());
            atleta.setBairro(bairroInput.getText().toString());
            atleta.setAcademia(academiaInput.getText().toString());
            atleta.setRecordeSegundos(recordInput.getText().toString());

            controleAtletaOutro.cadastrar(atleta);

            List<AtletaOutro> lista = controleAtletaOutro.listar();
            StringBuffer buffer = new StringBuffer();
            for(AtletaOutro ao : lista) {
                buffer.append(ao.toString() + "\n");
            }
            tvLista.setText(buffer.toString());

            nomeInput.setText("");
            nascimentoInput.setText("");
            bairroInput.setText("");
            recordInput.setText("");

            Toast.makeText(view.getContext(), atleta.toString(), Toast.LENGTH_LONG).show();
        });

        return view;
    }
}