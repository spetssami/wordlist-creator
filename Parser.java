	
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;



public class Parser {
	
	public static void main(String[] args) {
		try {
			createWordList("./sanalista.txt");
			System.out.println("Sanalista luotu");
		}catch(Exception e) {
			System.out.println("Homma kusi");
		}
	}
	
	public static void createWordList(String path) throws IOException {
		try {
			FileWriter fw = new FileWriter(path);
			ArrayList<String> oikea = readList("./raakalista.txt");
			ArrayList<String> kielto = readList("./vakiosanat.txt");
			Collections.shuffle(oikea);
			for(int i=0; i<2000; i++) {
				fw.write(oikea.get(i));	
			}
			for(int i=0; i<kielto.size(); i++) {
				fw.write(kielto.get(i));
			}
			fw.close();			
		}catch(Exception e) {
			System.out.print(e);
		}
	}
	
	public static ArrayList<String> readList(String path) throws Exception {
		ArrayList<String> sanalista = new ArrayList<>();
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
		String str;
		System.out.println(in.read());
		while((str = in.readLine()) != null) {
			sanalista.add(str);
		}
		in.close();
		return sanalista;
	}
}
