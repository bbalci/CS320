package racms;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class InformationPanel extends JFrame implements ActionListener{
	
	public static void openInformationPanel(){
		
		String[] labels = {"Name:", "Surname:", "Birth Date:", 
							"ID Number:", "Address:", "Phone Number:", "e-mail:", "IBAN:"};		
		int numPairs = labels.length;
		
		JPanel MainPanel = new JPanel(new BorderLayout());		
		JPanel InfoPanel = new JPanel(new SpringLayout());		
		JPanel CarInfoSummary = new JPanel(new FlowLayout());
		JTextField carinfofield = new JTextField();
		JTextField price = new JTextField();
		carinfofield.setText("Car Info");
		price.setText("Price");
		carinfofield.setEditable(false);
		price.setEditable(false);
		CarInfoSummary.add(carinfofield);
		CarInfoSummary.add(price);
		
		for(int i = 0; i < numPairs; i++){
			JLabel label = new JLabel(labels[i], JLabel.TRAILING);
			JTextField inputfield = new JTextField(20);
			inputfield.addActionListener(new ActionListener(){
			      public void actionPerformed(ActionEvent e) {
			          System.out.println("Text=" + inputfield.getText());
			        }
			});
			label.setLabelFor(inputfield);
			InfoPanel.add(label);
			InfoPanel.add(inputfield);			
		}
		
		SpringUtilities.makeCompactGrid(InfoPanel,
										numPairs,2,
										6, 6,
										6, 6);
		JFrame frame = new JFrame("Information Panel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		InfoPanel.setOpaque(true);
		MainPanel.setOpaque(true);
		CarInfoSummary.setOpaque(true);
		
		MainPanel.add(CarInfoSummary, BorderLayout.WEST);
		MainPanel.add(InfoPanel, BorderLayout.EAST);
		
		frame.setContentPane(MainPanel);		
		frame.pack();
		frame.setVisible(true);
	
	}	
	
	public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                openInformationPanel();
            }
        });
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
