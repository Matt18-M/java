package com.krakedev.ejercicios;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Admin {
	private static Logger Logger=LogManager.getLogger(Admin.class);
	
	public void agregar() {
		Logger.warn ("mensaje de warrn");
		Logger.info ("mensaje de info");
		Logger.debug ("mensaje de debug");
		Logger.trace ("mensaje de trace");
		
		Logger.error ("mensaje de error");
		
		
	}
	
}
