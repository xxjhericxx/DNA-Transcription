package Main;

import javax.swing.JOptionPane;

/**
 * Strand class contains the static methods to generate a complementary strand and 
 * a mRNA & tRNA strand (Transcription).
 *
 *@author Jheric
 */
public class Strand {
	
	/**
	 * Takes a DNA template string and returns the complementary strand string.
	 * @param s
	 * @return
	 */
	
	public static String complementaryStrand(String s) {
		StringBuilder cStrand = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			Character temp = s.charAt(i);
			if(temp == 'A' || temp == 'a'){
				temp = 'T';
			} else if (temp == 'T' || temp == 't'){
				temp = 'A';
			} else if (temp == 'C' || temp == 'c') {
				temp ='G';
			} else if(temp == 'G' || temp == 'g') {
				temp = 'C';
			} else if(temp == ' ') {

			} else  {
				JOptionPane.showMessageDialog(null,temp + " is not a nucleotide.");
				return("");
			}
			cStrand.append(temp);
		}
		return cStrand.toString();
	}

	/**
	 * Takes a DNA template string and returns the mRNA sequence string. 
	 * @param s
	 * @return
	 */
	
	public static String mRNA(String s) {
		StringBuilder cStrand = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			Character temp = s.charAt(i);
			if(temp == 'A' || temp == 'a'){
				temp = 'U';
			} else if (temp == 'T' || temp == 't'){
				temp = 'A';
			} else if (temp == 'C' || temp == 'c') {
				temp ='G';
			} else if(temp == 'G' || temp == 'g') {
				temp ='C';
			} else if(temp == ' ') {

			} else  {
				JOptionPane.showMessageDialog(null,temp + " is not a nucleotide.");
				return("");
			}
			cStrand.append(temp);
		}
		return cStrand.toString();	
	}

	/**
	 * Takes a mRNA template string and returns the tRNA sequence string. 
	 * @param s
	 * @return
	 */
	
	public static String tRNA(String s) {
		StringBuilder tStrand = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			Character temp = s.charAt(i);
			if(temp == 'A' || temp == 'a'){
				temp = 'U';
			} else if (temp == 'T' || temp == 't'){
				temp = 'A';
			} else if (temp == 'C' || temp == 'c') {
				temp ='G';
			} else if(temp == 'G' || temp == 'g') {
				temp ='C';
			} else if (temp == 'U' || temp == 'u') {
				temp = 'A';
			} else if(temp == ' ') {

			} else  {
				JOptionPane.showMessageDialog(null,temp + " is not a nucleotide.");
				return("");
			}
			tStrand.append(temp);
		}
		return tStrand.toString();	
	}
	
}