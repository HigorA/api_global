package br.com.fiap.globalapi.entities.vo.security;

import java.util.Date;

public record TokenVO (
        String login,
        Boolean authenticated,
        Date created,
        Date expiration,
        String accessToken,
        String refreshToken
) {
}
