public class Utils { // Classe auxiliar
    public static void zeraValores(String infixa, String posfixa, boolean presente[], boolean preenchi) { // Zera os
                                                                                                          // valores de
                                                                                                          // um vetor
        infixa = "";
        posfixa = "";
        preenchi = false;
        for (int i = 0; i < presente.length; i++)
            presente[i] = false;
    }

    public static boolean ehLexicamenteCorreto(String expressao, int prec[]) { // Verifica se a expressão é lexicamente
                                                                               // correta
        boolean valido = true;
        for (int i = 0; i < expressao.length(); i++) { // Percorre o vetor verificando se os caracteres são letras e a
                                                       // expressão foi preenchida corrrtamente
            if (!Character.isLetter(expressao.charAt(i)) && prec[expressao.charAt(i)] == 0) {
                valido = false; // Se for diferente retorna um falso
            }
        }
        return valido;
    }

    public static boolean ehSintaticamenteCorreto(String expressao, int prec[]) { // Verifica se a sintaxe da expressão
                                                                                  // está correta
        Pilha operador = new Pilha(expressao.length()); // Cria uma pilha operador
        int estado = -1;
        for (int i = 0; i < expressao.length(); i++) { // Percorre a expressao
            if (estado != -1) { // Verifica os estados da expressão
                if (prec[expressao.charAt(i)] != 0) { // dois operadores consecutivos
                    if (expressao.charAt(i) != '(' && expressao.charAt(i) != ')' && estado == 2)
                        return false;
                } else {
                    if (estado == 1)
                        return false; // duas variáveis consecutivas
                }
            }

            if (expressao.charAt(i) == '(') {
                if(estado == 1) return false;
                operador.push(expressao.charAt(i));
                estado = -1; // estado -1 representa parentesis
            } else if (expressao.charAt(i) == ')') {
                if (operador.isEmpty())
                    return false;
                else {
                    operador.pop();
                    estado = -1;
                }
            } else if (Character.isLetter(expressao.charAt(i)))
                estado = 1; // estado 1 representa variavel
            else
                estado = 2; // estado 2 representa operador
        }

        return operador.isEmpty(); // Retorna se o operador está vazio ou não
    }

}
