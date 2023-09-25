public class Pilha { // Classe responsável pela implementação da estrutura de dados "pilha"
    private int[] pilha;
    private int topo;
    private static int MAX_TAM = 1000;

    public Pilha() { // método construtor padrão
        this(MAX_TAM);
    }

    public Pilha(int size) { // método construtor com tamanho definido
        this.pilha = new int[size];
        this.setTopo(-1);
    }

    public int getTopo() { // retorna o ponteiro do topo da pilha
        return this.topo;
    }

    public void setTopo(int new_top) { // define o valor do ponteiro do topo
        this.topo = new_top;
    }

    public boolean isEmpty() { // retorna um valor booleano, verdadeiro caso a pilha esteja vazia
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
