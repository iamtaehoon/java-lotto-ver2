package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class LottoTicket {
	public static int BALL_CNT = 6;

	private TreeSet<LottoBall> lottoTicket = new TreeSet<>();

	public LottoTicket(String[] eachLottoNumbers) {
		errorIfInputTooMany(eachLottoNumbers);
		for (String eachLottoNumberString : eachLottoNumbers) {
			int eachLottoNumber = Integer.parseInt(eachLottoNumberString);
			lottoTicket.add(new LottoBall(eachLottoNumber));
		}
		validateBallCntIsCorrect();
	}

	private void errorIfInputTooMany(String[] eachLottoNumbers) {
		if (eachLottoNumbers.length > BALL_CNT) {
			throw new IllegalArgumentException("로또 티켓에는 6개의 번호가 적혀야 합니다.");
		}

	}
	private void validateBallCntIsCorrect() {
		if (lottoTicket.size() != BALL_CNT) {
			throw new IllegalArgumentException("로또 티켓에는 6개의 번호가 적혀야 합니다.");
		}
	}
}
