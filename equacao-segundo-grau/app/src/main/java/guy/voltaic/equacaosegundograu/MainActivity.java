package guy.voltaic.equacaosegundograu;

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
    private EditText editTextValorA;
    private EditText editTextValorB;
    private EditText editTextValorC;
    private TextView textViewX1;
    private TextView textViewX2;

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
        editTextValorA = findViewById(R.id.editTextValorA);
        editTextValorA.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        editTextValorB = findViewById(R.id.editTextValorB);
        editTextValorB.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        editTextValorC = findViewById(R.id.editTextValorC);
        editTextValorC.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        textViewX1 = findViewById(R.id.textViewX1);
        textViewX1.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        textViewX2 = findViewById(R.id.textViewX2);
        textViewX2.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        Button buttonCalc = findViewById(R.id.buttonCalc);

        buttonCalc.setOnClickListener(op -> calc());
    }

    /*
     *@author:<Robison>
     *@ra:<1110482313007>
     */
    private void calc() {

        //Limpar Text Views
        textViewX1.setText("");
        textViewX2.setText("");

        //Coletar valores das Text Label
        double a = Double.parseDouble(editTextValorA.getText().toString());
        double b = Double.parseDouble(editTextValorB.getText().toString());
        double c = Double.parseDouble(editTextValorC.getText().toString());

        //Fazer a função de segundo grau
        double delta = Math.pow(b, 2) - 4 * a * c;
        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
        double x2 = (-b - Math.sqrt(delta)) / (2 * a);

        //enviar texto pros Text View
        if(delta < 0) {
            String resD0 = "A equação não tem raizes reais, delta < 0";
            textViewX1.setText(resD0);
        } else {
            String resX1 = getString(R.string.x1) + " " + x1;
            String resX2 = getString(R.string.x2) + " " + x2;
            textViewX1.setText(resX1);
            textViewX2.setText(resX2);
        }

        //Limpar textos das labels
        editTextValorA.setText("");
        editTextValorB.setText("");
        editTextValorC.setText("");
    }
}