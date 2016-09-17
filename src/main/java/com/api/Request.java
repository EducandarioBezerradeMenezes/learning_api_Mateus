package com.api;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Request {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private Date date;
	
	private String ip;
	private String device;
	private String protocol;
	private String method;
	private String parameter;
	private String response;
	
	protected Request(){}

	public Request(String ip, String device, String protocol, String method, String parameter, String response) {
		super();
		this.date = new Date((new java.util.Date().getTime()));
		this.ip = ip;
		this.device = device;
		this.protocol = protocol;
		this.method = method;
		this.parameter = parameter;
		this.response = response;
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", date=" + date + ", ip=" + ip + ", device=" + device + ", protocol=" + protocol
				+ ", method=" + method + ", parmeter=" + parameter + ", response=" + response + "]";
	}

	public int getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public String getIp() {
		return ip;
	}

	public String getDevice() {
		return device;
	}

	public String getProtocol() {
		return protocol;
	}

	public String getMethod() {
		return method;
	}

	public String getParameter() {
		return parameter;
	}

	public String getResponse() {
		return response;
	}	
}