package br.com.bb.letscode.restcontroller.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bb.letscode.restcontroller.services.impl.HoraServiceImpl;

@RestController
@RequestMapping("/hello")
@Slf4j
@RequiredArgsConstructor
public class HelloController {

    @Autowired
    private final HoraServiceImpl horaService;
    
    @GetMapping() 
    public ResponseEntity<String> hello() {

        log.info("Hello simples.");
        return ResponseEntity.ok("Hello!");
    }
    
    @GetMapping("/{nome}")
    public ResponseEntity<String> helloNome(@PathVariable String nome) {
        
        log.info("Hello nomeado. \tNome: " + nome);
        return ResponseEntity.ok("Hello, " + nome + "!");
    }

    @GetMapping("/{nome}/horario")
    public ResponseEntity<String> helloNomeDataHora (@PathVariable String nome) {
       
       String hora = horaService.definirHora();
       
       log.info("Hello nomeado temporal. \tNome: " + nome 
       + "\tHora: " + hora);

       return ResponseEntity.ok("Hello " + nome 
       + "! Agora são " + hora + ", não se esqueça!");
    }    
}