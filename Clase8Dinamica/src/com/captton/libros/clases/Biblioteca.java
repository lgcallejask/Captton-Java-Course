package com.captton.libros.clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;



public class Biblioteca {
	private ArrayList<Libro> listaLibros;
	
	
	
	public static void agregarLibro(String titulo, String autor, String editorial, String año ){
		
		
		String abs = "/home/alumno/workspace/Clase8Dinamica/libros.txt";
		
			File file = new File(abs);
		
			if(!file.exists()){
			
				try {
				file.createNewFile();
				
				} catch (IOException e) {
				
				System.out.println(e.getMessage());
				
				}
			}
			Writer w = null;
			BufferedWriter bw = null;
		
			try {
				w = new FileWriter(file, true);
				bw = new BufferedWriter(w);
			
		
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
		
		String abs = "/home/alumno/workspace/Clase8Dinamica/libros.txt";
		File file = new File(abs);
		
		Reader r = null;
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		try {
			r = new FileReader(file);
			br = new BufferedReader(r);
			
			
			String txt = "";
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
