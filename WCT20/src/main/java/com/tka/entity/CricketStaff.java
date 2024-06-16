package com.tka.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CricketStaff {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int saffId;
	String staffName;
	String staffDept;
	int staffAge;
	int staffNoofYearsinBCC;
	int matches;
	int Score;
	int wickets;
	public int getWickets() {
		return wickets;
	}
	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
	public int getScore() {
		return Score;
	}
	public void setScore(int score) {
		Score = score;
	}
	public CricketStaff(int saffId, String staffName, String staffDept, int staffAge, int staffNoofYearsinBCC) {
		super();
		this.saffId = saffId;
		this.staffName = staffName;
		this.staffDept = staffDept;
		this.staffAge = staffAge;
		this.staffNoofYearsinBCC = staffNoofYearsinBCC;
	}
	public CricketStaff(String staffName, String staffDept, int staffAge, int staffNoofYearsinBCC) {
		super();
		this.staffName = staffName;
		this.staffDept = staffDept;
		this.staffAge = staffAge;
		this.staffNoofYearsinBCC = staffNoofYearsinBCC;
	}
	public CricketStaff() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getSaffId() {
		return saffId;
	}
	public void setSaffId(int saffId) {
		this.saffId = saffId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getStaffDept() {
		return staffDept;
	}
	public void setStaffDept(String staffDept) {
		this.staffDept = staffDept;
	}
	public int getStaffAge() {
		return staffAge;
	}
	public void setStaffAge(int staffAge) {
		this.staffAge = staffAge;
	}
	public int getStaffNoofYearsinBCC() {
		return staffNoofYearsinBCC;
	}
	public void setStaffNoofYearsinBCC(int staffNoofYearsinBCC) {
		this.staffNoofYearsinBCC = staffNoofYearsinBCC;
	}
	@Override
	public String toString() {
		return "CricketStaff [saffId=" + saffId + ", staffName=" + staffName + ", staffDept=" + staffDept
				+ ", staffAge=" + staffAge + ", staffNoofYearsinBCC=" + staffNoofYearsinBCC + ", matches=" + matches
				+ ", Score=" + Score + ", wickets=" + wickets + "]";
	}
	public CricketStaff(int saffId, String staffName, String staffDept, int staffAge, int staffNoofYearsinBCC,
			int matches, int score, int wickets) {
		super();
		this.saffId = saffId;
		this.staffName = staffName;
		this.staffDept = staffDept;
		this.staffAge = staffAge;
		this.staffNoofYearsinBCC = staffNoofYearsinBCC;
		this.matches = matches;
		Score = score;
		this.wickets = wickets;
	}
	

	
	
	
	
}
