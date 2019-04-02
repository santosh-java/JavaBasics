package com.oracle.practice.programming;

import java.util.ArrayList;
import java.util.List;

public class Chunkify {

	public static void main(String[] args) {
		Chunkify c = new Chunkify();
		
		System.out.println("Testcase 1 : ab:a:abc:asdfasdf:asdfasd:a:aa:");
		List<String> chunkify = c.chunkify("ab:a:abc:asdfasdf:asdfasd:a:aa:", 5);
		chunkify.stream().forEach(System.out::println);
		
		System.out.println("Testcase 2 : abaadfaasdf:a:abc:asdfasdf:asdfasd:a:aa:");
		List<String> chunkify1 = c.chunkify("abaadfaasdf:a:abc:asdfasdf:asdfasd:a:aa:", 5);
		chunkify1.stream().forEach(System.out::println);
		
		System.out.println("Testcase 3 : ab:a:abc:asdfasdf:asdfasd:a:aa:");
		List<String> chunkify2 = c.chunkify("a:bb:cc:abcdef:ab:c:d:", 5);
		chunkify2.stream().forEach(System.out::println);
	}

	public List<String> chunkify(String doc, int chunkSize) {
		List<String> chunks = new ArrayList<String>();
		StringBuilder temp = new StringBuilder(doc);
		int chunkStart = 0;
		int chunkEnd = 0;
		while (chunkStart < temp.length()) {
			chunkEnd = temp.indexOf(":", chunkStart);
			while ((chunkEnd - chunkStart) <= chunkSize) {
				int tmpInd = temp.indexOf(":", chunkEnd+1);
				if(tmpInd == -1 || tmpInd > chunkSize+chunkStart ) {
					break;
				}
				chunkEnd = tmpInd;
			}
			chunks.add(temp.substring(chunkStart, chunkEnd+1));
			chunkStart = chunkEnd+1;
		}

		return chunks;
	}

}
