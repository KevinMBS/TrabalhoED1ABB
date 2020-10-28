package TrabalhoED1_ArvoreBinaria.comandos;

import TrabalhoED1_ArvoreBinaria.elementos.Arquivo;
import TrabalhoED1_ArvoreBinaria.elementos.ArvoreBinariaBusca;
import static TrabalhoED1_ArvoreBinaria.elementos.ArvoreBinariaBusca.printArvoreRecursivo;
import TrabalhoED1_ArvoreBinaria.elementos.Diretorio;
import TrabalhoED1_ArvoreBinaria.exceptions.DiretorioInexistenteLSException;
import TrabalhoED1_ArvoreBinaria.funcoes.Funcao;


public class ComandoLs implements Funcao{

    @Override
    public void fazFuncao(ArvoreBinariaBusca arvore, String... resComando) throws Exception {
        
        ArvoreBinariaBusca dir; 
        Arquivo aux = null;
        if(resComando.length == 1){
            arvore.printArvore("");
        }else if(resComando[1].equals("-R")){
            //recursiva
            if(resComando.length == 3){
                aux = arvore.interpretaPath(resComando[2]);
                if(((Diretorio)aux).getDir().getRaiz() == null){ //Diretorio não existe
                    throw new DiretorioInexistenteLSException(resComando[0], resComando[1]);
                }else if(!(aux instanceof Diretorio)){ //Ou seja, se ele for um arquivo base não é possivel imprir seu conteudo no nosso sistema
                     System.out.println("./");
                }
                printArvoreRecursivo(".", ((Diretorio)aux).getDir(),aux.getChave());
            }else{
                dir = arvore;       
                printArvoreRecursivo(".", dir,"");
            }

        }else{
            //não recursiva
            aux = arvore.interpretaPath(resComando[1]);
            if(((Diretorio)aux).getDir() == null){ //Diretorio não existe
                throw new DiretorioInexistenteLSException(resComando[0], resComando[1]);
            }else if(!(((Diretorio)aux).getDir().getRaiz() instanceof Diretorio)){ //Ou seja, se ele for um arquivo base não é possivel imprir seu conteudo no nosso sistema
                System.out.println("./");
            }else{
                ((Diretorio)aux).getDir().printArvore(aux.getChave());
        
            }
        }
    }
    
}
