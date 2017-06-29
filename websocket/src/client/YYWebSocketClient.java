package client;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import helper.YYLogger;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public class YYWebSocketClient {
	private static final YYWebSocketClient instance=new YYWebSocketClient();
	private static final String TAG = "YYWebSocketClient";
	private static final String HOSTNAME = "118.89.182.250";
	private static final int PORT = 8080;
	private static final String HEAD_REQ="tldservice/appwebsocket/";
	
	private WebSocket mWebSocketClient;
	
	
	private YYWebSocketClient(){};
	
	public static YYWebSocketClient getInstance(){
		return instance;
	}

	public void connect(String username,String password) {
		
		OkHttpClient client = new OkHttpClient.Builder().build();
		Request request = new Request.Builder().url("ws://" + HOSTNAME + ":" + PORT + "/"+HEAD_REQ+username+"/"+password).build();
		

		client.newWebSocket(request, new WebSocketListener() {

			@Override
			public void onOpen(WebSocket webSocket, Response response) {
				super.onOpen(webSocket, response);
				YYLogger.debug(TAG, "onOpen ....");

				mWebSocketClient=webSocket;
				
				

			}

			@Override
			public void onMessage(WebSocket webSocket, String text) {
				super.onMessage(webSocket, text);

				YYLogger.debug(TAG, "onMessage ...."+text);
				
				Gson gson=new Gson();
				
				Map dict= gson.fromJson(text,Map.class);
				
				System.out.println("CMD  "+dict.get("device").getClass());
				
				

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
		});

	}

}
