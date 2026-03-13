public class ListaDinamica implements ListaOperacoes {
    private No inicio;
    private int tamanho;

    private class No {
        String conteudo;
        No proximo;

        No(String conteudo) {
            this.conteudo = conteudo;
            this.proximo = null;
        }

        public String getConteudo() {
            return conteudo;
        }

        public void setConteudo(String conteudo) {
            this.conteudo = conteudo;
        }

        public No getProx() {
            return proximo;
        }

        public void setProx(No proximo) {
            this.proximo = proximo;
        }
    }

    public ListaDinamica() {
        // Inicializa como null para representar uma lista vazia
        this.inicio = new No(null);
        this.tamanho = 0;
        System.out.println("Lista Dinâmica criada com sucesso!");
    }

    // Métodos originais
    public void adicionarElemento(String conteudo) {
        if (!this.existeInicio()) {
            this.inicio.setConteudo(conteudo);
        } else {
            No novoNo = new No(conteudo);
            No aux = this.inicio;
            while (aux.getProx() != null) {
                aux = aux.getProx();
            }
            aux.setProx(novoNo);
        }
    }

    private boolean existeInicio() {
        if (this.inicio.getConteudo() == null) {
            return false;
        } else {
            return true;
        }
    }

    public void exibirElementos() {
        if (existeInicio()) {
            No aux = this.inicio;
            while (aux.getProx() != null) {
                System.out.println(aux.getConteudo());
                aux = aux.getProx();
            }
            System.out.println(aux.getConteudo());
        } else {
            System.out.println("Não existem elementos na Lista Dinâmica.");
        }
    }

    public void removerElemento(String elemento) {
        if (existeInicio()) {
            if (buscarElemento(elemento)) {
                //removendo primeiro
                if (this.inicio.getConteudo().equals(elemento)) {
                    this.inicio = this.inicio.getProx();
                } else if (this.inicio.getProx() != null) {
                    No aux = this.inicio;
                    do {
                        if (aux.getProx().getConteudo().equals(elemento)) {
                            aux.setProx(aux.getProx().getProx());
                            return;
                        }
                        aux = aux.getProx();
                    } while (aux != null);
                } else {
                    this.inicio.setConteudo(null);
                }

                //removendo intermediário
                //método de busca
            }

        } else {
            System.out.println("Não existem elementos na lista.");
        }
    }

    public boolean buscarElemento(String elemento) {
        No aux = this.inicio;

        do {
            if (aux.getConteudo().equals(elemento)) {
                System.out.println("Elemento " + elemento + " encontrado.");
                return true;
            }
            aux = aux.getProx();
        } while (aux != null);
        System.out.println("Elemento " + elemento + " não encontrado!");
        return false;
    }

    // Novos métodos (implementação da interface)
    @Override
    public int removerTodas(String elemento) {
        int removidos = 0;
        while (inicio != null && inicio.getConteudo() != null && inicio.getConteudo().equals(elemento)) {
            inicio = inicio.getProx();
            removidos++;
        }
        No atual = inicio;
        while (atual != null && atual.getProx() != null) {
            if (atual.getProx().getConteudo().equals(elemento)) {
                atual.setProx(atual.getProx().getProx());
                removidos++;
            } else {
                atual = atual.getProx();
            }
        }
        return removidos;
    }

    @Override
    public int contar() {
        int cont = 0;
        No aux = inicio;
        while (aux != null && aux.getConteudo() != null) {
            cont++;
            aux = aux.getProx();
        }
        return cont;
    }

    @Override
    public int adicionarVarios(String[] elementos) {
        int cont = 0;
        for (String e : elementos) {
            adicionarElemento(e);
            cont++;
        }
        return cont;
    }

    @Override
    public String obter(int indice) {
        if (indice < 0) {
            return null;
        }
        No aux = inicio;
        int i = 0;
        while (aux != null && aux.getConteudo() != null) {
            if (i == indice) {
                return aux.getConteudo();
            }
            aux = aux.getProx();
            i++;
        }
        return null;
    }

    @Override
    public boolean inserir(int indice, String elemento) {
        if (indice < 0) {
            return false;
        }
        No novo = new No(elemento);
        if (indice == 0) {
            novo.setProx(inicio);
            inicio = novo;
            return true;
        }
        No aux = inicio;
        int i = 0;
        while (aux != null && i < indice - 1) {
            aux = aux.getProx();
            i++;
        }
        if (aux == null) {
            return false;
        }
        novo.setProx(aux.getProx());
        aux.setProx(novo);
        return true;
    }

    @Override
    public String removerPorIndice(int indice) {
        if (indice < 0 || inicio == null) {
            return null;
        }
        if (indice == 0) {
            String valor = inicio.getConteudo();
            inicio = inicio.getProx();
            return valor;
        }
        No aux = inicio;
        int i = 0;
        while (aux.getProx() != null && i < indice - 1) {
            aux = aux.getProx();
            i++;
        }
        if (aux.getProx() == null) {
            return null;
        }
        String valor = aux.getProx().getConteudo();
        aux.setProx(aux.getProx().getProx());
        return valor;
    }

    @Override
    public void limpar() {
        inicio = new No(null);
    }

    @Override
    public int ultimoIndiceDe(String elemento) {
        int indice = 0;
        int ultimo = -1;
        No aux = inicio;
        while (aux != null && aux.getConteudo() != null) {
            if (aux.getConteudo().equals(elemento)) {
                ultimo = indice;
            }
            aux = aux.getProx();
            indice++;
        }
        return ultimo;
    }

    @Override
    public int contarOcorrencias(String elemento) {
        int cont = 0;
        No aux = inicio;
        while (aux != null && aux.getConteudo() != null) {
            if (aux.getConteudo().equals(elemento)) {
                cont++;
            }
            aux = aux.getProx();
        }
        return cont;
    }

    @Override
    public int substituir(String antigo, String novo) {
        int cont = 0;
        No aux = inicio;
        while (aux != null && aux.getConteudo() != null) {
            if (aux.getConteudo().equals(antigo)) {
                aux.setConteudo(novo);
                cont++;
            }
            aux = aux.getProx();
        }
        return cont;
    }
}