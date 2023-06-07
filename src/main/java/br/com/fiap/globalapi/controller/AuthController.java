package br.com.fiap.globalapi.controller;

import br.com.fiap.globalapi.entities.User;
import br.com.fiap.globalapi.entities.vo.security.AccountCredentialsVO;
import br.com.fiap.globalapi.entities.vo.security.TokenVO;
import br.com.fiap.globalapi.entities.vo.security.UserRegisterVO;
import br.com.fiap.globalapi.service.AuthServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Autenticação", description = "API Restfull do Challenge, responsavel pela autenticação e operações do usuário.")
@RestController
@CrossOrigin("*")
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private final AuthServices authServices;

    public AuthController(AuthServices authServices) {
        this.authServices = authServices;
    }


    @Operation(summary = "Faz o login.", description = "Autentica um usuário.",
            tags = {"Autenticação"})
    @PostMapping(value = "/signin")
    public ResponseEntity<TokenVO> signIn(@RequestBody @Valid AccountCredentialsVO data) {
        return authServices.signIn(data);
    }

    @Operation(summary = "Faz o cadastro.", description = "Cadastra um usuário.",
            tags = {"Autenticação"})
    @PostMapping(value = "/signup")
    public ResponseEntity<User> signUp(@RequestBody @Valid UserRegisterVO data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authServices.signUp(data));
    }

    @Operation(summary = "Faz a desativação de um usuário.", description = "Desativa um usuário.",
            tags = {"Autenticação"})
    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> delete(@RequestBody @Valid AccountCredentialsVO data) {
        authServices.deleteUser(data);
        return ResponseEntity.status(HttpStatus.OK).body("User removed!");
    }
}
