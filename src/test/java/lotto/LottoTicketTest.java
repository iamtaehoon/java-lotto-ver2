package lotto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

	@Test
	@DisplayName("로또 공이 6개가 주어지면 정상적으로 로직을 실행한다.")
	void 로또_공의_개수는_6개_정상로직() {
		LottoTicket lottoTicket = new LottoTicket(new String[] {"1", "2", "3", "4", "5", "6"});
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
	// TODO 자동으로 로또 번호를 찍을 때, 겹치지 않는가는 눈으로 확인함. 어떻게 이걸 확인해야 하지?

	@Test
	@DisplayName("로또 티켓이 양식에 맞게 만들어지는가를 검증한다.")
	void 로또_티켓_String_으로_만들기() {
		LottoTicket lottoTicket = new LottoTicket(new String[] {"1", "2", "3", "4", "5", "6"});
		Assertions.assertEquals("[1, 2, 3, 4, 5, 6]",lottoTicket.toString()); //기대하는 값, 내가 만든 답
	}

	@Test
	@DisplayName("로또 티켓이 양식에 맞게 만들어지는가 틀린 결과값을 사용해 오류를 낸다.")
	void 로또_티켓_String_으로_만들기_정답_다르게() {
		LottoTicket lottoTicket = new LottoTicket(new String[] {"1", "2", "3", "4", "5", "6"});
		Assertions.assertNotEquals("[1, 2, 3, 4, 7, 6]",lottoTicket.toString());
	}
}