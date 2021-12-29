package GUI;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Exceptions.AccNotFound;
import Exceptions.InvalidAmount;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.awt.event.ActionEvent;
import Data.FileIO;
import java.awt.SystemColor;

public class DepositAcc extends JFrame implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField textField;
	public JTextField textField_1;
	public JButton btnDeposit;
	public JButton btnReset;
	public int a;

	/**
	 * Create the frame.
	 */
	public DepositAcc() {
		setTitle("Deposit To Account");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDepositToAccount = new JLabel("Deposit To Account");
		lblDepositToAccount.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDepositToAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblDepositToAccount.setBounds(10, 11, 414, 36);
		contentPane.add(lblDepositToAccount);
		
		JLabel lblName = new JLabel("Account Number:");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(0, 86, 111, 14);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(121, 83, 211, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(121, 147, 211, 20);
		contentPane.add(textField_1);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAmount.setBounds(0, 150, 111, 14);
		contentPane.add(lblAmount);
		
		btnDeposit = new JButton("Deposit");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String accountNum;
				double amt;
				accountNum=textField.getText();
				amt=Double.parseDouble(textField_1.getText());
				a=JOptionPane.showConfirmDialog(getComponent(0), "Confirm?");
				if(a==0){
					try {
						FileIO.bank.deposit(accountNum, amt);
						JOptionPane.showMessageDialog(getComponent(0),"Deposit Successful");
						dispose();
						textField.setText(null);
						textField_1.setText(null);
					}
					catch(InvalidAmount e1) {
						JOptionPane.showMessageDialog(getComponent(0), "Sorry! Deposit Amount is Invalid");
					}
					catch(AccNotFound e1) {
						JOptionPane.showMessageDialog(getComponent(0), "Sorry! Account is Not Found");
					}
					finally{
						textField.setText(null);
						textField_1.setText(null);
					}
				}
				else {
					textField.setText(null);
					textField_1.setText(null);
				}
			}
		});
		btnDeposit.setBounds(73, 212, 89, 23);
		contentPane.add(btnDeposit);
		
		btnReset = new JButton("Reset");
		btnReset.setBounds(243, 212, 89, 23);
		contentPane.add(btnReset);
		
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
			}
		});
	}
}
