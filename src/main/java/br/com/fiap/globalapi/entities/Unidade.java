package br.com.fiap.globalapi.entities;

import br.com.fiap.globalapi.entities.vo.UnidadeVO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "unidade")
public class Unidade implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "unidade", cascade = CascadeType.ALL)
    private Endereco endereco;
    private String status;
    @Column(name = "business_hours")
    private String horarioDeFuncionamento;

    @OneToMany(mappedBy = "unidade", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Contato> contato;

    @ManyToOne
    @JoinColumn(name = "ong_id")
    @JsonIgnore
    private Ong ong;

    public Unidade() {
    }

    public Unidade(Long id, Endereco endereco, String status, String horarioDeFuncionamento, List<Contato> contato, Ong ong) {
        this.id = id;
        this.endereco = endereco;
        this.status = status;
        this.horarioDeFuncionamento = horarioDeFuncionamento;
        this.contato = contato;
        this.ong = ong;
    }

    public Unidade(UnidadeVO vo) {
        this.endereco = new Endereco(vo.enderecoVO());
        this.status = vo.status();
        this.horarioDeFuncionamento = vo.horarioDeFuncionamento();
        this.contato = new ArrayList<>();
        vo.contatoVO().forEach(contatoVO -> {
            Contato contato1 = new Contato(contatoVO);
            contato1.setUnidade(this);
            contato.add(contato1);
        });
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHorarioDeFuncionamento() {
        return horarioDeFuncionamento;
    }

    public void setHorarioDeFuncionamento(String horarioDeFuncionamento) {
        this.horarioDeFuncionamento = horarioDeFuncionamento;
    }

    public List<Contato> getContato() {
        return contato;
    }

    public void setContato(List<Contato> contato) {
        this.contato = contato;
    }

    public Ong getOng() {
        return ong;
    }

    public void setOng(Ong ong) {
        this.ong = ong;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unidade unidade = (Unidade) o;
        return Objects.equals(id, unidade.id) && Objects.equals(endereco, unidade.endereco) && Objects.equals(status, unidade.status) && Objects.equals(horarioDeFuncionamento, unidade.horarioDeFuncionamento) && Objects.equals(contato, unidade.contato) && Objects.equals(ong, unidade.ong);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, endereco, status, horarioDeFuncionamento, contato, ong);
    }

    @Override
    public String toString() {
        return "Unidade{" +
                "id=" + id +
                ", endereco=" + endereco +
                ", status='" + status + '\'' +
                ", horarioDeFuncionamento='" + horarioDeFuncionamento + '\'' +
                ", contato=" + contato +
                ", ong=" + ong +
                '}';
    }
}
