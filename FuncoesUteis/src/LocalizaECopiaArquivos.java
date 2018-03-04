import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LocalizaECopiaArquivos {
/*
 * Este codigo copia todo texto num outro arquivo
 * */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String nomeArquivoSaida = "a.txt";
		String caminhoArquivo = "C:/Users/Edson/Desktop/teste/"+nomeArquivoSaida;
		
		
		
		String patternInicia = "[(]";
		String patternFinaliza = "[)]";
		
		boolean condicao = false;
		
		
		File arquivo2 = new File(nomeArquivoSaida);
	       /*ESCREVER*/
	    FileWriter fileW = new FileWriter (arquivo2);//arquivo para escrita
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(caminhoArquivo));
		    arquivo2.createNewFile ();//arquivo criado
		} 
		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
		}
		
	    BufferedWriter buffW = new BufferedWriter (fileW);
		while(br.ready()){

		   String linha = br.readLine();

		   Pattern patternStart = Pattern.compile(patternInicia);
		   Matcher matcherStart = patternStart.matcher(linha);
		   
		   Pattern patternEnd = Pattern.compile(patternFinaliza);
		   Matcher matcherEnd = patternEnd.matcher(linha);
		   
		   if (matcherStart.find()) {
			   condicao = true;
		   }
		   
		   if(condicao) 
		   {
			   System.out.println(br.read()+" "+ linha);
			   
		       buffW.write (linha);//Leia um arquivo e Escreva no outro
		       buffW.newLine ();//pula uma linha no arquivoescrever (result);
		   }
		   
		   if (matcherEnd.find()) {
			   condicao = false;
		   }
		   
		}
		br.close();
	    buffW.close ();
	}

}
