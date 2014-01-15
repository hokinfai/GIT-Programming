package assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Decoder {
	public static void main(String args[]) throws IOException {
		long start = System.currentTimeMillis();
		long end = 0;
		HashMap<String, String> map = new HashMap<String, String>();
		StringBuffer buffer = new StringBuffer();
		BufferedReader Buf = new BufferedReader(new InputStreamReader(
				new FileInputStream(args[0])));
		int nothing;
		while ((nothing = Buf.read()) != -1) {
			buffer.append((char) nothing);
		}
		String input = buffer.toString();
		Buf.close();

		
		
		
		
		StringBuffer buffer1 = new StringBuffer();
		BufferedReader dict = new BufferedReader(new InputStreamReader(
				new FileInputStream(args[1])));

		int something;
		while ((something = dict.read()) != -1) {
			buffer1.append((char) something);
		}
		String oldDic = buffer1.toString();
		
		dict.close();
		String[] spliter = (oldDic.substring(1, oldDic.length() - 1)).split(", ");
		
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//String dic = oldDic.substring(1, oldDic.length() - 1);


		// sort my dictionary
		
		int length=spliter.length;
		char[] key = new char[length];
		String[] value = new String[length];

		for (int x = 0; x < spliter.length; x++) {
			key[x] = spliter[x].charAt(0);
			value[x] = spliter[x].substring(2);
			map.put(value[x], String.valueOf(key[x]));
		}

		StringBuilder file = new StringBuilder("");
		String temporary = "";
		end = System.currentTimeMillis();
		System.out.println(end - start);

		for (int i = 0; i < input.length() ;i++) {
			temporary += input.charAt(i);
			if (map.get(temporary) != null) {
				file.append(map.get(temporary));
				temporary = "";
			}
		}

		end = System.currentTimeMillis();
		System.out.println(end - start);
		BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[2]));
		fileWriter.write(file.toString());
		fileWriter.close();
		// System.out.println(file);
	}
}
