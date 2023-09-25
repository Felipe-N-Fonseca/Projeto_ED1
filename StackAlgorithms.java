public class StackAlgorithms { // Classe dos algoritmos da pilha
    public static String converterInfixaParaPosfixa(String Infixa, int precedencia[]) { // Converte infixa para pos-fixa
        Pilha auxiliar = new Pilha(Infixa.length());

        String posfixa = "";
        for (int i = 0; i < Infixa.length(); i++) { // Percorre a expressão infixa
            if (Character.isLetter(Infixa.charAt(i))) // Se for um caractere letra adiciona diretamente a pos fixa
                posfixa += Infixa.charAt(i);
            else { // Se não, coloca os parenteses e especiais dentro de um vetor auxiliar
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

        while (!auxiliar.isEmpty()) // Pos-fixa recebe o topo do vetor auxiliar
            posfixa += (char) auxiliar.pop();

        return posfixa; // Retorna a expressao pos-fixa
    }

    public static boolean ExpressaoValida(String expressao, int precedencia[]) { // Verifica se a expressao é válida
        boolean simbolosValidos, operandosCorretos;

        simbolosValidos = Utils.ehLexicamenteCorreto(expressao, precedencia); // Verifica se a expressão é lexicamente correta
        operandosCorretos = Utils.ehSintaticamenteCorreto(expressao, precedencia); // Verifica se os operandos correspodem

        return operandosCorretos && simbolosValidos; // Retorna um valor booleano true ou false para isso
    }

    public static int AvaliaExpressao(String posfixa, int value[]) { // Realiza o calculo da expressao matematica
        Pilha auxiliar = new Pilha(posfixa.length()); // Cria uma pilha auxiliar para isso
        int res = 0;
        for (int i = 0; i < posfixa.length(); i++) { // Percorre toda expressão
            if (Character.isLetter(posfixa.charAt(i))) { // Se for uma letra adiciona o caractere
                auxiliar.push(value[posfixa.charAt(i) - 'A']);
            } else { // Senão verifica quais são os operandos
                int x = auxiliar.pop(), y = auxiliar.pop(); // Define x e y para as operacoes
                if (posfixa.charAt(i) == '+') // Se o caractere for "+" realiza a operação de soma
                    res = x + y;
                else if (posfixa.charAt(i) == '-') // Se o caractere for "-" realiza a operação de subtração
                    res = y - x;
                else if (posfixa.charAt(i) == '*') // Se o caractere for "*" realiza a operação de multiplicação
                    res = x * y;
                else if (posfixa.charAt(i) == '/') // Se o caractere for "/" realiza a operação de divisão
                    res = y / x;
                else
                    res = (int) Math.pow(y, x); // Se não for esses operandos trata-se de uma operação de potenciação

                auxiliar.push(res); // Insere o resultado no vetor auxiliar
            }
        }
        res = auxiliar.isEmpty() ? 0 : auxiliar.pop(); // Se a aulixiar estiver vazia o resultado é zero
        return res; // Retorna o resultado
    }
}
