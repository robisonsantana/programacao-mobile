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

import guy.voltaic.cadastroatletas.control.ControleAtletaJuvenil;
import guy.voltaic.cadastroatletas.model.AtletaJuvenil;

public class atleta_juvenil_fragment extends Fragment {

    private EditText nomeInput, nascimentoInput, bairroInput, anosPraticaInput;
    private TextView tvLista;
    private ControleAtletaJuvenil controleAtletaJuvenil = new ControleAtletaJuvenil();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_atleta_juvenil, container, false);

        nomeInput = view.findViewById(R.id.editTextNome);
        nascimentoInput = view.findViewById(R.id.editTextNascimento);
        bairroInput = view.findViewById(R.id.editTextBairro);
        anosPraticaInput = view.findViewById(R.id.editTextAnosPratica);
        tvLista = view.findViewById(R.id.textViewResultados);
        Button cadastrarButton = view.findViewById(R.id.buttonCadastrar);

        cadastrarButton.setOnClickListener(v -> {
            AtletaJuvenil atleta = new AtletaJuvenil();
            atleta.setNome(nomeInput.getText().toString());
            atleta.setDataNascimento(nascimentoInput.getText().toString());
            atleta.setBairro(bairroInput.getText().toString());
            atleta.setAnosDePratica(Integer.parseInt(anosPraticaInput.getText().toString()));

            controleAtletaJuvenil.cadastrar(atleta);

            List<AtletaJuvenil> lista = controleAtletaJuvenil.listar();
            StringBuffer buffer = new StringBuffer();
            for(AtletaJuvenil aj : lista) {
                buffer.append(aj.toString() + "\n");
            }
            tvLista.setText(buffer.toString());

            nomeInput.setText("");
            nascimentoInput.setText("");
            bairroInput.setText("");
            anosPraticaInput.setText("");

            Toast.makeText(view.getContext(), atleta.toString(), Toast.LENGTH_LONG).show();
        });

        return view;
    }
}
