import lombok.Data;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Banco banco, Cliente cliente){
        super(banco, cliente);
    }

}
