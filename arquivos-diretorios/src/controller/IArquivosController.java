package controller;

import java.io.IOException;

public interface IArquivosController {
	
	// como o objetivo eh so printar, podemos usar void.
	// No caso de pegar os dados, poderia retornar um File[]
	public void readDir(String path) throws IOException;
	
	public void createFile(String path, String nome) throws IOException;
	public void readFile(String path, String nome) throws IOException;
	public void openFile(String path, String nome) throws IOException;
	
}
