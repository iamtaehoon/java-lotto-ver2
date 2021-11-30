package lotto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

	@Test
	@DisplayName("로또 공이 6개가 주어지면 정상적으로 로직을 실행한다.")
	void 로또_공의_개수는_6개_정상로직() {
		String[] parameter = {"1", "2", "3", "4", "5", "6"};
		LottoTicket lottoTicket = new LottoTicket(parameter);
	}

	@Test
	@DisplayName("로또 공이 6개보다 많으면 에러를 반환한다.")
	void 로또_공의_개수가_6개보다_많은경우() {
		Assertions.assertThrows(IllegalArgumentException.class,
			() -> new LottoTicket(new String[] {"1", "2", "3", "4", "5", "6", "7"}));
	}

	@Test
	@DisplayName("로또 공이 6개보다 적으면 에러를 반환한다.")
	void 로또_공의_개수가_6개보다_적은경우() {
		Assertions.assertThrows(IllegalArgumentException.class,
			() -> new LottoTicket(new String[] {"1", "2", "3", "4", "5"}));
	}

	@Test
	@DisplayName("공이 중복되면 에러를 반환한다.")
	void 로또_공이_중복된경우() {
		Assertions.assertThrows(IllegalArgumentException.class,
			() -> new LottoTicket(new String[] {"1", "2", "3", "4", "5", "5"}));
	}

	@Test
	@DisplayName("로또 공이 6개보다 많은데, 중복을 빼고 6개인 경우에도 오류를 반환한다.")
	void 로또_공_중복_제외_6개인경우() {
		Assertions.assertThrows(IllegalArgumentException.class,
			() -> new LottoTicket(new String[] {"1", "2", "3", "4", "5", "6", "6"}));
	}

}