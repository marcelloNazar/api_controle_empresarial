package controle.finaceiro.api.domain.categoria;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria getCategoriaById(Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if (categoria.isPresent()) {
            return categoria.get();
        } else {
            throw new EntityNotFoundException("Categoria não encontrada com o id " + id);
        }
    }

    public Categoria createCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria updateCategoria(Long id, Categoria categoriaDetails) {
        Categoria categoria = getCategoriaById(id);
        categoria.setNome(categoriaDetails.getNome());
        categoria.setCor(categoriaDetails.getCor());
        categoria.setIcone(categoriaDetails.getIcone());
        return categoriaRepository.save(categoria);
    }

    public void deleteCategoria(Long id) {
        Categoria categoria = getCategoriaById(id);
        categoriaRepository.delete(categoria);
    }
}