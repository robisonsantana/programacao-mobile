package guy.voltaic.contabancaria.model;

import android.widget.TextView;

public class ContaEspecial extends ContaBancaria {
    private float limite;

    private TextView tv_erro;

    public ContaEspecial(String cliente, int numConta, float saldoInicial, float limite) {
        super(cliente, numConta, saldoInicial);
        this.limite = limite;
    }

    @Override
    public void sacar(float valor) {
        if (saldo - valor >= -limite) {
            saldo -= valor;
        } else {
            tv_erro.setText("Saldo insuficiente para saque.");
        }
    }
}
