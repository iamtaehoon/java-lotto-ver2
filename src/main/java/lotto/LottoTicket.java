package lotto;

import java.util.ArrayList;

public class LottoTicket {
	public static int BALL_CNT = 6;

	private ArrayList<LottoBall> lottoTicket = new ArrayList<>();

	public LottoTicket(String[] eachLottoNumbers) {
		for (String eachLottoNumberString : eachLottoNumbers) {
			int eachLottoNumber = Integer.parseInt(eachLottoNumberString);
			lottoTicket.add(new LottoBall(eachLottoNumber));
		}
		validateBallCntIsCorrect();
	}

	private void validateBallCntIsCorrect() {
		if (lottoTicket.size() != BALL_CNT) {
			throw new IllegalArgumentException("로또 티켓에는 6개의 번호가 적혀야 합니다.");
		}
	}
}
