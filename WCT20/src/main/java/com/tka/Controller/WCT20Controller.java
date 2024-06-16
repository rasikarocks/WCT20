package com.tka.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entity.CricketStaff;
import com.tka.service.WCT20Service;

@RestController
public class WCT20Controller {
	@Autowired
	WCT20Service wService;

	@GetMapping("totalCricketStaff")
	public int fetchAllIndianCricketStafDepartmentfCount() {
		return wService.fetchAllIndianCricketDepartmentCount();
	}

	@GetMapping("totalmedCrickStaff")
	public int allIndianCricketMedStaffCount() {
		return wService.allIndianCricketMedStaffCount();
	}

	@GetMapping("ageNameStaff")
	public HashMap<String, Integer> fetchIndianCricketNamewithAge() {
		return wService.getAgeandNameofStaff();
	}

	@GetMapping("MaxYearsToBCCI")
	public String fetchStaffNamewithMaxYears() {
		return wService.fetchStaffNamewithMaxYears();
	}

	@GetMapping("AgeMoreThan30Year")
	public HashMap<String, Integer> fetchStaffNameMoreThan30Year() {
		return wService.fetchStaffNameMoreThan30Year();
	}

	@GetMapping("AgeLessThan30Years")
	public HashMap<String, Integer> fetchStaffNameLessThan30Year() {
		return wService.fetchStaffNameLessThan30Year();
	}

	@GetMapping("NameStartswithS")
	public ArrayList<String> fetchNameStartsWithS() {
		return wService.fetchNameStartsWithS();
	}

	@GetMapping("NameOfAllStaffInCapital")
	public ArrayList<String> fetchAllStaffPlayersInCapitalLetter() {
		return wService.fetchAllStaffPlayersInCapitalLetter();

	}

	@GetMapping("NameOfAllStaffInLower")
	public ArrayList<String> fetchAllStaffPlayersInLowerLetter() {
		return wService.fetchAllStaffPlayersInLowerLetter();

	}

	@GetMapping("OnlyPlayersDepartmentInCapital")
	public HashMap<String, String> fetchPalyersDepartmentNameInCapitalLetter() {
		return wService.fetchPalyersDepartmentNameInCapitalLetter();
	}

	@GetMapping("NameOfMedicalStaffOnly")
	public ArrayList<String> fetchNameOfMedicalStaffOnly() {
		return wService.fetchNameOfMedicalStaffOnly();

	}

	@GetMapping("AdditionOfExperienceYearsOFMedStaff")
	public int fechAdditionOfExperienceYearsOfMedStaff() {
		return wService.fechAdditionOfExperienceYearsOfMedStaff();
	}

	@GetMapping("AdditionOfExpYearsOfPlayersStaff")
	public Map<String, Object> fetchAdditionOfExperienceYearsOfPlayerStaff() {

		int totalExperience = wService.fechAdditionOfExperienceYearsOfPlayerStaff();
		Map<String, Object> response = new HashMap<>();

		response.put("totalExperience", totalExperience);
		response.put("message", "Addition of Players Experience");

		return response;
	}

	@GetMapping("HighestT20Score")
	public String fetchHighestScoreInT20() {
		return wService.fetchHighestScoreInT20();
	}
	
	@GetMapping("HighestWicketTaker")
	public String fetchHighestWickets() {
		return wService.fetchHighestWickets();
	} 
	
	@GetMapping("SingleCricketStaff")
	public CricketStaff fetchSingleCircketStaff() {
		return wService.fetchSingleCircketStaff();
	}
	
	@PostMapping("InsertCricketStaff")
	public void insertCricketStaff(@RequestBody CricketStaff cricketStaff) {
		System.out.println("CLick Staff data from Postman-->"+cricketStaff);
		wService.insertCricketStaff(cricketStaff);
	}
	
	@PutMapping("UpdateCrickStaff")
	public void updateCricketStaff(@RequestBody CricketStaff cricketStaff) {
		System.err.println("uPDATE Staff data-->"+cricketStaff);
		wService.updateCricketStaff(cricketStaff);
	}
	
	@GetMapping("CountofStaffAsPerDept/{deptName}/{staffNoofYearsinBCC}")
	public int fetchStaffAsPerDeptNAme(@PathVariable("deptName") String staffDept, @PathVariable int staffNoofYearsinBCC){
		System.err.println(staffDept);
		System.err.println(staffNoofYearsinBCC);
		return wService.fetchStaffAsPerDeptNAme(staffDept);
	}

	@GetMapping("CountofStaffAsPerDeptReqParam")
	public int fetchStaffAsPerDeptNAmeReqParam(@RequestParam("deptName") String staffDept, @RequestParam int staffNoofYearsinBCC){
		System.err.println(staffDept);
		System.err.println(staffNoofYearsinBCC);
		return wService.fetchStaffAsPerDeptNAme(staffDept);
	}
	
	@GetMapping("ageNameStaffPathVariable/{staffName}/{staffAge}")
	public HashMap<String, Integer> fetchIndianCricketNamewithAgePathVariable(@PathVariable String staffName,@PathVariable int staffAge) {
		return wService.fetchIndianCricketNamewithAgePathVariable(staffName,staffAge);
	}
}
