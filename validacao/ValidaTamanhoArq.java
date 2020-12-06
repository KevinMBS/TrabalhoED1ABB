package TrabalhoED1_ArvoreBinaria.validacao;

import TrabalhoED1_ArvoreBinaria.exceptions.NomeInvalidoException;

public class ValidaTamanhoArq {
    public static void validador(String nome) throws NomeInvalidoException{
        if(nome.length() > 50)
            throw new NomeInvalidoException(nome);
    }
}
