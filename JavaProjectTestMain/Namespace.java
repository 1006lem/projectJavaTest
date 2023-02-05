//package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class Namespace {
	/*-필드-*/
	private Map<String, String> labels = new HashMap<>();
	private String name; // 네임스페이스의 이름
	/*-필드-*/
	
	
	/*-getter/setter-*/
	public Map<String, String> getLabels() {
		return labels;
	}
	public void setLabels(Map<String, String> labels) {
		this.labels = labels;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/*-getter/setter-*/
	
	
	
	public void putLabels(String key, String value) {
		this.labels.put(key, value);
	}
	
	public void removeLabels(String key) {
		this.labels.remove(key);
	}
	
	
	@Override
	public String toString() {
		return "Namespace [labels=" + labels + ", name=" + name + "]";
	}
}
