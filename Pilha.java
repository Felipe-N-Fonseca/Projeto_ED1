public class Pilha {
    private char[] pilha;
    private int topo = -1;
    private int tamanho = 1000;

    public Pilha(){
        pilha = new char[tamanho];
    }

    public Pilha(int tamanho){
        pilha = new char[tamanho];
        this.tamanho = tamanho;
    }

    public char pop(){
        if(!isEmpty()){
            return pilha[topo--];
        }else{
            System.out.println("Operação inválida.");
            return 0;
        }
    }

    public char topo(){
        if(!isEmpty()){
            return pilha[topo];
        }else{
            System.out.println("Operação inválida.");
            return 0;
        }
    }

    public void push(char valor){
        if(!isFull()){
            pilha[++topo] = valor;
        }else{
            System.out.println("Operação inválida.");
        }    
    }

    public boolean isEmpty(){
        return topo < 0;
    }

    public boolean isFull(){
        return topo == tamanho;
    }
}
