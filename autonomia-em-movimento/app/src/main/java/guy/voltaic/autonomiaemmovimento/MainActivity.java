package guy.voltaic.autonomiaemmovimento;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
public class MainActivity extends AppCompatActivity {

    //Declaração de campos de tela
    private EditText etQtdLitros;
    private EditText etConsumoMedio;
    private TextView tvRes;
    private Button bntCalc;

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
        etConsumoMedio = findViewById(R.id.etConsumoMedio);
        etConsumoMedio.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        etQtdLitros = findViewById(R.id.etQtdLitros);
        etQtdLitros.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        tvRes = findViewById(R.id.tvRes);
        tvRes.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        bntCalc = findViewById(R.id.bntCalc);
        bntCalc.setOnClickListener(op -> calc());
    }


    /*
     *@author:<Robison>
     *@ra:<1110482313007>
     */
    private void calc() {

        //Coletar valores das TextView
        double qtdLitros = Double.parseDouble(etQtdLitros.getText().toString());
        double consumoMedio = Double.parseDouble((etConsumoMedio.getText().toString()));

        //calcular consumo médio
        double metros = (qtdLitros / consumoMedio) * 1000;

        //manda resposta pro TextView
        tvRes.setText("Quantidade de metros restante: " + metros);

        //limpar EditText
        etQtdLitros.setText("");
        etConsumoMedio.setText("");
    }
}