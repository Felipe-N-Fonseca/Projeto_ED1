public class StackAlgorithms{    
    public static String converterInfixaParaPosfixa(String Infixa){
        Pilha auxiliar = new Pilha(Infixa.length());
        int precedencia[] = new int[100];

        precedencia['+'] = 1; precedencia['-'] = 1;
        precedencia['*'] = 2; precedencia['/'] = 2;
        precedencia['^'] = 3; precedencia['('] = 0;

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

    public static boolean ExpressaoValida(String expressao){
        Pilha auxiliar = new Pilha(expressao.length());
        boolean parentesisCorretos = true, simbolosValidos = true;

        final String operadores = "+-*/^()";

        for(int i = 0; i < expressao.length(); i++){
            if(!Character.isLetter(expressao.charAt(i)) && operadores.indexOf(expressao.charAt(i)) == -1){
                simbolosValidos = false;
            }
        }

        for(int i = 0; i < expressao.length(); i++){
            if(expressao.charAt(i) == '(') auxiliar.push('(');
            else if(expressao.charAt(i) == ')'){
                if(auxiliar.isEmpty()){
                    parentesisCorretos = false;
                    break;
                }
                auxiliar.pop();
            }
        }

        return parentesisCorretos && simbolosValidos && auxiliar.isEmpty();
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