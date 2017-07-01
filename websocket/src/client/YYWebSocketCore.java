package client;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import client.bean.BaseInfo;
import helper.YYLogger;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public class YYWebSocketCore {
	private static final YYWebSocketCore instance=new YYWebSocketCore();
	private static final String TAG = "YYWebSocketClient";
	private static final String HOSTNAME = "118.89.182.250";
	private static final int PORT = 8080;
	private static final String HEAD_REQ="tldservice/appwebsocket/";
	
	private WebSocket mWebSocketClient;
	private WebSocketListener listenser;
	
	
	
	private YYWebSocketCore(){};
	
	public static YYWebSocketCore getInstance(){
		return instance;
	}

	public void connect(String username,String password,final WebSocket mWebSocket) {
		this.mWebSocketClient=mWebSocket;
		
		OkHttpClient client = new OkHttpClient.Builder().build();
		Request request = new Request.Builder().url("ws://" + HOSTNAME + ":" + PORT + "/"+HEAD_REQ+username+"/"+password).build();
		

		client.newWebSocket(request, listenser);

	}

}
