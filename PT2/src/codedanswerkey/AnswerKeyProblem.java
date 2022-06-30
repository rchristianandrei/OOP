package codedanswerkey;

import java.util.regex.*;
import java.io.*;

public class AnswerKeyProblem {
	
	private static final Pattern validAnswer = Pattern.compile("[a-fA-F]");
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader codedAnswers = new BufferedReader(new FileReader(new File("CodedAnswerKey.txt")));
		StringBuilder answers = new StringBuilder();
		
		readFile(codedAnswers, answers);
		answers = finalAnswers(answers);
		printAnswers(answers);
		
		codedAnswers.close();
	}

	private static void readFile(BufferedReader codedAnswers, StringBuilder answers) throws IOException{
		
		String temp = codedAnswers.readLine();
				
		while (temp != null) {
			if(validAnswer.matcher(temp).find()) {
				answers.append(temp);
			}
			temp = codedAnswers.readLine();
		}	
	}
	
	private static StringBuilder finalAnswers(StringBuilder answers) {
		
		String temp = answers.toString().replace('e', 'b');
		temp = temp.replace('E', 'A');
		temp = temp.replace('f', 'c');
		temp = temp.replace('F', 'd');
		
		return new StringBuilder(temp.toLowerCase());
	}
	
	private static void printAnswers(StringBuilder answers) {
		
		for(int i = 0; i < answers.length(); i++) {
			System.out.println(answers.charAt(i));
		}
	}
}

