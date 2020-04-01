package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	DistilleryRepository distilleryRepository;

	@Autowired
	WhiskyRepository whiskyRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindWhiskyByYear(){
		List<Whisky> foundWhiskies = whiskyRepository.findWhiskyByYear(2018);
	}

	@Test
	public void canFindWhiskyByDistilleryAndByAge(){
		List<Whisky> foundWhiskies = whiskyRepository.findWhiskyByDistilleryNameAndAge("Rosebank", 12);
	}

	@Test
	public void canFindWhiskyByDistilleryRegion(){
		List<Whisky> foundWhiskies = whiskyRepository.findWhiskyByDistilleryRegion("Highland");
	}

	@Test
	public void canFindDistilleryByRegion(){
		List<Distillery> foundDistilleries = distilleryRepository.findDistilleryByRegion("Highland");
	}

	@Test
	public void canFindDistilleryWhichHaveWhiskiesThatAre12YearsOld(){
		List<Distillery> foundDistilleries = distilleryRepository.findDistilleryByWhiskiesAgeEquals(12);
	}


}
