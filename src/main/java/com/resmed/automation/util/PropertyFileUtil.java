package com.resmed.automation.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Contains property file read helper methods
 * 
 * @author madhur_agrawal
 */

public class PropertyFileUtil {

	/**
	 * Read Properties File specified in path
	 * 
	 * @param propertyFilePath
	 * @return prop
	 */
	public Properties readProperty(String propertyFilePath) {
		InputStream input = null;
		Properties prop = null;
		try {
			input = new FileInputStream(propertyFilePath);
			prop = new Properties();
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
