package Utilities;

import constants.Constants;

public class TestDataUtility {
	public static String getProperty() {
		return System.getProperty("user.dir") + Constants.TESTDATAFILE;
	}

}
