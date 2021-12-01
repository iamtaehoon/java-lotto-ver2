package lotto;

import java.util.ArrayList;

import view.InputView;
import view.OutPutView;

public class Player {
	public static int LOTTO_PRICE = 1000; //TODO : 상수 클래스로 나중에 이동

	private int inputMoney;
	private int earnedMoney;
	private double profitRatio;
	private int totalLottoCnt;
	private int manualLottoCnt;
	private ArrayList<LottoTicket> lottoTickets = new ArrayList<>();
	private LottoMachine lottoMachine = new LottoMachine(lottoTickets);


	public void playLotto() {
		inputMoney = InputView.putMoney();
		totalLottoCnt = inputMoney / LOTTO_PRICE;
		enterManualLottoCnt();
		makeManualLottoTickets();
		lottoMachine.makeAutoLottoTickets(totalLottoCnt - manualLottoCnt);
		lottoMachine.showAllTickets(manualLottoCnt, totalLottoCnt-manualLottoCnt);
		earnedMoney = lottoMachine.getResult();
		profitRatio = (double)earnedMoney / inputMoney;
		OutPutView.showProfitRatio(profitRatio);
	}

	private void makeManualLottoTickets() {
		InputView.enterEachManualLottoTicketMessage();
		for (int i = 0; i < manualLottoCnt; i++) {
			makeEachManualLottoTicket();
		}
	}

	private void makeEachManualLottoTicket() {
		String[] eachLottoNumbers = InputView.splitTicketToEachNumber();
		LottoTicket lottoTicket = new LottoTicket(eachLottoNumbers);
		lottoTickets.add(lottoTicket);
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
