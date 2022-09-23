package br.mil.eb.cds.sisgcorp.registro.servico;

import br.mil.eb.cds.sisgcorp.registro.dominio.User;
import br.mil.eb.cds.sisgcorp.registro.repositorio.GerenciarSolicitacaoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
@Transactional
public class RestituicaoProcessoService {

    private final GerenciarSolicitacaoRepository gerenciarSolicitacaoRepository;

    public List<User> buscarSolicitacaoPorTipoPessoa() {
        return gerenciarSolicitacaoRepository
            .findAllSolicitacaoPorStatusDataServico("abcde");
    }

}

