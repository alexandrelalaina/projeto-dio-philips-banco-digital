import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Banco {

    private String nome;
    private Endereco endereco;

}
