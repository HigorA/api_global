package br.com.fiap.globalapi.entities.vo;

public record EnderecoVO(
        Long cep,
        String uf,
        String bairro,
        String logradouro,
        String numero,
        String complemento
) {
}
