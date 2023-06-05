package br.com.fiap.globalapi.controller;

import br.com.fiap.globalapi.entities.vo.OngVO;
import br.com.fiap.globalapi.service.OngServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Ong", description = "Manipula as ongs de um usuario")
@RestController
@RequestMapping("/ong")
public class OngController {

    @Autowired
    private final OngServices ongServices;


    public OngController(OngServices ongServices) {
        this.ongServices = ongServices;
    }

    @Operation(tags = {"Ong"})
    @GetMapping("/{userId}")
    public ResponseEntity<?> findAll(@PathVariable Long userId) {
        return ongServices.findAll(userId);
    }


    @Operation(tags = {"Ong"})
    @PostMapping("/{userId}")
    public ResponseEntity<?> save(@PathVariable Long userId, @RequestBody OngVO vo) {
        return ongServices.save(userId, vo);
    }

}
