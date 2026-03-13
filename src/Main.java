public class Main {

    public static void main(String[] args) {

        System.out.println("--- TESTANDO LISTA SIMPLES ---");

        ListaSimples listaSimples = new ListaSimples(10);

        // Métodos originais
        listaSimples.adicionarElemento("Arroz");
        listaSimples.adicionarElemento("Feijão");
        listaSimples.adicionarElemento("Macarrão");
        listaSimples.adicionarElemento("Arroz");

        listaSimples.exibirElementos();

        System.out.println("\nBuscar Feijão: índice = " + listaSimples.buscarElemento("Feijão"));

        listaSimples.alterarElemento("Macarrão", "Batata");

        listaSimples.quantidadeElementos();

        listaSimples.removerElemento("Feijão");

        listaSimples.exibirElementos();


        // Interface

        System.out.println("\nAdicionar vários:");
        String[] novos = {"Tomate", "Alface", "Arroz"};
        int adicionados = listaSimples.adicionarVarios(novos);
        System.out.println("Adicionados: " + adicionados);

        listaSimples.exibirElementos();

        System.out.println("\nTotal elementos: " + listaSimples.contar());

        System.out.println("\nElemento no índice 2: " + listaSimples.obter(2));

        System.out.println("\nInserindo 'Leite' no índice 1");
        listaSimples.inserir(1, "Leite");
        listaSimples.exibirElementos();

        System.out.println("\nRemover por índice 3: " + listaSimples.removerPorIndice(3));
        listaSimples.exibirElementos();

        System.out.println("\nOcorrências de 'Arroz': " + listaSimples.contarOcorrencias("Arroz"));

        System.out.println("\nÚltimo índice de 'Arroz': " + listaSimples.ultimoIndiceDe("Arroz"));

        System.out.println("\nSubstituindo 'Arroz' por 'Pão'");
        int substituidos = listaSimples.substituir("Arroz", "Pão");
        System.out.println("Substituições realizadas: " + substituidos);
        listaSimples.exibirElementos();

        System.out.println("\nRemovendo todas ocorrências de 'Pão'");
        int removidos = listaSimples.removerTodas("Pão");
        System.out.println("Removidos: " + removidos);
        listaSimples.exibirElementos();

        System.out.println("\nLimpando lista...");
        listaSimples.limpar();
        listaSimples.exibirElementos();



        System.out.println("\n\n--- TESTANDO LISTA DINÂMICA ---");

        ListaDinamica listaDinamica = new ListaDinamica();

        // Métodos originais
        listaDinamica.adicionarElemento("Ana");
        listaDinamica.adicionarElemento("Carlos");
        listaDinamica.adicionarElemento("Pedro");
        listaDinamica.adicionarElemento("Ana");

        listaDinamica.exibirElementos();

        listaDinamica.buscarElemento("Carlos");

        listaDinamica.removerElemento("Pedro");

        System.out.println("\nLista após remover Pedro:");
        listaDinamica.exibirElementos();


        // Interface

        System.out.println("\nAdicionar vários:");
        String[] pessoas = {"Maria", "João", "Ana"};
        int add = listaDinamica.adicionarVarios(pessoas);
        System.out.println("Adicionados: " + add);

        listaDinamica.exibirElementos();

        System.out.println("\nTotal elementos: " + listaDinamica.contar());

        System.out.println("\nElemento no índice 2: " + listaDinamica.obter(2));

        System.out.println("\nInserindo 'Lucas' no índice 1");
        listaDinamica.inserir(1, "Lucas");

        listaDinamica.exibirElementos();

        System.out.println("\nRemover por índice 2: " + listaDinamica.removerPorIndice(2));

        listaDinamica.exibirElementos();

        System.out.println("\nOcorrências de 'Ana': " + listaDinamica.contarOcorrencias("Ana"));

        System.out.println("\nÚltimo índice de 'Ana': " + listaDinamica.ultimoIndiceDe("Ana"));

        System.out.println("\nSubstituindo 'Ana' por 'Julia'");
        int subs = listaDinamica.substituir("Ana", "Julia");
        System.out.println("Substituições: " + subs);

        listaDinamica.exibirElementos();

        System.out.println("\nRemovendo todas 'Julia'");
        int rem = listaDinamica.removerTodas("Julia");
        System.out.println("Removidos: " + rem);

        listaDinamica.exibirElementos();

        System.out.println("\nLimpando lista...");
        listaDinamica.limpar();

        listaDinamica.exibirElementos();
    }
}