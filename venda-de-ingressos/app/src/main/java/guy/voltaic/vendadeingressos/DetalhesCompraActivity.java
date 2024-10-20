package guy.voltaic.vendadeingressos;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
public class DetalhesCompraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detalhes_compra);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView detalhesCompra = findViewById(R.id.detalhesCompra);
        Button voltarButton = findViewById(R.id.voltarButton);

        Intent intent = getIntent();
        String tipoIngresso = intent.getStringExtra("tipoIngresso");
        String codigo = intent.getStringExtra("codigo");
        float valorFinal = intent.getFloatExtra("valorFinal", 0);
        String funcao = intent.getStringExtra("funcao");

        if ("VIP".equals(tipoIngresso)) {
            detalhesCompra.setText("Ingresso VIP\n" +
                    "Código: " + codigo + "\n" +
                    "Função: " + funcao + "\n" +
                    "Valor Final: R$ " + valorFinal);
        } else {
            detalhesCompra.setText("Ingresso Normal\n" +
                    "Código: " + codigo + "\n" +
                    "Valor Final: R$ " + valorFinal);
        }

        voltarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}