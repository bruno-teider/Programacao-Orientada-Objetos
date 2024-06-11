import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.time.format.DateTimeFormatter;


public class Interface {
    private static String strRespostas = "";

    public static void interface_opcoes(JPanel painel, Consumer<Integer> callback) throws ExcecaoValorInvalido, ExcecaoNumeroInvalido {
        painel.setLayout(new BorderLayout()); // Tipo de Layout do painel

        // Título das opções
        JLabel texto_opcoes = new JLabel("Opções:");
        texto_opcoes.setBorder(BorderFactory.createEmptyBorder(20, 10, 0, 0));
        texto_opcoes.setFont(new Font("Arial", Font.PLAIN, 22));
        painel.add(texto_opcoes, BorderLayout.NORTH);

        // Criação de um novo painel contendo as opções
        JPanel opcoesPanel = new JPanel();
        opcoesPanel.setLayout(new BoxLayout(opcoesPanel, BoxLayout.Y_AXIS));

        JLabel op1 = new JLabel("1 - Detalhes sobre um médico");
        op1.setBorder(BorderFactory.createEmptyBorder(5, 10, 0, 0));
        op1.setFont(new Font("Arial", Font.PLAIN, 18));
        opcoesPanel.add(op1);

        JLabel op2 = new JLabel("2 - Ver resultados da última consulta");
        op2.setBorder(BorderFactory.createEmptyBorder(3, 10, 0, 0));
        op2.setFont(new Font("Arial", Font.PLAIN, 18));
        opcoesPanel.add(op2);

        // Adicionando o painel de opções no painel principal
        painel.add(opcoesPanel, BorderLayout.CENTER);

        // Criando novo painel para parte do input do usuário
        JPanel inputPanel = new JPanel();
        inputPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

        JLabel selecao = new JLabel("Digite a opção desejada: ");
        selecao.setFont(new Font("Arial", Font.PLAIN, 18));
        inputPanel.add(selecao);

        JTextField opcao = new JTextField(5);
        opcao.setBounds(0, 0, 160, 30);
        inputPanel.add(opcao);

        JButton botao_op = new JButton("Ok");
        inputPanel.add(botao_op);

        painel.add(inputPanel, BorderLayout.SOUTH);

        // Ação que será realizada ao clicar no botão
        botao_op.addActionListener(e -> {
            try {

                // Checar se o usuário escreveu algo diferente de número (usando tabela ascii)
                try {
                    for(char c : opcao.getText().toCharArray()){
                        if(c < '0' || c > '9') throw new ExcecaoValorInvalido();
                    }
                } catch (ExcecaoValorInvalido ex) { JOptionPane.showMessageDialog(painel, "Valor inserido inválido"); }

                // Checar se o número digitado está válido
                int intOpcao = Integer.parseInt(opcao.getText()); // Converte o texto lido em int

                if(intOpcao > 2 || intOpcao < 1) throw new ExcecaoNumeroInvalido();
                else callback.accept(intOpcao);

            } catch (ExcecaoNumeroInvalido ex) { JOptionPane.showMessageDialog(painel, "Número inserido inválido"); }
        });
    }

    public static void interfaceOpcao1(JPanel painel, List<Medico> medicos) throws ExcecaoValorInvalido, ExcecaoNumeroInvalido {
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS)); // Tipo de Layout do painel

        // Print da lista de todos os médicos
        JLabel titulo = new JLabel("Lista de todos os Médicos:");
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 10, 0, 0));
        titulo.setFont(new Font("Arial", Font.PLAIN, 26));
        painel.add(titulo);

        for(Medico medico : medicos){
            JLabel texto = new JLabel("Código: " + medico.codigo + " | Nome: " + medico.nome);
            texto.setBorder(BorderFactory.createEmptyBorder(3, 10, 0, 0));
            texto.setFont(new Font("Arial", Font.PLAIN, 18));
            painel.add(texto);
        }

        // Painel para os inputs do usuario
        JPanel inputPanel = new JPanel();
        inputPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

        JLabel selecao = new JLabel("Código do médico desejado: ");
        selecao.setFont(new Font("Arial", Font.PLAIN, 18));
        inputPanel.add(selecao);

        JTextField codigo = new JTextField(5);
        codigo.setBounds(0, 0, 160, 30);
        inputPanel.add(codigo);

        JButton button = new JButton("Ok");
        inputPanel.add(button);

        painel.add(inputPanel);

        // Ação que será realizada ao clicar no botão
        button.addActionListener(e -> {
            try {

                // Checar se o usuário escreveu algo diferente de número (usando tabela ascii)
                try {
                    for(char c : codigo.getText().toCharArray()){
                        if(c < '0' || c > '9') throw new ExcecaoValorInvalido();
                    }
                } catch (ExcecaoValorInvalido ex) { JOptionPane.showMessageDialog(painel, "Valor inserido inválido"); }

                int codMedico = Integer.parseInt(codigo.getText()); // Converte o texto lido em int
                if(codMedico > medicos.size() || codMedico < 0) throw new ExcecaoNumeroInvalido();
                else {
                    // Basicamente recria o painel, para colocar as informações dos pacientes
                    painel.removeAll();
                    painel.repaint();
                    painel.revalidate();
                    painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));

                    Medico medico = medicos.get(codMedico-1);

                    List<String> nomes_pacientes = new ArrayList<>(); // Lista para não repetir o nome dos pacientes

                    // Mostra todos os pacientes do médico escolhido e as consultas
                    strRespostas += "\nLista pacientes e consultas do(a) "+ medico.nome; // Joga para uma var q será salva como objPersistente
                    JLabel titulo_lista = new JLabel("Lista pacientes e consultas do(a) "+ medico.nome);
                    titulo_lista.setBorder(BorderFactory.createEmptyBorder(20, 10, 0, 0));
                    titulo_lista.setFont(new Font("Arial", Font.PLAIN, 26));
                    painel.add(titulo_lista);

                    int i = 1;
                    for(Paciente paciente : medico.pacientes){
                        if (!nomes_pacientes.contains(paciente.nome)){
                            nomes_pacientes.add(paciente.nome);

                            strRespostas += "\nPaciente " + i + ": " + paciente.nome;
                            JLabel texto_paciente = new JLabel("Paciente " + i + ": " + paciente.nome);
                            // Mostrar as consultas de um paciente
                            for (Consulta consulta : paciente.consultas){
                                if(medico.codigo == consulta.medicos.get(0).codigo){
                                    String print = " | Consulta: " + consulta.data_hora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                                    print += " as "+consulta.data_hora.format(DateTimeFormatter.ofPattern("HH")) + " horas.\n";
                                    strRespostas += print;
                                    texto_paciente.setText(texto_paciente.getText() + print);
                                }
                            }

                            texto_paciente.setBorder(BorderFactory.createEmptyBorder(3, 10, 0, 0));
                            texto_paciente.setFont(new Font("Arial", Font.PLAIN, 18));
                            painel.add(texto_paciente);
                            i++;
                        }
                    }

                    JButton botFim = new JButton("Encerrar Programa");
                    painel.add(botFim);

                    botFim.addActionListener(f -> {
                        try{
                            encerrarPrograma();
                            System.exit(0);
                        } catch (IOException ex) { ex.printStackTrace(); }
                    });
                }
            } catch (ExcecaoNumeroInvalido ex){ JOptionPane.showMessageDialog(painel, "Número inserido inválido"); }
        });
    }

    public static  void interfaceOpcao2(JPanel painel) throws IOException, ClassNotFoundException{
        // Leitura do objeto persistente
        FileInputStream objPersistente = new FileInputStream("RespostasGeradas.txt");
        ObjectInputStream restaurador = new ObjectInputStream(objPersistente);

        String texto_lido = (String) restaurador.readObject();

        restaurador.close();
        objPersistente.close();

        // Separar as linhas lidas
        String[] linhas = texto_lido.split("\n");

        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));

        // Colocar linha por linha em um JLabel e colocar na tela
        for (String linha : linhas){
            JLabel label = new JLabel(linha);
            label.setBorder(BorderFactory.createEmptyBorder(3, 10, 0, 0));
            label.setFont(new Font("Arial", Font.PLAIN, 18));
            painel.add(label);
        }

        // Botão para fechar o programa
        JButton botFim = new JButton("Encerrar Programa");
        painel.add(botFim);

        botFim.addActionListener(e -> {System.exit(0);});
    }

    public static void encerrarPrograma() throws IOException {
        try {
            // Faz a criação do objeto persistente em txt
            FileOutputStream objPersistente = new FileOutputStream("RespostasGeradas.txt");
            ObjectOutputStream gravador = new ObjectOutputStream(objPersistente);

            gravador.writeObject(strRespostas);

            gravador.close();
            objPersistente.close();

        } catch (IOException e) { e.printStackTrace(); }
    }

}