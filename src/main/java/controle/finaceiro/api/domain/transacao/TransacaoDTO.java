package controle.finaceiro.api.domain.transacao;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TransacaoDTO {
    private String tipo;
    private Double valor;
    private String descricao;
    private Boolean pago;
    private Long categoriaId;

}
