package com.api.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.api.model.Request;

public class ServiceRequestFile {

	File file;
	
	public ServiceRequestFile(){
		file = new File("Request.txt");
		try{
			if (!file.exists()) {
				file.createNewFile();
			}
		}catch(IOException e){}
	}
	
	public int persistRequest(Request request){
		try {

			String register = ("{\"Data\": \"" + request.getDate() + "\" ,"
							 + " \"IP\": \"" + request.getIp() + "\" ,"
							 + " \"Device\": \"" + request.getDevice() + "\" ,"
							 + " \"Protocolo\": \"" + request.getProtocol() + "\" ,"
							 + " \"Metodo\": \"" + request.getMethod() + "\" ,"	 
							 + " \"Parametro\": \"" + request.getParameter() + "\" ,"
							 + " \"Resposta\": \"" + request.getResponse() + "\"}");
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			

			if(file.length()!=0){
				bw.write(",");
				bw.newLine();
			}
			bw.write(register);
			bw.close();

		} catch (IOException e) {
			return 1;
		}

		return 0;
	}
	public String getRequests(){
		String info = "";
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));

			String line = br.readLine();
			
			while(line!=null){
				info += line;
				line = br.readLine();
			}
			br.close();
		}catch(IOException e){
			return "";
		}
		return info;
	}
}
