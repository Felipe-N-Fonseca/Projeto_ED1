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

public class StackAlgorithms {
    public static String converterInfixaParaPosfixa(String Infixa, int precedencia[]) {
        Pilha auxiliar = new Pilha(Infixa.length());

        String posfixa = "";
        for (int i = 0; i < Infixa.length(); i++) { // Percorre a expressão
            if (Character.isLetter(Infixa.charAt(i))) // Se for uma variável, é adicionada diretamente na expressão final
                posfixa += Infixa.charAt(i);
            else { // Se não, coloca os parenteses e especiais dentro da pilha auxiliar de acordo com a prioridade
                if (Infixa.charAt(i) == '(')
                    auxiliar.push(Infixa.charAt(i));
                else if (Infixa.charAt(i) == ')') {
                    while (!auxiliar.isEmpty() && auxiliar.topo() != '(')
                        posfixa += (char) auxiliar.pop();
                    auxiliar.pop();
                } else {
                    while (!auxiliar.isEmpty() && precedencia[auxiliar.topo()] >= precedencia[Infixa.charAt(i)]) {
                        posfixa += (char) auxiliar.pop();
                    }
                    auxiliar.push(Infixa.charAt(i));
                }
            }
        }

        while (!auxiliar.isEmpty()) // Posfixa recebe o topo da pilha auxiliar enquanto a pilha não for vazia
            posfixa += (char) auxiliar.pop();

        return posfixa; // Retorna a expressao posfixa
    }

    public static boolean ExpressaoValida(String expressao, int precedencia[]) {
        boolean simbolosValidos, operandosCorretos;

        simbolosValidos = Utils.ehLexicamenteCorreto(expressao, precedencia);
        operandosCorretos = Utils.ehSintaticamenteCorreto(expressao, precedencia);

        return operandosCorretos && simbolosValidos;
    }

    public static int AvaliaExpressao(String posfixa, int value[]) { // Realiza o calculo da expressão matematica
        Pilha auxiliar = new Pilha(posfixa.length()); // Cria uma pilha auxiliar
        int res = 0;
        for (int i = 0; i < posfixa.length(); i++) { // Percorre toda expressão
            if (Character.isLetter(posfixa.charAt(i))) { // Se for uma variável, empilha o valor dela
                auxiliar.push(value[posfixa.charAt(i) - 'A']);
            } else {
                int x = auxiliar.pop(), y = auxiliar.pop(); // Pega os ultimos dois topos da pilha, e guarda em x e y
                if (posfixa.charAt(i) == '+') res = x + y;
                else if (posfixa.charAt(i) == '-') res = y - x;
                else if (posfixa.charAt(i) == '*') res = x * y;
                else if (posfixa.charAt(i) == '/') res = y / x;
                else res = (int) Math.pow(y, x);

                auxiliar.push(res);
            }
        }
        res = auxiliar.isEmpty() ? 0 : auxiliar.pop(); // Se a auxiliar estiver vazia o resultado é zero
        return res;
    }
}
