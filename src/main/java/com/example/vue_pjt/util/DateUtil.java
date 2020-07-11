package com.example.vue_pjt.util;

import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {

	/**
	 * 현재 시간을 구한다
	 * @return now
	 */
	public static Date now() {
		return new Date(System.currentTimeMillis());
	}

	private static final SimpleDateFormat dateFormat_yyyyMM = new SimpleDateFormat("yyyyMM");
	/**
	 * 현재 시간을 yyyyMM 포맷으로 리턴한다
	 * @return yyyyMM
	 */
	public static String now_yyyymm() {
		return dateFormat_yyyyMM.format(now());
	}
	
	private static final SimpleDateFormat dateFormat_yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	/**
	 * 현재 시간을 yyyyMMdd 포맷으로 리턴한다
	 * @return yyyyMMdd
	 */
	public static String now_yyyymmdd() {
		return dateFormat_yyyyMMdd.format(now());
	}

	public static String to_yyyymmdd(Calendar calendar) {
		return dateFormat_yyyyMMdd.format(calendar.getTime());
	}

	private static final SimpleDateFormat dateFormat_hhmmss = new SimpleDateFormat("HHmmss");
	/**
	 * 현재 시간을 HHmmSS 포맷으로 리턴한다
	 * @return HHmmSS
	 */
	public static String now_hhmmss() {
		return dateFormat_hhmmss.format(now());
	}
	
	public static String to_hhmmss(Calendar calendar) {
		return dateFormat_hhmmss.format(calendar.getTime());
	}
	
	/**
	 *  문자열을 날짜로 변환한다
	 * @param strYMD yyyyMMdd 포맷의 문자열
	 * @param setEndOfDay true:24시로 세팅, false:0시로 세팅
	 * @return date
	 */
	public static Date toDate_yyyymmdd(String strYMD, boolean setEndOfDay) {
		int yyyymmdd = 0;
		try {
			yyyymmdd = Integer.parseInt(strYMD);
		} catch (Exception e) {
			return null;
		}

		return getCalendar(yyyymmdd, setEndOfDay).getTime();
	}

	/**
	 * 두 날짜사이의 날짜들을 구한다
	 * @param fromYMD yyyyMMdd 포맷의 시작일
	 * @param toYMD yyyyMMdd 포맷의 종료일
	 * @return list 날짜(yyyyMMdd) 리스트
	 */
	public static List<String> getDateStrListBetween(String fromYMD, String toYMD) {
		int from_yyyymmdd = 0;
		try {
			from_yyyymmdd = Integer.parseInt(fromYMD);
			int to_yyyymmdd = Integer.parseInt(toYMD);
			if (from_yyyymmdd > to_yyyymmdd) {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
		
		List<String> resultList = new ArrayList<>();
		Calendar curDate = getCalendar(from_yyyymmdd, false);
		String curYMD = fromYMD;

		for (int i = 0; i < 10; i++) {	//최대 10일까지만 생성
			//현재날짜 추가
			resultList.add(curYMD);

			//마지막 날짜까지 처리 완료
			if (curYMD.equals(toYMD)) {
				break;
			}

			//다음날로 이동
			curDate.add(Calendar.DAY_OF_MONTH, 1);
			curYMD = dateFormat_yyyyMMdd.format(curDate.getTime());
		}
		return resultList;
	}
	
	public static Calendar getCalendar(int yyyymmdd, boolean setEndOfDay) {
		Calendar calendar = new GregorianCalendar();
		if (setEndOfDay) {
			calendar.set((yyyymmdd / 10000), ((yyyymmdd / 100) % 100 - 1), yyyymmdd % 100, 23, 59, 59); //last time
		}
		else {
			calendar.set((yyyymmdd / 10000), ((yyyymmdd / 100) % 100 -1), yyyymmdd % 100, 0, 0 ,0); //start time
		}
		return calendar;
	}
	
	public static Calendar getCalendar(int yyyymmdd, int hhmmss) {
		Calendar calendar = new GregorianCalendar();
		calendar.set((yyyymmdd / 10000), ((yyyymmdd / 100) % 100 - 1), yyyymmdd % 100, hhmmss/10000, (hhmmss / 100) % 100, hhmmss % 100);
		return calendar;
	}
}
