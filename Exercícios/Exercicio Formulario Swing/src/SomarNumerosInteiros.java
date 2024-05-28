import javax.swing.*;

public class SomarNumerosInteiros {
    public static void main(String[] args){
        String s1 = JOptionPane.showInputDialog(null, "Primeiro número inteiro");
        while (!numeroInteiroValido(s1)) {
            s1= JOptionPane.showInputDialog(null, "Entrada Inválida. Digite um número inteiro");
        }
        int v1 = Integer.parseInt(s1);

        String s2 = JOptionPane.showInputDialog(null, "Segundo número inteiro");
        while (!numeroInteiroValido(s2)){
            s2 = JOptionPane.showInputDialog(null, "Entrada Inválida. Digite um número inteiro");
        }
        int v2 = Integer.parseInt(s2);

        JOptionPane.showMessageDialog(null, s1 + " + " + s2 + " = " + (v1+v2));
    }

    private static boolean numeroInteiroValido(String s){
        boolean resultado;
        try {
            Integer.parseInt(s);
            resultado = true;
        } catch (NumberFormatException e) { resultado = false; }

        return resultado;
    }
}
