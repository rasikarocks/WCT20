package com.tka.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.tka.dao.WCT20Dao;
import com.tka.entity.CricketStaff;

@Service
public class WCT20Service {
	@Autowired
	WCT20Dao dao;

	// Distinct department count
	public int fetchAllIndianCricketDepartmentCount() {
		List<CricketStaff> crickStaff = dao.fetchAllIndianCricketStaff();
		// one new arrayList created
		Set<String> alcrickStaffsDept = new HashSet<String>();
		for (CricketStaff cricketStaff : crickStaff) {
			// using foreach loop through the condition those data are retrived that are
			// equal to med department
			alcrickStaffsDept.add(cricketStaff.getStaffDept());

		}
		return alcrickStaffsDept.size();
	}

	// Medical Staff Count
	public int allIndianCricketMedStaffCount() {
		List<CricketStaff> crickstaffs = dao.fetchAllIndianCricketStaff();
		// Logic
		ArrayList<CricketStaff> alCrickStaffNew = new ArrayList<CricketStaff>();
		for (CricketStaff crickStaff : crickstaffs) {
			if (crickStaff.getStaffDept().equals("Batting Department")) {
				alCrickStaffNew.add(crickStaff);
			}
		}
		return alCrickStaffNew.size();
	}

	// All Staff age and name
	public HashMap<String, Integer> getAgeandNameofStaff() {

		List<CricketStaff> crickstaffs = dao.fetchAllIndianCricketStaff();
		HashMap<String, Integer> AgeNameMap = new HashMap<String, Integer>();

		// ArrayList<CricketStaff>alCrickStaffNew = new ArrayList<CricketStaff>();
		for (CricketStaff crickStaff : crickstaffs) {
			AgeNameMap.put(crickStaff.getStaffName(), crickStaff.getStaffAge());
		}
		return AgeNameMap;
	}

	// Max year to BCCI
	public String fetchStaffNamewithMaxYears() {
		List<CricketStaff> crickstaffs = dao.fetchAllIndianCricketStaff();

		TreeMap<Integer, String> AgeNameMap = new TreeMap<Integer, String>();
		for (CricketStaff crickStaff : crickstaffs) {
			AgeNameMap.put(crickStaff.getStaffNoofYearsinBCC(), crickStaff.getStaffName());
		}
		System.err.println(AgeNameMap);
		Map.Entry<Integer, String> maxEntry = AgeNameMap.lastEntry();
		String nameOfPerson = maxEntry != null ? maxEntry.getValue() : null;

		return nameOfPerson;
	}

	// Age more than 30
	public HashMap<String, Integer> fetchStaffNameMoreThan30Year() {
		List<CricketStaff> crickstaffs = dao.fetchAllIndianCricketStaff();
		HashMap<String, Integer> staffName = new HashMap<String, Integer>();
		for (CricketStaff cricketStaff : crickstaffs) {
			if (cricketStaff.getStaffAge() > 30) {
				staffName.put(cricketStaff.getStaffName(), cricketStaff.getStaffAge());
			}
		}
		return staffName;
	}

	// Age less than 30
	public HashMap<String, Integer> fetchStaffNameLessThan30Year() {
		List<CricketStaff> cricketStaffs = dao.fetchAllIndianCricketStaff();
		HashMap<String, Integer> ageandnamelessthan30 = new HashMap<String, Integer>();
		for (CricketStaff cricketStaff : cricketStaffs) {
			if (cricketStaff.getStaffAge() < 30) {
				ageandnamelessthan30.put(cricketStaff.getStaffName(), cricketStaff.getStaffAge());
			}
		}
		return ageandnamelessthan30;
	}

	public ArrayList<String> fetchNameStartsWithS() {
		List<CricketStaff> cricketStaffs = dao.fetchAllIndianCricketStaff();
		ArrayList<String> NameStartsWiths = new ArrayList<String>();
		for (CricketStaff cricketStaff : cricketStaffs) {
			if (cricketStaff.getStaffName().toUpperCase().startsWith("S")) {
				NameStartsWiths.add(cricketStaff.getStaffName());
			}
		}
		return NameStartsWiths;
	}

	public ArrayList<String> fetchAllStaffPlayersInCapitalLetter() {
		List<CricketStaff> cricketStaffs = dao.fetchAllIndianCricketStaff();
		ArrayList<String> pList = new ArrayList<String>();
		for (CricketStaff cricketStaff : cricketStaffs) {
			String upperName = cricketStaff.getStaffName().toUpperCase();
			pList.add(upperName);
		}
		return pList;

	}

	public ArrayList<String> fetchAllStaffPlayersInLowerLetter() {
		List<CricketStaff> cricketStaffs = dao.fetchAllIndianCricketStaff();
		ArrayList<String> pList = new ArrayList<String>();
		for (CricketStaff cricketStaff : cricketStaffs) {
			String upperName = cricketStaff.getStaffName().toLowerCase();
			pList.add(upperName);
		}
		return pList;

	}

	public HashMap<String, String> fetchPalyersDepartmentNameInCapitalLetter() {
		List<CricketStaff> cricketStaffs = dao.fetchAllIndianCricketStaff();
		HashMap<String, String> pList = new HashMap<String, String>();
		for (CricketStaff cricketStaff : cricketStaffs) {
			if (cricketStaff.getStaffDept().equals("Bowler Department")) {// Fetch only players
				String deptInUpper = cricketStaff.getStaffDept().toUpperCase();// Convert Dept In Upper Case
				pList.put(cricketStaff.getStaffName(), deptInUpper);
			}

		}
		return pList;
	}

	public ArrayList<String> fetchNameOfMedicalStaffOnly() {
		List<CricketStaff> cricketStaffs = dao.fetchAllIndianCricketStaff();
		ArrayList<String> pList = new ArrayList<String>();
		for (CricketStaff cricketStaff : cricketStaffs) {
			if (cricketStaff.getStaffDept().equalsIgnoreCase("Med")) {
				String StaffName = cricketStaff.getStaffName();
				pList.add(StaffName);
			}
		}
		return pList;

	}

	public int fechAdditionOfExperienceYearsOfMedStaff() {
		int sum = 0;
		List<CricketStaff> cricketStaffs = dao.fetchAllIndianCricketStaff();
		// ArrayList<Integer> pList=new ArrayList<Integer>();
		for (CricketStaff cricketStaff : cricketStaffs) {
			if (cricketStaff.getStaffDept().equalsIgnoreCase("Med")) {
				int exp = cricketStaff.getStaffNoofYearsinBCC();
				// pList.add(exp);
				sum += exp;
			}
//			
//			for (int years: pList) {
//				sum+=years;
//			}
		}
		return sum;
	}

	public int fechAdditionOfExperienceYearsOfPlayerStaff() {
		List<CricketStaff> cricketStaffs = dao.fetchAllIndianCricketStaff();
		int sum = 0;
		for (CricketStaff cricketStaff : cricketStaffs) {
			if (cricketStaff.getStaffDept().equalsIgnoreCase("Player")) {
				int exp = cricketStaff.getStaffNoofYearsinBCC();
				sum += exp;
			}
		}
		return sum;
	}

	public String fetchHighestScoreInT20() {
		List<CricketStaff> cricketStaffs = dao.fetchAllIndianCricketStaff();
		if (cricketStaffs == null || cricketStaffs.isEmpty()) {
			return "No Player Found";
		}

		String highestScorer = "";
		int highestScore = -1; // Assuming scores are non-negative

		for (CricketStaff cricketStaff : cricketStaffs) {
			String name = cricketStaff.getStaffName();
			Integer score = cricketStaff.getScore(); // Use Integer to handle null values

			if (name != null && score != null && score > highestScore) {
				highestScore = score;
				highestScorer = name;
			}
		}

		if (highestScorer.isEmpty()) {
			return "No valid player found with a score";
		} else {
			return "Highest Scorer: " + highestScorer + " with score: " + highestScore;
		}
	}

	public String fetchHighestWickets() {
		List<CricketStaff> cricketStaffs = dao.fetchAllIndianCricketStaff();
		if (cricketStaffs == null || cricketStaffs.isEmpty()) {
			return "Player not found";
		}

		int highestWicket = -1;
		String hName = "";
		for (CricketStaff cricketStaff : cricketStaffs) {
			String name = cricketStaff.getStaffName();
			Integer wickets = cricketStaff.getWickets();

			if (name != null && wickets != null && wickets > highestWicket) {
				highestWicket = wickets;
				hName = name;
			}
		}

		return "Highest Wickets Taker: " + hName + " with Count: " + highestWicket;
	}

	public CricketStaff fetchSingleCircketStaff() {
		CricketStaff cricketStaff=dao.fetchingSingleCricketStaff();
		return cricketStaff;
	}

	public void insertCricketStaff(CricketStaff cricketStaff) {
	dao.insertCricketStaff(cricketStaff);
		
	}

	public void updateCricketStaff(CricketStaff cricketStaff) {
		dao.updateCricketStaff(cricketStaff);
		
	}

	public int fetchStaffAsPerDeptNAme(String staffDept) {
		List<CricketStaff> cricketStaffs=dao.fetchAllIndianCricketStaff();
		
		ArrayList<String> al=new ArrayList<String>();
		for (CricketStaff cricketStaff : cricketStaffs) {
			if(cricketStaff.getStaffDept().equalsIgnoreCase(staffDept)) {
				al.add(staffDept);
			}
		}
		return al.size();
	}

	public HashMap<String, Integer> fetchIndianCricketNamewithAgePathVariable(String staffName, int staffAge) {
		List<CricketStaff> crickstaffs = dao.fetchAllIndianCricketStaff();
		HashMap<String, Integer> AgeNameMap = new HashMap<String, Integer>();

		// ArrayList<CricketStaff>alCrickStaffNew = new ArrayList<CricketStaff>();
		for (CricketStaff crickStaff : crickstaffs) {
			AgeNameMap.put(crickStaff.getStaffName(), crickStaff.getStaffAge());
		}
		return AgeNameMap;
	}


}
