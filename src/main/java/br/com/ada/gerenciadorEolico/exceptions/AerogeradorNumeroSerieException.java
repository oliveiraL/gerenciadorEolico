package br.com.ada.gerenciadorEolico.exceptions;

public class AerogeradorNumeroSerieException extends RuntimeException{

    public AerogeradorNumeroSerieException() {
        super("Aerogerador já existe");
    }
}
