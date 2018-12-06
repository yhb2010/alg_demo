package com.demo.alg.chapter13;

public enum Color {

	RED("red"), BLACK("black");

	private String name;

	private Color(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
