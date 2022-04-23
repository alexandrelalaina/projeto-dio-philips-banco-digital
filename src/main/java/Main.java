import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Banco santander = Banco.builder()
                .nome("Santander")
                .endereco(Endereco.builder()
                        .estado(EnderecoUFENum.SP)
                        .cidade("Araraquara")
                        .tipo(EnderecoTipoEnum.AV)
                        .logradouro("Av. 1 de janeiro")
                        .numero(123)
                        .complemento("B1-199")
                        .build())
                .build();
        Banco meuBanco = Banco.builder()
                .nome("Meu Banco")
                .endereco(Endereco.builder()
                        .estado(EnderecoUFENum.SP)
                        .cidade("Araraquara")
                        .tipo(EnderecoTipoEnum.RUA)
                        .logradouro("Av. 9 de julho")
                        .numero(456)
                        .build())
                .build();

        Endereco home = Endereco.builder()
                .estado(EnderecoUFENum.SP)
                .cidade("Araraquara")
                .tipo(EnderecoTipoEnum.AV)
                .logradouro("Aqui")
                .numero(123)
                .complemento("B1-321")
                .build();

        Cliente alexandre = Cliente.builder()
                .nome("Alexandre La Laina")
                .endereco(home)
                .build();
        Cliente janaina = Cliente.builder()
                .nome("Janaina")
                .endereco(home)
                .build();
        Cliente serena = Cliente.builder()
                .nome("Serena")
                .endereco(home)
                .build();

        Conta cc1 = new ContaCorrente(santander, alexandre);
        Conta cc2 = new ContaCorrente(santander, janaina);
        Conta cp1 = new ContaPoupanca(meuBanco, serena);

        System.out.println("Saldos iniciais\n");
        cc1.imprimirExtrato();
        System.out.println(" ");
        cc2.imprimirExtrato();
        System.out.println(" ");
        cp1.imprimirExtrato();
        System.out.println(" ");

        cc1.depositar(5000);
        System.out.println(" ");
        cc2.depositar(1000);
        System.out.println(" ");
        cc1.transferir(2000, cp1);
        System.out.println(" ");
        cc2.transferir(500, cp1);
        System.out.println(" ");

        System.out.println("Saldos finais");
        cc1.imprimirExtrato();
        System.out.println(" ");
        cc2.imprimirExtrato();
        System.out.println(" ");
        cp1.imprimirExtrato();

        System.out.println("\n2) listar clientes do banco");

        List<Banco> bancoList = new ArrayList<>();
        bancoList.addAll(List.of(santander, meuBanco));

        List<Conta> contaList = new ArrayList<>();
        contaList.addAll(List.of(cc1, cc2, cp1));

        for (Banco banco: bancoList) {
            System.out.println(banco);

            List<Conta> result = contaList.stream()
                    .filter(s -> s.banco.getNome().equals(banco.getNome()))
                    .collect(Collectors.toList());

            int i = 0;
            for (Conta conta: result){
                System.out.println(result.get(i).getCliente().getNome());
                i++;
            }

            System.out.println(" ");

        }

    }

}
