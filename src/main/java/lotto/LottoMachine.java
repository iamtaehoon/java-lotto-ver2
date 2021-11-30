package lotto;

import java.util.ArrayList;

import view.InputView;
import view.OutPutView;

public class LottoMachine {
	ArrayList<LottoTicket> lottoTickets;
	ArrayList<Integer> winningNum = new ArrayList<>();
	Result result = new Result();

	public LottoMachine(ArrayList<LottoTicket> lottoTickets) {
		this.lottoTickets = lottoTickets;
	}

	public void makeAutoLottoTickets(int autoLottoCnt) {
		for (int i = 0; i < autoLottoCnt; i++) {
			lottoTickets.add(new LottoTicket());
		}
	}

	public void showAllTickets(int manualCnt, int autoCnt) {
		OutPutView.showManualAndAutoCnt(manualCnt, autoCnt);
		lottoTickets.stream().forEach(lottoTicket -> OutPutView.showThisTicket(lottoTicket));
	}

	public void getResult() {
		String[] inputWinningNum = InputView.enterWinningNum();
		int bonusBall = InputView.enterBonusBall();
		validateWinningNumAndBonusBall(inputWinningNum, bonusBall);
		makeWinningNum(inputWinningNum);
		for (LottoTicket lottoTicket : lottoTickets) {
			int matchingCnt = lottoTicket.compareWinningNum(winningNum);
			boolean matchBonusBall = lottoTicket.hasBonusBall(bonusBall);
			Rank rank = Rank.valueOf(matchingCnt, matchBonusBall);
			result.addRank(rank);
		}
		result.getResult();

	}

	private void validateWinningNumAndBonusBall(String[] inputWinningNum, int bonusBall) {
		new LottoTicket(inputWinningNum); // 범위 제대로 들어가고 겹치지도 않았고
		new LottoBall(bonusBall);
	}

	private void makeWinningNum(String[] inputWinningNum) {
		for (String s : inputWinningNum) {
			int eachDigitWinningNum = Integer.parseInt(s);
			winningNum.add(eachDigitWinningNum);
		}
	}
}
