public class Pilha {
    private int[] pilha;
    private int topo;
    private static int MAX_TAM = 1000;

    public Pilha(){
        this(MAX_TAM);
    }

    public Pilha(int size){
        this.pilha = new int[size];
        this.setTopo(-1);
    }

    public int getTopo(){ return this.topo; }

    public void setTopo(int new_top){ this.topo = new_top; }

    public boolean isEmpty(){ return this.getTopo() < 0; }

    public void push(int valor){
        if(!this.isFull()){
            this.setTopo(this.getTopo()+1);
            this.pilha[topo] = valor;
        }else System.out.println("Operação inválida. A pilha está cheia!");
    }

    public int pop(){
        if(!this.isEmpty()){
            int topoAnterior = this.pilha[this.getTopo()];
            this.setTopo(this.getTopo()-1);
            return topoAnterior;
        }else System.out.println("Operação inválida. A pilha está vazia!");
        return 0;
    }

    public int topo(){
        if(!this.isEmpty()) return this.pilha[this.getTopo()];
        else System.out.println("Operação inválida. A pilha está vazia!");
        return 0;
    }

    public boolean isFull(){ return this.getTopo() == this.pilha.length-1; }

    public int sizeElements(){ return this.getTopo()+1; }
}
