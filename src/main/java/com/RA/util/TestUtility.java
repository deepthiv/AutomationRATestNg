package com.RA.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.RA.Constant.Constants;

/**
 * Utility class, methods are accessible directly
 * 
 * @author Manish
 *
 */
public class TestUtility {

	public static Workbook book;
	public static Sheet sheet;
	public static Properties property;
	public static Logger log = Logger.getLogger(TestUtility.class.getClass());

	

	/**
	 * read config property file return value of given key
	 * 
	 * @param key
	 * @return
	 */
	public static String getConfigProperty(String key) {
		try {
			property = new Properties();
			InputStream is = new FileInputStream(Constants.CONFIG_PROPERTY);
			property.load(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String value = (String) property.get(key);
		return value;
	}

	/**
	 * Set date for log4j
	 */
	public static void setDateForLog4j() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("_ddMMyyyy_HHmmss");
		System.setProperty("current_date", dateFormat.format(new Date()));
		PropertyConfigurator.configure("./src/main/resources/log4j.properties");
	}

	/**
	 * method to get date
	 * 
	 * @return
	 */
	public static String getDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("_ddMMyyyy_HHmmss");
		return dateFormat.format(new Date());
	}
	
}
