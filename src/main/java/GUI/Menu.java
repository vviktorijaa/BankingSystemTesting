package GUI;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Data.FileIO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.Icon;

public class Menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JButton btnExit;
	public JButton btnNewButton;
	public JButton btnDisplayAccountList;
	public JButton btnDepositToAccount;
	public JButton btnWithdrawFromAccount;

	/**
	 * Create the frame.
	 */
	public Menu() {
		setTitle("Banking System");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 649, 474);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setForeground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBankingSystem = new JLabel("Banking System");
		lblBankingSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblBankingSystem.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblBankingSystem.setBounds(0, 69, 613, 59);
		contentPane.add(lblBankingSystem);
		
		FileIO.Read();

		btnDepositToAccount = new JButton("Deposit To Account");
		btnDepositToAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!GUIForm.depositacc.isVisible()) {
					GUIForm.depositacc.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(getComponent(0), "Already Opened", "Warning", 0);
				}
			}
		});
		btnDepositToAccount.setBounds(217, 213, 194, 33);
		contentPane.add(btnDepositToAccount);
		
		btnWithdrawFromAccount = new JButton("Withdraw From Account");
		btnWithdrawFromAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!GUIForm.withdraw.isVisible()) {
					GUIForm.withdraw.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(getComponent(0), "Already Opened", "Warning", 0);
				}
			}
		});
		btnWithdrawFromAccount.setBounds(217, 256, 194, 33);
		contentPane.add(btnWithdrawFromAccount);
		
		btnDisplayAccountList = new JButton("Display Account List");
		btnDisplayAccountList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!GUIForm.displaylist.isVisible()) {
					GUIForm.displaylist.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(getComponent(0), "Already Opened", "Warning", 0);
				}
				
			}
		});
		btnDisplayAccountList.setBounds(217, 300, 194, 32);
		contentPane.add(btnDisplayAccountList);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//JOptionPane.showMessageDialog(getComponent(0), "Thanks For Using") ;
				FileIO.Write();
				System.exit(0);
			}
		});
		btnExit.setBounds(217, 343, 194, 33);
		contentPane.add(btnExit);
		
		btnNewButton = new JButton("Add Account");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!GUIForm.addaccount.isVisible()) {
					GUIForm.addaccount.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(getComponent(0), "Already Opened", "Warning", 0);
				}
			}
		});
		btnNewButton.setBounds(217, 166, 194, 36);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(397, 16, 216, 213);
		contentPane.add(lblNewLabel);

		ImageIcon icon = new ImageIcon("1.png");
	}
}
