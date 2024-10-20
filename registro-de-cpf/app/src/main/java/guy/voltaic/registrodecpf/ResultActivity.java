package guy.voltaic.registrodecpf;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {

    private TextView tvLocalRegistro;
    private Button bntVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvLocalRegistro = findViewById(R.id.tvLocalRegistro);
        bntVoltar = findViewById(R.id.bntVoltar);

        Intent intent = getIntent();
        String cpf = intent.getStringExtra("cpf");

        String localRegistro = getLocalRegistro(cpf);
        tvLocalRegistro.setText(localRegistro);

        bntVoltar.setOnClickListener(v -> {
            Intent voltarIntent = new Intent(ResultActivity.this, MainActivity.class);
            voltarIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(voltarIntent);
        });
    }

    private String getLocalRegistro(String cpf) {
        if (cpf != null && cpf.length() >= 9) {
            char digito = cpf.charAt(8);
            switch (digito) {
                case '1': return "Distrito Federal, Goiás, Mato Grosso, Mato Grosso do Sul e Tocantins";
                case '2': return "Pará, Amazonas, Acre, Amapá, Rondônia e Roraima";
                case '3': return "Ceará, Maranhão e Piauí";
                case '4': return "Pernambuco, Rio Grande do Norte, Paraíba e Alagoas";
                case '5': return "Bahia e Sergipe";
                case '6': return "Minas Gerais";
                case '7': return "Rio de Janeiro e Espírito Santo";
                case '8': return "São Paulo";
                case '9': return "Paraná e Santa Catarina";
                case '0': return "Rio Grande do Sul";
                default: return "Local de registro desconhecido";
            }
        } else {
            return "CPF inválido";
        }
    }
}