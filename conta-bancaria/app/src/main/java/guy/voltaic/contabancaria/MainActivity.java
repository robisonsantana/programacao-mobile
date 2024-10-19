package guy.voltaic.contabancaria;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import guy.voltaic.contabancaria.model.ContaBancaria;
import guy.voltaic.contabancaria.model.ContaEspecial;
import guy.voltaic.contabancaria.model.ContaPoupanca;

/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
public class MainActivity extends AppCompatActivity {

    private RadioGroup rgTipoConta;
    private RadioButton rbContaPoupanca, rbContaEspecial;
    private EditText etValor, etTaxaRendimento;
    private TextView tvSaldo;
    private Button btnSacar, btnDepositar, btnCalcularRendimento;

    private ContaBancaria contaBancaria;
    private ContaPoupanca contaPoupanca = new ContaPoupanca("Cliente Poupança", 12345, 1000.0f, 15);
    private ContaEspecial contaEspecial = new ContaEspecial("Cliente Especial", 54321, 500.0f, 1000.0f);

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

        rgTipoConta = findViewById(R.id.rg_tipo_conta);
        rbContaPoupanca = findViewById(R.id.rb_conta_poupanca);
        rbContaEspecial = findViewById(R.id.rb_conta_especial);
        etValor = findViewById(R.id.et_valor);
        etTaxaRendimento = findViewById(R.id.et_taxa_rendimento);
        tvSaldo = findViewById(R.id.tv_saldo);
        btnSacar = findViewById(R.id.btn_sacar);
        btnDepositar = findViewById(R.id.btn_depositar);
        btnCalcularRendimento = findViewById(R.id.btn_calcular_rendimento);


        rgTipoConta.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rb_conta_poupanca) {
                etTaxaRendimento.setVisibility(View.VISIBLE);
                btnCalcularRendimento.setVisibility(View.VISIBLE);
                atualizarSaldo(contaPoupanca);
            } else if (checkedId == R.id.rb_conta_especial) {
                etTaxaRendimento.setVisibility(View.GONE);
                btnCalcularRendimento.setVisibility(View.GONE);
                atualizarSaldo(contaEspecial);
            }
        });

        btnSacar.setOnClickListener(v -> {
            float valor = obterValor();
            if (valor > 0) {
                if (rbContaPoupanca.isChecked()) {
                    contaPoupanca.sacar(valor);
                    atualizarSaldo(contaPoupanca);
                } else if (rbContaEspecial.isChecked()) {
                    contaEspecial.sacar(valor);
                    atualizarSaldo(contaEspecial);
                }
            }
        });

        btnDepositar.setOnClickListener(v -> {
            float valor = obterValor();
            if (valor > 0) {
                if (rbContaPoupanca.isChecked()) {
                    contaPoupanca.depositar(valor);
                    atualizarSaldo(contaPoupanca);
                } else if (rbContaEspecial.isChecked()) {
                    contaEspecial.depositar(valor);
                    atualizarSaldo(contaEspecial);
                }
            }
        });

        btnCalcularRendimento.setOnClickListener(v -> {
            if (rbContaPoupanca.isChecked()) {
                float taxa = obterTaxaRendimento();
                if (taxa > 0) {
                    contaPoupanca.calcularNovoSaldo(taxa);
                    atualizarSaldo(contaPoupanca);
                }
            }
        });
    }

    /*
     *@author:<Robison>
     *@ra:<1110482313007>
     */
    private float obterValor() {
        String valorStr = etValor.getText().toString();
        if (!valorStr.isEmpty()) {
            try {
                return Float.parseFloat(valorStr);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Valor inválido", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Digite um valor", Toast.LENGTH_SHORT).show();
        }
        return 0;
    }

    /*
     *@author:<Robison>
     *@ra:<1110482313007>
     */
    private float obterTaxaRendimento() {
        String taxaStr = etTaxaRendimento.getText().toString();
        if (!taxaStr.isEmpty()) {
            try {
                return Float.parseFloat(taxaStr);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Taxa de rendimento inválida", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Digite a taxa de rendimento", Toast.LENGTH_SHORT).show();
        }
        return 0;
    }

    /*
     *@author:<Robison>
     *@ra:<1110482313007>
     */
    private void atualizarSaldo(ContaBancaria conta) {
        tvSaldo.setText("Saldo: R$ " + String.format("%.2f", conta.getSaldo()));
    }
}
