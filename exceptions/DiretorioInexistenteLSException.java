package TrabalhoED1_ArvoreBinaria.exceptions;

public class DiretorioInexistenteLSException extends Exception{
    public DiretorioInexistenteLSException(){
        super("cannot list from this directory");
    }
}
