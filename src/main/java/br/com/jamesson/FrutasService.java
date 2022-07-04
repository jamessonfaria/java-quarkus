package br.com.jamesson;

import io.quarkus.arc.Lock;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Lock // os metodos desse servico nao vao poder ser chamados de forma paralela, é como se fosse um syncronized
@ApplicationScoped
public final class FrutasService {

    @Inject
    IdentificadorTransacao identificadorTransacao;

    @Lock(value = Lock.Type.READ, time = 3, unit = TimeUnit.SECONDS) // definindo lock especifico para esse list
    public List<Fruta> list() {
        System.out.println(identificadorTransacao.getIdentificadorTransacao());
        return Fruta.listAll();
    }

    @Transactional
    public void novaFruta(InserirFrutaDTO inserirFrutaDTO) {
        System.out.println(identificadorTransacao.getIdentificadorTransacao());

        Fruta fruta = new Fruta();
        fruta.nome = inserirFrutaDTO.getNome();
        fruta.qtd = inserirFrutaDTO.getQtd();
        fruta.persist();
    }
}
