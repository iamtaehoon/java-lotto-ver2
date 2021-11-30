package lotto;

import java.util.Arrays;
import java.util.HashMap;

import view.OutPutView;

public class Result {
	HashMap<Rank, Integer> rankOfResult = new HashMap<>();
	public Result() {
		Arrays.stream(Rank.values()).forEach(rankLevel -> rankOfResult.put(rankLevel, 0));
	}

	public void addRank(Rank rank) {
		rankOfResult.put(rank, rankOfResult.get(rank) + 1);
	}

	public void getResult() {
		OutPutView.getResult(rankOfResult);
	}
}
