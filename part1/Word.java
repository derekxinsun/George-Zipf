/*
 * Program introduction: Word class to keep the String of the word and the frequency.
 */
public class Word implements Comparable{
	private int frequency;
	private String word;
	/**
	 * parameterized constructor
	 * @param word
	 * @param frequency
	 */
	public Word(String word,int frequency) {
		this.word = word;
		this.frequency = frequency;
		
	}
	/**
	 * getters and setters 
	 */
	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
	/**
	 * add one on frequency
	 * @return
	 */
	public int fAddOne() {
		frequency++;
		return frequency;
	}
	

	public String toString() {
		return(frequency+"\t\t"+word);
	}
	/**
	 * method override method compareTo for sorting 
	 */
	public int compareTo(Object o) {
		Word w = (Word)o;
		Integer i =this.frequency;
		return i.compareTo(w.frequency);
	}
}
