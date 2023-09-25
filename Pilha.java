/*
               Estruturas de Dados I

                  INTEGRANTES:
        NOME                            TIA
Anderson Nicodemo                       32285671
Felipe do Nascimento Fonseca            42215366
Giovanni Alves Lavia                    42218365
Gustavo Garabetti Munhoz                42211956
Turma: 03N12

*/

public class Pilha { // Classe responsável pela implementação da estrutura de dados "pilha"
    private int[] pilha; // A pilha foi implementada utilizando um vetor
    private int topo;
    private static int MAX_TAM = 1000;

    public Pilha() { // método construtor padrão sem parâmetros
        this(MAX_TAM);
    }

    public Pilha(int size) { // método construtor com com parâmetros
        this.pilha = new int[size];
        this.setTopo(-1);
    }

    public int getTopo() { // retorna o ponteiro do topo da pilha
        return this.topo;
    }

    public void setTopo(int new_top) { // acessa o valor do ponteiro do topo
        this.topo = new_top;
    }

    public boolean isEmpty() { // verifica se a pilha está vazia
        return this.getTopo() < 0;
    }

    public void push(int valor) { // adiciona um item no topo da pilha
        if (!this.isFull()) {
            this.setTopo(this.getTopo() + 1);
            this.pilha[topo] = valor;
        } else
            System.out.println("Operação inválida. A pilha está cheia!");
    }

    public int pop() { // remove e retorna o elemento do topo da pilha
        if (!this.isEmpty()) {
            int topoAnterior = this.pilha[this.getTopo()];
            this.setTopo(this.getTopo() - 1);
            return topoAnterior;
        } else
            System.out.println("Operação inválida. A pilha está vazia!");
        return 0;
    }

    public int topo() { // retorna o valor do elemento do topo sem remove-lo
        if (!this.isEmpty())
            return this.pilha[this.getTopo()];
        else
            System.out.println("Operação inválida. A pilha está vazia!");
        return 0;
    }

    public boolean isFull() { // retorna se a pilha está cheia
        return this.getTopo() == this.pilha.length - 1;
    }

    public int sizeElements() { // retorna a quantidade de elementos
        return this.getTopo() + 1;
    }
}
