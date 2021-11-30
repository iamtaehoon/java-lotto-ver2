package lotto;

import static lotto.LottoBall.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.TreeSet;

public class LottoTicket {
	public static int BALL_CNT = 6;

	private TreeSet<LottoBall> lottoTicket = new TreeSet<>();
	Random random = new Random();


	public LottoTicket(String[] eachLottoNumbers) {
		errorIfInputTooMany(eachLottoNumbers);
		for (String eachLottoNumberString : eachLottoNumbers) {
			int eachLottoNumber = Integer.parseInt(eachLottoNumberString);
			lottoTicket.add(new LottoBall(eachLottoNumber));
		}
		validateBallCntIsCorrect();
	}

	public LottoTicket() {
		makeLottoTicketAuto();
	}

	private void makeLottoTicketAuto() {
		int ballNum;
		while (lottoTicket.size() != BALL_CNT) {
			ballNum = random.nextInt(MAX_LOTTO_NUM) + MIN_LOTTO_NUM;
			lottoTicket.add(new LottoBall(ballNum));
		}
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
