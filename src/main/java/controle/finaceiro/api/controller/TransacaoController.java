package controle.finaceiro.api.controller;

import controle.finaceiro.api.domain.categoria.Categoria;
import controle.finaceiro.api.domain.categoria.CategoriaDTO;
import controle.finaceiro.api.domain.categoria.CategoriaService;
import controle.finaceiro.api.domain.transacao.Transacao;
import controle.finaceiro.api.domain.transacao.TransacaoDTO;
import controle.finaceiro.api.domain.transacao.TransacaoService;
import controle.finaceiro.api.user.User;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/transacoes")
@SecurityRequirement(name = "bearer-key")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Transacao> createTransacao(@Valid @RequestBody TransacaoDTO transacaoInput) {
        return ResponseEntity.status(CREATED).body(transacaoService.createTransacao(transacaoInput));
    }

    @GetMapping
    public ResponseEntity<Page<Transacao>> getAllTransacoes(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "data") String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort).descending());
        return ResponseEntity.ok(transacaoService.getAllTransacoes(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transacao> getTransacaoById(@PathVariable Long id) {
        return ResponseEntity.ok(transacaoService.getTransacaoById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transacao> updateTransacao(@PathVariable Long id, @Valid @RequestBody TransacaoDTO transacaoInput) {
        return ResponseEntity.ok(transacaoService.updateTransacao(id, transacaoInput));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransacao(@PathVariable Long id) {
        transacaoService.deleteTransacao(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/categoria")
    public ResponseEntity<List<Categoria>> getAllCategorias() {
        return ResponseEntity.ok(categoriaService.getAllCategorias());
    }

    @GetMapping("/categoria/{id}")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.getCategoriaById(id));
    }

    @GetMapping("/categoria/{categoriaId}")
    public ResponseEntity<List<Transacao>> getTransacoesByCategoria(@PathVariable Long categoriaId) {
        return ResponseEntity.ok(transacaoService.getTransacoesByCategoria(categoriaId));
    }

    @ControllerAdvice
    public class GlobalExceptionHandler {
        @ExceptionHandler(value = Exception.class)
        public ResponseEntity<Object> exception(Exception exception) {
            return new ResponseEntity<>("Error occurred: " + exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
