package com.baskinrobbins.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.baskinrobbins.baseclass.Baseclass;

public class Log extends Baseclass {

	private static final Logger Log = LogManager.getLogger(Log.class);

	// Info Level Logs
	public static void info(String message) {
		Log.info("Test started");
	}

	// Warn Level Logs
	public static void warn(String message) {
		Log.warn("Test failed");
	}

	// Error Level Logs
	public static void error(String message) {
		Log.error("Logic error");
	}

	// Fatal Level Logs
	public static void fatal(String message) {
		Log.fatal(message);
	}

	// Debug Level Logs
	public static void debug(String message) {
		Log.debug(message);
	}
}
