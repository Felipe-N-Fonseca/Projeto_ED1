public class Utils {
    public static void zeraValores(String infixa, String posfixa, boolean presente[], boolean preenchi){
        infixa = "";
        posfixa = "";
        preenchi = false;
        for(int i = 0; i < presente.length; i++) presente[i] = false;
    }

    public static boolean ehLexicamenteCorreto(String expressao, int prec[]){
        boolean valido = true;
        for(int i = 0; i < expressao.length(); i++){
            if(!Character.isLetter(expressao.charAt(i)) && prec[expressao.charAt(i)] == 0){
                valido = false;                
            }
        }
        return valido;
    }

    public static boolean ehSintaticamenteCorreto(String expressao, int prec[]){
        Pilha operador = new Pilha(expressao.length());
        int estado = -1;
        for(int i = 0; i < expressao.length(); i++){
            if(estado != -1){
                if(prec[expressao.charAt(i)] != 0){ // dois operadores consecutivos
                    if(expressao.charAt(i) != '(' && expressao.charAt(i) != ')' && estado == 2) return false;
                }else{
                    if(estado == 1) return false; // duas variáveis consecutivas
                }
            }

            if(expressao.charAt(i) == '('){
                operador.push(expressao.charAt(i));
                estado = -1; // estado -1 representa parentesis
            }else if(expressao.charAt(i) == ')'){
                if(operador.isEmpty()) return false;
                else{
                    operador.pop();
                    estado = -1;
                }
            }else if(Character.isLetter(expressao.charAt(i))) estado = 1; // estado 1 representa variavel
            else estado = 2; // estado 2 representa operador
        }

        return operador.isEmpty();
    }

}
