package TrabalhoED1_ArvoreBinaria.exceptions;

public class ArquivoExistenteException1 extends Exception{
    public ArquivoExistenteException1(String op){
        super("touch: File " + op + " already exists");
    }
}
