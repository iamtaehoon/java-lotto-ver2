package lotto;

import static lotto.LottoBall.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
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

	public int compareWinningNum(ArrayList<Integer> winningNum) {
		int result = 0;
		for (LottoBall lottoBall : lottoTicket) { //내가 산 티켓의 자릿수 한개
			Optional<Integer> existNum = winningNum.stream()
				.filter(eachDigitWinningNum -> Integer.toString(eachDigitWinningNum).equals(lottoBall.toString()))
				.findAny();
			if (existNum.isPresent()) {
				result += 1;
			}
		}
		return result;
	}

	public boolean hasBonusBall(int bonusBall) {
		return lottoTicket.stream()
			.filter(eachDigitLotto -> eachDigitLotto.toString().equals(Integer.toString(bonusBall)))
			.findAny()
			.isPresent();
	}

	@Override
	public String toString() {
		String lottoTicketsToString = "[";
		for (LottoBall lottoBall : lottoTicket) {
			lottoTicketsToString += lottoBall.toString();
			if (!(lottoBall.equals(lottoTicket.last()))) {
				lottoTicketsToString += ", ";
			}
		}
		lottoTicketsToString += "]";
		return lottoTicketsToString;
	}
}
