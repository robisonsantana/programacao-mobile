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
import android.widget.EditText;
import android.widget.RadioGroup;

import guy.voltaic.vendadeingressos.model.Ingresso;
import guy.voltaic.vendadeingressos.model.IngressoVIP;


/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
public class MainActivity extends AppCompatActivity {

    private EditText codigoIdentificadorInput, valorInput, taxaConvenienciaInput, funcaoInput;
    private RadioGroup tipoIngressoGroup;

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

        codigoIdentificadorInput = findViewById(R.id.codigoInput);
        valorInput = findViewById(R.id.valorInput);
        taxaConvenienciaInput = findViewById(R.id.taxaInput);
        funcaoInput = findViewById(R.id.funcaoInput);
        tipoIngressoGroup = findViewById(R.id.tipoIngressoGroup);
        Button comprarButton = findViewById(R.id.comprarButton);

        comprarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String codigo = codigoIdentificadorInput.getText().toString();
                float valor = Float.parseFloat(valorInput.getText().toString());
                float taxa = Float.parseFloat(taxaConvenienciaInput.getText().toString());
                int tipoIngressoSelecionado = tipoIngressoGroup.getCheckedRadioButtonId();

                Intent intent = new Intent(MainActivity.this, DetalhesCompraActivity.class);

                if (tipoIngressoSelecionado == R.id.radioIngressoVip) {
                    String funcao = funcaoInput.getText().toString();
                    IngressoVIP ingressoVIP = new IngressoVIP(codigo, valor, funcao);
                    intent.putExtra("tipoIngresso", "VIP");
                    intent.putExtra("valorFinal", ingressoVIP.valorFinal(taxa));
                    intent.putExtra("funcao", funcao);
                } else {
                    Ingresso ingresso = new Ingresso(codigo, valor);
                    intent.putExtra("tipoIngresso", "Normal");
                    intent.putExtra("valorFinal", ingresso.valorFinal(taxa));
                }

                intent.putExtra("codigo", codigo);
                intent.putExtra("valor", valor);
                startActivity(intent);
            }
        });
    }
}