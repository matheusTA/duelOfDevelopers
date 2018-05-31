package apresentacao;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ControllerJogador;
import dados.DaoJogador;
import entidades.Jogador;

public class TelaCriarJogador extends JFrame implements Serializable {

    private JPanel contentPane;
    private JTextField txtNome;
    private JTextField txtLogin;
    private JPasswordField txtSenha;
    ControllerJogador controllerJogador = new ControllerJogador();
    DaoJogador daoJogador = new DaoJogador();

    public TelaCriarJogador() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 792, 503);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        lblNome.setBounds(170, 133, 78, 32);
        contentPane.add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(238, 128, 328, 37);
        contentPane.add(txtNome);
        txtNome.setColumns(10);

        JLabel lblLogin = new JLabel("Login:");
        lblLogin.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        lblLogin.setBounds(170, 195, 90, 25);
        contentPane.add(lblLogin);

        txtLogin = new JTextField();
        txtLogin.setBounds(238, 183, 328, 37);
        contentPane.add(txtLogin);
        txtLogin.setColumns(10);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        lblSenha.setBounds(170, 246, 78, 32);
        contentPane.add(lblSenha);

        txtSenha = new JPasswordField();
        txtSenha.setBounds(238, 241, 328, 37);
        contentPane.add(txtSenha);
        txtSenha.setColumns(10);

        JButton btnCriar = new JButton("Criar");
        btnCriar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                CriarJogador();

            }
        });
        btnCriar.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        btnCriar.setBounds(343, 318, 90, 32);
        contentPane.add(btnCriar);

        JButton btnMenu = new JButton("Menu");
        btnMenu.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                trocarTelaMenu();
            }

        });
        btnMenu.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        btnMenu.setBounds(343, 361, 90, 32);
        contentPane.add(btnMenu);
        this.setLocationRelativeTo(null);
    }

    private void trocarTelaMenu() {
        this.setVisible(false);
        TelaMenu telaMenu = new TelaMenu();
        telaMenu.show();
    }

    private void limparCamposUsuario() {
        this.txtNome.setText("");
        this.txtLogin.setText("");
        this.txtSenha.setText("");
    }

    private void CriarJogador() {
        ArrayList<Jogador> jogadores;
        try {
            jogadores = daoJogador.lerJogador();
            boolean flag = true;

            for (int i = 0; i < jogadores.size(); i++) {
                if (jogadores.get(i).getNome().equalsIgnoreCase(txtNome.getText())) {
                    JOptionPane.showMessageDialog(null, "Esse nome ja existe, tente novamente");
                    txtNome.setText("");
                    flag = false;
                    break;
                } else if (jogadores.get(i).getLogin().equalsIgnoreCase(txtLogin.getText())) {
                    JOptionPane.showMessageDialog(null, "Esse login ja existe, tente novamente");
                    txtLogin.setText("");
                    flag = false;
                    break;
                }
            }
            if (txtSenha.getText().length() < 6) {
                JOptionPane.showMessageDialog(null, "A senha deve ter no minimo 6 caracteres.");
                txtSenha.setText("");
            } else if (flag == true) {
                controllerJogador.criar(new Jogador(txtNome.getText(), txtLogin.getText(), txtSenha.getText()));
                limparCamposUsuario();
                JOptionPane.showMessageDialog(null, "Jogador criado com sucesso!");
            }
        } catch (ClassNotFoundException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}