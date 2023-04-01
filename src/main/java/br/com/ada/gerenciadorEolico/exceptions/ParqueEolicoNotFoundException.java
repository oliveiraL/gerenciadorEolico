package br.com.ada.gerenciadorEolico.exceptions;

public class ParqueEolicoNotFoundException extends RuntimeException {
    public ParqueEolicoNotFoundException() {
        super("Parque Eolico não encontrado");
    }
}
