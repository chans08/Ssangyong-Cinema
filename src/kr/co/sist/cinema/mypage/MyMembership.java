package kr.co.sist.cinema.mypage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class MyMembership {
	
	public static final String PATH_MEMBER = "D:\\java\\Cinema\\src\\data\\member.dat";
	private static ArrayList<Member> list;
	private static Scanner scan;
	
	static {
		list = new ArrayList<Member>();
		scan = new Scanner(System.in);
	}
	
	private String id;
	
	public MyMembership(String id) {
		this.id = id;
	}
	
	/**
	 * 간략한 멤버십 정보를 출력하는 메소드
	 */
	public void info() {
		for (int i=0; i<list.size(); i++) {
			if (list.get(i).getId().equals(id)) {
				System.out.println();
				System.out.println("[멤버십 정보]");
				System.out.printf("%s님은 '%s %s' 회원입니다.\n", list.get(i).getName(), thisYear(), list.get(i).getGrade());
				
				break;
			}
		}
	}
	
	public String thisYear() {
		Calendar c = Calendar.getInstance();
		 String thisYear = c.get(Calendar.YEAR) + "";
		 return thisYear;
	}
	
	public void load() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(PATH_MEMBER));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("■");
				Member m = new Member(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], temp[9], temp[10], temp[11], temp[12], temp[13], temp[14], temp[15], temp[16]);
				list.add(m);
			}
			reader.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	/**
	 * ArrayList<Member> list에 회원정보 담기
	 */
	public void loadMember() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(PATH_MEMBER));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("■");
				Member m = new Member(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], temp[9], temp[10], temp[11], temp[12], temp[13], temp[14], temp[15], temp[16]);
				list.add(m);
			}
			reader.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}