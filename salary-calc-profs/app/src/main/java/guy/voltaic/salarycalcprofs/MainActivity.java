package guy.voltaic.salarycalcprofs;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.math.BigDecimal;
import java.math.RoundingMode;

import guy.voltaic.salarycalcprofs.model.Professor;
import guy.voltaic.salarycalcprofs.model.ProfessorHoristico;
import guy.voltaic.salarycalcprofs.model.ProfessorTitular;

/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
public class MainActivity extends AppCompatActivity {

    private RadioButton rbProfTitular, rbProfHorista;
    private EditText etAnosHoras;
    private TextView tvRes;
    private Button bntRes;
    private Professor prof;

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

        rbProfHorista = findViewById(R.id.rbProfHorista);
        rbProfTitular = findViewById(R.id.rbProfTitular);
        tvRes = findViewById(R.id.tvRes);
        etAnosHoras = findViewById(R.id.etAnosHoras);
        bntRes = findViewById(R.id.bntCalc);

        bntRes.setOnClickListener(op -> calc());
    }

    /*
     *@author:<Robison>
     *@ra:<1110482313007>
     */
    private void calc() {

        int horasAnos = Integer.parseInt(etAnosHoras.getText().toString());
        if (rbProfTitular.isChecked()) {
            prof = new ProfessorTitular();
        }
        if (rbProfHorista.isChecked()) {
            prof = new ProfessorHoristico();
        }
        double sal = prof.calcSalario(5000, horasAnos);

        tvRes.setText(getString(R.string.rs) + " " + sal);
    }
}