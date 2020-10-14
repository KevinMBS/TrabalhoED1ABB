package TrabalhoED1_ArvoreBinaria.comandos;

import TrabalhoED1_ArvoreBinaria.elementos.ArvoreBinariaBusca;
import TrabalhoED1_ArvoreBinaria.exceptions.ArquivoExistenteException;
import TrabalhoED1_ArvoreBinaria.exceptions.FaltaOperandoException;
import TrabalhoED1_ArvoreBinaria.funcoes.Funcao;


public class ComandoTouch implements Funcao{

    @Override
    public void fazFuncao(ArvoreBinariaBusca arvore, String... resComando) throws Exception {
        int index;
        
        if(resComando.length == 1){
            throw new FaltaOperandoException(resComando[0]);
        }else if(resComando.length == 2){
            if(resComando[1].contains("/")){
                index = resComando[1].lastIndexOf('/');
                
            }else{
                if(arvore.procuraArquivo(resComando[1]) != null)
                    throw new ArquivoExistenteException(resComando[1]);
                arvore.addArquivo(resComando[1]);
            }
        }
    }
    
}
