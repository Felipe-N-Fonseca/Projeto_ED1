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

public class Utils { // Classe com métodos auxiliares
    // Zera os valores de das expressões e dos vetores auxiliares
    public static void zeraValores(String infixa, String posfixa, boolean presente[], boolean preenchi) {
        infixa = "";
        posfixa = "";
        preenchi = false;
        for (int i = 0; i < presente.length; i++) presente[i] = false;
    }

    // Verifica se a expressão é lexicamente correta
    public static boolean ehLexicamenteCorreto(String expressao, int prec[]) {
        boolean valido = true;
        // Percorre a expressão verificando se os caracteres são letras ou operadores
        for (int i = 0; i < expressao.length(); i++) { 
            // Se não for retorna false
            if (!Character.isLetter(expressao.charAt(i)) && prec[expressao.charAt(i)] == 0) valido = false;
        }
        return valido;
    }

    public static boolean ehSintaticamenteCorreto(String expressao, int prec[]) {
        Pilha simbolo = new Pilha(expressao.length()); // Cria uma pilha simbolo
        int estado = -1;
        for (int i = 0; i < expressao.length(); i++) { // Percorre a expressao
            if (estado != -1) { // Se o simbolo anterior não for um '(' ou ')'
                if (prec[expressao.charAt(i)] != 0) { // Se o simbolo atual for um operador ou '(' ou ')'
                    // O atual e o anterior são operadores = incorreto
                    if (expressao.charAt(i) != '(' && expressao.charAt(i) != ')' && estado == 2) return false;
                } else { // Se for uma variável
                    if (estado == 1) return false; // Duas variáveis consecutivas = incorreto
                }
            }

            if (expressao.charAt(i) == '(') {
                if(estado == 1) return false; // Anterior é variável e a atual é '(' = incorreto
                simbolo.push(expressao.charAt(i));
                estado = -1; // estado -1 representa parentesis
            } else if (expressao.charAt(i) == ')') {
                if (simbolo.isEmpty()) return false; // Fechar parentesis sem ter aberto = incorreto
                else {
                    simbolo.pop();
                    estado = -1;
                }
            } else if (Character.isLetter(expressao.charAt(i))) estado = 1; // estado 1 representa variavel
            else estado = 2; // estado 2 representa operador
        }

        return simbolo.isEmpty(); // Retorna se ainda há parêntesis abertos na pilha após fechar o último
    }

}
