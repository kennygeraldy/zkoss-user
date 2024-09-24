package com.fif;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;

public class MyViewModel {

	private int count;
	private String name;
	private String helloWorld;

	@Init
	public void init() {
		count = 100;
		name = "Kenny Geraldy Chandra";
		helloWorld = "Hello World!";
	}

	@Command
	@NotifyChange("count")
	public void cmd() { ++count; }

	public int getCount()
	{
		return count;
	}

	public String getName()
	{
		return name;
	}
	public String getHelloWorld()
	{
		return helloWorld;
	}
}
