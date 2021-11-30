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

	// 공이 하나라도 중복되면 오류 발생시키기

}