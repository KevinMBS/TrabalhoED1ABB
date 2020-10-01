package arvoreBinariaBusca;

import elementos.Arquivo;

public class ABB {
    private Arquivo raiz;
    public ABB(){
        this.raiz = null;
    }

    public Arquivo getRaiz() {
        return raiz;
    }

    public void setRaiz(Arquivo raiz) {
        this.raiz = raiz;
    }
}
