package guy.voltaic.areatrapezio;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //Declaração de campos de tela
    private EditText etBaseMaior;
    private EditText etBaseMenor;
    private EditText etAltura;
    private TextView tvArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Capturar entrada de dados dos usuários
        etBaseMaior = findViewById(R.id.etBaseMaior);
        etBaseMaior.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etBaseMenor = findViewById(R.id.etBaseMenor);
        etBaseMenor.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etAltura = findViewById(R.id.etAltura);
        etAltura.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tvArea = findViewById(R.id.tvArea);
        tvArea.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        Button btnCalc = findViewById(R.id.bntCalc);
        btnCalc.setOnClickListener(op -> calc());

    }

    private void calc() {

        //Coletar valores das Text Label
        int baseMaior = Integer.parseInt(etBaseMaior.getText().toString());
        int baseMenor = Integer.parseInt(etBaseMenor.getText().toString());
        int altura = Integer.parseInt(etAltura.getText().toString());

        //Calcular área do trapézio
        int area = ((baseMaior + baseMenor) * altura) / 2;

        //Envia texto pros Text View
        String res = getString(R.string.area) + " " + area + "²";
        tvArea.setText(res);

        //Limpar texto das labels
        etBaseMaior.setText("");
        etBaseMenor.setText("");
        etAltura.setText("");
    }
}