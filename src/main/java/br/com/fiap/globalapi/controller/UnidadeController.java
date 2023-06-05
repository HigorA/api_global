package br.com.fiap.globalapi.controller;

import br.com.fiap.globalapi.entities.Unidade;
import br.com.fiap.globalapi.entities.vo.UnidadeVO;
import br.com.fiap.globalapi.service.UnidadeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/unidade")
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
}
