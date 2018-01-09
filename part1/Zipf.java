/*
 * Program introduction: Driver class to perform statistics on text file.
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Zipf {

	public static void main(String[] args) {
		
		System.out.print("Please enter the name of the file that you want to read: ");
		Scanner kb = new Scanner(System.in);
		String infile = null;
		Scanner sc =null;
		File f = null;
		boolean OpenFileFailed = false;
		/**
		 * Opening the file
		 */
		do{
			infile = kb.next(); 
			f = new File(infile);
			if(f.exists()) {
				try {
					sc = new Scanner(new FileInputStream(infile));
					OpenFileFailed = false;
				}catch(FileNotFoundException e){
					System.out.println("Problem opening file...");
					System.out.print("Please enter a new name: ");
					OpenFileFailed = true;
				}
			}else {
				System.out.println("File does not exist...");
				System.out.print("Please enter a new name: ");
				OpenFileFailed = true;
			}
		}while(OpenFileFailed);
		
		// create an empty arraylist to keep Word later.
		ArrayList <Word> sArraylist = new ArrayList<>();
		int totalNumbers=0;
		
		//import Words from text file and insert them into arraylist.
		while(sc.hasNext()) {
			String temp = sc.next().toLowerCase();
			if(temp.matches("[a-zA-Z]+")) {// we only import Words only contains letters.
				totalNumbers++;
				Word w = new Word(temp,1);
				sArraylist.add(w);// add the new word to arraylist.
				for(int i=0;i<sArraylist.size()-1;i++) {// search the list, if there is the same Word in the list already, add 1 on frequency and delete the latest added Word from arraylist.
					if(temp.equals((sArraylist.get(i).getWord()).toLowerCase())){
						sArraylist.get(i).fAddOne();
						sArraylist.remove(sArraylist.size()-1);
					}
				}
				
			}
		}
		sc.close();
		kb.close();
		System.out.println("=======================================");
		System.out.println("RANK"+"\t\t"+"FREQ"+"\t\t"+"WORD");
		System.out.println("=======================================");
	
		sortWord(sArraylist);
		
		for(int i=0;i<sArraylist.size();i++) {
			System.out.println((i+1)+"\t\t"+sArraylist.get(i));
		}
		
		int totalTypes = sArraylist.size();
		int happax=0;
		for(int i=0;i<sArraylist.size();i++) {
			if(sArraylist.get(i).getFrequency()==1) {
				happax++;
			}
		}
		
		int stopWords=0;
		int totalNumberOfStopwords=0;
		for(int i=0;i<sArraylist.size();i++) {
			
			if(sArraylist.get(i).getFrequency()>=10 && sArraylist.get(i).getWord().length()<=4) {
				stopWords++;
				totalNumberOfStopwords=totalNumberOfStopwords+sArraylist.get(i).getFrequency();
				
			}
		}
		
		System.out.println("=======================================");
		System.out.println("Nb of word tokens: "+ totalNumbers);
		System.out.println("Nb of word types: "+ totalTypes+"\n");
		System.out.println("Nb of Happax: "+ happax);
		System.out.println("% of Happax: "+ (int)((double)happax/totalTypes*100)+"%");
		System.out.println("Happax account for: "+ (int)((double)happax/totalNumbers*100)+"% of the text");
		
		System.out.println("\nNb of stop words: "+ stopWords);
		System.out.println("% of stop words: "+ (int)((double)stopWords/totalTypes*100)+"%");
		System.out.println("Stop words account for: "+ (int)((double)totalNumberOfStopwords/totalNumbers*100)+"% of the text");
	}
	/**
	 * sort arraylist by frequency.
	 * @param sArrlist
	 */
	public static void sortWord(ArrayList<Word> sArrlist) {
			for(int i=0;i<sArrlist.size()-1;i++){
				int index =i;
				for (int j=i+1;j<sArrlist.size();j++){
					if(sArrlist.get(j).compareTo(sArrlist.get(index))==1)
						index=j;
					}
					Word lager = sArrlist.get(index);
					sArrlist.set(index,sArrlist.get(i));
					sArrlist.set(i, lager);
			}
		
		
//		Word max= new Word("max",0);
//		int index=0;
//		for(int i=0;i<sArrlist.size();i++) {
//			for(int j=0;j<sArrlist.size()-i;j++) {
//				if(sArrlist.get(j).compareTo(max)>0) {
//					max=sArrlist.get(j);
//					index=j;
//				}
//			}
//			sArrlist.add(sArrlist.size(),sArrlist.get(index));
//			sArrlist.remove(index);
//			max=new Word("max",0);
//		}
	}
}
