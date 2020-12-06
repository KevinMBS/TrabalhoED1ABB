package TrabalhoED1_ArvoreBinaria.validacao;

import TrabalhoED1_ArvoreBinaria.exceptions.PathInvalidoException;

public class ValidaTamanhoPath {
    public static void validador(String path) throws PathInvalidoException{
        int count = path.length() - path.replaceAll("/", "").length();
        if(!(count < 100)){
            throw new PathInvalidoException();
        }
    }
}
