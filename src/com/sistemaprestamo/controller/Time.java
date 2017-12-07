package com.sistemaprestamo.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

public class Time implements Runnable{

	private JLabel timelbl;
	private DateFormat dateformat;
	
	
	public Time(JLabel timelbl) {
		
		this.timelbl = timelbl;
		dateformat = new SimpleDateFormat("EEEE MMM dd, hh:mm aaa");
		
	}
	
	
	
	@Override
	public void run() {
			
		while(true) {
				
			try {
				
				timelbl.setText(dateformat.format(new Date()));
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}
		
	}
	
}
