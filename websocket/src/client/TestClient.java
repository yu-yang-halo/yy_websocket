package client;

public class TestClient {
	public static void main(String[] args) {
		WebSocketReqImpl.getInstance().login("guest", "123456");
		
		
		try {
			new Thread().sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		WebSocketReqImpl.getInstance().fetchRealTimeData("00000601");
	}
}
