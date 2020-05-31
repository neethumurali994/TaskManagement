package com.covid.CovidTracker.Model;


public class CaseStatus {
	
	private String country;
	private String state;
	private int NewCases;

	
	
public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getNewCases() {
		return NewCases;
	}
	public void setNewCases(int newCases) {
		NewCases = newCases;
	}
	@Override
	public String toString() {
		return "CaseStatus [country=" + country + ", state=" + state + ", NewCases=" + NewCases + "]";
	}
	public CaseStatus(String country, String state, int newCases) {
		super();
		this.country = country;
		this.state = state;
		NewCases = newCases;
	}

	public CaseStatus()
	{}
	
}
