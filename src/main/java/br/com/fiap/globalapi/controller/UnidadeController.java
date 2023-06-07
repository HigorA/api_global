package br.com.fiap.globalapi.controller;

import br.com.fiap.globalapi.entities.Unidade;
import br.com.fiap.globalapi.entities.vo.UnidadeVO;
import br.com.fiap.globalapi.service.UnidadeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unidade")
@CrossOrigin("*")
@Tag(name = "Unidade")
public class UnidadeController {

    @Autowired
    private final UnidadeService unidadeService;

    public UnidadeController(UnidadeService unidadeService) {
        this.unidadeService = unidadeService;
    }

    @PostMapping("/{ongId}")
    public ResponseEntity<Unidade> save(@PathVariable Long ongId, @RequestBody UnidadeVO unidadeVO) {
        return unidadeService.save(ongId, unidadeVO);
    }

    @GetMapping("/{ongId}")
    public ResponseEntity<Page<List<Unidade>>> list(@PageableDefault(size = 3, sort = {"horarioDeFuncionamento"}) Pageable pageable, @PathVariable Long ongId) {
        return unidadeService.findAll(ongId, pageable);
    }

    @GetMapping("/id/{unidadeId}")
    public ResponseEntity<Unidade> findById(@PathVariable Long unidadeId) {
        return unidadeService.findById(unidadeId);
    }
}
