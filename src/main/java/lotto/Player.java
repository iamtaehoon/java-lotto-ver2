package lotto;

import view.InputView;

public class Player {
	public static int LOTTO_PRICE = 1000; //TODO : 상수 클래스로 나중에 이동

	private int inputMoney;
	private int totalLottoCnt;
	private int manualLottoCnt;

	public void playLotto() {
		inputMoney = InputView.putMoney();
		totalLottoCnt = inputMoney / LOTTO_PRICE;
		enterManualLottoCnt();
		InputView.enterEachManualLottoTicket(manualLottoCnt);
	}

	private void enterManualLottoCnt() {
		manualLottoCnt = InputView.enterManualLottoCnt();
		validateTotalLottoCntIsBiggerThanManual();
	}

	private void validateTotalLottoCntIsBiggerThanManual() {
		if (manualLottoCnt > totalLottoCnt) {
			throw new IllegalArgumentException("수동으로 구입할 로또의 개수가 전체 로또보다 많을 수 없습니다.");
		}
	}
}
