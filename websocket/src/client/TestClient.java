package client;

public class TestClient {
	public static void main(String[] args) {
		YYWebSocketClient.getInstance().connect("guest","123456");
	}
}
