package main;

import java.util.ArrayList;
import java.util.List;

import net.sf.extjwnl.JWNLException;
import net.sf.extjwnl.data.POS;
import net.sf.extjwnl.data.PointerUtils;
import net.sf.extjwnl.data.Synset;
import net.sf.extjwnl.data.Word;
import net.sf.extjwnl.data.list.PointerTargetNode;
import net.sf.extjwnl.data.list.PointerTargetNodeList;
import net.sf.extjwnl.dictionary.Dictionary;

public class InputProcess {
	
	public static boolean check(String input, String word) {
		boolean contains = false;
		
		if(checkSynonym(input,word)||SpellCheck.hasTypoLineHelper(input, word))
			contains = true;
		
		return contains;
	}
	
	public static boolean checkSynonym(String input, String word) {
		boolean synonymFound = false;
		
		List<String> synonyms = new ArrayList<String>();
		try {
			synonyms = getSynonyms(word);
		} catch (JWNLException e) {
			e.printStackTrace();
		}
		String[] inputWords = input.split("\\s+");
		
		for(String inputWord : inputWords) {
			for(String synonym : synonyms) {
				if(inputWord.equalsIgnoreCase(synonym)) {
					synonymFound = true;
				}
			}
		}
		return synonymFound;
	}
	
	public static List<String> getSynonyms(String toFind) throws JWNLException {
		Dictionary d = Dictionary.getDefaultResourceInstance();
		List<String> toReturn = new ArrayList<String>();
		List<POS> poss = POS.getAllPOS();
		for(POS pos : poss) {
			try {
				List<Synset> synsets = d.getIndexWord(pos, toFind).getSenses();
				for(Synset synset : synsets) {
					PointerTargetNodeList nodeList = PointerUtils.getDirectHyponyms(synset);
					for(PointerTargetNode ptn : nodeList) {
						List<Word> words = ptn.getSynset().getWords();
						for(Word word : words) {
							String wordString = word.getLemma();
							toReturn.add(wordString);
						}
					}
				}
			} catch (IndexOutOfBoundsException e) {
				System.out.println("OOB" + POS.getPOSForId(pos.getId()).toString());
			} catch (NullPointerException e) {
				System.out.println("NULL EXCEPTION");
			}
		}
		return toReturn;
	}
}
