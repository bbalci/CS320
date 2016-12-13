import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CarInformation{
	static JTextField textField;
	static JLabel label;
	static JTextField textField1;
	static JLabel label1;
	static JTextField textField2;
	static JLabel label2;
	static JTextField textField3;
	static JLabel label3;
	static JTextField textField4;
	static JLabel label4;
	static JTextField textField5;
	static JLabel label5;
	static JTextField textField6;
	static JLabel label6;
	static JTextField textField7;
	static JLabel label7;
	static JTextField textField8;
	static JLabel label8;
	static JTextField textField9;
	static JLabel label9;
	static JTextField textField10;
	static JLabel label10;
	static String id;
	static String brand;
	static String model;
	static String clas;
	static String gear;
	static String door;
	static String seat;
	static String fuel;
	static String price;
	static byte Bid;
	static byte Bdoor;
	static byte Bseat;
	static byte Bprice;
	static String reserved;
	static JRadioButton radio1;
	static JRadioButton radio2;
	static JRadioButton radio3;
	static JRadioButton radio4;
	static JRadioButton radio5;
	static JRadioButton radio6;
	static JRadioButton radio7;
	static JRadioButton radio8;


	public static void main (String args []) {
		Scanner keyboard=new Scanner(System.in);

		JFrame frame=new JFrame();
		frame.setSize(800, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		JPanel panel=new JPanel();
		panel.setBackground(Color.WHITE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);	    
		frame.add(panel);
		panel.setLayout(null);


		JButton button = new JButton("New Car");
		button.setBounds(50,50,150,30);
		button.addActionListener(new ActionListener(){


			@Override
			public void actionPerformed(ActionEvent e) {
				JButton button4 = new JButton("Save");
				button4.setBounds(325,450,100,30);
				panel.add(button4);
				label.setBounds(450,50,300,30);
				textField.setBounds(500,50,200,30);
				label1.setBounds(450,100,300,30);
				textField1.setBounds(500,100,200,30);
				label2.setBounds(450,150,300,30);
				textField2.setBounds(500,150,200,30);
				label3.setBounds(450,200,300,30);
				textField3.setBounds(500,200,200,30);
				label4.setBounds(450,250,300,30);
				textField4.setBounds(500,250,200,30);
				label5.setBounds(450,300,300,30);
				textField5.setBounds(500,300,200,30);
				label6.setBounds(450,350,300,30);
				textField6.setBounds(500,350,200,30);
				label7.setBounds(450,400,200,30);
				textField7.setBounds(500,400,200,30);
				label8.setBounds(450,450,200,30);
				textField8.setBounds(500,450,200,30);
				label10.setBounds(450,500,200,30);
				textField10.setBounds(500,500,200,30);
				button4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{
						Object source = e.getSource();
						if (source instanceof JButton) {
							JButton btn = (JButton)source;
							id=textField.getText();
							brand=textField1.getText();
							model=textField2.getText();
							clas=textField3.getText();
							gear=textField4.getText();
							door=textField5.getText();
							seat=textField6.getText();
							fuel=textField7.getText();
							price=textField8.getText();
							reserved=textField10.getText();
							Bid=Byte.parseByte(id);
							Bdoor=Byte.parseByte(door);
							Bseat=Byte.parseByte(seat);
							Bprice=Byte.parseByte(price);

							/*	System.out.println(id);
							System.out.println(brand);
							System.out.println(model);
							System.out.println(clas);
							System.out.println(gear);
							System.out.println(door);
							System.out.println(seat);
							System.out.println(fuel);
							System.out.println(price);
							 */
							car car2 =new car(Bid,brand,model,clas,gear,Bdoor,Bseat,fuel,Bprice,reserved);
							JOptionPane.showMessageDialog(null, car2);
						}
					}
				});

			}

		});
		JButton button2 = new JButton("Edit Car");		
		button2.setBounds(50,100,150,30);
		button2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				label9.setBounds(450,50,300,30);
				textField9.setBounds(500,50,200,30);
				JButton edit=new JButton("Edit");
				edit.setBounds(500,150,200,30);
				panel.add(edit);
				edit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{
						Object source = e.getSource();
						if (source instanceof JButton) {
							JButton btn = (JButton)source;
							/*	radio1 = new JRadioButton("Brand");
							radio2 = new JRadioButton("Model");
							radio2 = new JRadioButton("Class");
							radio3 = new JRadioButton("Gear");
							radio4 = new JRadioButton("Door");
							radio5 = new JRadioButton("Seat");
							radio6 = new JRadioButton("Fuel");
							radio7 = new JRadioButton("Price");
							radio8 = new JRadioButton("Reserve");



					        ButtonGroup group1 = new ButtonGroup();
					        group1.add(radio1);
					        group1.add(radio2);
					        group1.add(radio3);
					        group1.add(radio4);
					        group1.add(radio5);
					        group1.add(radio6);
					        group1.add(radio7);
					        group1.add(radio8);


					        panel.add(radio1); 
					        panel.add(radio2); 
					        panel.add(radio3); 
					        panel.add(radio4); 
					        panel.add(radio5); 

							 */

						}
					}
				});

			}
		});

		JButton button3 = new JButton("Delete Car");
		button3.setBounds(50,150,150,30);
		button3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				label9.setBounds(450,50,300,30);
				textField9.setBounds(500,50,200,30);
				JButton delete=new JButton("Delete");
				delete.setBounds(500,150,200,30);
				panel.add(delete);
				delete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{
						Object source = e.getSource();
						if (source instanceof JButton) {
							JButton btn = (JButton)source;
							JOptionPane.showMessageDialog(null, textField9.getText() + " is deleted from database..");
						}
					}
				});

			}
		});


		JButton button5 = new JButton("Exit");
		button5.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

			}

		});

		button5.setBounds(50,200,150,30);
		panel.add(button5);

		panel.add(button);
		panel.add(button2);
		panel.add(button3);


		textField = new JTextField("");
		label = new JLabel("ID");
		panel.add(label);
		panel.add(textField);
		textField1 = new JTextField("");
		label1 = new JLabel("Brand");
		panel.add(label1);
		panel.add(textField1);
		textField2 = new JTextField("");
		label2= new JLabel("Model");
		panel.add(label2);
		panel.add(textField2);
		textField3 = new JTextField("");
		label3= new JLabel("Class");
		panel.add(label3);
		panel.add(textField3);
		textField4 = new JTextField("");
		label4= new JLabel("Gear");
		panel.add(label4);
		panel.add(textField4);
		textField5 = new JTextField("");
		label5= new JLabel("Door");
		panel.add(label5);
		panel.add(textField5);
		textField6 = new JTextField("");
		label6= new JLabel("Seat");
		panel.add(label6);
		panel.add(textField6);
		textField7 = new JTextField("");
		label7= new JLabel("Fuel");
		panel.add(label7);
		panel.add(textField7);
		textField8 = new JTextField("");
		label8= new JLabel("Price");
		panel.add(label8);
		panel.add(textField8);
		textField9 = new JTextField("");
		label9= new JLabel("CarID");
		panel.add(label9);
		panel.add(textField9);
		textField10 = new JTextField("");
		label10= new JLabel("Reserve");
		panel.add(label10);
		panel.add(textField10);



	}


}	




