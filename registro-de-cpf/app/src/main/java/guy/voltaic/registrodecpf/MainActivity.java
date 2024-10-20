package guy.voltaic.registrodecpf;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etCpf;
    private EditText etNome;
    private Button bntEnviar;
    
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

        etCpf = findViewById(R.id.etCpf);
        etNome = findViewById(R.id.etNome);
        bntEnviar = findViewById(R.id.bntEnviar);

        bntEnviar.setOnClickListener(v -> {
            String cpf = etCpf.getText().toString();
            String nome = etNome.getText().toString();

            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("cpf", cpf);
            intent.putExtra("nome", nome);
            startActivity(intent);
        });

    }
}