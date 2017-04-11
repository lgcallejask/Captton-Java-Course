package com.Captton.clase7.ejercicio3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;


public class ejercicio3 {	

	public static void main(String[] args) {
		
		String path = "/home/alumno/workspace/clase7/Libros.txt";
		File Libros = new File(path);
		Reader rLibros = crearFileReader(Libros);
		BufferedReader brLibros = new BufferedReader(rLibros);
		ArrayList<String> aLibros = crearArrayDelFile(brLibros);				
		
		Collections.sort(aLibros);		
		
//		aLibros.sort(new Comparator<String>() {
//			public int compare(String p1,String p2) {
//				 return p1.compareTo(p2);
//			}	 
//		});
		
		StringBuilder strLibros = crearStringBuilderDelArray(aLibros);
		
		StringBuilder str = new StringBuilder();
		str.append("Titulo\t\t\t\t\tAutor\t\t\t\t\tEditorial\t\t\t\tA�o\n");
		
		for (int i=0, j=0;i<strLibros.length();i++){
			if (strLibros.charAt(i)==';' || strLibros.charAt(i)=='\n' || i==strLibros.length()-1 ){
				String datoAMosrtar = strLibros.substring(j, i);
				if (strLibros.charAt(i)==';'){
					int resultadoP = (datoAMosrtar.length()/8);
					int limite = (5-resultadoP);
					for (int k=0; k<limite;k++){
						datoAMosrtar+="\t";
					}
				}
				else{
					datoAMosrtar+="\n";
				}
				str.append(datoAMosrtar);
				i++;	
				j=i;
			}
		}
		
		System.out.println(str.toString());
		
	}
	
	private static StringBuilder crearStringBuilderDelArray(ArrayList<String> array) {
		StringBuilder str = new StringBuilder();
		for (int i=0;i<array.size();i++){
			str.append(array.get(i)+"\n");
		}
		return str;
	}

	private static void borrarElementoDeContenido(ArrayList<String> array , Object elementoABorrar) {
		for (int i=0;i<array.size();i++){
			if (array.get(i).equals(elementoABorrar)) {
				array.remove(i);
			};
		}
		
	}
	
	private static ArrayList<String> crearArrayDelFile(BufferedReader brFile) {
		String line;
		ArrayList<String> aFile= new ArrayList<>();
		try {
			while(( line = brFile.readLine()) != null) {
				aFile.add(line);
			}			
			return aFile;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private static void cerrarFile(Closeable file) {
		try {
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void escribirEnFile(File file, String texto) {
		Writer wFile = crearFileWriter(file);
		BufferedWriter bwFile = new BufferedWriter(wFile);
		try {			
			bwFile.write(texto);
			bwFile.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		cerrarFile(bwFile);
		cerrarFile(wFile);
	}
	
	private static void escribirEnFile(File file, String texto, boolean append) {
		Writer wFile = crearFileWriter(file, append);
		BufferedWriter bwFile = new BufferedWriter(wFile);
		try {			
			bwFile.write(texto);
			bwFile.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		cerrarFile(bwFile);
		cerrarFile(wFile);
	}
	
	
	private static void imprimirArchivo(BufferedReader brFile) {
		String texto;
		try {
			while(( texto = brFile.readLine()) != null) {	
				System.out.println(texto);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	private static Reader crearFileReader(File file) {
		Reader rFile;
		try {
			rFile = new FileReader(file);
			return rFile;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private static Writer crearFileWriter(File file) {
		return crearFileWriter(file, true);
	}
	
	private static Writer crearFileWriter(File file, boolean append) {
		Writer wFile;
		try {
			wFile = new FileWriter(file, append);
			return wFile;
		}
		catch (IOException e) {		
			e.printStackTrace();
			return null;
		}
	}
	
	private static void crearFileSiNoExiste(File file) {
		if(!file.exists()) {
			try {
				file.createNewFile();
			}
			catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}