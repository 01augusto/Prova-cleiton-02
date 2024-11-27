import javax.swing.*;
import java.awt.*;

public class BancoView {
    private BancoController controller;
    private JLabel lblSaldo;
    private JTextField txtValor;
    private JLabel lblMensagem;

    public BancoView(BancoController controller) {
        this.controller = controller;
    }

    public void createAndShowGUI() {

        JFrame frame = new JFrame("Banco - Sistema Simples");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(5, 1));


        lblSaldo = new JLabel("Saldo: R$ " + String.format("%.2f", controller.getSaldo()), JLabel.CENTER);
        lblSaldo.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(lblSaldo);


        JPanel panelInput = new JPanel(new FlowLayout());
        JLabel lblValor = new JLabel("Valor: ");
        txtValor = new JTextField(10);
        panelInput.add(lblValor);
        panelInput.add(txtValor);
        frame.add(panelInput);


        JPanel panelBotoes = new JPanel(new FlowLayout());
        JButton btnSaque = new JButton("Realizar Saque");
        JButton btnDeposito = new JButton("Realizar Depósito");
        panelBotoes.add(btnSaque);
        panelBotoes.add(btnDeposito);
        frame.add(panelBotoes);


        lblMensagem = new JLabel("", JLabel.CENTER);
        lblMensagem.setFont(new Font("Arial", Font.PLAIN, 14));
        frame.add(lblMensagem);


        JButton btnLimpar = new JButton("Limpar");
        frame.add(btnLimpar);


        btnSaque.addActionListener(e -> realizarSaque());


        btnDeposito.addActionListener(e -> realizarDeposito());


        btnLimpar.addActionListener(e -> lblMensagem.setText(""));


        frame.setVisible(true);
    }

    private void realizarSaque() {
        try {
            double valor = Double.parseDouble(txtValor.getText());
            String mensagem = controller.realizarSaque(valor);
            atualizarSaldo();
            lblMensagem.setText(mensagem);
        } catch (NumberFormatException ex) {
            lblMensagem.setText("Erro: Valor inválido.");
        }
    }

    private void realizarDeposito() {
        try {
            double valor = Double.parseDouble(txtValor.getText());
            String mensagem = controller.realizarDeposito(valor);
            atualizarSaldo();
            lblMensagem.setText(mensagem);
        } catch (NumberFormatException ex) {
            lblMensagem.setText("Erro: Valor inválido.");
        }
    }

    private void atualizarSaldo() {
        lblSaldo.setText("Saldo: R$ " + String.format("%.2f", controller.getSaldo()));
    }
}