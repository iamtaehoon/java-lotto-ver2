package view;

import lotto.LottoTicket;

public class OutPutView {
	public static void showThisTicket(LottoTicket lottoTicket) {
		System.out.println(lottoTicket.toString());
	}

	public static void showManualAndAutoCnt(int manualCnt, int autoCnt) {
		System.out.println(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.", manualCnt, autoCnt));
	}
}
