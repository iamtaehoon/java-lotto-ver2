package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import lotto.LottoTicket;
import lotto.Rank;
import lotto.Result;

public class OutPutView {

	public static void showThisTicket(LottoTicket lottoTicket) {
		System.out.println(lottoTicket.toString());
	}

	public static void showManualAndAutoCnt(int manualCnt, int autoCnt) {
		System.out.println(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.", manualCnt, autoCnt));
	}

	public static void getResult(ArrayList<Result> rankOfResult) {
		System.out.println("당첨 통계\n"
			+ "---------");
		// 스트림을 반대로 돌림. 근데 Lose는 포함하면 안됨. -> arrayList로 바꾸고 Collection.reverse 근데 그냥 Rank를 뒤집을래
		// 2등인 경우에만 양식을 다르게 하는 로직이 필요함.

		rankOfResult.stream()
			.filter(result -> !result.equals(new Result(Rank.LOSE)))
			.forEach(result -> System.out.println(showEachResult(result)));
	}

	public static String showEachResult(Result result) {
		Rank rank = result.getRank();
		int countThisRank = result.getCountThisRank();
		if (rank == Rank.SECOND) {
			return String.format("%d개 일치, 보너스 볼 일치(%d원)- %d개", rank.getHit(), rank.getReward(), countThisRank);
		}
		return String.format("%d개 일치 (%d원)- %d개", rank.getHit(), rank.getReward(), countThisRank);
	}
}
