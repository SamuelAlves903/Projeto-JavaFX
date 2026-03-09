package com.clinica.fx.util;

import com.clinica.fx.enums.Cargo;

public class SessaoUsuario {

    private static String token;

    private static String usuario;

    private static Cargo cargo;

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        SessaoUsuario.token = token;
    }

    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String usuario) {
        SessaoUsuario.usuario = usuario;
    }

    public static Cargo getCargo() {
        return cargo;
    }

    public static void setCargo(Cargo cargo) {
        SessaoUsuario.cargo = cargo;
    }
}
