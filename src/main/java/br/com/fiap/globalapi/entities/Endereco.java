package br.com.fiap.globalapi.entities;

import br.com.fiap.globalapi.entities.vo.EnderecoVO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "endereco")
public class Endereco implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cep;
    private String uf;
    private String bairro;
    private String logradouro;
    private String numero;
    private String complemento;
    @OneToOne
    @JoinColumn(name = "unidade_id")
    @JsonIgnore
    private Unidade unidade;

    public Endereco() {
    }

    public Endereco(Long id, Long cep, String uf, String bairro, String logradouro, String numero, String complemento, Unidade unidade) {
        this.id = id;
        this.cep = cep;
        this.uf = uf;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.unidade = unidade;
    }

    public Endereco(EnderecoVO vo) {
        this.cep = vo.cep();
        this.uf = vo.uf();
        this.bairro = vo.bairro();
        this.logradouro = vo.logradouro();
        this.numero = vo.numero();
        this.complemento = vo.complemento();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(id, endereco.id) && Objects.equals(cep, endereco.cep) && Objects.equals(uf, endereco.uf) && Objects.equals(bairro, endereco.bairro) && Objects.equals(logradouro, endereco.logradouro) && Objects.equals(numero, endereco.numero) && Objects.equals(complemento, endereco.complemento) && Objects.equals(unidade, endereco.unidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cep, uf, bairro, logradouro, numero, complemento, unidade);
    }
}
