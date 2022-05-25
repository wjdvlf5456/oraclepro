package com.javaex.phone;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		PhoneDao phoneDao = new PhoneDao();

		// 프로그램 시작
		System.out.println("*******************************************");
		System.out.println("*         전화번호 관리 프로그램          *");
		System.out.println("*******************************************");

		while (true) {

			int i = 1;
			System.out.println("");
			System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
			System.out.println("-------------------------------------------");
			System.out.print("<메뉴번호: ");
			int contents = sc.nextInt();
			int active = contents;

			// ---------5.종료------------
			if (active == 5) {
				System.out.println("*******************************************");
				System.out.println("*                감사합니다               *");
				System.out.println("*******************************************");
				break;

				// ------------ 1.리스트 ------------
			} else if (active == 1) {
				System.out.println("<1.리스트>");
				phoneDao.personSelect();
				break;
				// ------------ 2.등록 ------------
			} else if (active == 2) {
				System.out.println("<2.등록>");
				System.out.print(">이름: ");
				String name = sc.nextLine();

				String hp = sc.nextLine();
				System.out.print(">휴대전화: ");

				System.out.print(">회사전화: ");
				String company = sc.nextLine();
				System.out.println("[등록되었습니다.]");

				PersonVo person = new PersonVo(name, hp, company);

				// ------------ 3.삭제 ------------
			} else if (active == 3) {
				System.out.println("<3.삭제>");
				System.out.print(">번호: ");
				int delete = sc.nextInt();
				int deleteNumber = delete - 1;

				// ------------ 4.검색 ------------
			} else if (active == 4) {
				System.out.println("<4.검색>");
				System.out.print(">이름: ");
				String search = sc.nextLine();
				char cSearch = search.charAt(0);

				for (PersonVo person : search) {
					String pName = person.getName();
					char cn1 = pName.charAt(0);		// 이
					char cn2 = pName.charAt(1);
					char cn3 = pName.charAt(2);
					if (cSearch == cn1 || cSearch == cn2 || cSearch == cn3) {
						System.out.print(i);
						// person.showList();
					}
					i++;
				}

				// ------------ 재입력 ------------
			} else {
				System.out.println("[다시 입력해 주세요]");
				change(fList);
			}
		}
		for (

		PersonVo person : fList) {
			String savestr = person.getName() + "," + person.getHp() + "," + person.getCompany();

		}
		sc.close();

	}

	// 실시간으로 반영하기 위한 전역변수
	public static void change(List<PersonVo> fList) throws IOException {
		OutputStream os = new FileOutputStream("./PhoneDB.txt");
		OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);

		for (PersonVo person : fList) {
			String savestr = person.getName() + "," + person.getHp() + "," + person.getCompany();

			bw.write(savestr);
			bw.newLine();

		}

		bw.flush();
		bw.close();

	}

}
