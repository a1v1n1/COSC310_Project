package main;

import java.util.List;

import net.sf.extjwnl.JWNLException;

public class MainTest2 {

	public static void main(String[] args) throws JWNLException {
		List<String> synonyms = InputProcess.getSynonyms("cancer");
		for (String s : synonyms) {
			System.out.println(s);
		}

	}

}
