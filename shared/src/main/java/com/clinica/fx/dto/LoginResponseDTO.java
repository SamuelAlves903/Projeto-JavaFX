package com.clinica.fx.dto;

import com.clinica.fx.enums.Cargo;

public record LoginResponseDTO(

        String token,
        String usuario,
        Cargo cargo
) {}
