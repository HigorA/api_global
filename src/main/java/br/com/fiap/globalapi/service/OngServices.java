package br.com.fiap.globalapi.service;

import br.com.fiap.globalapi.entities.Ong;
import br.com.fiap.globalapi.entities.Unidade;
import br.com.fiap.globalapi.entities.User;
import br.com.fiap.globalapi.entities.vo.OngVO;
import br.com.fiap.globalapi.repository.OngRepository;
import br.com.fiap.globalapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public ResponseEntity<Ong> findAll(Long id) {
        return ResponseEntity.ok().body(ongRepository.findAllByUserId(id));
    }

    public ResponseEntity<Ong> save(Long id, OngVO ongVO) {
        User user = userRepository.findById(id).orElseThrow();
        Ong ong = new Ong(ongVO);
        ong.setUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(ongRepository.save(ong));
    }


}
