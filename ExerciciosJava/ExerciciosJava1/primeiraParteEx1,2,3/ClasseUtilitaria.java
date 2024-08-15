
public class ClasseUtilitaria{    

public static int contarVogais(String str) {
    int count = 0;
    str = str.toLowerCase(); 
    
    for (int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);

        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            count++;
        }
    }
    
    return count; 
}


 public static int contarDigitos(String str) {
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);
        if (Character.isDigit(ch)) {
            count++;
        }
    }
    return count;
}

public static boolean ehPalindromo(String str) {
    str = str.toLowerCase().replaceAll("[^a-z0-9]", "");
    int left = 0;
    int right = str.length() - 1;
    while (left < right) {
        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }
        left++;
        right--;
    }
    return true;
}

public static String numeroPorExtenso(int numero){
    
        String[] unidades = {
            "zero", "um", "dois", "três", "quatro",
            "cinco", "seis", "sete", "oito", "nove"
        };
        
        String numeroStr = Integer.toString(numero);
        StringBuilder extenso = new StringBuilder();

        for (int i = 0; i < numeroStr.length(); i++) {
            int digito = Character.getNumericValue(numeroStr.charAt(i));

            if (i > 0) {
                extenso.append(", ");
            }

            extenso.append(unidades[digito]);
        }

        return extenso.toString();
    }


        
    
}