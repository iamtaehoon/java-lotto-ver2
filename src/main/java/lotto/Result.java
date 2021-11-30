package lotto;

import java.util.Arrays;
import java.util.HashMap;

import view.OutPutView;

public class Result {
	HashMap<Rank, Integer> rankOfResult = new HashMap<>();
	public Result() { //TODO 뭔가 코드를 단순하게 만들 수 있지 않을까?
		Arrays.stream(Rank.values()).forEach(rankLevel -> rankOfResult.put(rankLevel, 0));
	}

	public void addRank(Rank rank) {
		rankOfResult.put(rank, rankOfResult.get(rank) + 1);
	}

	//addRank가 끝나면 <FIRST,1>,<SECOND,2>, 이런 식으로 저장되어있음.
	public void getResult() {
		OutPutView.getResult(rankOfResult);
	}
}
