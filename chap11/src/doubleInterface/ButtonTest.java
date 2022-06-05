package doubleInterface;

public class ButtonTest {

	public static void main(String[] args) {
		Button btn = new Button();
		
		btn.setListener(new MessageListener());
		
		btn.touch();
	}

}
