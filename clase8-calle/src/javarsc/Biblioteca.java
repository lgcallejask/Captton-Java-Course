package javarsc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;

public class Biblioteca {
	
	private ArrayList<Libro> listaLibros;
	
	public static void agregarLibro(String titulo, String autor, String editorial, String año ){
		String path= "/home/alumno/workspace/Clase8Dinamica/libros.txt";
		File file = new File(path);
		Archivo.crearFileSiNoExiste(file);
		Writer w = Archivo.crearFileWriter(file, true);
		BufferedWriter bw = new BufferedWriter(w);
		try {
			bw.write(titulo + ";");				
			bw.write(autor + ";");
			bw.write(editorial + ";");
			bw.write(año + ";");
			bw.newLine();
			bw.flush();	
			bw.close();
			w.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String leerLibro(){
		
		String path = "/home/alumno/workspace/Clase8Dinamica/libros.txt";
		File file = new File(path);
		Reader r = Archivo.crearFileReader(file);
		BufferedReader br = new BufferedReader(r);
		StringBuilder sb = new StringBuilder();
		
		//sb = Archivo.crearStringBuilderDelArray(Archivo.crearArrayDelFile(br));
		
		try {
			String linea;
			while( (linea=br.readLine()) != null){
				sb.append(linea);
			}
			br.close();
			r.close();
		} catch (FileNotFoundException e) {
			e.getMessage();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public ArrayList<Libro> getListaLibros() {
		return listaLibros;
	}

	public void setListaLibros(ArrayList<Libro> listaLibros) {
		this.listaLibros = listaLibros;
	}
}
