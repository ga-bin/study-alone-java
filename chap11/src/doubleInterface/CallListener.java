package doubleInterface;

public class CallListener implements Button.OnClickListener {

	@Override
	public void onClick() {
		System.out.println("call calllistenner.onclick()");
	}
	
}
