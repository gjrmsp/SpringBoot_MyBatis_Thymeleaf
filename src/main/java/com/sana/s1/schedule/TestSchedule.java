package com.sana.s1.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sana.s1.member.MemberMapper;

@Component
public class TestSchedule {

	@Autowired
	private MemberMapper memberMapper;

	@Scheduled(fixedRateString = "1000", initialDelayString = "2000")
	public void fixRateScheduleTest() throws Exception {
		System.out.println("fixRateSchedule");
	}

	@Scheduled(cron = "0 0 9-18/2 * * 1-5")
	public void cronTest() throws Exception {
		System.out.println("Cron ~~~~~~");
	}

}
