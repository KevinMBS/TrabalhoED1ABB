package TrabalhoED1_ArvoreBinaria.funcoes;

import TrabalhoED1_ArvoreBinaria.elementos.ArvoreBinariaBusca;
import TrabalhoED1_ArvoreBinaria.elementos.Arquivo;
import TrabalhoED1_ArvoreBinaria.elementos.Diretorio;


public abstract class InterpretaPath {
    //isso é iterativo
    /*
    public static Arquivo interpreta(ABB lista, String path) throws PathInvalidoException, NaoEDiretorioException{
    
        String[] dirsAVisitar = path.split("/");
        ABB dirAtual = lista;
        Arquivo atual = dirAtual.getRaiz();
        int i, tamanho;
        
        i = 0;
        tamanho = dirsAVisitar.length-1;
        while(atual != null){
            if(atual.getChave().equals(dirsAVisitar[i]) && i < tamanho){
                if(atual instanceof Diretorio){
                    dirAtual = ((Diretorio) atual).getDir();
                    atual = dirAtual.getRaiz();
                    i++;
                }
            }else if(atual.getChave().equals(dirsAVisitar[i]) && i == tamanho){
                return atual;
            }else{
                atual = atual.getProx();
            }
        }
        return null;
    }
    */
    
    //isso é recursivo(melhor)
    //recebe a arvore onde deseja-se procurar o path,e o path dividido,ou seja, path.split
    public static Arquivo intertpreta(String pathDividido[], ArvoreBinariaBusca arvore){
        Arquivo atual = arvore.getRaiz();
        String aux[] = null;
        //caso este não seja o ultimo caminho a ter que ser visitado o vetor aux será passado como parâmetro,este tem uma posição a menos que o pathDividido
        if(pathDividido.length != 1){
            
            aux = new String[pathDividido.length-1];
            for(int i=1;i < pathDividido.length;i++){
                aux[i-1] = pathDividido[i];

            }
        }
        while(atual != null){
            if(atual.getChave().compareTo(pathDividido[0]) == 0){
                //iguais
                if(pathDividido.length != 1){
                    //arrumar pois path tem que ser dividido
                    if(atual instanceof Diretorio){
                        return intertpreta(aux, ((Diretorio)atual).getDir());
                    }else{
                        //não é um diretório possivel
                        return null;
                    }
                }else{
                    
                    return atual;
                }
                //retornar recursivamente
            }else if(atual.getChave().compareTo(pathDividido[0]) <= -1){
                //vai para a esquerda pois a chave do caminho procurado tem tamanho menor que o atual
                atual = atual.getEsquerdo();
            }else{
                //vai para a direita pois a chave do caminho procurado tem tamanho maior que o atual
                atual = atual.getDireito();
            }
        }
        return null;
    }
}