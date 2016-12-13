package racms;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import java.awt.*;

public class PaymentPanel extends JFrame{
	
	public static String input;
	public final static long MILLISECONDS_IN_DAY = 24 * 60 * 60 * 1000;
	
	public PaymentPanel(JPanel p, Car c, java.util.Date d1, java.util.Date d2){
		this.setTitle("Payment");
		String[] labels = {"Name:", "Surname:", "Birth Date:", 
							"ID Number:", "Address:", "Phone Number:", "e-mail:", "Credit Card No:"};	
		
		String[] inputs = new String[labels.length];
		
		int numPairs = labels.length;
		
		JPanel MainPanel = new JPanel(new BorderLayout());		
		JPanel InfoPanel = new JPanel(new SpringLayout());		
		JPanel CarInfoSummary = new JPanel(new BorderLayout());
		JTextField[] inputfields = new JTextField[numPairs];
		
		for(int i = 0; i < numPairs; i++){
			JLabel label = new JLabel(labels[i], JLabel.TRAILING);
			inputfields[i] = new JTextField(20);
			
			label.setLabelFor(inputfields[i]);
			InfoPanel.add(label);
			InfoPanel.add(inputfields[i]);			
		}
		
		JButton submit = new JButton("Submit");
		submit.setMaximumSize(new Dimension(100,200));
		submit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				for(int i = 0; i < numPairs; i++){
					inputs[i] = inputfields[i].getText();
					c.setStatus("Rented");
					c.setRenterAddress(inputs[4]);
					c.setRenterEmail(inputs[6]);
					c.setRenterID(Integer.parseInt(inputs[3]));
					c.setRenterName(inputs[0]+" "+inputs[1]);
					c.setRenterPhone(Integer.parseInt(inputs[5]));
					c.setOutDate(d1);
					c.setReturnDate(d2);
				}
			}
		});
		
		CarInfoSummary.add(p, BorderLayout.NORTH);
		JPanel reservation_info = new JPanel();
		reservation_info.setLayout(new GridLayout(4,1));
		
		JLabel date1 = new JLabel("Pick-Up: "+d1);
		JLabel date2 = new JLabel("Return: "+d2);
		int day = (int)((d2.getTime() - d1.getTime()) / MILLISECONDS_IN_DAY);
		JLabel total_days = new JLabel("Total days: "+day);
		JLabel price_info = new JLabel("You will be charged: "+day*c.getDailyPrice()+" TL");
		
		reservation_info.add(date1);
		reservation_info.add(date2);
		reservation_info.add(total_days);
		reservation_info.add(price_info);
		reservation_info.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
				
		CarInfoSummary.add(reservation_info, BorderLayout.CENTER);		
		CarInfoSummary.add(submit, BorderLayout.SOUTH);
		
		SpringUtilities.makeCompactGrid(InfoPanel,
										numPairs,2,
										6, 6,
										6, 6);
		//JFrame frame = new JFrame("Information Panel");
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		InfoPanel.setOpaque(true);
		MainPanel.setOpaque(true);
		CarInfoSummary.setOpaque(true);
		
		MainPanel.add(CarInfoSummary, BorderLayout.WEST);
		MainPanel.add(InfoPanel, BorderLayout.EAST);
		
		this.setContentPane(MainPanel);		
		this.pack();
		
		//frame.setVisible(true);
	
	}	
	
	/*
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
	*/
}
