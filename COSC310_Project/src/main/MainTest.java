package main;

import java.util.ArrayList;
import java.util.List;

import net.sf.extjwnl.JWNLException;
import net.sf.extjwnl.dictionary.Dictionary;
import net.sf.extjwnl.data.*;
import net.sf.extjwnl.data.list.PointerTargetNode;
import net.sf.extjwnl.data.list.PointerTargetNodeList;
//import net.sf.extjwnl

public class MainTest {

	public static void main(String[] args) throws JWNLException {
		// TODO Auto-generated method stub
		Dictionary d = Dictionary.getDefaultResourceInstance();
		List<POS> pos = POS.getAllPOS();
		
		IndexWord GET = d.getIndexWord(pos.get(0),"abs");
		List<Synset> GETsynList = GET.getSenses();
		PointerTargetNodeList synonyms = PointerUtils.getDirectHyponyms(GETsynList.get(0));
		synonyms.print();
		List<Word> words = synonyms.get(0).getSynset().getWords();
		System.out.println(words.get(0).getLemma());
		
		
		
		
		System.out.println();
		
		String synonym = PointerUtils.getDirectHyponyms(GET.getSenses().get(0)).get(1).getSynset().getWords().get(0).getLemma();
		
		System.out.println(synonym);
		
		List<String> allSynonym = getSynonyms("plate");
		for(String s : allSynonym) {
			System.out.println(s);
		}
		
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
