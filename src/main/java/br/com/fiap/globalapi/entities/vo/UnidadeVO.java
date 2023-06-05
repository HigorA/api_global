package br.com.fiap.globalapi.entities.vo;

import java.util.List;

public record UnidadeVO(

        EnderecoVO enderecoVO,
        String status,
        String horarioDeFuncionamento,
        List<ContatoVO> contatoVO
) {
}
