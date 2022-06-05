package doubleInterface;

public class Button {
	// 인터페이스 타입의 필드를 원래는 다른 클래스에서 선언해서 거기에 구현클래스의 객체를 넣은 방식이었는데
	// 중첩인터페이스이므로 클래스 내부에 인터페이스 타입 필드를 선언한다.
	OnClickListener listener;
	// 인터페이스는 객체 생성할 수 없으므로 나중에 실행클래스에서 생성된 button객체의 setter메소드를 이용해 객체를 할당하려는 의도
	
	// setter
	public void setListener(OnClickListener listener) {
		this.listener = listener;
	}
	
	
	// 메소드
	public void touch() {
		listener.onClick();
	}
	
	
	static interface OnClickListener {
		// 중첩인터페이스는 인스턴스 멤버 인터페이스와 정적 멤버 인터페이스 모두 선언이 가능하다.
		// 정적멤버로 선언된 경우 외부 클래스의 객체 없이도 사용가능
		void onClick();
		// public abstract void onClick();
		// 인터페이스는 추상메소드만 가질 수 있으며, public으로 선언한다.
	}
}
