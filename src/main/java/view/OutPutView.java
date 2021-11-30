package view;

import java.util.HashMap;

import lotto.LottoTicket;
import lotto.Rank;

public class OutPutView {
	public static void showThisTicket(LottoTicket lottoTicket) {
		System.out.println(lottoTicket.toString());
	}

	public static void showManualAndAutoCnt(int manualCnt, int autoCnt) {
		System.out.println(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.", manualCnt, autoCnt));
	}

	public static void getResult(HashMap<Rank, Integer> rankOfResult) {
		System.out.println("당첨 통계\n"
			+ "---------");
		System.out.println(String.format("%d개 일치 (%d원)- %d개", Rank.FIFTH.getHit(), Rank.FIFTH.getReward(),
			rankOfResult.get(Rank.FIFTH)));
		System.out.println(String.format("%d개 일치 (%d원)- %d개", Rank.FOURTH.getHit(), Rank.FOURTH.getReward(),
			rankOfResult.get(Rank.FOURTH)));
		System.out.println(String.format("%d개 일치 (%d원)- %d개", Rank.THIRD.getHit(), Rank.THIRD.getReward(),
			rankOfResult.get(Rank.THIRD)));
		System.out.println(String.format("%d개 일치, 보너스 볼 일치(%d원)- %d개", Rank.SECOND.getHit(), Rank.SECOND.getReward(),
			rankOfResult.get(Rank.SECOND)));
		System.out.println(String.format("%d개 일치 (%d원)- %d개", Rank.FIRST.getHit(), Rank.FIRST.getReward(),
			rankOfResult.get(Rank.FIRST)));

	}
}
