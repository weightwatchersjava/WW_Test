package com.ww.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileProcessing {

	public static void main(String args[]) throws Exception {
		String respath = "/input.txt";
		Boolean fileExists = doesFileExist(respath);
		if(fileExists) {
			try {
				InputStream in = getInputStream(respath);
				String data = new FileProcessing().readFromInputStream(in);
				System.out.println(data);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			throw new Exception("resource not found: " + respath);
		}
	}

	private static Boolean doesFileExist(String respath) {
		InputStream in = FileProcessing.class.getResourceAsStream(respath);
		if (in != null ) {
			return true;
		} 
		return false;
	}

	private static InputStream getInputStream(String respath) throws Exception {
		InputStream in = FileProcessing.class.getResourceAsStream(respath);
		if (in == null )
			throw new Exception("resource not found: " + respath);
		return in;
	}

	private String readFromInputStream(InputStream inputStream)	throws IOException {
		StringBuilder resultStringBuilder = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] result = line.split("\\–");

				for(int i=0; i<result.length; i++) {
					String resultString = result[i];
					if(resultString!="" && resultString !=null  && resultString.trim()!="") {
						resultString = resultString.trim();
						if(resultString.contains(",")) {
							String[] typeArray = resultString.split("\\,");
							for(int j=0; j<typeArray.length; j++) {
								String resultTypeString = typeArray[j];
								if(resultTypeString!="" && resultTypeString !=null && resultTypeString.trim()!="") {
									resultTypeString = resultTypeString.trim();
									resultStringBuilder.append(resultTypeString).append("\n");
								}
							}
						} else {
							resultStringBuilder.append(resultString).append("\n");
						}
					}
				}
			}
		}
		return resultStringBuilder.toString();
	}
}
