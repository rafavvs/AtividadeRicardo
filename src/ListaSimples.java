public class ListaSimples implements ListaOperacoes {
    private String[] lista;
    private String[] dados;
    private int tamanho;

    public ListaSimples(int tamanho) {
        this.lista = new String[tamanho];
    }

    // Métodos originais
    public void exibirElementos() {
        for (int i = 0; i < this.lista.length; i++) {
            System.out.println("Lista[" + i + "] = " + this.lista[i]);
        }
    }

    public void adicionarElemento(String elemento) {
        if (!estaCheia()) {
            this.lista[encontrarPosicaoVazia()] = elemento;
            System.out.println("Elemento " + elemento + " adicionado com sucesso!");
        }
    }


    private boolean estaCheia() {
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] == null) {
                return false;
            }
        }
        System.out.println("A lista está cheia!");
        return true;
    }

    private boolean estaVazio() {
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] != null) {
                return false;
            }
        }
        System.out.println("A lista está vazia!");
        return true;
    }

    private int encontrarPosicaoVazia() {
        int i;
        for (i = 0; i < this.lista.length; i++) {
            if (this.lista[i] == null) {
                return i;
            }
        }
        return i;
    }

    public void removerElemento(String elemento) {
        if (!estaVazio()) {
            if (this.buscarElemento(elemento) >= 0) {
                this.lista[this.buscarElemento(elemento)] = null;
                System.out.println("Elemento " + elemento + " removido com sucesso!");
            }
        }
    }

    public int buscarElemento(String elemento) {
        int i;
        if (!estaVazio()) {
            for (i = 0; i < this.lista.length; i++) {
                if (this.lista[i].equals(elemento)) {
                    return i;
                }
            }
        }
        System.out.println("Elemento não encontrado na lista.");
        return -1;
    }

    public void alterarElemento(String elementoASerAlterado, String alteracao) {
        if (buscarElemento(elementoASerAlterado) >= 0) {
            this.lista[buscarElemento(elementoASerAlterado)] = alteracao;
            System.out.println("Elemento " + elementoASerAlterado + " alterado com sucesso para " + alteracao);
        }
    }

    public void quantidadeElementos() {
        int cont = 0;
        if (!estaVazio()) {
            for (int i = 0; i < this.lista.length; i++) {
                if (this.lista[i] != null) {
                    cont++;
                }
            }
        }
        System.out.println("A lista possui " + cont + " elementos!");
    }

    // Novos métodos (implementação da interface)
    @Override
    public int removerTodas(String elemento) {
        int removidos = 0;

        for (int i=0; i<lista.length; i++) {
            if (lista[i] != null && lista[i].equals(elemento)) {
                lista[i] = null;
                removidos++;
            }
        }
        return removidos;
    }

    @Override
    public int contar() {
        int cont = 0;
        for (int i=0; i<lista.length; i++) {
            if (lista[i] != null) {
                cont++;
            }
        }
        return cont;
    }

    @Override
    public int adicionarVarios(String[] elementos) {
        int adicionados = 0;
        for (String e : elementos) {
            if (!estaCheia()) {
                lista[encontrarPosicaoVazia()] = e;
                adicionados++;
            } else {
                break;
            }
        }
        return adicionados;
    }

    @Override
    public String obter(int indice) {
        if (indice<0 || indice>=lista.length) {
            return null;
        }
        return lista[indice];
    }

    @Override
    public boolean inserir(int indice, String elemento) {
        if (indice<0 || indice>=lista.length) {
            return false;
        }
        if (lista[indice] == null) {
            lista[indice] = elemento;
            return true;
        }
        if (estaCheia()) {
            return false;
        }
        for (int i = lista.length-1; i>indice; i--) {
            lista[i] = lista[i - 1];
        }
        lista[indice] = elemento;
        return true;
    }

    @Override
    public String removerPorIndice(int indice) {
        if (indice<0 || indice>=lista.length) {
            return null;
        }
        String removido = lista[indice];
        lista[indice] = null;
        return removido;
    }

    @Override
    public void limpar() {
        for (int i=0; i<lista.length; i++) {
            lista[i] = null;
        }
    }

    @Override
    public int ultimoIndiceDe(String elemento) {
        for (int i=lista.length-1; i>=0; i--) {
            if (lista[i] != null && lista[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int contarOcorrencias(String elemento) {
        int cont = 0;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null && lista[i].equals(elemento)) {
                cont++;
            }
        }
        return cont;
    }

    @Override
    public int substituir(String antigo, String novo) {
        int substituidos = 0;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null && lista[i].equals(antigo)) {
                lista[i] = novo;
                substituidos++;
            }
        }
        return substituidos;
    }
}