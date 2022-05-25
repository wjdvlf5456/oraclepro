package com.javaex.phone;

import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		PhoneDao phoneDao = new PhoneDao();

		// 프로그램 시작
		System.out.println("***********************************************");
		System.out.println("*           전화번호 관리 프로그램            *");
		System.out.println("***********************************************");

		while (true) {

			System.out.println("");
			System.out.println("1.리스트  2.등록  3.수정  4.삭제  5.검색  6.종료");
			System.out.println("------------------------------------------------");
			System.out.print("<메뉴번호: ");
			int active = sc.nextInt();

			// ---------6.종료------------
			if (active == 6) {
				System.out.println("***********************************************");
				System.out.println("*                 감사합니다                  *");
				System.out.println("***********************************************");
				break;

				// ------------ 1.리스트 ------------
			} else if (active == 1) {
				System.out.println("<1.리스트>");
				phoneDao.personSelect();
				// ------------ 2.등록 ------------
			} else if (active == 2) {
				System.out.println("<2.등록>");
				System.out.print(">이름: ");
				String name = sc.next();

				System.out.print(">휴대전화: ");
				String hp = sc.next();

				System.out.print(">회사전화: ");
				String company = sc.next();
				System.out.println("[등록되었습니다.]");

				PersonVo vo = new PersonVo(name, hp, company);
				phoneDao.personinsert(vo);

				// ------------ 3.수정 ------------
			} else if (active == 3) {
				System.out.println("<3.수정>");
				System.out.print(">번호: ");
				int upId = sc.nextInt();

				System.out.print(">이름: ");
				String upName = sc.next();

				System.out.print(">휴대전화: ");
				String upHp = sc.next();

				System.out.print(">회사전화: ");
				String upCompany = sc.next();
				System.out.println("[수정되었습니다.]");

				PersonVo upVo = new PersonVo(upId, upName, upHp, upCompany);
				phoneDao.personUpdate(upVo);

				// ------------ 4.삭제 ------------
			} else if (active == 4) {
				System.out.println("<4.삭제>");
				System.out.print(">번호: ");
				int delete = sc.nextInt();
				phoneDao.persondelete(delete);

				// ------------ 5.검색 ------------
			} else if (active == 5) {
				System.out.println("<5.검색>");
				System.out.print(">검색어: ");
				String search = sc.next();
				phoneDao.personSearch(search);

				// ------------ 재입력 ------------
			} else {
				System.out.println("[다시 입력해 주세요]");
			}
		}
		sc.close();

	}

}
