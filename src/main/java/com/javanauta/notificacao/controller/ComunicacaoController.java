package com.javanauta.notificacao.controller;

import com.javanauta.notificacao.business.EmailService;
import com.javanauta.notificacao.business.dto.ComunicacaoNotificacaoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comunicacao")
public class ComunicacaoController {

    private final EmailService emailService;


    @PostMapping
    public ResponseEntity<Void> enviarComunicacao(
            @RequestBody ComunicacaoNotificacaoDTO dto){

        emailService.enviaComunicacao(dto);

        return ResponseEntity.ok().build();
    }
}