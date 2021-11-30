package lotto;

import java.util.HashMap;

import view.OutPutView;

public class Result {
	HashMap<Rank, Integer> rankOfResult;
	public Result() {
		rankOfResult = new HashMap<>();
		rankOfResult.put(Rank.FIRST, 0);
		rankOfResult.put(Rank.SECOND, 0);
		rankOfResult.put(Rank.THIRD, 0);
		rankOfResult.put(Rank.FOURTH, 0);
		rankOfResult.put(Rank.FIFTH, 0);
		rankOfResult.put(Rank.LOSE, 0);

	}


	public void addRank(Rank rank) {
		rankOfResult.put(rank, rankOfResult.get(rank) + 1);
	}

	//addRank가 끝나면 <FIRST,1>,<SECOND,2>, 이런 식으로 저장되어있음.
	public void getResult() {
		OutPutView.getResult(rankOfResult);
	}
}