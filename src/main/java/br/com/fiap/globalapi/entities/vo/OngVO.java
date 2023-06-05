package br.com.fiap.globalapi.entities.vo;

import java.util.List;

public record OngVO(
        String razaoSocial,
        List<UnidadeVO> unidadesVO
) {

}
