package vending_machine;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int i = 0;
		List<merchandise> merchandiseList = List.of(
				  new merchandise(i++, "コーラ", 140)
				, new merchandise(i++, "緑茶", 130)
				, new merchandise(i++, "カルピス", 160)
				, new merchandise(i++, "リアルゴールド", 130)
				, new merchandise(i++, "ポカリスエット", 140));

		System.out.println("商品ID / 商品名 / 価格");
		merchandiseList.forEach(merchandise -> System.out.printf("%d %s %d円%n",
				merchandise.id(), merchandise.name(), merchandise.price()));
		
		System.out.printf("%n金額を投入してください： ");
		int input = validInput();
		System.out.printf("投入額：%d%n%n", input);
		
		System.out.printf("購入する商品番号を入力：");
		int merchandiseNo = scanner.nextInt();
		System.out.printf("%sを購入しました。お釣りは%d円です。",
				merchandiseList.get(merchandiseNo).name(),
				input - merchandiseList.get(merchandiseNo).price());
	}

	public static int validInput() {
		int input = 0;
		try {
			input = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("金額は小数点を含まない1以上の値を入力してください。");
			System.out.print("不正な値が入力されたため処理を終了します。");
			System.exit(0);
		}

		while(true) {
			if(input < 1) {
				System.out.println("金額は1以上の整数を入力してください");
				System.out.print("金額を入力してください：");
				input = scanner.nextInt();
			} else {
				break;
			}
		}
		return input;
	}
}

record merchandise(int id, String name, int price) {}