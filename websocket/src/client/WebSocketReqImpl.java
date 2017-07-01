package client;

import com.google.gson.Gson;

import client.bean.BaseInfo;
import helper.YYLogger;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public class WebSocketReqImpl extends AbstractWebSocketReqImpl{
	private static final WebSocketReqImpl instance=new WebSocketReqImpl();
	private static final String TAG="WebSocketReqImpl";
	private YYWebSocketCore yySocketCore=YYWebSocketCore.getInstance();
	private WebSocket  mWebSocket;
	
	public static WebSocketReqImpl getInstance(){
		return instance;
	}

	@Override
	public void reqWebSocketData(String json) {
		YYLogger.debug(TAG, "req ::: "+json);

		mWebSocket.send(json);
		
		
	}


	@Override
	public void login(String username, String password) {
		
		yySocketCore.connect(username, password,mWebSocket);
		
	}
	
	@Override
	public void onOpen(WebSocket webSocket, Response response) {
		super.onOpen(webSocket, response);
		YYLogger.debug(TAG, "onOpen ....");
		mWebSocket=webSocket;
		

	}

	@Override
	public void onMessage(WebSocket webSocket, String text) {
		super.onMessage(webSocket, text);

		YYLogger.debug(TAG, "onMessage ...."+text);
		
		Gson gson=new Gson();
		
		BaseInfo baseInfo= gson.fromJson(text,BaseInfo.class);
		
		System.out.println("CMD  "+baseInfo);
		
		

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
	
	
	

}
