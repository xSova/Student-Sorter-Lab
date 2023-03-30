package radnom;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;

public class LabProgram {
	   
	public static void main(String[] args) throws IOException {
	      Scanner scnr = new Scanner(System.in);
	      String fileName = scnr.next();
	      double midterm1Avg = 0.0;
	      double midterm2Avg = 0.0;
	      double finalAvg = 0.0;
	      int counter = 0;
	      int totalToBeAvgdFinal = 0;
	      int totalToBeAvgdMidterm1 = 0;
	      int totalToBeAvgdMidterm2 = 0;
	      int i = 0;
	      List<Student> students = new ArrayList<>();
	      try (Scanner fileScnr = new Scanner(new FileInputStream(fileName))) {
	         PrintWriter fileWriter = new PrintWriter(new FileOutputStream("/Users/bryceschultz/eclipse-workspace/Random/bin/radnom/report.txt"));   
	         do {
	        	 String lastName = fileScnr.next();
	        	 //System.out.println("last name collected: " + lastName);
	        	 String firstName = fileScnr.next();
	        	 //System.out.println("first name collected: " + firstName);
	        	 students.add(new Student(lastName));
	        	 //System.out.println("Outputting last name from object: " + students.get(counter).getLastName());
	        	 students.get(counter).setFirstName(firstName);
	        	 //System.out.println("Outputting first name from object: " + students.get(counter).getFirstName());
	        	 students.get(counter).setMidterm1(fileScnr.nextInt());
	        	 System.out.println("Midterm1 collected: " + students.get(counter).getMidterm1());
	        	 students.get(counter).setMidterm2(fileScnr.nextInt());
	        	 students.get(counter).setFinalScore(fileScnr.nextInt());
	        	 students.get(counter).calcGradeAndSetGrade();
	        	 ++counter;
	         } while(fileScnr.hasNext());
	         
	         //FIXME: math starts here
	         //get total for avg midterm1 grade
	         for (i = 0; i < students.size(); ++i) {
	        	 totalToBeAvgdMidterm1 += students.get(i).getMidterm1();
	         }
	         midterm1Avg = (double) totalToBeAvgdMidterm1 / students.size();
	         //get total for avg midterm2 grade
	         for (i = 0; i < students.size(); ++i) {
	        	 totalToBeAvgdMidterm2 += students.get(i).getMidterm2();
	         }
	         midterm2Avg = (double) totalToBeAvgdMidterm2 / students.size();
	         //get total for avg final grade average
	         for (i = 0; i < students.size(); ++i) {
	        	 totalToBeAvgdFinal += students.get(i).getFinalScore();
	         }
	         finalAvg = (double) totalToBeAvgdFinal / students.size();
	         
	         for (i = 0; i < students.size(); ++i) {
	        	//print last name followed by tab
	        	 fileWriter.print(students.get(i).getLastName() + '\t');
	        	 System.out.println(students.get(i).getLastName() + " < last name");
	        	 //print first name followed by tab
	        	 fileWriter.print(students.get(i).getFirstName() + '\t');
	        	 System.out.println(students.get(i).getFirstName() + " < first name");
	        	 //print midterm1 followed by a tab
	        	 fileWriter.printf("" + students.get(i).getMidterm1() + '\t');
	        	 System.out.println(students.get(i).getMidterm1() + " < midterm1");
	        	 //print midterm2 followed by a tab
	        	 fileWriter.printf("" + students.get(i).getMidterm2() + '\t');
	        	 System.out.println(students.get(i).getMidterm2() + " < midterm2");
	        	 //print final followed by a tab
	        	 fileWriter.printf("" + students.get(i).getFinalScore() + '\t');
	        	 System.out.println(students.get(i).getFinalScore() + " < final");
	        	 //print grade followed by newline
	        	 fileWriter.println(students.get(i).getGrade());
	        	 System.out.println(students.get(i).getGrade());
	         }
	         System.out.println();
	         fileWriter.printf("Averages: Midterm1 " + midterm1Avg + ", Midterm2 " + midterm2Avg + ", Final " + finalAvg, "%.2f");
	         
	         //closing files
	         if (fileScnr != null) {
	        	 fileScnr.close();
	        	 System.out.println("Closed input.txt");
	         }
	         if (fileWriter != null) {
	        	 fileWriter.close();
	        	 System.out.println("Closed input.txt");
	         }
	      }
	      catch (FileNotFoundException exception) {
	         System.out.println("File not found");
	      }
	      
	      /* TODO: Read a file name from the user and read the tsv file here. */
	      
	      
	      /* TODO: Compute student grades and exam averages, then output results to a text file here. */
	      // /Users/bryceschultz/eclipse-workspace/Random/bin/StudentInfo.tsv
	      // /Users/bryceschultz/eclipse-workspace/Random/bin/radnom/report.txt
	   
	
		
		
		
	}
	}