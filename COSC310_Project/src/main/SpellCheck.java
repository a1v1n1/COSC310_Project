package main;
import net.sf.extjwnl.JWNLException;
import net.sf.extjwnl.data.IndexWord;
import net.sf.extjwnl.data.POS;
import net.sf.extjwnl.dictionary.Dictionary;
import java.util.List;

public class SpellCheck {
	
	public static void main(String[] args) throws JWNLException {
		String test = "dortor";
		System.out.println(hasTypo(test));
	}
	
	public SpellCheck() {
	}
	
	static String hasTypo(String t) throws JWNLException {
		Dictionary dictionary = Dictionary.getDefaultResourceInstance();
	    List<POS> pos = POS.getAllPOS();
	    IndexWord GET = dictionary.getIndexWord(pos.get(0), t);
		if(!(GET==null)) {
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
		    		if(!(GET==null)) {
		    			return check;
		    		}
	    		}
	    	}
	    	checkedWord[i] = storage[i];
	    }
	    return t;
	}
	
	//Resources
	static char[] alph = "abcdefghijklmnopqrstuvwxyz".toCharArray();
}