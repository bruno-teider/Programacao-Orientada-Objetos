import java.awt.*;
import java.io.IOException;
import java.util.List;
import javax.swing.*;

public class Clinica {
    public static void main(String[] args) {
        // Criação dos objetos pelos arquivos csv
        List<Medico> medicos = LeituraDados.gerarMedicos();
        List<Paciente> pacientes = LeituraDados.gerarPacientes();
        List<Consulta> consultas = LeituraDados.gerarConsultas(medicos, pacientes);

        // Criação  da janela do aplicativo
        JFrame frame  = new JFrame("Programa");
        frame.setSize(854, 480); // Tamanho da tela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha ao clicar no X

        // Cria um card que vai conter as telas
        JPanel cardPanel = new JPanel(new CardLayout());

        // Criação de paineis e adicao no card
        JPanel painelOpcoes = new JPanel();
        cardPanel.add(painelOpcoes, "Opções");

        JPanel painelOpcao1 = new JPanel();
        try { Interface.interfaceOpcao1(painelOpcao1, medicos); }
        catch (ExcecaoValorInvalido | ExcecaoNumeroInvalido e) { e.printStackTrace(); }
        cardPanel.add(painelOpcao1, "op1");

        JPanel painelOpcao2 = new JPanel();
        try { Interface.interfaceOpcao2(painelOpcao2); }
        catch (IOException | ClassNotFoundException e) { e.printStackTrace(); }
        cardPanel.add(painelOpcao2, "op2");

        frame.add(cardPanel);

        // Colocar na tela as opções e pegar o valor digitado
        try {
            Interface.interface_opcoes(painelOpcoes, operacao-> {
                CardLayout c1 = (CardLayout) cardPanel.getLayout();

                switch (operacao){
                    case 1:
                        c1.show(cardPanel, "op1");
                        break;
                    case 2:
                        c1.show(cardPanel, "op2");
                        break;
                }
            });
        } catch ( ExcecaoValorInvalido |ExcecaoNumeroInvalido ex){ ex.printStackTrace(); }

        frame.setVisible(true);
    }
}