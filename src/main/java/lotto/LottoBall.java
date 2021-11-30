package lotto;

public class LottoBall implements Comparable<LottoBall> {

	public static int MAX_LOTTO_NUM = 45;
	public static int MIN_LOTTO_NUM = 1;

	private int lottoBallNumber;

	public LottoBall(int lottoBallNumber) {
		validateLottoBallIsInRange(lottoBallNumber);
		this.lottoBallNumber = lottoBallNumber;
	}

	private void validateLottoBallIsInRange(int lottoBallNumber) {
		if ((MAX_LOTTO_NUM < lottoBallNumber) || (lottoBallNumber < MIN_LOTTO_NUM)) {
			throw new IllegalArgumentException("로또 공이 나올 수 없는 번호입니다.");
		}
	}

	// TODO Comparable 공부하기.
	@Override
	public int compareTo(LottoBall lottoBall) {
		return this.lottoBallNumber - lottoBall.lottoBallNumber;
	}

	// @Override
	// public String toString() {
	// 	return Integer.toString(lottoBallNumber);
	// }

	public int seeBallNum() {
		return lottoBallNumber;
	}
}
