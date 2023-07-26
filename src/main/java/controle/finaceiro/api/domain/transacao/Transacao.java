package controle.finaceiro.api.domain.transacao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import controle.finaceiro.api.domain.categoria.Categoria;
import controle.finaceiro.api.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transacao")
public class Transacao {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Double valor;
    private Boolean despesa;
    private String data;
    private String descricao;
    private Boolean paga;
    @ManyToOne
    @JoinColumn(name="categoria_id", nullable=false)
    @JsonManagedReference
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonManagedReference
    @JsonIgnore
    private User user;


}