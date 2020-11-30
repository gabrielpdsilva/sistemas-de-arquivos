package view;

import java.io.IOException;

import controller.ArquivosController;
import controller.IArquivosController;

public class Principal {
	
	public static void listarDiretorios() {
		IArquivosController control = new ArquivosController();
		String dirWindows = "C:\\Windows";

		// listando tudo de C:\Windows
		try {
			control.readDir(dirWindows);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		IArquivosController control = new ArquivosController();
		
		String path = "C:\\Users\\Windows 10\\Desktop";
		// no caso de um arquivo do excel
		// por exemplo, podemos colocar
		// teste.csv e, na entrada, colocar
		// por exemplo "1; 2; 3" e depois
		// "4; 3; 10". Cada entrada sera
		// uma linha do Excel
		String nome = "teste.txt";

		// listando tudo de C:\Windows
		try {
			
			//control.createFile(path, nome);
			//control.readFile(path, nome);
			control.openFile(path, nome);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
