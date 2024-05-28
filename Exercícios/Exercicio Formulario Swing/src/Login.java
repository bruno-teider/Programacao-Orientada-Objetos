import javax.swing.*;

public class Login {
    public static void main(String[] args){
        String usuario = JOptionPane.showInputDialog(null, "Usuário");
        String senha = JOptionPane.showInputDialog(null, "Senha");

        System.out.println(usuario);
        System.out.println(senha);

        if(usuario != null && senha != null && usuario.equals("pucpr") && senha.equals("poo")){
            JOptionPane.showMessageDialog(null, "login autorizado");
        } else JOptionPane.showMessageDialog(null, "login recusado");
    }
}
