package br.com.fiap.globalapi.entities;

import br.com.fiap.globalapi.entities.vo.ContatoVO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "contato")
public class Contato implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "telephone")
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "unidade_id")
    @JsonIgnore
    private Unidade unidade;

    public Contato() {
    }

    public Contato(Long id, String telefone, Unidade unidade) {
        this.id = id;
        this.telefone = telefone;
        this.unidade = unidade;
    }

    public Contato(ContatoVO vo) {
        this.telefone = vo.telefone();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
        Contato contato = (Contato) o;
        return Objects.equals(id, contato.id) && Objects.equals(telefone, contato.telefone) && Objects.equals(unidade, contato.unidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, telefone, unidade);
    }

    @Override
    public String toString() {
        return "Contato{" +
                "id=" + id +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
