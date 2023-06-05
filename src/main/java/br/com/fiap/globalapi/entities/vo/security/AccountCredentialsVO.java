package br.com.fiap.globalapi.entities.vo.security;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AccountCredentialsVO(
        @NotBlank(message = "Campo login não pode estar em branco")
        @Email(message = "O campo login  aceita apenas valores no formato de email")
        String login,

        @NotBlank(message = "A senha não pode estar em branco")
        String password
) {

}
