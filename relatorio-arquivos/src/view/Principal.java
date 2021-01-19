package view;

import java.io.IOException;

import controller.ArquivosController;
import controller.IArquivosController;

/*
 * Pegar o arquivo relat�rio.txt, colocar em um diret�rio que o
 * permita ser lido, fazer a leitura e colocar seu conte�do em
 * um arquivo CSV, para que seja lido pelo Excel.
 */

public class Principal {
	
	public static void main(String[] args) {
		
		IArquivosController control = new ArquivosController();
		
		String path = ".";
		String nome = "relatorio.txt";

		try {
			
			//control.createFile(path, nome);
			//control.readFile(path, nome);
			//control.openFile(path, nome);
			control.createFile("C:\\Users\\Windows 10\\Desktop", "arquivo.csv");
			control.txtParaExcel(path, nome);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
