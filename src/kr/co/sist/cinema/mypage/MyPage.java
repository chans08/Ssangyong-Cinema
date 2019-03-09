package kr.co.sist.cinema.mypage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MyPage {
	
	public static final String PATH_MEMBER = "D:\\java\\Cinema\\src\\data\\member.dat";
	private static ArrayList<Member> list;
	private static Scanner scan;
	
	static {
		list = new ArrayList<Member>();
		scan = new Scanner(System.in);
	}
	
	private String id;
	
	public MyPage(String id) {
		this.id = id;
	}

	/**
	 * 회원 정보를 출력하는 메소드
	 */
	public void info() {
		for (int i=0; i<list.size(); i++) {
			if (list.get(i).getId().equals(id)) {
				System.out.println("[회원 정보]");
				System.out.printf("%s님\t\t\t| %s\n", list.get(i).getName(), list.get(i).getGrade());
				System.out.printf("멤버십 포인트\t\t\t %,5dp\n", Integer.parseInt(list.get(i).getPoint()));
				System.out.printf("이번달 관람 회수\t\t %,5dp\n", Integer.parseInt(list.get(i).getThisMonthViewCount()));
				break;
			}
		}
	}
	
	/**
	 * mypage에서 선택가능한 메뉴를 보여주는 메소드
	 */
	public void menu() {
		System.out.println("[메뉴]");
		System.out.println("==============================");//30개
		System.out.println("1. 멤버십 정보");
		System.out.println("2. 예매 확인/취소");
		System.out.println("3. 스토어 구매내역");
		System.out.println("4. 개인정보수정");
		System.out.println("5. 나의문의내역");
		System.out.println("0. 로그 아웃");
		System.out.println("==============================");
		System.out.print("선택(번호) : ");
	}
	
	/**
	 * 선택한 메뉴를 불러오는 메소드
	 */
	public void selectMenu() {
		boolean loop = true;
		while (loop) {
			System.out.println();
			menu();
			switch(scan.nextLine()) {
			case "1":
				MyMembership myMembership = new MyMembership(id);
				myMembership.load();
				myMembership.info();
				break;
			case "2":
//				reservationConfimAndCancel();
				break;
			case "3":
//				myPurchaseHistory();
				break;
			case "4":
//				personalInfoModification();
				break;
			case "5":
//				myEnQuiryDetails();
				break;
			case "0":
				loop = false;
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				break;
			}
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
