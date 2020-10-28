package TrabalhoED1_ArvoreBinaria.elementos;

import java.util.ArrayList;

public class ArvoreBinariaBusca {
    private Arquivo raiz;
    public ArvoreBinariaBusca(){
        this.raiz = null;
    }

    public Arquivo getRaiz() {
        return raiz;
    }

    public void setRaiz(Arquivo raiz) {
        this.raiz = raiz;
    }
    
    public Arquivo procuraArquivo(String chave){ //Serve mais para chamar o metodo recursivo
        return procuraArquivoRec(this.raiz, chave);
    }
    
    private Arquivo procuraArquivoRec(Arquivo raiz, String chave){
        Arquivo atual = raiz;
        
        if(atual == null || atual.getChave().equals(chave)){
            return atual;
        }
        
        if(chave.compareTo(atual.getChave()) < 0)
            return procuraArquivoRec(atual.getEsquerdo(), chave);
        
        return procuraArquivoRec(atual.getDireito(), chave);
    }
    
    public void addDiretorio(String chave){
        this.raiz = addDiretorioRec(this.raiz, chave);
    }
    
    private Arquivo addDiretorioRec(Arquivo raiz, String chave){
        Arquivo atual = raiz;
        
        if(atual == null){
            atual = new Diretorio(chave);
            return (Diretorio) atual;
        }
        
        if(chave.compareTo(atual.getChave()) < 0){
            atual.setEsquerdo(addDiretorioRec(raiz.getEsquerdo(), chave));
        }else if(chave.compareTo(atual.getChave()) > 0){
            atual.setDireito(addDiretorioRec(raiz.getDireito(), chave));
        }
        return atual;
    }
    
    public void addArquivo(String chave){
        this.raiz = addArquivoRec(this.raiz, chave);
    }
    
    private Arquivo addArquivoRec(Arquivo raiz, String chave){
        Arquivo atual = raiz;
        
        if(atual == null){
            atual = new Arquivo(chave);
            return atual;
        }
        
        if(chave.compareTo(atual.getChave()) < 0){
            atual.setEsquerdo(addArquivoRec(raiz.getEsquerdo(), chave));
        }else if(chave.compareTo(atual.getChave()) > 0){
            atual.setDireito(addArquivoRec(raiz.getDireito(), chave));
        }
        return atual;
    }
    
    public Arquivo interpretaPath(String path){
        return interpretaPathRec(this, path);
    }
    
    private Arquivo interpretaPathRec(ArvoreBinariaBusca atual, String path){
        int index = 0;
        String dirAtual = path;
        Arquivo dir;
        if(path.contains("/")){
            index = path.indexOf("/");
            dirAtual = dirAtual.substring(0, index);
            dir = atual.procuraArquivo(dirAtual);
            if(dir instanceof Diretorio)
                return interpretaPathRec(((Diretorio) dir).getDir(), path.substring(index+1, path.length()));
            return dir;
        }else{
            return atual.procuraArquivo(dirAtual);
        }
    }
    
    public static void printArvoreRecursivo(String caminho, Arquivo dir){
        Arquivo raiz = ((Diretorio)dir).getDir().getRaiz();
        ArrayList<Diretorio> dirsAvisitar = new ArrayList<>();
        caminho = caminho.concat("/" + dir.getChave());
        System.out.println("" + caminho);
        
        //Imprimindo e guardando em um array os nós desta arvore que são diretorios,portanto estes devem ser visitados
        dirsAvisitar = auxPrintArvoreRec(raiz);
        
        //visantando diretorios(arvores) contidas nos nós 
        
        if(dirsAvisitar.isEmpty()){
            System.out.println("");
        } else {
            for(Diretorio d:dirsAvisitar){
               
                printArvoreRecursivo(caminho, d);

            }
        }
        
    }
    
    private static ArrayList<Diretorio> auxPrintArvoreRec(Arquivo atual){
        ArrayList<Diretorio> dirsAvisitar = new ArrayList<>();
        if(atual != null){
            ArrayList<Diretorio> esquerdo = auxPrintArvoreRec(atual.getEsquerdo());
            System.out.println(" "+atual.getChave());
            ArrayList<Diretorio> direito = auxPrintArvoreRec(atual.getDireito());
            if(esquerdo.isEmpty() == false){
                for(Diretorio d:esquerdo){
                    dirsAvisitar.add(d);
                }
            }
            if(atual instanceof Diretorio){
                dirsAvisitar.add((Diretorio)atual);
            }
            if(direito.isEmpty() == false){
                for(Diretorio d:direito){
                    dirsAvisitar.add(d);
                }
            }
            
            
        }
        return dirsAvisitar;
        
        
    }

    public void printArvore(String nomeDir) {
        System.out.println("./"+ nomeDir);
        Arquivo raiz = this.getRaiz();
        auxPrintArvore(raiz);
        
    }

    private static void auxPrintArvore(Arquivo raiz) {
        if(raiz.getEsquerdo() != null){
            auxPrintArvore(raiz.getEsquerdo());
        }
        System.out.println(raiz.getChave());
        if(raiz.getDireito() != null){
            auxPrintArvore(raiz.getDireito());
        }
    }
    
    
}
