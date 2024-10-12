package guy.voltaic.dicerollerpro;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
public class MainActivity extends AppCompatActivity {

    private RadioButton rb1, rb2, rb3;
    private Spinner spTipoDado;
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

        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        spTipoDado = findViewById(R.id.spTipoDado);
        tvRes = findViewById(R.id.tvRes);
        bntCalc = findViewById(R.id.bntCalc);

        preencherSpinner();
        bntCalc.setOnClickListener(op -> calc());
    }

    /*
     *@author:<Robison>
     *@ra:<1110482313007>
     */
    private void calc() {
        Integer qtd = (Integer) spTipoDado.getSelectedItem();

        Random random = new Random();
        StringBuilder result = new StringBuilder();

        if (rb1.isChecked()) {
            if (qtd == 4) {
                int roll = random.nextInt(4) + 1;
                result.append("Dado 1 (D4): ").append(roll).append("\n");
            } else if (qtd == 6) {
                int roll = random.nextInt(6) + 1;
                result.append("Dado 1 (D6): ").append(roll).append("\n");
            } else if (qtd == 8) {
                int roll = random.nextInt(8) + 1;
                result.append("Dado 1 (D8): ").append(roll).append("\n");
            } else if (qtd == 10) {
                int roll = random.nextInt(10) + 1;
                result.append("Dado 1 (D10): ").append(roll).append("\n");
            } else if (qtd == 12) {
                int roll = random.nextInt(12) + 1;
                result.append("Dado 1 (D12): ").append(roll).append("\n");
            } else if (qtd == 20) {
                int roll = random.nextInt(20) + 1;
                result.append("Dado 1 (D20): ").append(roll).append("\n");
            } else if (qtd == 100) {
                int roll = random.nextInt(100) + 1;
                result.append("Dado 1 (D100): ").append(roll).append("\n");
            }
        } else if (rb2.isChecked()) {
            if (qtd == 4) {
                int roll1 = random.nextInt(4) + 1;
                int roll2 = random.nextInt(4) + 1;
                result.append("Dado 1 (D4): ").append(roll1).append("\n");
                result.append("Dado 2 (D4): ").append(roll2).append("\n");
            } else if (qtd == 6) {
                int roll1 = random.nextInt(6) + 1;
                int roll2 = random.nextInt(6) + 1;
                result.append("Dado 1 (D6): ").append(roll1).append("\n");
                result.append("Dado 2 (D6): ").append(roll2).append("\n");
            } else if (qtd == 8) {
                int roll1 = random.nextInt(8) + 1;
                int roll2 = random.nextInt(8) + 1;
                result.append("Dado 1 (D8): ").append(roll1).append("\n");
                result.append("Dado 2 (D8): ").append(roll2).append("\n");
            } else if (qtd == 10) {
                int roll1 = random.nextInt(10) + 1;
                int roll2 = random.nextInt(10) + 1;
                result.append("Dado 1 (D10): ").append(roll1).append("\n");
                result.append("Dado 2 (D10): ").append(roll2).append("\n");
            } else if (qtd == 12) {
                int roll1 = random.nextInt(12) + 1;
                int roll2 = random.nextInt(12) + 1;
                result.append("Dado 1 (D12): ").append(roll1).append("\n");
                result.append("Dado 2 (D12): ").append(roll2).append("\n");
            } else if (qtd == 20) {
                int roll1 = random.nextInt(20) + 1;
                int roll2 = random.nextInt(20) + 1;
                result.append("Dado 1 (D20): ").append(roll1).append("\n");
                result.append("Dado 2 (D20): ").append(roll2).append("\n");
            } else if (qtd == 100) {
                int roll1 = random.nextInt(100) + 1;
                int roll2 = random.nextInt(100) + 1;
                result.append("Dado 1 (D100): ").append(roll1).append("\n");
                result.append("Dado 2 (D100): ").append(roll2).append("\n");
            }
        } else if (rb3.isChecked()) {
            if (qtd == 4) {
                int roll1 = random.nextInt(4) + 1;
                int roll2 = random.nextInt(4) + 1;
                int roll3 = random.nextInt(4) + 1;
                result.append("Dado 1 (D4): ").append(roll1).append("\n");
                result.append("Dado 2 (D4): ").append(roll2).append("\n");
                result.append("Dado 3 (D4): ").append(roll3).append("\n");
            } else if (qtd == 6) {
                int roll1 = random.nextInt(6) + 1;
                int roll2 = random.nextInt(6) + 1;
                int roll3 = random.nextInt(6) + 1;
                result.append("Dado 1 (D6): ").append(roll1).append("\n");
                result.append("Dado 2 (D6): ").append(roll2).append("\n");
                result.append("Dado 3 (D6): ").append(roll3).append("\n");
            } else if (qtd == 8) {
                int roll1 = random.nextInt(8) + 1;
                int roll2 = random.nextInt(8) + 1;
                int roll3 = random.nextInt(8) + 1;
                result.append("Dado 1 (D8): ").append(roll1).append("\n");
                result.append("Dado 2 (D8): ").append(roll2).append("\n");
                result.append("Dado 3 (D8): ").append(roll3).append("\n");
            } else if (qtd == 10) {
                int roll1 = random.nextInt(10) + 1;
                int roll2 = random.nextInt(10) + 1;
                int roll3 = random.nextInt(10) + 1;
                result.append("Dado 1 (D10): ").append(roll1).append("\n");
                result.append("Dado 2 (D10): ").append(roll2).append("\n");
                result.append("Dado 3 (D10): ").append(roll3).append("\n");
            } else if (qtd == 12) {
                int roll1 = random.nextInt(12) + 1;
                int roll2 = random.nextInt(12) + 1;
                int roll3 = random.nextInt(12) + 1;
                result.append("Dado 1 (D12): ").append(roll1).append("\n");
                result.append("Dado 2 (D12): ").append(roll2).append("\n");
                result.append("Dado 3 (D12): ").append(roll3).append("\n");
            } else if (qtd == 20) {
                int roll1 = random.nextInt(20) + 1;
                int roll2 = random.nextInt(20) + 1;
                int roll3 = random.nextInt(20) + 1;
                result.append("Dado 1 (D20): ").append(roll1).append("\n");
                result.append("Dado 2 (D20): ").append(roll2).append("\n");
                result.append("Dado 3 (D20): ").append(roll3).append("\n");
            } else if (qtd == 100) {
                int roll1 = random.nextInt(100) + 1;
                int roll2 = random.nextInt(100) + 1;
                int roll3 = random.nextInt(100) + 1;
                result.append("Dado 1 (D100): ").append(roll1).append("\n");
                result.append("Dado 2 (D100): ").append(roll2).append("\n");
                result.append("Dado 3 (D100): ").append(roll3).append("\n");
            }
        }

        tvRes.setText(result.toString());
    }

    /*
     *@author:<Robison>
     *@ra:<1110482313007>
     */
    private void preencherSpinner() {
        List<Integer> lista = new ArrayList<>();
        lista.add(4);
        lista.add(6);
        lista.add(8);
        lista.add(10);
        lista.add(12);
        lista.add(20);
        lista.add(100);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, lista);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTipoDado.setAdapter(adapter);
    }
}