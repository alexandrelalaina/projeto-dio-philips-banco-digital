import lombok.Data;

public class ContaCorrente extends Conta {

    public ContaCorrente(Banco banco, Cliente cliente){
        super(banco, cliente);
    }

}
