package org.techquiero.archivos.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

public class Traductor extends Properties {

	private static final long serialVersionUID = 1L;

	public Traductor(Idioma idioma) {

		if (idioma == null)
			idioma = Idioma.ES;

		switch (idioma) {
		case ES:
			getProperties("messages_es.propertie");
			break;
		case EN:
			getProperties("messages_en.propertie");
			break;
		default:
			getProperties("messages_es.properties");
		}
	}

	public enum Idioma {
		ES, EN
	}

	private void getProperties(String propertiesPath) {

		try {
			// Generate the path of the file form the resources folder.
			String url = getClass().getClassLoader().getResource(propertiesPath).getFile();

			// Create file.
			File file = new File(url);

			FileInputStream input = new FileInputStream(file);
			load(new InputStreamReader(input, Charset.forName("UTF-8")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
