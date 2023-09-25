public class StackAlgorithms{    
    public static String converterInfixaParaPosfixa(String Infixa, int precedencia[]){
        Pilha auxiliar = new Pilha(Infixa.length());

        String posfixa = "";
        for(int i = 0; i < Infixa.length(); i++){
            if(Character.isLetter(Infixa.charAt(i))) posfixa += Infixa.charAt(i);
            else{
                if(Infixa.charAt(i) == '(') auxiliar.push(Infixa.charAt(i));
                else if(Infixa.charAt(i) == ')'){
                    while(!auxiliar.isEmpty() && auxiliar.topo() != '(') posfixa += (char)auxiliar.pop();
                    auxiliar.pop();
                }else{
                    while(!auxiliar.isEmpty() && precedencia[auxiliar.topo()] >= precedencia[Infixa.charAt(i)]){
                        posfixa += (char)auxiliar.pop();
                    }
                    auxiliar.push(Infixa.charAt(i));
                }
            }
        }

        while(!auxiliar.isEmpty()) posfixa += (char)auxiliar.pop();

        return posfixa;
    }

    public static boolean ExpressaoValida(String expressao, int precedencia[]){
        boolean simbolosValidos, operandosCorretos;

        simbolosValidos = Utils.ehLexicamenteCorreto(expressao, precedencia);
        operandosCorretos = Utils.ehSintaticamenteCorreto(expressao, precedencia);

        return operandosCorretos && simbolosValidos;
    }

    public static int AvaliaExpressao(String posfixa, int value[]){
        Pilha auxiliar = new Pilha(posfixa.length());
        int res = 0;
        for(int i = 0; i < posfixa.length(); i++){
            if(Character.isLetter(posfixa.charAt(i))){
                auxiliar.push(value[posfixa.charAt(i)-'A']);
            }else{
                int x = auxiliar.pop(), y = auxiliar.pop();
                if(posfixa.charAt(i) == '+') res = x+y;
                else if(posfixa.charAt(i) == '-') res = y-x;
                else if(posfixa.charAt(i) == '*') res = x*y;
                else if(posfixa.charAt(i) == '/') res = y/x;
                else res = (int)Math.pow(y, x);

                auxiliar.push(res);
            }
        }
        res = auxiliar.isEmpty() ? 0 : auxiliar.pop();
        return res;
    }
}