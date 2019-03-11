package org.techquiero.archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.techquiero.archivos.utils.Traductor;
import org.techquiero.archivos.utils.Traductor.Idioma;

public class Main {

	public static void leerArchivo(String rutaDelArchivo) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			archivo = new File(rutaDelArchivo);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}

				if (br != null) {
					br.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void escribirArchivo(String nombreArchivo, String texto) {
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter("/Users/JoaquinCoronado/" + nombreArchivo + ".txt");
			pw = new PrintWriter(fichero);
			pw.println(texto);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			if (fichero != null) {
				try {
					fichero.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) {
		// String rutaArchivo = "/Users/JoaquinCoronado/texto.txt";
		// leerArchivo(rutaArchivo);
		// String texto = "este se un archivo de prueba";
		// escribirArchivo("prueba", texto);

		Traductor traductor = new Traductor(Idioma.EN);
		System.out.println(traductor.getProperty("saludo", "texto por default"));
		System.out.println("Fin del programa...");
	}

}
