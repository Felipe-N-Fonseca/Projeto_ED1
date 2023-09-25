import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String infixa = "", posfixa = "";

        boolean fimDoPrograma = false, inseriValores = false, gerouPosfixa = false;
        boolean estaNaExpressao[] = new boolean[27];
        int valor[] = new int[27];
        int precedencia[] = new int[100];

        //Define a precedência dos operadores
        precedencia['+'] = 2;
        precedencia['-'] = 2;
        precedencia['*'] = 3;
        precedencia['/'] = 3;
        precedencia['^'] = 4;
        precedencia['('] = 1;
        precedencia[')'] = 1;

        //Verifica a escolha do usuario atráves de Switch Case
        do {
            int opcao = IOFunctions.choice(); //Recebe a escolha do usuário

            switch (opcao) {
                case 1:
                    Utils.zeraValores(infixa, posfixa, estaNaExpressao, inseriValores); //Zera as pilhas
                    boolean ehValida = false;
                    do {
                        System.out.print("\n            Digite a expressão na notação infixa: "); //Solicita ao usuário que insira a expressão na forma infixa
                        infixa = input.nextLine().trim().toUpperCase().replaceAll(" ", "");
                        for (int i = 0; i < infixa.length(); i++) {
                            if (Character.isLetter(infixa.charAt(i))) //Verifica a presença das letras na expressão  
                                estaNaExpressao[infixa.charAt(i) - 'A'] = true;
                        }
                        ehValida = StackAlgorithms.ExpressaoValida(infixa, precedencia); //Verifica se a expressão é válida com base na precedência dos operadores
                        if (!ehValida)
                            System.out.println("\n                        Expressão inválida!"); //Se for inválida imprime esta mensagem
                    } while (!ehValida);
                    inseriValores = false;
                    gerouPosfixa = false;
                    break;
                case 2:
                    if (infixa.isEmpty()) {
                        System.out.println("\n          Erro! Por favor insira a expressão na forma infixa."); //Se a string infixa estiver vazia imprime esta mensagem
                        continue;
                    }
                    System.out.println("\n                  Digite os valores das variáveis: "); //Solicita ao usuário a entrada dos valores para as variáveis
                    for (int i = 0; i < estaNaExpressao.length; i++) {
                        if (estaNaExpressao[i]) {
                            System.out.printf("                  Digite o valor da variável %c: ", i + 'A'); //Recebe os valores passados pelo usuário para cada variável
                            valor[i] = Integer.parseInt(input.nextLine());
                        }
                    }
                    inseriValores = true; //Após a realização das linhas acima determina o valor desta variável como true 
                    break;
                case 3:
                    if (infixa.isEmpty()) {
                        System.out.println("\n          Erro! Por favor insira a expressão na forma infixa."); //Se a string infixa estiver vazia imprime esta mensagem
                        continue;
                    }
                    posfixa = StackAlgorithms.converterInfixaParaPosfixa(infixa, precedencia); //Realiza a conversão da expressão na forma infixa para a posfixa
                    System.out.println("\n+------------------------------------------------------------------+");
                    System.out.printf("| A expressão posfixa é dada por: %-33s|\n", posfixa);                     //Imprime a expressão convertida na forma posfixa  
                    System.out.println("+------------------------------------------------------------------+");
                    gerouPosfixa = true; //Após a realização das linhas acima determina o valor desta variável como true
                    break;
                case 4:
                    if (infixa.isEmpty()) {
                        System.out.println("\n          Erro! Por favor insira a expressão na forma infixa."); //Se a string infixa estiver vazia imprime esta mensagem
                        continue;
                    }
                    if (!inseriValores) {
                        System.out.println("\n          Erro! Por favor insira valores para as variáveis."); //Se inseriValores estiver na condição false imprime esta mensagem
                        continue;
                    }
                    if (posfixa.isEmpty()) {
                        System.out.println("\nErro! Por favor selecione a opção de converter para a forma posfixa."); //Se a string posfixa estiver vazia imprime esta mensagem
                        continue;
                    }
                    if (!gerouPosfixa) {
                        System.out.println("\n+------------------------------------------------------------------+");
                        System.out.println("|           Atenção! Você ainda não gerou a nova posfixa,          |"); // Se ja tiver uma expressão infixa e outra for adicionada sem
                        System.out.println("|                realizando calculo com a anterior.                |"); // que tenha gerado a posfixa da anterior, imprime esta mensagem
                        System.out.println("+------------------------------------------------------------------+");
                    }
                    System.out.println("\n+------------------------------------------------------------------+");
                    System.out.println("|                       Resultado do cálculo                       |"); //Apresenta o resultado do calculo
                    System.out.println("+------------------------------------------------------------------+");
                    System.out.printf("| A expressão infixa é: %-43s|\n", infixa); //Apresenta o calculo da infixa
                    System.out.printf("| A expressão posfixa é: %-42s|\n", posfixa); //Apresenta o calculo da pos-fixa
                    System.out.printf("| As variaveis dessa expressão são:                                |\n");
                    for (int i = 0; i < estaNaExpressao.length; i++) { //Mostra as variaveis usadas na expressao
                        if (estaNaExpressao[i])
                            System.out.printf("| %c = %-61d|\n", i + 'A', valor[i]);
                    }
                    int resultado = StackAlgorithms.AvaliaExpressao(posfixa, valor); //Guarda o resultado da expressao
                    System.out.println("+------------------------------------------------------------------+");
                    System.out.printf("| O resultado da expressão é: %-37d|\n", resultado); //Apresenta o resultado da expressao
                    System.out.println("+------------------------------------------------------------------+");
                    break;
                case 5:
                    fimDoPrograma = true; //Finaliza o programa
                    break;
                default:
                    break;
            }

        } while (!fimDoPrograma); //Apresenta uma mensagem de finalizando programa... 
        System.out.println("\n+------------------------------------------------------------------+");
        System.out.println("|                     Encerrando o programa...                     |"); // Imprime a mensagem do fim do programa
        System.out.println("+------------------------------------------------------------------+");
        input.close();
    }
}
