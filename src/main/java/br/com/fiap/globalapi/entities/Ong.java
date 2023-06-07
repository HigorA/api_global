package br.com.fiap.globalapi.entities;

import br.com.fiap.globalapi.entities.vo.OngVO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ong")
public class Ong implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "ong_name")
    private String razaoSocial;
    @OneToMany(mappedBy = "ong", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Unidade> unidades;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    @JsonIgnore
    private User user;

    public Ong() {
    }

    public Ong(Long id, String razaoSocial, List<Unidade> unidades, User user) {
        this.id = id;
        this.razaoSocial = razaoSocial;
        this.unidades = unidades;
        this.user = user;
    }

    public Ong(OngVO vo) {
        this.razaoSocial = vo.razaoSocial();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public List<Unidade> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<Unidade> unidades) {
        this.unidades = unidades;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ong ong = (Ong) o;
        return Objects.equals(id, ong.id) && Objects.equals(razaoSocial, ong.razaoSocial) && Objects.equals(unidades, ong.unidades) && Objects.equals(user, ong.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, razaoSocial, unidades, user);
    }

    @Override
    public String toString() {
        return "Ong{" +
                "id=" + id +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", unidades=" + unidades +
                ", user=" + user +
                '}';
    }
}
