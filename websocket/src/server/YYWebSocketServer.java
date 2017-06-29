package server;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import helper.YYLogger;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

public class YYWebSocketServer {
	public static final String TAG = "YYWebSocketServer";
	public static final YYWebSocketServer instance = new YYWebSocketServer();

	private YYWebSocketServer() {

	}

	public static YYWebSocketServer getInstance() {
		return instance;
	}

	private final MockWebServer mockWebServer = new MockWebServer();
	private final ExecutorService writeExecutor = Executors.newSingleThreadExecutor();

	public void startServer() {
		
		String hostName = mockWebServer.getHostName();
		int port = mockWebServer.getPort();

		System.out.println("hostName:" + hostName);
		System.out.println("port:" + port);

		mockWebServer.enqueue(new MockResponse().withWebSocketUpgrade(new WebSocketListener() {

			@Override
			public void onOpen(WebSocket webSocket, Response response) {
				super.onOpen(webSocket, response);

				YYLogger.debug(TAG, "onOpen ....");

			}

			@Override
			public void onMessage(WebSocket webSocket, String text) {
				super.onMessage(webSocket, text);

				YYLogger.debug(TAG, "onMessage ....");

			}

			@Override
			public void onFailure(WebSocket webSocket, Throwable t, Response response) {
				super.onFailure(webSocket, t, response);

				YYLogger.debug(TAG, "onFailure ....");

			}

			@Override
			public void onClosing(WebSocket webSocket, int code, String reason) {
				super.onClosing(webSocket, code, reason);
				YYLogger.debug(TAG, "onClosing ....");

			}

			@Override
			public void onClosed(WebSocket webSocket, int code, String reason) {
				super.onClosed(webSocket, code, reason);

				YYLogger.debug(TAG, "onClosed ....");

			}

		}));

	}

}
