package javarsc;
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

public class Archivo {

	public static StringBuilder crearStringBuilderDelArray(ArrayList<String> array) {
		StringBuilder str = new StringBuilder();
		for (int i=0;i<array.size();i++){
			str.append(array.get(i)+"\n");
		}
		return str;
	}

	public static void borrarElementoDeContenido(ArrayList<String> array , Object elementoABorrar) {
		for (int i=0;i<array.size();i++){
			if (array.get(i).equals(elementoABorrar)) {
				array.remove(i);
			};
		}
		
	}
	
	public static ArrayList<String> crearArrayDelFile(BufferedReader brFile) {
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
	
	public static void cerrarFile(Closeable file) {
		try {
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void escribirEnFile(File file, String texto) {
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
	
	public static void escribirEnFile(File file, String texto, boolean append) {
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
	
	
	public static void imprimirArchivo(BufferedReader brFile) {
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
	
	public static Reader crearFileReader(File file) {
		Reader rFile;
		try {
			rFile = new FileReader(file);
			return rFile;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Writer crearFileWriter(File file) {
		return crearFileWriter(file, true);
	}
	
	public static Writer crearFileWriter(File file, boolean append) {
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
	
	public static void crearFileSiNoExiste(File file) {
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
