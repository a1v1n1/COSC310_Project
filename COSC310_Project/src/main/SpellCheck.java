package main;
import net.sf.extjwnl.JWNLException;
import net.sf.extjwnl.data.IndexWord;
import net.sf.extjwnl.data.POS;
import net.sf.extjwnl.dictionary.Dictionary;
import java.util.List;

public class SpellCheck {
	
	public static void main(String[] args) throws JWNLException {
		String test = "dortor dof hoase paent yea ni yoo na yeh goobd";
		System.out.println(hasTypoLine(test));
	}
	
	public SpellCheck() {
	}
	//
	
	public static boolean hasTypoLineHelper(String input, String word) {
		boolean contains = false;
		
		try {
			if(hasTypoLine(input.toLowerCase()).contains(word)) {
				contains = true;
			}
		} catch (JWNLException e) {
			e.printStackTrace();
		}
		
		
		return contains;
	}
	
	public static String hasTypoLine(String input) throws JWNLException {
		String[] array = input.split("\\s+");
		for(int i = 0; i < array.length; i++) {
			array[i] = hasTypo(array[i]);
		}
		String toReturn = "";
		for(String s : array) {
			toReturn += s + " ";
		}
		toReturn = toReturn.substring(0, toReturn.length()-1);
		return toReturn;
	}
	
	public static String hasTypo(String t) throws JWNLException {
		Dictionary dictionary = Dictionary.getDefaultResourceInstance();
	    List<POS> pos = POS.getAllPOS();
	    IndexWord GET = dictionary.getIndexWord(pos.get(0), t);
		if(!(GET==null) && t.length() > 3) {
			return t;
		}
	    char[] storage = t.toCharArray();
	    char[] checkedWord = t.toCharArray();
	    for(int i = checkedWord.length - 1; i > 0; i--) {
	    	for(int j = 0; j < 26; j++) {
	    		checkedWord[i] = alph[j];
	    		String check = new String(checkedWord);
	    		for(int k = 0; k < 4; k++) {
	    			GET = dictionary.getIndexWord(pos.get(0), check);
		    		if(!(GET==null) && check.length() > 3) {
		    			return check;
		    		}
		    		else if(check.equalsIgnoreCase("yes")) {
		    			return "yes";
		    		}
		    		else if(check.equalsIgnoreCase("no")) {
		    			return "no";
		    		}
	    		}
	    	}
	    	checkedWord[i] = storage[i];
	    }
	    for(int i = checkedWord.length - 1; i > 0; i--) {
	    	StringBuilder brokenWord = new StringBuilder(t);
	    	brokenWord.deleteCharAt(i);
	    	String constr = brokenWord.toString();
	    	GET = dictionary.getIndexWord(pos.get(0), constr);
	    	if(!(GET==null) && constr.length() > 3) {
    			return constr;
    		}
	    }
	    return t;
	}
	
	//Resources
	static char[] alph = "abcdefghijklmnopqrstuvwxyz".toCharArray();
}