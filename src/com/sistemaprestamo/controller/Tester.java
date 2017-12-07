package com.sistemaprestamo.controller;

import com.sistemaprestamo.model.Modelo;
import nueva_vista.Vista_Login;

public class Tester {

	public static void main(String[] args) {
		
		new Vista_Login(new Controller(new Modelo()));	
	}

}
