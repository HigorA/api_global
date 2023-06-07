package br.com.fiap.globalapi.service;

import br.com.fiap.globalapi.entities.Ong;
import br.com.fiap.globalapi.entities.Unidade;
import br.com.fiap.globalapi.entities.vo.ListagemUnidadeVO;
import br.com.fiap.globalapi.entities.vo.UnidadeVO;
import br.com.fiap.globalapi.repository.OngRepository;
import br.com.fiap.globalapi.repository.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadeService {

    @Autowired
    private UnidadeRepository unidadeRepository;
    @Autowired
    private OngRepository ongRepository;


    public ResponseEntity<Unidade> findAll(Long ongId) {
        return ResponseEntity.ok().body(unidadeRepository.findAllByOng(ongId));
    }

    public ResponseEntity<Unidade> save(Long ongId, UnidadeVO unidadeVO) {
        Ong ong = ongRepository.findById(ongId).orElseThrow();
        Unidade unidade = new Unidade(unidadeVO);
        unidade.setOng(ong);
        unidade.getEndereco().setUnidade(unidade);
        Unidade finalUnidade = unidade;
        unidade.getContato().forEach(contato -> contato.setUnidade(finalUnidade));
        unidade = unidadeRepository.save(unidade);
        return ResponseEntity.status(HttpStatus.CREATED).body(unidade);
    }

}
