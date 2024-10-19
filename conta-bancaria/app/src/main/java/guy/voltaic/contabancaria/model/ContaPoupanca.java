package guy.voltaic.contabancaria.model;

import android.widget.TextView;

public class ContaPoupanca extends ContaBancaria {
    private int diaDeRendimento;

    private TextView tv_erro;

    public ContaPoupanca(String cliente, int numConta, float saldoInicial, int diaDeRendimento) {
        super(cliente, numConta, saldoInicial);
        this.diaDeRendimento = diaDeRendimento;
    }

    public void calcularNovoSaldo(float taxaRendimento) {
        saldo += saldo * (taxaRendimento / 100);
    }

    @Override
    public void sacar(float valor) {
        if (saldo - valor >= saldo) {
            saldo -= valor;
        } else {
            tv_erro.setText("Saldo insuficiente para saque.");
        }
    }
}