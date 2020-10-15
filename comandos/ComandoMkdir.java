package TrabalhoED1_ArvoreBinaria.comandos;

import TrabalhoED1_ArvoreBinaria.elementos.Arquivo;
import TrabalhoED1_ArvoreBinaria.elementos.ArvoreBinariaBusca;
import TrabalhoED1_ArvoreBinaria.elementos.Diretorio;
import TrabalhoED1_ArvoreBinaria.exceptions.DiretorioExistenteException;
import TrabalhoED1_ArvoreBinaria.exceptions.FaltaOperandoException;
import TrabalhoED1_ArvoreBinaria.exceptions.DiretorioInexistenteException;
import TrabalhoED1_ArvoreBinaria.exceptions.NaoEDiretorioException;
import TrabalhoED1_ArvoreBinaria.funcoes.Funcao;

public class ComandoMkdir implements Funcao{

    @Override
    public void fazFuncao(ArvoreBinariaBusca arvore, String... resComando) throws Exception {
        int index;
        
        if(resComando.length == 1){
            throw new FaltaOperandoException(resComando[0]);
        }else if(resComando.length == 2){
            if(resComando[1].contains("/")){
                index = resComando[1].lastIndexOf('/');
                Arquivo dir = arvore.interpretaPath(resComando[1].substring(0, index));
                if(dir == null){
                    throw new DiretorioInexistenteException(resComando[0], resComando[1]);
                }else if(!(dir instanceof Diretorio)){
                    throw new NaoEDiretorioException(resComando[0], resComando[1]);
                }else{
                    if(((Diretorio) dir).getDir().procuraArquivo(resComando[1].substring(index+1)) != null)
                        throw new DiretorioExistenteException(resComando[1]);
                    ((Diretorio) dir).getDir().addDiretorio(resComando[1].substring(index+1));
                }
            }else{
                if(arvore.procuraArquivo(resComando[1]) != null)
                    throw new DiretorioExistenteException(resComando[1]);
                arvore.addDiretorio(resComando[1]);
            }
        }
    }
    
}
