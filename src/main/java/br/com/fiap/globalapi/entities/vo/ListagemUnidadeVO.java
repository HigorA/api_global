package br.com.fiap.globalapi.entities.vo;

import br.com.fiap.globalapi.entities.Contato;
import br.com.fiap.globalapi.entities.Endereco;
import br.com.fiap.globalapi.entities.Unidade;

import java.util.List;

public record ListagemUnidadeVO(
        Long id,
        Endereco endereco,
        String status,
        String horarioDeFuncionamento,
        List<Contato> contato
) {
    public ListagemUnidadeVO(Unidade unidade) {
        this(
                unidade.getId(),
                unidade.getEndereco(),
                unidade.getStatus(),
                unidade.getHorarioDeFuncionamento(),
                unidade.getContato()
        );
    }
}
