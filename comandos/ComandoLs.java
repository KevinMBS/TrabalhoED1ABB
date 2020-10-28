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
        
        Arquivo dir;      
        if(resComando.length == 1){
            arvore.printArvore("");
        }else if(resComando[1].equals("-R")){
            //recursiva
            if(resComando.length == 3){
                dir = arvore.interpretaPath(resComando[2]);
            }else{
                dir = arvore.getRaiz();
            }
            if(dir == null){ //Diretorio não existe
                throw new DiretorioInexistenteLSException(resComando[0], resComando[1]);
            }else if(!(dir instanceof Diretorio)){ //Ou seja, se ele for um arquivo base não é possivel imprir seu conteudo no nosso sistema
                System.out.println(""+dir.getChave());
            }else{
                printArvoreRecursivo(".",dir);
            } 
        }else{
            //não recursiva
            dir = arvore.interpretaPath(resComando[1]);
            if(dir == null){ //Diretorio não existe
                throw new DiretorioInexistenteLSException(resComando[0], resComando[1]);
            }else if(!(dir instanceof Diretorio)){ //Ou seja, se ele for um arquivo base não é possivel imprir seu conteudo no nosso sistema
                System.out.println(""+dir.getChave());
            }else{
                ((Diretorio)dir).getDir().printArvore(dir.getChave());
        
            }
        }
    }
    
}
