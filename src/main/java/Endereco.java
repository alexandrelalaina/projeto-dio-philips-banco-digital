import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Endereco {

    private EnderecoUFENum estado;
    private String cidade;
    private EnderecoTipoEnum tipo;
    private String logradouro;
    private int numero;
    private String complemento;


}
