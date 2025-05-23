import java.awt.*;
import javax.swing.*;

public class LayoutTest {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Demonstração de Layout Managers");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);

        // Painel principal com GridLayout para organizar nossos painéis de teste
        JPanel mainPanel = new JPanel(new GridLayout(2, 3, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Adiciona todos os painéis de teste
        mainPanel.add(createFlowLayoutPanel());
        mainPanel.add(createBorderLayoutPanel());
        mainPanel.add(createGridLayoutPanel());
        mainPanel.add(createBoxLayoutPanel());
        mainPanel.add(createGridBagLayoutPanel());
        mainPanel.add(createCardLayoutPanel());

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    // 1. FlowLayout Panel
    private static JPanel createFlowLayoutPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel.setBackground(new Color(255, 200, 200)); // Rosa claro
        panel.setBorder(BorderFactory.createTitledBorder("FlowLayout"));

        panel.add(new JLabel("Layout de fluxo"));
        JButton button1 = new JButton("fechar 1");
        button1.addActionListener(e -> {
            System.exit(0);
        });
        panel.add(button1);
        panel.add(new JButton("Botão 2"));
        panel.add(new JButton("Botão 3"));

        return panel;
    }

    // 2. BorderLayout Panel
    private static JPanel createBorderLayoutPanel() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBackground(new Color(200, 255, 200)); // Verde claro
        panel.setBorder(BorderFactory.createTitledBorder("BorderLayout"));

        panel.add(new JButton("Norte"), BorderLayout.NORTH);
        panel.add(new JButton("Sul"), BorderLayout.SOUTH);
        panel.add(new JButton("Leste"), BorderLayout.EAST);
        panel.add(new JButton("Oeste"), BorderLayout.WEST);
        panel.add(new JButton("Centro"), BorderLayout.CENTER);

        return panel;
    }

    // 3. GridLayout Panel
    private static JPanel createGridLayoutPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 3, 5, 5));
        panel.setBackground(new Color(200, 200, 255)); // Azul claro
        panel.setBorder(BorderFactory.createTitledBorder("GridLayout (2x3)"));

        for (int i = 1; i <= 6; i++) {
            panel.add(new JButton("Botão " + i));
        }

        return panel;
    }

    // 4. BoxLayout Panel
    private static JPanel createBoxLayoutPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(255, 255, 200)); // Amarelo claro
        panel.setBorder(BorderFactory.createTitledBorder("BoxLayout (Y_AXIS)"));

        panel.add(new JLabel("Empilhamento vertical"));
        panel.add(new JButton("Botão 1"));
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaço fixo
        panel.add(new JButton("Botão 2"));
        panel.add(Box.createVerticalGlue()); // Espaço expansível
        panel.add(new JButton("Botão 3"));

        return panel;
    }

    // 5. GridBagLayout Panel
    private static JPanel createGridBagLayoutPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(255, 200, 255)); // Roxo claro
        panel.setBorder(BorderFactory.createTitledBorder("GridBagLayout"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Margens

        // Linha 0
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(new JLabel("Layout mais flexível"), gbc);

        // Linha 1
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(new JButton("Botão 1"), gbc);

        gbc.gridx = 1;
        panel.add(new JButton("Botão 2"), gbc);

        // Linha 2
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(new JButton("Botão largo"), gbc);

        return panel;
    }

    // 6. CardLayout Panel
    private static JPanel createCardLayoutPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(200, 255, 255)); // Ciano claro
        panel.setBorder(BorderFactory.createTitledBorder("CardLayout"));

        // Painel de cards
        JPanel cards = new JPanel(new CardLayout());
        cards.setPreferredSize(new Dimension(200, 150));

        // Card 1
        JPanel card1 = new JPanel();
        card1.setBackground(new Color(220, 220, 220));
        card1.add(new JLabel("Card 1"));
        cards.add(card1, "card1");

        // Card 2
        JPanel card2 = new JPanel();
        card2.setBackground(new Color(240, 240, 240));
        card2.add(new JLabel("Card 2"));
        cards.add(card2, "card2");

        // Botão para alternar cards
        JButton toggleButton = new JButton("Alternar Card");
        toggleButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) cards.getLayout();
            cl.next(cards);
        });

        panel.add(cards, BorderLayout.CENTER);
        panel.add(toggleButton, BorderLayout.SOUTH);

        return panel;
    }
}
