package br.com.bb.t99.services.impl;

import br.com.bb.t99.services.HoraService;
import java.time.LocalTime;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@Named("clienteServiceImpl")
@RequiredArgsConstructor
public class HoraServiceImpl implements HoraService{

    @Override
    public String definirHora() {
        
        return LocalTime.now().toString();
    }    
}

