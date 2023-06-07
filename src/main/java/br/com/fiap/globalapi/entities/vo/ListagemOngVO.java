package br.com.fiap.globalapi.entities.vo;

import br.com.fiap.globalapi.entities.Ong;

public record ListagemOngVO(
        Long id,
        String razaoSocial
) {
    public ListagemOngVO(Ong ong) {
        this(
            ong.getId(),
            ong.getRazaoSocial()
        );
    }
}
