package br.com.fiap.globalapi.service;

import br.com.fiap.globalapi.entities.Ong;
import br.com.fiap.globalapi.entities.User;
import br.com.fiap.globalapi.entities.vo.ListagemOngVO;
import br.com.fiap.globalapi.entities.vo.OngVO;
import br.com.fiap.globalapi.repository.OngRepository;
import br.com.fiap.globalapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OngServices {

    @Autowired
    private final OngRepository ongRepository;

    @Autowired
    private final UserRepository userRepository;

    public OngServices(OngRepository ongRepository, UserRepository userRepository) {
        this.ongRepository = ongRepository;
        this.userRepository = userRepository;
    }

    public ResponseEntity<Ong> findAllByUserId(Long id) {
        return ResponseEntity.ok().body(ongRepository.findByUserId(id));
    }

    public ResponseEntity<Page<ListagemOngVO>> findAll(Pageable pageable) {
        return ResponseEntity.ok().body(ongRepository.findAll(pageable).map(ListagemOngVO::new));
    }

    public ResponseEntity<Ong> save(Long id, OngVO ongVO) {
        User user = userRepository.findById(id).orElseThrow();
        Ong ong = new Ong(ongVO);
        ong.setUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(ongRepository.save(ong));
    }


}
