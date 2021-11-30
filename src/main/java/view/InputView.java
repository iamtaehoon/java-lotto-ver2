package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import lotto.LottoTicket;

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

	public static ArrayList<LottoTicket> enterEachManualLottoTicket(int manualLottoCnt) {
		ArrayList<LottoTicket> tickets = new ArrayList<>();
		System.out.println("수동으로 구매할 번호를 입력해 주세요.");
		for (int i = 0; i < manualLottoCnt; i++) {
			String[] eachLottoNumbers = sc.nextLine().split(", ");
			LottoTicket lottoTicket = new LottoTicket(eachLottoNumbers);
			tickets.add(lottoTicket);
		}
		return tickets;
	}
}
