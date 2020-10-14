package TrabalhoED1_ArvoreBinaria.exceptions;

public class ArquivoExistenteException extends Exception{
    public ArquivoExistenteException(String op){
        super("touch: File " + op + " already exists");
    }
}
