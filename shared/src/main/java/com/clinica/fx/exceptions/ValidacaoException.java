package com.clinica.fx.exceptions;

import com.clinica.fx.dto.ErroValidacaoDTO;

import java.util.List;

public class ValidacaoException extends RuntimeException{

    private final List<ErroValidacaoDTO> erros;

    public ValidacaoException(List<ErroValidacaoDTO> erros) {
        this.erros = erros;
    }

    public List<ErroValidacaoDTO> getErros() {
        return erros;
    }
}
