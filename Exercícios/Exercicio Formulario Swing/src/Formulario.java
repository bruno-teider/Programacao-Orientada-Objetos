import javax.swing.*;
import java.awt.event.ActionListener;

public class Formulario {
    public static void main(String[] args){
        JFrame frame = new JFrame("Login");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel();
        frame.add(painel);
        inserir_componentes(painel);

        frame.setVisible(true);
    }

    public static void inserir_componentes(JPanel painel){
        painel.setLayout(null);

        // Componentes
        JLabel rotulo_usuario = new JLabel("Usuário");
        rotulo_usuario.setBounds(10, 10, 80, 25);
        painel.add(rotulo_usuario);

        JTextField campo_usuario = new JTextField(20);
        campo_usuario.setBounds(100, 10, 160, 25);
        painel.add(campo_usuario);

        JLabel rotulo_senha = new JLabel("Senha");
        rotulo_senha.setBounds(10, 40, 80, 25);
        painel.add(rotulo_senha);

        JPasswordField campo_senha = new JPasswordField(20);
        campo_senha.setBounds(100, 40, 160, 25);
        painel.add(campo_senha);

        // Botões
        JButton botao_login = new JButton("Login");
        botao_login.setBounds(10, 80, 80, 25);
        painel.add(botao_login);

        JButton botao_cadastro = new JButton("Cadastro");
        botao_cadastro.setBounds(180, 80, 80, 25);
        painel.add(botao_cadastro);

        ActionListener leitor_botoes = new LeitorBotoes();
        botao_login.addActionListener(leitor_botoes);
        botao_cadastro.addActionListener(leitor_botoes);
    }
}
