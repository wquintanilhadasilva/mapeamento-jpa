package br.mil.eb.cds.sisgcorp.registro;

import br.mil.eb.cds.sisgcorp.registro.servico.RestituicaoProcessoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@Log4j2
public class MapeamentoJpaApplication {

	@Autowired
	RestituicaoProcessoService service;

	public static void main(String[] args) {
		SpringApplication.run(MapeamentoJpaApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		System.out.println("hello world, I have just started up");
		var result = service.buscarSolicitacaoPorTipoPessoa();
		result.forEach(u -> log.info(String.format("Usuário %s, UserName %s", u.getNameUsuario(), u.getUsername())));
	}

}
