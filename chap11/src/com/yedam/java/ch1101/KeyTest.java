package com.yedam.java.ch1101;

import java.util.HashMap;
import java.util.Map;

public class KeyTest {

	public static void main(String[] args) {
		Map<Key, String> map = new HashMap<Key, String>(); 
		
		map.put(new Key(1), "홍길동");
		
		String value = map.get(new Key(1));
		System.out.println(value);

		// new HashMap과 new Key는 서로 다른 인스턴스임에도 같은 값, 같은 타입이면 같은 인스턴스로
		// 인식시키도록 오버라이딩했다.
	}

}
