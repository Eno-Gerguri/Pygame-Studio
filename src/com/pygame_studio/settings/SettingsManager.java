/**
 * Handles serializing the settings into a .xml file and also deserializing the settings from a .xml file.
 */
package com.pygame_studio.settings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * @author Eno Gerguri
 *
 */
public class SettingsManager {

	/**
	 * Controls serializing and deserializing the settings.
	 */
	public SettingsManager() {
		;
	}
	
	/**
	 * Serializes an instance of the "Settings" class into a xml file.
	 * @param settings - Instance of the "Settings" class, to be serialized into "directoryToStore".
	 * @param directoryToStore - Directory where the "Settings" object will be serialized to.
	 */
	public void serializeSettings(Settings settings, File directoryToStore) {
		XmlMapper xmlMapper = new XmlMapper();
		try {
			xmlMapper.writeValue(directoryToStore, settings);
			
		} catch (JsonGenerationException e) {
			e.printStackTrace();
			
		} catch (JsonMappingException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	
	/**
	 * Deserializes an instance of the "Settings" class out of a xml file and then returns it.
	 * @param settingsFile - File which contains the "Settings" instance to be deserialized.
	 * @return Settings - returns the "Settings" object it deserializes.
	 */
	public Settings deserializeSettings(File settingsFile) {
		XmlMapper xmlMapper = new XmlMapper();
		String xml = null;
		Settings settings = null;
		
		try {
			xml = inputStreamToString(new FileInputStream(settingsFile));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		try {
			settings = xmlMapper.readValue(xml, Settings.class);
			
		} catch (JsonMappingException e) {
			e.printStackTrace();
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			
		}
		
		return settings;
	}
	
	private String inputStreamToString(InputStream inputStream) throws IOException {
		StringBuilder stringBuilder = new StringBuilder();
		String line;
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		while ((line = bufferedReader.readLine()) != null) {
			stringBuilder.append(line);
		}
		bufferedReader.close();
		return stringBuilder.toString();
	}

}
