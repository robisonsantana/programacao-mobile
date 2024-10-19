package guy.voltaic.contabancaria.model;

import android.widget.TextView;

public class ContaBancaria {
    protected String cliente;
    protected int numConta;
    protected float saldo;

    private TextView tv_erro;

    public ContaBancaria(String cliente, int numConta, float saldoInicial) {
        this.cliente = cliente;
        this.numConta = numConta;
        this.saldo = saldoInicial;
    }

    public void sacar(float valor) {
        if (saldo - valor >= 0) {
            saldo -= valor;
        } else {
            tv_erro.setText("Saldo insuficiente para saque.");
        }
    }

    public void depositar(float valor) {
        saldo += valor;
    }

    public float getSaldo() {
        return saldo;
    }

    public String getDadosConta() {
        return "Cliente: " + cliente + "\nConta: " + numConta + "\nSaldo: R$ " + saldo;
    }
}
