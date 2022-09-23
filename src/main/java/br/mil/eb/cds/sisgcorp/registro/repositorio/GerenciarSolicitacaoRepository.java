package br.mil.eb.cds.sisgcorp.registro.repositorio;

import br.mil.eb.cds.sisgcorp.registro.dominio.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface GerenciarSolicitacaoRepository  extends JpaRepository<User, Long> {

        @Query(value = "select  * from core.users u " +
                "inner join core.user_perfis up on up.id_usuario = u.id " +
                "inner join core.perfis p on p.id = up.id_perfil " +
                "inner join core.perfil_roles pr on pr.id_perfil = p.id where u.name = :nomeUsuario", nativeQuery = true
        )

//        @Query(value = "select * from core.users u " +
//                "inner join core.user_perfis up on up.id_usuario = u.id " +
//                "inner join core.perfis p on p.id = up.id_perfil " +
//                "inner join core.perfil_roles pr on pr.id_perfil = p.id ", nativeQuery = true)

//        @Query(value = "select us from User us " +
//                " inner join us.perfis ")
        List<User> findAllSolicitacaoPorStatusDataServico(@Param("nomeUsuario") String nm);
//
//    @Query(value = "select gs from GerenciarSolicitacao gs " +
//            " inner join gs.solicitacaoServico ss " +
//            " inner join ss.pessoaId p " +
//            " where ss.solicitacaoStatus.id = :situacaoId " +
//            " and gs.historicoTransicao.solicitacaoStatusId.id = ss.solicitacaoStatus.id " +
//            " and (gs.historicoTransicao.dataHora > :dataVigenciaInc " +
//            " and gs.historicoTransicao.dataHora < :dataVigenciaFim) " +
//            " and gs.solicitacaoServico.servicoId.id = :tipoProcesso " +
//            " and p.tipoPessoa = :tipoPessoa " +
//            " and gs.historicoTransicao.dataHora = (select max(ht.dataHora)" +
//            " from HistoricoTransicao ht where ht.gerenciarSolicitacaoId = gs.historicoTransicao.gerenciarSolicitacaoId" +
//            " and ht.solicitacaoStatusId.id = gs.historicoTransicao.solicitacaoStatusId.id)")
//    List<GerenciarSolicitacao> findAllSolicitacaoPorStatusDataServico(@Param("tipoProcesso") Long servicoId,
//                                                                      @Param("situacaoId") Integer situacaoAtualId,
//                                                                      @Param("dataVigenciaInc") LocalDateTime dataVigenciaInc,
//                                                                      @Param("dataVigenciaFim") LocalDateTime dataVigenciaFim,
//                                                                      @Param("tipoPessoa") EnumTipoPessoa tipoPessoa);
//
//    @Query(value = "SELECT * FROM GERENCIAMENTO_SOLICITACAO GS INNER JOIN " +
//            "SOLICITACAO_SERVICO SS on SS.ID = GS.SOLICITACAO_SERVICO_Id INNER JOIN " +
//            "PESSOA P on SS.PESSOA_ID = P.ID INNER JOIN " +
//            "HISTORICO_TRANSICAO HT on GS.ID = HT.GEREN_SOLICITACAO_ID " +
//            "INNER JOIN SERVICO S on SS.SERVICO_TAXA_ID = S.ID " +
//            "WHERE SS.SOLICITACAO_STATUS_ID = :situacaoId " +
//            "AND ht.SOLICITACAO_STATUS_ID = SS.SOLICITACAO_STATUS_ID " +
//            "AND S.SERVICO_TIPO_ID = :tipoProcesso " +
//            "AND trunc(sysdate) - trunc(ht.data_hora) >= :tempoSituacaoAtual " +
//            "AND p.TIPO_PESSOA_COD= :tipoPessoa " +
//            "AND HT.DATA_HORA BETWEEN TO_DATE( :dataInicio,'YYYY-MM-DD') AND TO_DATE( :dataFim,'YYYY-MM-DD')" +
//            "AND ht.data_hora = (select max(htt.data_hora) " +
//                "FROM historico_transicao htt " +
//                "WHERE htt.geren_solicitacao_id = ht.geren_solicitacao_id " +
//                "AND ht.SOLICITACAO_STATUS_ID = :solicitacaoStatusId)", nativeQuery = true)
//    List<GerenciarSolicitacao> findAllSolicitacaoPorStatusDataServico(@Param("tipoProcesso") Long servicoId,
//                                                                      @Param("situacaoId") Integer situacaoAtualId,
//                                                                      @Param("solicitacaoStatusId") Integer solicitacaoStatusId,
//                                                                      @Param("tempoSituacaoAtual") Integer tempoSituacaoAtual,
//                                                                      @Param("dataInicio") String dataInicio,
//                                                                      @Param("dataFim") String dataFim,
//                                                                      @Param("tipoPessoa") EnumTipoPessoa tipoPessoa);
}
