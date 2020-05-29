package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Translate_Window {

	private JFrame frame;
	private JTextField txtDNA;
	private JTextField txtMRNA;
	private JTextField txtTRNA;
	private JTextField txtAminoAcid;
	
	Codon cod = new Codon();
	private JTextField txtComp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Translate_Window window = new Translate_Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Translate_Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("DNA Translator");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(0, 0, 384, 586);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(47, 79, 79));
		panel_1.setBounds(10, 11, 364, 564);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(47, 79, 79));
		panel_2.setBounds(80, 11, 222, 43);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblTitle = new JLabel("DNA Translator");
		lblTitle.setFont(new Font("Ink Free", Font.BOLD, 27));
		lblTitle.setForeground(new Color(255, 140, 0));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(-10, 0, 232, 43);
		panel_2.add(lblTitle);
		
		JLabel lblDNA = new JLabel("Enter a DNA Sequence :");
		lblDNA.setForeground(new Color(255, 140, 0));
		lblDNA.setFont(new Font("DialogInput", Font.BOLD, 14));
		lblDNA.setBounds(22, 90, 189, 23);
		panel_1.add(lblDNA);
		
		txtDNA = new JTextField();
		txtDNA.setBounds(55, 124, 251, 20);
		panel_1.add(txtDNA);
		txtDNA.setColumns(10);
		
		JLabel lblMRNA = new JLabel("mRNA Sequence :");
		lblMRNA.setForeground(new Color(255, 140, 0));
		lblMRNA.setFont(new Font("DialogInput", Font.BOLD, 14));
		lblMRNA.setBounds(22, 215, 189, 23);
		panel_1.add(lblMRNA);
		
		txtMRNA = new JTextField();
		txtMRNA.setEditable(false);
		txtMRNA.setColumns(10);
		txtMRNA.setBounds(55, 249, 251, 20);
		panel_1.add(txtMRNA);
		
		JLabel lblTRNA = new JLabel("tRNA Sequence :");
		lblTRNA.setForeground(new Color(255, 140, 0));
		lblTRNA.setFont(new Font("DialogInput", Font.BOLD, 14));
		lblTRNA.setBounds(22, 289, 189, 23);
		panel_1.add(lblTRNA);
		
		txtTRNA = new JTextField();
		txtTRNA.setEditable(false);
		txtTRNA.setColumns(10);
		txtTRNA.setBounds(55, 323, 251, 20);
		panel_1.add(txtTRNA);
		
		/**
		 * Clicking the translate button will translate DNA
		 * to mRNA, tRNA & Amino Acid
		 */
		
		JButton btnTranslate = new JButton("TRANSLATE");
		btnTranslate.setBackground(new Color(245, 245, 220));
		btnTranslate.setForeground(new Color(255, 140, 0));
		btnTranslate.setFont(new Font("DialogInput", Font.BOLD, 16));
		btnTranslate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String templateStrand = txtDNA.getText();
				
				String tRNA = Strand.mRNA(templateStrand);
				String mRNA = Strand.tRNA(tRNA);
				
				txtComp.setText(Strand.complementaryStrand(templateStrand));
				txtTRNA.setText(tRNA);
				txtMRNA.setText(mRNA);
				txtAminoAcid.setText(cod.toCodon(mRNA));
						
			}
		});
		btnTranslate.setBounds(114, 446, 130, 23);
		panel_1.add(btnTranslate);
		
		JLabel lblAminoAcid = new JLabel("Amino Acid Sequence :");
		lblAminoAcid.setForeground(new Color(255, 140, 0));
		lblAminoAcid.setFont(new Font("DialogInput", Font.BOLD, 14));
		lblAminoAcid.setBounds(22, 354, 189, 23);
		panel_1.add(lblAminoAcid);
		
		txtAminoAcid = new JTextField();
		txtAminoAcid.setEditable(false);
		txtAminoAcid.setColumns(10);
		txtAminoAcid.setBounds(55, 388, 251, 20);
		panel_1.add(txtAminoAcid);
		
		/**
		 * Clear all the data when you clicked the reset
		 */
		
		JButton btnReset = new JButton("RESET");
		btnReset.setForeground(new Color(255, 140, 0));
		btnReset.setBackground(new Color(245, 245, 220));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtDNA.setText(null);
				txtMRNA.setText(null);
				txtTRNA.setText(null);
				txtComp.setText(null);
				txtAminoAcid.setText(null);
				
			}
		});
		btnReset.setFont(new Font("DialogInput", Font.PLAIN, 11));
		btnReset.setBounds(22, 488, 89, 23);
		panel_1.add(btnReset);
		
		/**
		 * Exit button to end the program
		 */
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setBackground(new Color(245, 245, 220));
		btnExit.setForeground(new Color(255, 140, 0));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (JOptionPane.showConfirmDialog(null, "Confirm if you want to Exit program.","DNA Translator",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("DialogInput", Font.PLAIN, 11));
		btnExit.setBounds(248, 488, 89, 23);
		panel_1.add(btnExit);
		
		JLabel lblComplementary = new JLabel("Complementary Strand :");
		lblComplementary.setForeground(new Color(255, 140, 0));
		lblComplementary.setFont(new Font("DialogInput", Font.BOLD, 14));
		lblComplementary.setBounds(22, 155, 189, 23);
		panel_1.add(lblComplementary);
		
		txtComp = new JTextField();
		txtComp.setEditable(false);
		txtComp.setColumns(10);
		txtComp.setBounds(55, 189, 251, 20);
		panel_1.add(txtComp);
		
		JLabel lblCreatedBy = new JLabel("Created By :");
		lblCreatedBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreatedBy.setForeground(new Color(255, 140, 0));
		lblCreatedBy.setFont(new Font("DialogInput", Font.BOLD, 14));
		lblCreatedBy.setBounds(110, 511, 130, 23);
		panel_1.add(lblCreatedBy);
		
		JLabel lblCreator = new JLabel("Jheric Yuzon");
		lblCreator.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreator.setForeground(new Color(255, 140, 0));
		lblCreator.setFont(new Font("DialogInput", Font.BOLD, 14));
		lblCreator.setBounds(110, 532, 130, 23);
		panel_1.add(lblCreator);
		
		JLabel lbl1 = new JLabel("5'");
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setForeground(new Color(255, 140, 0));
		lbl1.setFont(new Font("DialogInput", Font.BOLD, 14));
		lbl1.setBounds(22, 111, 33, 23);
		panel_1.add(lbl1);
		
		JLabel lbl2 = new JLabel("3'");
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setForeground(new Color(255, 140, 0));
		lbl2.setFont(new Font("DialogInput", Font.BOLD, 14));
		lbl2.setBounds(304, 111, 33, 23);
		panel_1.add(lbl2);
		
		JLabel lbl3 = new JLabel("3'");
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3.setForeground(new Color(255, 140, 0));
		lbl3.setFont(new Font("DialogInput", Font.BOLD, 14));
		lbl3.setBounds(22, 181, 33, 23);
		panel_1.add(lbl3);
		
		JLabel lbl4 = new JLabel("5'");
		lbl4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl4.setForeground(new Color(255, 140, 0));
		lbl4.setFont(new Font("DialogInput", Font.BOLD, 14));
		lbl4.setBounds(304, 181, 33, 23);
		panel_1.add(lbl4);
		
		JLabel lbl5 = new JLabel("5'");
		lbl5.setHorizontalAlignment(SwingConstants.CENTER);
		lbl5.setForeground(new Color(255, 140, 0));
		lbl5.setFont(new Font("DialogInput", Font.BOLD, 14));
		lbl5.setBounds(22, 237, 33, 23);
		panel_1.add(lbl5);
		
		JLabel lbl6 = new JLabel("3'");
		lbl6.setHorizontalAlignment(SwingConstants.CENTER);
		lbl6.setForeground(new Color(255, 140, 0));
		lbl6.setFont(new Font("DialogInput", Font.BOLD, 14));
		lbl6.setBounds(304, 237, 33, 23);
		panel_1.add(lbl6);
		
		JLabel lbl7 = new JLabel("5'");
		lbl7.setHorizontalAlignment(SwingConstants.CENTER);
		lbl7.setForeground(new Color(255, 140, 0));
		lbl7.setFont(new Font("DialogInput", Font.BOLD, 14));
		lbl7.setBounds(304, 309, 33, 23);
		panel_1.add(lbl7);
		
		JLabel lbl8 = new JLabel("3'");
		lbl8.setHorizontalAlignment(SwingConstants.CENTER);
		lbl8.setForeground(new Color(255, 140, 0));
		lbl8.setFont(new Font("DialogInput", Font.BOLD, 14));
		lbl8.setBounds(22, 309, 33, 23);
		panel_1.add(lbl8);
	}
}
