package br.com.ada.gerenciadorEolico.exceptions;

public class AerogeradorNotFoundException extends RuntimeException {
    public AerogeradorNotFoundException() {
        super("Aerogerador não encontrado");
    }
}
