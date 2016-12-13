package racms;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.*;
import java.awt.*;

public class PaymentPanel extends JFrame implements ActionListener{
	
	public static String input;
	
	public static void paymentPanel(){
		
		String[] labels = {"Name:", "Surname:", "Birth Date:", 
							"ID Number:", "Address:", "Phone Number:", "e-mail:", "IBAN:"};	
		
		String[] inputs = new String[labels.length];
		
		int numPairs = labels.length;
		
		JPanel MainPanel = new JPanel(new BorderLayout());		
		JPanel InfoPanel = new JPanel(new SpringLayout());		
		JPanel CarInfoSummary = new JPanel(new FlowLayout());
		JTextField[] inputfields = new JTextField[numPairs];
		
		for(int i = 0; i < numPairs; i++){
			JLabel label = new JLabel(labels[i], JLabel.TRAILING);
			inputfields[i] = new JTextField(20);
			
			label.setLabelFor(inputfields[i]);
			InfoPanel.add(label);
			InfoPanel.add(inputfields[i]);			
		}
		
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				for(int i = 0; i < numPairs; i++){
					inputs[i] = inputfields[i].getText();
				}
				System.out.println(Arrays.toString(inputs));
			}
		});
		
		JTextField carinfofield = new JTextField();
		JTextField price = new JTextField();
		
		
		//Car and Price Information should be gathered from DB
		carinfofield.setText("Car Info");
		price.setText("Price");
		
		
		carinfofield.setEditable(false);
		price.setEditable(false);
		CarInfoSummary.add(carinfofield);
		CarInfoSummary.add(price);
		

		
		CarInfoSummary.add(submit);
		
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
                paymentPanel();
            }
        });
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
