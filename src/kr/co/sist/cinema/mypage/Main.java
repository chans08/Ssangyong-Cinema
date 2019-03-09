package kr.co.sist.cinema.mypage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author 차민희
 * 모든 클래스에 
 * save*(), load*() 류와 함께 PATH_*류,
 *  ArrayList<Member> list, 
 *  Scanner scan 
 *  가져와야 해요.
 *
 */
public class Main {
	
	public static final String PATH_MEMBER = "D:\\java\\Cinema\\src\\data\\member.dat";
	
	//main
	public static void main(String[] args) {
		
		MyPage myPage = new MyPage("iszlgz319");
		MyMembership myMembership = new MyMembership("iszlgz319");

		myPage.loadMember();
		myPage.info();
		myPage.selectMenu();
		
	}//main
}
