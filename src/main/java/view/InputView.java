package view;

import java.util.Scanner;

public class InputView {
	private static Scanner sc = new Scanner(System.in);

	private InputView() {
	}

	public static int putMoney() {
		int inputAmount;
		System.out.println("구입금액을 입력해 주세요.");
		inputAmount = Integer.parseInt(sc.nextLine());
		validateItIsPositive(inputAmount);
		return inputAmount;
	}

	private static void validateItIsPositive(int inputAmount) {
		if (inputAmount < 0) {
			throw new IllegalArgumentException("입력 금액은 음수가 될 수 없습니다.");
		}
	}
}
