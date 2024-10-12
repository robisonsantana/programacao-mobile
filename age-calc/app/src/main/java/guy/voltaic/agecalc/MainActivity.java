package guy.voltaic.agecalc;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
public class MainActivity extends AppCompatActivity {

    private EditText etAno, etMes, etDia;
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

        etAno = findViewById(R.id.etAno);
        etAno.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        etDia = findViewById(R.id.etDia);
        etDia.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        etMes = findViewById(R.id.etMes);
        etMes.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
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
        int dia = Integer.parseInt(etDia.getText().toString());
        int mes = Integer.parseInt(etMes.getText().toString());
        int ano = Integer.parseInt(etAno.getText().toString());

        Calendar dataAtual = Calendar.getInstance();
        int anoAtual = dataAtual.get(Calendar.YEAR);
        int mesAtual = dataAtual.get(Calendar.MONTH) + 1;
        int diaAtual = dataAtual.get(Calendar.DAY_OF_MONTH);

        int idadeAnos = anoAtual - ano;
        int idadeMeses = mesAtual - mes;
        int idadeDias = diaAtual - dia;

        if (idadeMeses < 0) {
            idadeAnos--;
            idadeMeses += 12;
        }

        if (idadeDias < 0) {
            idadeMeses--;
            Calendar ultimoMes = Calendar.getInstance();
            ultimoMes.set(anoAtual, mesAtual - 2, 1);
            int diasNoUltimoMes = ultimoMes.getActualMaximum(Calendar.DAY_OF_MONTH);
            idadeDias += diasNoUltimoMes;
        }

        String resultadoTexto = "Idade: " + idadeAnos + " anos, " + idadeMeses + " meses, e " + idadeDias + " dias.";
        tvRes.setText(resultadoTexto);

        etAno.setText("");
        etMes.setText("");
        etDia.setText("");
    }

    private boolean isAnoBissexto(int ano) {
        if (ano % 4 == 0) {
            if (ano % 100 == 0) {
                return ano % 400 == 0;
            } else {
                return true;
            }
        }
        return false;
    }
}