package br.com.bb.letscode.restcontroller.services.impl;

import java.time.LocalTime;

import org.springframework.stereotype.Service;

import br.com.bb.letscode.restcontroller.services.HoraService;

@Service
public class HoraServiceImpl implements HoraService{

    @Override
    public String definirHora() {
        
        return LocalTime.now().toString();
    }    
}
