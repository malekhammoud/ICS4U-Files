package GraphicsPt2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class RadioButtomDemo extends JPanel implements ActionListener{
    JLabel latin, latinName;
    JRadioButton basil, lavender, parsley, peppermint, saffron, sage;
    ButtonGroup radioButtons;
    public RadioButtomDemo(){
        JFrame frame = new JFrame("Radio Button Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(0,2));
        latin = new JLabel("Latin name: ");
        this.add(latin);
        latinName = new JLabel(" ");
        this.add(latinName);

        basil = new JRadioButton("basil", true);
        basil.setMnemonic(KeyEvent.VK_B);
        basil.setActionCommand("basil");
        basil.addActionListener(this);
        this.add(basil);

        lavender = new JRadioButton("lavender");
        lavender.setMnemonic(KeyEvent.VK_L);
        lavender.setActionCommand("lavender");
        lavender.addActionListener(this);
        this.add(lavender);

        parsley = new JRadioButton("parsley");
        parsley.setMnemonic(KeyEvent.VK_Y);
        parsley.setActionCommand("parsley");
        parsley.addActionListener(this);
        this.add(parsley);

        peppermint = new JRadioButton("peppermint");
        peppermint.setMnemonic(KeyEvent.VK_P);
        peppermint.setActionCommand("peppermint");
        peppermint.addActionListener(this);

        this.add(peppermint);
        saffron = new JRadioButton("saffron");
        saffron.setMnemonic(KeyEvent.VK_F);
        saffron.setActionCommand("saffron");
        saffron.addActionListener(this);

        this.add(saffron);
        sage = new JRadioButton("sage");
        sage.setMnemonic(KeyEvent.VK_S);
        sage.setActionCommand("sage");
        sage.addActionListener(this);

        this.add(sage);
        radioButtons = new ButtonGroup();
        radioButtons.add(basil);
        radioButtons.add(lavender);
        radioButtons.add(parsley);
        radioButtons.add(peppermint);
        radioButtons.add(saffron);
        radioButtons.add(sage);
        frame.setContentPane(this);
        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        String eventName = event.getActionCommand();
        if (eventName.equals("basil")) {
            latinName.setText("Ocimum");
        } else if (eventName.equals("lavender")) {
            latinName.setText("Lavadula spica");
        } else if (eventName.equals("parsley")) {
            latinName.setText("Apium");
        } else if (eventName.equals("peppermint")) {
            latinName.setText("Mentha piperita");
        } else if (eventName.equals("saffron")) {
            latinName.setText("Crocus");
        } else if (eventName.equals("sage")) {
            latinName.setText("Salvia");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RadioButtomDemo();
            }
        });
    }
}

