package controller;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class ArquivosController implements IArquivosController {
	
	public ArquivosController() {
		super();
	}

	@Override
	public File[] readDir(String path) throws IOException {
		// file pode ser arquivo
		// ou diretorio no java
		File dir = new File(path);
		
		if(dir.exists() && dir.isDirectory()) {
			File[] files = dir.listFiles();
			for(File f: files) {
				if(f.isFile()) {
					System.out.println("     \t" + f.getName());
				} else {
					System.out.println("<DIR>\t" + f.getName());
				}
			}
		} else {
			throw new IOException("Diretorio invalido.");
		}
		
		
		
		// TODO
		return dir.listFiles();
	}

	@Override
	public void createFile(String path, String nome) throws IOException {
		File dir = new File(path);
		File arquivo = new File(path, nome);
		
		// arquivo nao precisa existir,
		// mas o diretorio sim
		if(dir.exists() && dir.isDirectory()) {
			// inicia partindo da ideia
			// que o arquivo nao existe.
			// Pra usar ou write ou append
			boolean existe = false;
			
			if(arquivo.exists())
				existe = true;
			
			String conteudo = txtParaExcel(".", "relatorio.txt");
			
			// responsavel por abrir o arquivo
			// e definir qual o tipo de operacao,
			// write ou append. Se nao passar
			// a variavel booleana, sempre sera
			// write, mesmo que o arquivo exista
			FileWriter fileWriter = new FileWriter(arquivo, existe);
			
			// responsavel por escrever o conteudo
			PrintWriter print = new PrintWriter(fileWriter);
			print.write(conteudo);
			
			// finaliza a escrita
			print.flush();
			
			print.close();
			fileWriter.close();
		} else {
			throw new IOException("Diretorio invalido.");
		}
	}

	private String gerarTxt() {
		StringBuffer buffer = new StringBuffer();
		String linha = "";
		
		// enquanto a linha nao for FIM
		while(!linha.equalsIgnoreCase("fim")) {
			linha = JOptionPane.showInputDialog(null, "Digite uma frase", "Entrada de texto", JOptionPane.INFORMATION_MESSAGE);
			
			// impedindo que "fim"
			// seja escrito
			if(!linha.equalsIgnoreCase("fim")) {
				// a nao ser que esteja usando Windows 10,
				// precisa colocar o \r alem do \n pra
				// quebrar linha.
				buffer.append(linha+"\r\n");				
			}
		}
		return buffer.toString();
	}
	
	public String txtParaExcel(String pathTxt, String nomeTxt) throws IOException {
		StringBuffer bufferExcel = new StringBuffer();
	
		File arquivo = new File(pathTxt, nomeTxt);
		if(arquivo.exists() && arquivo.isFile()) {
		
			FileInputStream fluxo = new FileInputStream(arquivo);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader bufferTxt = new BufferedReader(leitor);
			String linhaTxt = bufferTxt.readLine();
			
			while(linhaTxt != null) {								
				linhaTxt = linhaTxt.replaceAll(" ", ";");
				bufferExcel.append(linhaTxt + "\r\n");
				linhaTxt = bufferTxt.readLine();
			}
			bufferTxt.close();
			leitor.close();
			fluxo.close();
			return bufferExcel.toString();
		} else {
			throw new IOException("Arquivo invalido.");			
		}
	}


	// processos emelhante ao dos processos
	@Override
	public void readFile(String path, String nome) throws IOException {
		File arquivo = new File(path, nome);
		if(arquivo.exists() && arquivo.isFile()) {
			
			// abre, le, converte, coloca no
			// buffer, faz as operacoes e
			// depois fecha
			
			FileInputStream fluxo = new FileInputStream(arquivo);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			
			while(linha != null) { // procurando EOF, end of file
				System.out.println(linha);
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
			
		} else {
			throw new IOException("Arquivo invalido.");			
		}
	}

	@Override
	public void openFile(String path, String nome) throws IOException {
		File arquivo = new File(path, nome);
		if(arquivo.exists() && arquivo.isFile()) {
			// Desktop eh uma classe capaz
			// de mandar email, abrir browser,
			// abrir/ler um arquivo no software associado
			// exemplo: abrir um txt usando o Bloco de Notas
			
			Desktop desktop = Desktop.getDesktop();
			desktop.open(arquivo);
		} else {
			throw new IOException("Arquivo invalido.");
		}
	}

}
