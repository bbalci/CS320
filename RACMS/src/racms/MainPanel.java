package racms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class MainPanel extends JPanel{
	public static void main (String args[]){
		JFrame frame = new JFrame("CS 320 | Rent A Car Management System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon icon = new ImageIcon("banner.png");
		JLabel bg = new JLabel(icon);
		
		
		//Vendor and Date Options for the Customer
		JPanel user_panel = new JPanel();
		user_panel.setBorder(new EmptyBorder(10,10,10,10));
		user_panel.setOpaque(false);
		
		JLabel vendor_name = new JLabel("Vendor");
		JLabel pick_date = new JLabel("Pick Up Date");
		JLabel return_date = new JLabel("Return Date");
		
		JComboBox vendor_list = new JComboBox();
		ArrayList<String> v_list = AdminAuth.getVendors();
		for(int i=0; i<v_list.size(); i++){
			vendor_list.addItem(v_list.get(i));
		}
		
	
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl pickupDatePicker = new JDatePickerImpl(datePanel);
		
		UtilDateModel model1 = new UtilDateModel();
		JDatePanelImpl datePanel1 = new JDatePanelImpl(model1);
		JDatePickerImpl returnDatePicker = new JDatePickerImpl(datePanel1);
		
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				vendor_list.getSelectedItem();
				java.sql.Date d1 = (java.sql.Date) pickupDatePicker.getModel().getValue();
				java.sql.Date d2 = (java.sql.Date) returnDatePicker.getModel().getValue();
				System.out.println(d1.toString());
				System.out.println(d2.toString());
				
			}
			
		});
		
		
		user_panel.setLayout(new GridLayout(7,1));
		user_panel.add(vendor_name);
		user_panel.add(vendor_list);
		user_panel.add(pick_date);
		user_panel.add(pickupDatePicker);
		user_panel.add(return_date);
		user_panel.add(returnDatePicker);
		user_panel.add(submit);
		
		
		
		//Administrator authentication procedure
		JButton admin_button = new JButton("Admin Log In");
		admin_button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = JOptionPane.showInputDialog("Enter Vendor Number:");
				String password = JOptionPane.showInputDialog("Enter Password:");
				int result = AdminAuth.checkID(username, password);
				if(result == 1){
					AdminPanel ad = new AdminPanel();
					ad.setVisible(true);
				}
				
			}
			
		});
		
	
		frame.setSize(500, 400);
		frame.add(bg, BorderLayout.NORTH);
		frame.add(user_panel, BorderLayout.CENTER);
		frame.add(admin_button, BorderLayout.SOUTH);
		frame.setVisible(true);	
		
	}
}

