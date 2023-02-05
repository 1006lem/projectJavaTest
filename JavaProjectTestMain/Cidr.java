//package com.example.demo;

import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.security.web.util.matcher.IpAddressMatcher;



public class Cidr {
	private String ip;
	private int netMaskLen;
	private String cidr;
	
	public Cidr(String ip, int netMaskLen) {
		this.ip = ip;
		this.netMaskLen = netMaskLen;
		this.cidr = ip+netMaskLen;
	}

	public Cidr(String cidr) {
		//   / 를 포함한 모든 길이를 다 받는경우
		String[] parseData = cidr.split("/");
		
		this.ip = parseData[0];
		this.netMaskLen = Integer.parseInt(parseData[1]);
		this.cidr = cidr;
	}
	
	public Boolean match(String ip) {
		//System.out.println(matches(ip, this.cidr));
		return matches(ip, this.cidr);
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getNetMaskLen() {
		return netMaskLen;
	}

	public void setNetMaskLen(int netMaskLen) {
		this.netMaskLen = netMaskLen;
	}

	public String getCidr() {
		return cidr;
	}

	public void setCidr(String cidr) {
		this.cidr = cidr;
	}
	
	private boolean matches(String ip, String subnet) {
	    IpAddressMatcher ipAddressMatcher = new IpAddressMatcher(subnet);
	    return ipAddressMatcher.matches(ip);
	}
}

