package controller;

import java.io.File;
import java.io.IOException;

public interface IArquivosController {
	
	public File[] readDir(String path) throws IOException;
	public void createFile(String path, String nome) throws IOException;
	public void readFile(String path, String nome) throws IOException;
	public void openFile(String path, String nome) throws IOException;
	public String txtParaExcel(String path, String nome) throws IOException;
}