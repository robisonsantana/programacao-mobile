package guy.voltaic.conbustivelinteligente;

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
    private EditText etPrecoGasolina;
    private EditText etPrecoEtanol;
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
        etPrecoGasolina = findViewById(R.id.etPrecoGasolina);
        etPrecoGasolina.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        etPrecoEtanol = findViewById(R.id.etPrecoEtanol);
        etPrecoEtanol.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
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

        //Coletar valores das labels
        double gasolina = Double.parseDouble(etPrecoGasolina.getText().toString());
        double etanol = Double.parseDouble(etPrecoEtanol.getText().toString());

        //Comparar preços dos combustíveis
        if(etanol/gasolina <= 0.70) {
            String res = "A etanol vale mais a pena representando " + (etanol/gasolina)*100 + "% do valor da gasolina";
            tvRes.setText(res);
        } else {
            String res = "A gasolina vale mais a pena representando apenas " + ((gasolina/etanol)-1)*100 + "% acima do valor do etanol";
            tvRes.setText(res);
        }

        //Limpar edit texts
        etPrecoGasolina.setText("");
        etPrecoEtanol.setText("");

    }
}