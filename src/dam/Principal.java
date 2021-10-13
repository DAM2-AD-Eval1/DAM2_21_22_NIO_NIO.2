package dam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Principal {

	public static void main(String[] args) throws IOException {
		
		//Lectura del fichero properties utilizando NIO
		//El fichero tiene la siguiente estructura:
		//FICHERO=D:\\PRUEBAS...
		
		BufferedReader br = new BufferedReader(new FileReader("D:\\PRUEBAS\\fichero.properties"));
		
		String linea;
		String[] linea_separada = null;
		String ruta = null;
		while((linea=br.readLine()) != null) {
			linea_separada = linea.split("=");
			if (linea_separada[0].equals("FICHERO")){
				ruta = linea_separada[1];
			}
			
		}
		
		//Escritura del fichero obtenido antes empleando NIO.2
		//Con la variable ruta, ya tengo la ruta para escribir
		
		Path ruta_escritura = Paths.get(ruta);
		
		BufferedWriter bw = Files.newBufferedWriter(ruta_escritura);
		
		bw.write("He leído correctamente la ruta");
		
		bw.flush();
		bw.close();
		br.close();
	}

}
