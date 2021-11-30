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

	public static int enterManualLottoCnt() {
		System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
		int manualLottoCnt = Integer.parseInt(sc.nextLine());
		validateItIsPositive(manualLottoCnt);
		return manualLottoCnt;
	}

	public static void enterEachManualLottoTicketMessage() {
		System.out.println("수동으로 구매할 번호를 입력해 주세요.");
	}

	public static String[] splitTicketToEachNumber() {
		return sc.nextLine().split(", ");
	}

	public static String[] enterWinningNum() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		return sc.nextLine().split(", ");
	}

	public static int enterBonusBall() {
		System.out.println("보너스 볼을 입력해 주세요.");
		return Integer.parseInt(sc.nextLine());
	}
}
