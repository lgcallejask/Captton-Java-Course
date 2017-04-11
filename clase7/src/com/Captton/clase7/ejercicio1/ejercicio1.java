package com.Captton.clase7.ejercicio1;

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


public class ejercicio1 {	

	public static void main(String[] args) {
		
		String path = "/home/alumno/workspace/clase7/archivo.txt";
		File listaDeCompras = new File(path);
		crearFileSiNoExiste(listaDeCompras);
		
		StringBuilder str = new StringBuilder();
		str.append("Fafafa"+"\n");
		str.append("Chocolate"+"\n");
		str.append("Tira de asado"+"\n");
		str.append("Granola"+"\n");
		str.append("Coca"+"\n");
		str.append("Mila de soja"+"\n");
		str.append("Lechuga"+"\n");
		str.append("Latas de atun"+"\n");
		str.append("Vinito");
		str.append("Limon");
		escribirEnFile(listaDeCompras,str.toString(),false);		
		
		Reader rListaDeCompras = crearFileReader(listaDeCompras);
		BufferedReader brListaDeCompras = new BufferedReader(rListaDeCompras);
		//Scanner sc = new Scanner(file);
		
		//Cuando se crea el array, se lee todo el archivo y el puntero queda en el final.
		ArrayList<String> aLista = crearArrayDelFile(brListaDeCompras);				
		borrarElementoDeContenido(aLista, "Fafafa");
		borrarElementoDeContenido(aLista, "Mila de soja");
		borrarElementoDeContenido(aLista, "Granola");
		borrarElementoDeContenido(aLista, "Latas de atun");
		str = crearStringBuilderDelArray(aLista);
		escribirEnFile(listaDeCompras, str.toString(),false);
		
		//Lo cierro y lo vuelvo abrir xq sino el puntero queda abajo de todo y el "imprimirArchivo" no funca.
		cerrarFile(brListaDeCompras);
		cerrarFile(rListaDeCompras);
		rListaDeCompras= crearFileReader(listaDeCompras);
		brListaDeCompras=new BufferedReader(rListaDeCompras);
		imprimirArchivo(brListaDeCompras);
		
		cerrarFile(brListaDeCompras);
		cerrarFile(rListaDeCompras);
		
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