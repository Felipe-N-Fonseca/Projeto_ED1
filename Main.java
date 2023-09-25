import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String infixa = "", posfixa = "";

        boolean fimDoPrograma = false, inseriValores = false, gerouPosfixa = false;
        boolean estaNaExpressao[] = new boolean[27];
        int valor[] = new int[27];
        int precedencia[] = new int[100];

        precedencia['+'] = 2; precedencia['-'] = 2;
        precedencia['*'] = 3; precedencia['/'] = 3;
        precedencia['^'] = 4; precedencia['('] = 1;
        precedencia[')'] = 1;
        
        do {
            int opcao = IOFunctions.choice();

            switch(opcao){
                case 1:
                    Utils.zeraValores(infixa, posfixa, estaNaExpressao, inseriValores);
                    boolean ehValida = false;
                    do {
                        System.out.print("\nDigite a expressão na notação infixa: ");
                        infixa = input.nextLine().trim().toUpperCase().replaceAll(" ", "");
                        for(int i = 0; i < infixa.length(); i++){
                            if (Character.isLetter(infixa.charAt(i))) estaNaExpressao[infixa.charAt(i)-'A'] = true;
                        }
                        ehValida = StackAlgorithms.ExpressaoValida(infixa, precedencia);
                        if(!ehValida) System.out.println("\nExpressão inválida!");
                    } while(!ehValida);
                    inseriValores = false;
                    gerouPosfixa = false;
                    break;
                case 2:
                    if(infixa.isEmpty()){
                        System.out.println("\nErro! Por favor insira a expressão na forma infixa.");
                        continue;
                    }
                    System.out.println("\nDigite os valores das variáveis: ");
                    for(int i = 0; i < estaNaExpressao.length; i++){
                        if(estaNaExpressao[i]){
                            System.out.printf("Digite o valor da variável %c: ", i+'A');
                            valor[i] = Integer.parseInt(input.nextLine());
                        }
                    }
                    inseriValores = true;
                    break;
                case 3:
                    if(infixa.isEmpty()){
                        System.out.println("\nErro! Por favor insira a expressão na forma infixa.");
                        continue;
                    }
                    posfixa = StackAlgorithms.converterInfixaParaPosfixa(infixa, precedencia);
                    System.out.printf("\nA expressão posfixa é dada por: %s\n", posfixa);
                    gerouPosfixa = true;
                    break;
                case 4:
                    if(infixa.isEmpty()){
                        System.out.println("\nErro! Por favor insira a expressão na forma infixa.");
                        continue;
                    }
                    if(!inseriValores){
                        System.out.println("\nErro! Por favor insira valores para as variáveis.");
                        continue;
                    }
                    if(posfixa.isEmpty()){
                        System.out.println("\nErro! Por favor selecione a opção de converter para a forma posfixa.");
                        continue;
                    }
                    if(!gerouPosfixa){
                        System.out.println("\nAtenção! Você ainda não gerou a nova posfixa, \nrealizando calculo com a anterior.");
                        continue;
                    }
                    System.out.printf("\nA expressão infixa é: %s\n", infixa);
                    System.out.printf("A expressão posfixa é: %s\n", posfixa);
                    System.out.printf("As variaveis dessa expressão são:\n");
                    for(int i = 0; i < estaNaExpressao.length; i++){
                        if(estaNaExpressao[i]) System.out.printf("%c = %d\n", i+'A', valor[i]);
                    }
                    int resultado = StackAlgorithms.AvaliaExpressao(posfixa, valor);
                    System.out.printf("O resultado da expressão é: %d\n", resultado);
                    break;
                case 5:
                    fimDoPrograma = true;
                    break;
                default:
                    break;
                }

        }while(!fimDoPrograma);
            
        System.out.println("\nEncerrando o programa.");
        input.close();
    }
}