package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

import view.OutPutView;

public class Result {
	Rank rank;
	int countThisRank;

	public Result(Rank rank) {
		this.rank = rank;
		this.countThisRank = 0;
	}

	public void addCountThisRank() {
		this.countThisRank += 1;
	}

	@Override
	public String toString() {
		return "Result{" +
			"rank=" + rank +
			", countThisRank=" + countThisRank +
			'}';
	}


	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Result result = (Result)o;
		return rank == result.rank;
	}

	@Override
	public int hashCode() {
		return Objects.hash(rank);
	}
}
