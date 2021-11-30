package lotto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBallTest {

	@Test
	@DisplayName("로또 공이 1~45 사이의 숫자가 나온 경우 정상적으로 만들어진다.")
	void 로또_공이_범위를_벗어나지_않음() {
		LottoBall lottoBall1 = new LottoBall(1);
		LottoBall lottoBall10 = new LottoBall(10);
		LottoBall lottoBall45 = new LottoBall(45);
		LottoBall lottoBall34 = new LottoBall(34);
		LottoBall lottoBall2 = new LottoBall(2);
	}

	@Test
	@DisplayName("1보다 작은 값이 공의 번호로 주어지면 IllegalArgumentException을 낸다.")
	void 로또_공이_1보다_작음() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new LottoBall(-1));
	}

	@Test
	@DisplayName("45보다 큰 값이 공의 번호로 주어지면 IllegalArgumentException을 낸다.")
	void 로또_공이_45보다_큼() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new LottoBall(46));
	}

}