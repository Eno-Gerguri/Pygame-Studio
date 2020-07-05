/**
 * Handles serializing the given object into a .xml file and also deserializing the given object from a .xml file.
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
public class XmlManager {

	/**
	 * Controls serializing and deserializing of a given object.
	 */
	public XmlManager() {
		;
	}
	
	/**
	 * Serializes an instance of the given object into a xml file.
	 * @param objectToSerialize - Instance of the "Object" class, to be serialized into "directoryToStore".
	 * @param directoryToStore - Directory where the given object will be serialized to.
	 */
	public void serializeObject(Object objectToSerialize, File directoryToStore) {
		XmlMapper xmlMapper = new XmlMapper();  // Creates and initializes the xmlMapper
		try {
			xmlMapper.writeValue(directoryToStore, objectToSerialize);  // Tries to serialize the object to the directory to store it in.
			
		} catch (JsonGenerationException e) {
			e.printStackTrace();
			
		} catch (JsonMappingException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	
	/**
	 * Deserializes an instance of the given object out of a xml file and then returns it.
	 * @param classOfSerializedObject - Object of the class that is currently serialized in the file.
	 * @param serializedFileDirectory - File which contains the "Settings" instance to be deserialized.
	 * @return deserializedObject - returns the object it deserializes.
	 */
	public Object deserializeObject(Class<?> classOfSerializedObject, File serializedFileDirectory) {
		XmlMapper xmlMapper = new XmlMapper();  // Creates and initializes the xmlMapper
		String xml = null;  // Will store the xml in the file to this string
		Object deserializedObject = null;  // Will store the deserialized object
		
		try {
			xml = inputStreamToString(new FileInputStream(serializedFileDirectory));  // Gets the xml from the file into the string
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		try {
			deserializedObject = xmlMapper.readValue(xml, classOfSerializedObject);  // Deserializes the xml into the deserializedObject
			
		} catch (JsonMappingException e) {
			e.printStackTrace();
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			
		}
		
		return deserializedObject;
	}
	
	/**
	 * 
	 * @param inputStream - The file input stream with the file.
	 * @return String - The entire contents of the file.
	 * @throws IOException
	 */
	private String inputStreamToString(InputStream inputStream) throws IOException {
		StringBuilder stringBuilder = new StringBuilder();  // Creates and initialises the stringBuilder
		String line;  // Create a string line
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		while ((line = bufferedReader.readLine()) != null) {  // While there are still lines in the BufferedReader
			stringBuilder.append(line);  // Adds the line of the file to the stringBuilder
		}
		bufferedReader.close();  // Ensures that we close the file stream
		return stringBuilder.toString();  // Returns the stringBuilder in string format
	}

}
