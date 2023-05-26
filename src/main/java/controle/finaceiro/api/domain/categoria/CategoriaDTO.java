package controle.finaceiro.api.domain.categoria;

import lombok.Data;

@Data
public class CategoriaDTO {
    private Long id;
    private String nome;
    private String cor;
    private String icone;

    public CategoriaDTO(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
        this.cor = categoria.getCor();
        this.icone = categoria.getIcone();
    }
}
