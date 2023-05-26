package controle.finaceiro.api.domain.transacao;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TransacaoDTO {
    private Long id;
    private String tipo; // despesa ou receita
    private Double valor;
    private LocalDate data;
    private String descricao;
    private Boolean pago;
    private Long categoriaId;

}
