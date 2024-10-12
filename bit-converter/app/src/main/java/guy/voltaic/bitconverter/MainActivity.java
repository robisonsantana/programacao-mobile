package guy.voltaic.bitconverter;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
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

    private EditText etBit;
    private TextView tvRes;
    private Button bntCalc;
    private RadioButton rbBytes, rbKb, rbMb, rbGb, rbTb;

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

        rbBytes = findViewById(R.id.rbBytes);
        rbKb = findViewById(R.id.rbKb);
        rbMb = findViewById(R.id.rbMb);
        rbGb = findViewById(R.id.rbGb);
        rbTb = findViewById(R.id.rbTb);
        etBit = findViewById(R.id.etBit);
        tvRes = findViewById(R.id.tvRes);
        bntCalc = findViewById(R.id.bntCalc);
        bntCalc.setOnClickListener(op -> calc());
    }

    /*
     *@author:<Robison>
     *@ra:<1110482313007>
     */
    private void calc() {
        int bits = Integer.parseInt(etBit.getText().toString());
        double result = 0;
        
        if(rbBytes.isChecked()) {
            result = bits / 8.0;
            tvRes.setText(String.valueOf(result) + "Bytes");
        } else if(rbKb.isChecked()) {
            result = bits / (8.0 * 1024);
            tvRes.setText(String.valueOf(result) + "KB");
        } else if(rbMb.isChecked()) {
            result = bits / (8.0 * 1024 * 1024);
            tvRes.setText(String.valueOf(result) + "MB");
        } else if(rbGb.isChecked()) {
            result = bits / (8.0 * 1024 * 1024 * 1024);
            tvRes.setText(String.valueOf(result) + "GB");
        } else if(rbTb.isChecked()) {
            result = bits / (8.0 * 1024 * 1024 * 1024 * 1024);
            tvRes.setText(String.valueOf(result) + "TB");
        }

        etBit.setText("");
    }
}