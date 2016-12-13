package racms;

public class Admin {
	private int vendorNo;
	private String vendorName;
	private String passwd;

	// Getters
	public int getVendorNo() {
		return vendorNo;
	}

	public String getVendorName() {
		return vendorName;
	}

	public String getPasswd() {
		return passwd;
	}

	// Setters
	public void setVendorNo(int newVendorNo) {
		vendorNo = newVendorNo;
	}

	public void setVendorName(String newVendorName) {
		vendorName = newVendorName;
	}

	public void setPasswd(String newPasswd) {
		passwd = newPasswd;
	}
	
	//toPanel()
	
	public JPanel toPanel() {
		JPanel panel = new JPanel();
		
		JLabel vendorNoLabel = new JLabel("" + vendorNo);
		JLabel vendorNameLabel = new JLabel(vendorName);
		
		panel.setLayout(new GridLayout(1,2));
		panel.add(vendorNoLabel);
		panel.add(vendorNameLabel);
		
		return panel;
	}

}
