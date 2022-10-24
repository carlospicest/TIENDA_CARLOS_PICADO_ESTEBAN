package curso.java.tienda.index.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.HashCrypt;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import curso.java.tienda.index.pojo.Usuario;

public class AltaUsuarioService {

	public static Usuario setEncriptacion(Usuario usuario) {

		String salt = HashCrypt.generateSalt(32);

		String password = HashCrypt.generateHash(salt, usuario.getEmail() + usuario.getPassword());

		// Establecemos la password encriptada (email+password) en el usuario con su
		// respectiva salt.

		usuario.setSalt(salt);
		usuario.setPassword(password);

		return usuario;

	}

	public static ArrayList<String> getProvincias(String url) {

		URL urlData;
		String jsonDataProvincias = "";
		
		try {
			
			urlData = new URL(url);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(urlData.openStream()));

			
			String inputLine;
			while ((inputLine = in.readLine()) != null)
				jsonDataProvincias += inputLine;
				
			in.close();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode node = mapper.readTree(jsonDataProvincias);
			
			System.out.println(node.findValuesAsText("nm"));
			
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;

	}
	
	public static void main(String[] args) {
		
		getProvincias("https://raw.githubusercontent.com/IagoLast/pselect/master/data/provincias.json");
		
	}

}
