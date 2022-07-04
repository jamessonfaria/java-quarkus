package br.com.jamesson;

import io.quarkus.arc.DefaultBean;
import io.quarkus.arc.profile.IfBuildProfile;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

public class IdentificadorTransacaoProducer {

    @Produces
    @DefaultBean
    @RequestScoped
    public IdentificadorTransacao produceTeste() {
        return new IdentificadorTransacao("Teste-");
    }

    @Produces
    @IfBuildProfile("prod")
    @RequestScoped
    public IdentificadorTransacao produceProd() {
        return new IdentificadorTransacao("Prod-");
    }

}
