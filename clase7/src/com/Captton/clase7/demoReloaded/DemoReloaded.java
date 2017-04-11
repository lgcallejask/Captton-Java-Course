package com.Captton.clase7.demoReloaded;

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

public class DemoReloaded {

	public static void main(String[] args) {
		
		String path = "D:/workspace/clase7/archivo.txt";
		
		File listaDeCompras = new File(path);
		crearFileSiNoExiste(listaDeCompras);
		
		Writer wListaDeCompras = crearFileWriter(listaDeCompras);
		BufferedWriter bwListaDeCompras = new BufferedWriter(wListaDeCompras);
		
		StringBuilder str = new StringBuilder();
		str.append("Linea 1\n");
		str.append("Linea 2 ");
		
		escribirEnFile(bwListaDeCompras,str.toString());
		cerrarFile(bwListaDeCompras);
		cerrarFile(wListaDeCompras);
		
		Reader rListaDeCompras=crearFileReader(listaDeCompras);
		BufferedReader brListaDeCompras=new BufferedReader(rListaDeCompras);
		//Scanner sc = new Scanner(file);		

		imprimirArchivo(brListaDeCompras);
		cerrarFile(brListaDeCompras);
		cerrarFile(rListaDeCompras);
		
	}

	private static void cerrarFile(Closeable file) {
		try {
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void escribirEnFile(BufferedWriter bwFile, String texto) {
		try {			
			bwFile.write(texto);
			bwFile.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	private static void imprimirArchivo(BufferedReader brFile) {
		String texto;
		try {
			while(( texto = brFile.readLine()) != null) {	
					System.out.println(texto);
			}
		} catch (IOException e) {
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
		Writer wFile;
		try {
			wFile = new FileWriter(file);
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
