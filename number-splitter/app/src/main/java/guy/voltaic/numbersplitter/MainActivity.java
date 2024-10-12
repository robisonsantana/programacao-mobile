package guy.voltaic.numbersplitter;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

    private EditText etNum;
    private TextView tvUni, tvDez, tvCen;
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

        etNum = findViewById(R.id.etNum);
        etNum.setText(View.TEXT_ALIGNMENT_CENTER);
        tvUni = findViewById(R.id.tvUni);
        tvUni.setText(View.TEXT_ALIGNMENT_CENTER);
        tvDez = findViewById(R.id.tvDez);
        tvDez.setText(View.TEXT_ALIGNMENT_CENTER);
        tvCen = findViewById(R.id.tvCen);
        tvCen.setText(View.TEXT_ALIGNMENT_CENTER);
        bntCalc = findViewById(R.id.bntCalc);
        bntCalc.setOnClickListener(op -> calc());
    }

    /*
     *@author:<Robison>
     *@ra:<1110482313007>
     */
    private void calc() {

        String numeroTexto = etNum.getText().toString();

        if (TextUtils.isEmpty(numeroTexto)) {
            Toast.makeText(this, "Por favor, insira um número.", Toast.LENGTH_SHORT).show();
            return;
        }

        int num = Integer.parseInt(etNum.getText().toString());

        if (num < 100 || num > 999) {
            Toast.makeText(this, "O número deve estar entre 100 e 999.", Toast.LENGTH_SHORT).show();
            return;
        }

        int centena = num / 100;
        int dezena = (num % 100) / 10;
        int unidade = num % 10;

        String uni = getString(R.string.uni) + " " + unidade;
        String dez = getString(R.string.dez) + " " + dezena;
        String cen = getString(R.string.cent) + " " + centena;

        tvUni.setText(uni);
        tvDez.setText(dez);
        tvCen.setText(cen);

        etNum.setText("");

    }
}