package view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {
	@Test // 만들지 못함. 아무리 찾아봐도 콘솔 입력 자체를 주는 방법이 없음. inputView 테스트 하려면 구조가 바뀌어야 할 거 같음.
	@ValueSource(strings = {"10000\n","200000\n","0\n"})
	@DisplayName("일반적인 금액을 입력했을 때 정상적인 로직이 작동하나 확인한다.")
	void 입력_금액_테스트(String input) {
		InputStream in = generateUserInput(input);
		Scanner scanner = new Scanner(in);
		int i = InputView.putMoney();
	}

	public static InputStream generateUserInput(String input) {
		return new ByteArrayInputStream(input.getBytes());
	}

}