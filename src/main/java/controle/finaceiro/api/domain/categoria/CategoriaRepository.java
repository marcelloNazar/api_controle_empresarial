package controle.finaceiro.api.domain.categoria;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
