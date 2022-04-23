import lombok.Data;

import java.util.List;

@Data
public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 0001;

    private static int SEQUENCIAL = 1;
    protected int agencia;
    protected int numero;
    protected int saldo;
    protected Banco banco;
    protected Cliente cliente;

    public Conta(Banco banco, Cliente cliente){
        this.banco = banco;
        this.cliente = cliente;
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
    }

    @Override
    public void sacar(double valor) {
        System.out.println("sacar " + valor + " " + this.toString());
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        System.out.println("depositar " + valor + " " + this.toString());
        saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        System.out.println("transferir " + valor + " de: " + this.toString() + " para: " + contaDestino.toString());
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    @Override
    public void imprimirExtrato(){
        System.out.println(String.format("Cliente: %s", this.cliente));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %d", this.saldo));
    }

}
