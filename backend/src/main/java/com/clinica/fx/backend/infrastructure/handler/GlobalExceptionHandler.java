package com.clinica.fx.backend.infrastructure.handler;

import com.clinica.fx.dto.ErroDTO;
import com.clinica.fx.dto.ErroValidacaoDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErroValidacaoDTO>> validacao(MethodArgumentNotValidException ex) {
        List<ErroValidacaoDTO> erros = ex.getBindingResult().getFieldErrors().stream().map(campo -> new ErroValidacaoDTO(campo.getField(), campo.getDefaultMessage())).toList();

        return ResponseEntity.badRequest().body(erros);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErroDTO> entidadeNaoEncontrada(EntityNotFoundException ex) {
        var erro =  new ErroDTO(ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }
}
