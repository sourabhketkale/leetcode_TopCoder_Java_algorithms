package com.codechallenge.medalia;


/**
 * 
 * @input: DataSet: List<List<String>> DataSet containing words in each string

 * { {[Coding],[is],[fun]}, [coding],[is],[great],[thing]}, {[I],[Love],[to],[Code], [algorithms]}, 
 * {[coding],[improves],[analyatical],[skills],[of],[a],[programmer]} }
 * p
 * 	"coding" has relatedness 11 (is, fun great, thing, Love, to, code, algorithms, improves, analyatical, of, a, programmer)
 *  "is" has a relatedness 2 (coding, fun, great, thing)
 *  "fun" has a relatedness 2 (is, coding)
 *  
 *  @output:	 
 *  	Mean(average of) :  15(total relatedness)/3(total number of words) = 5
 *  	Median(Middle number) : to be found out
 * 
 * */
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class WordRelatedNess {
	
	public static float findReleatedNess(List<List<String>> dataSet) {
		 
		Map<String, ArrayList<String>> containsWordAndRelatedWords = new HashMap<>();
		float totalRelatedWords = 0, totalUniqueWords = 0;
		
		if(dataSet.size()==0){
			return 0;
		}
		for(List<String> iterator : dataSet){
			
			Set<String> UniqueWordsfromTheList = new HashSet<String>(iterator);
			for(String innerIterator : UniqueWordsfromTheList){
				
				containsWordAndRelatedWords.put(innerIterator, WordRelatedNess.provideRelatedWordsForGivenWordInTheArraylist(UniqueWordsfromTheList, innerIterator));
			}
		}
		totalUniqueWords = (float)containsWordAndRelatedWords.keySet().size();
		for(Map.Entry<String, ArrayList<String>> entry : containsWordAndRelatedWords.entrySet()){
				
			totalRelatedWords += entry.getValue().size(); 
		}
		return WordRelatedNess.findMedian((float)totalRelatedWords, totalUniqueWords);
		
	}
	/**
	 * @method: This helper function given the related words for a given word in the comment in a dataset
	 * @input: Hashset containing unique string(words) in a comment, and String word to be excluded
	 * */
	public static ArrayList<String> provideRelatedWordsForGivenWordInTheArraylist(Set<String> inputList, String word){
		
		
		ArrayList<String> outPutRelatedwords = new ArrayList<>();
		for(String it : inputList){
			if(!it.equals(word)){
				outPutRelatedwords.add(it);
			}
		}
		return outPutRelatedwords;
	}
	
	/**
	 * @method: This method calculates float value of the mean relatedness
	 * @input: no total related words, no of Unique words in the datasets
	 * @]
	 * */
	public static float findMedian(float totalRelatedWords, float totalUniqueWords){
		return totalRelatedWords/totalUniqueWords;
	}

	
	public static void main(String[] args) {  
		// TODO Auto-generated method stub

		List<List<String>> dataSet = new ArrayList<>();
	
		List<String> l1= new ArrayList<String>();
		List<String> l2= new ArrayList<String>();
		List<String> l3= new ArrayList<String>();
		List<String> l4= new ArrayList<String>();
		
		l1.add("Coding");
		l1.add("is");
		l1.add("fun");
		l2.add("Coding");
		l2.add("is");
		l2.add("great");
		l2.add("thing");
		l3.add("I");
		l3.add("love");	
		l3.add("to");
		l3.add("code");
		l3.add("algorithms");
		l4.add("Coding");
		l4.add("improves");
		l4.add("analyatical");
		l4.add("skills");
		l4.add("of");
		l4.add("a");
		l4.add("programmer");
		
		dataSet.add(l1);
		dataSet.add(l2);
		dataSet.add(l3);
		dataSet.add(l4);
		
		System.out.println(WordRelatedNess.findReleatedNess(dataSet));
	}

}
