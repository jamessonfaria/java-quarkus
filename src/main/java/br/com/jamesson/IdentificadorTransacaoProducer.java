package br.com.jamesson;

import io.quarkus.arc.profile.IfBuildProfile;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

public class IdentificadorTransacaoProducer {

    @Produces
    public IdentificadorTransacao produceTeste(InjectionPoint ip) {
        return new IdentificadorTransacao("Teste-");
    }

    @Produces
    @IfBuildProfile("prod")
    public IdentificadorTransacao produceProd(InjectionPoint ip) {
        return new IdentificadorTransacao("Prod-");
    }

}
