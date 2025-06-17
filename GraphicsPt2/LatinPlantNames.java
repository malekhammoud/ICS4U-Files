package GraphicsPt2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class LatinPlantNames implements ActionListener {
    JFrame frame;
    JPanel contentPane;
    JComboBox plantNames;
    JLabel plantListPrompt, latinName;

    public LatinPlantNames(){
        /*Create and set up the frame*/
        frame = new JFrame("Latin Plant Names");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Create a content pane with a BoxLayout and empty borders */
        contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        /*Create a combo box and a label*/
        plantListPrompt = new JLabel("Plant Names");
        plantListPrompt.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPane.add(plantListPrompt);
        String[] names= {"basil", "lavender", "parsley", "peppermint", "saffron", "sage"};
        plantNames = new JComboBox(names);
        plantNames.setAlignmentX(Component.LEFT_ALIGNMENT);
        plantNames.setSelectedIndex(0);
        plantNames.addActionListener(this);
        contentPane.add(plantNames);
        /*Create and add a lable that will display the latin names */
        latinName = new JLabel("Ocimum");
        latinName.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        contentPane.add(latinName);

        /* Add content pane to frame */
        frame.pack();
        frame.setVisible(true);
    }
    /** Handle a selection from the combo box */
    public void actionPerformed(ActionEvent e) {
        JComboBox comboBox = (JComboBox)e.getSource();
        String plantName = (String) comboBox.getSelectedItem();

        if (plantName == "basil"){
            latinName.setText("Ocimum");
        } else if (plantName == "lavender"){
            latinName.setText("Lavandula");
        } else if (plantName == "parsley"){
            latinName.setText("Petroselinum");
        } else if (plantName == "peppermint"){
            latinName.setText("Mentha");
        } else if (plantName == "saffron"){
            latinName.setText("Crocus");
        } else if (plantName == "sage"){
            latinName.setText("Salvia");
        }
    }

}
