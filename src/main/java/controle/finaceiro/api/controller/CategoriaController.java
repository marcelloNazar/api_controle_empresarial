package controle.finaceiro.api.controller;

import controle.finaceiro.api.domain.categoria.Categoria;
import controle.finaceiro.api.domain.categoria.CategoriaDTO;
import controle.finaceiro.api.domain.categoria.CategoriaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
@SecurityRequirement(name = "bearer-key")
@PreAuthorize("hasRole('ADMIN')")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;


    @PostMapping
    public ResponseEntity<Categoria> createCategoria(@Valid @RequestBody Categoria categoria) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.createCategoria(categoria));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> updateCategoria(@PathVariable Long id, @Valid @RequestBody Categoria categoria) {
        return ResponseEntity.ok().body(categoriaService.updateCategoria(id, categoria));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Long id) {
        categoriaService.deleteCategoria(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}