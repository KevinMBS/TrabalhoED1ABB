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
        
        if(atual.getChave().compareTo(chave) < 0)
            return procuraArquivoRec(atual.getEsquerdo(), chave);
        
        return procuraArquivoRec(atual.getDireito(), chave);
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
        
        if(atual.getChave().compareTo(chave) < 0)
            atual.setEsquerdo(addArquivoRec(raiz.getEsquerdo(), chave));
        
        atual.setDireito(addArquivoRec(raiz.getDireito(), chave));
        
        return atual;
    }
    
    public void printArvoreRecursivo(String caminho, Arquivo dir){
        Arquivo raiz = ((Diretorio)dir).getDir().getRaiz();
        ArrayList<Diretorio> dirsAvisitar = new ArrayList<>();
        caminho = caminho.concat("/" + dir.getChave());
        System.out.println("" + caminho);
        
        //Imprimindo e guardando em um array os nós desta arvore que são diretorios,portanto estes devem ser visitados
        dirsAvisitar = auxPrintListaRec(raiz);
        
        //visantando diretorios(arvores) contidas nos nós 
        for(Diretorio d:dirsAvisitar){
            printArvoreRecursivo(caminho, d);
        }
    }
    
    public static ArrayList<Diretorio> auxPrintListaRec(Arquivo atual){
        ArrayList<Diretorio> dirsAvisitar = new ArrayList<>();
        if(atual != null){
            
            ArrayList<Diretorio> esquerdo = auxPrintListaRec(atual.getEsquerdo());
            System.out.println(" " + atual.getChave());
            ArrayList<Diretorio> direito = auxPrintListaRec(atual.getDireito());
            if(esquerdo != null){
                for(Diretorio d:esquerdo){
                    dirsAvisitar.add(d);
                }
            }
            if(atual instanceof Diretorio){
                dirsAvisitar.add((Diretorio)atual);
            }
            if(direito != null){
                for(Diretorio d:direito){
                    dirsAvisitar.add(d);
                }
            }
            return dirsAvisitar;
        }
        return null;
    }
}
