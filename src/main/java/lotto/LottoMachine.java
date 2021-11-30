package lotto;

import static lotto.LottoBall.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class LottoMachine {
	ArrayList<LottoTicket> lottoTickets;

	public LottoMachine(ArrayList<LottoTicket> lottoTickets) {
		this.lottoTickets = lottoTickets;
	}

	public void makeAutoLottoTickets(int autoLottoCnt) {
		for (int i = 0; i < autoLottoCnt; i++) {
			lottoTickets.add(new LottoTicket());
		}
	}
}
