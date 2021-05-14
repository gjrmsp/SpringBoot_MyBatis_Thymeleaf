package com.sana.s1.aop.transfer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Card {

	@Around("execution(* com.sana.s1.aop.transfer.Transfer.*())")
	public Object cardCheck(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("----- 탑승 전 카드 체크 ----- ");
		//joinPoint - 핵심메서드(버스, 지하철)를 객체화 
		 Object obj = joinPoint.proceed();
		System.out.println(obj);
		System.out.println("----- 하차 시 카드 체크 -----");
		return obj;
	}

	@AfterReturning("execution(* com.sana.s1.board.notice.NoticeService.get*(..))")
	public void selectCheck() {
		System.out.println("Select Query 정상 종료");
	}
}
