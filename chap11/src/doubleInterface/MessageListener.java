package doubleInterface;

public class MessageListener implements Button.OnClickListener {

	@Override
	public void onClick() {
		System.out.println("Call MessageListener.onClick()");
		
	}

}
