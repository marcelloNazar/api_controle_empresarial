package controle.finaceiro.api.domain.categoria;

import lombok.Data;

@Data
public class CategoriaDTO {
    private Long id;
    private String nome;
    private String cor;
    private String icone;

}
