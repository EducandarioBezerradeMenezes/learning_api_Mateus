package com.api.model;

public class Cnpj {
	
	private String cnpj;
	private static final int[] peso = {6,5,4,3,2,9,8,7,6,5,4,3,2};
	private boolean valid;
	
	public Cnpj(String cnpj){
		this.cnpj = cnpj;
		this.valid = isValid(cnpj);
	}
	
	public Cnpj(){}
	
	public void setCnpj(String cnpj){
		this.cnpj = cnpj;
		this.valid = isValid(this.cnpj);
	}
	public  String getCnpj(){
		return cnpj;
	}
	
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public  boolean getValid(){
		return valid;
	}

	public static String digit(String cnpj){
		int soma = 0;
		String digit;
		for(int i= cnpj.length()-1, digito; i>=0;i--){
			digito = Character.getNumericValue(cnpj.charAt(i))*peso[peso.length-cnpj.length()+i];
			soma += digito;
		}
		soma = 11 - soma%11;
		digit = Integer.toString(soma>9?0:soma);
		
		return digit;
	}
	
	public static boolean isValid(String cnpj){
		if(cnpj == null || cnpj.length()!=14){
			return false;
		}
		
		if(		   cnpj == "11111111111111" ||
				   cnpj == "22222222222222" ||
				   cnpj == "33333333333333" ||
				   cnpj == "44444444444444" ||
				   cnpj == "55555555555555" ||
				   cnpj == "66666666666666" ||
				   cnpj == "77777777777777" ||
				   cnpj == "88888888888888" ||
				   cnpj == "99999999999999" ||
				   cnpj == "00000000000000"){
			return false;
		}
		
		String digits = digit(cnpj.substring(0,12));
			   digits += digit(cnpj.substring(0,12) + digits);	   
	    
		return (cnpj.equals(cnpj.substring(0,12) + digits));
	}
	
}
