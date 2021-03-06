package client;

public interface IWebSocketReq {
	/**
	 * 登录
	 */
	
	public void login(String username,String password);
	
	/**
	 * 发送心跳
	 * command 0
	 * {"command":0}
	 */
	public void sendHeart();
	
	
	
	/**
	 * 控制设备开关
	 * command 101
	 * {"mac": ,"gprsmac": ,"command":101,"switch":{"no": ,"val": }}
	 */
	public void controlDevice(String mac,String gprsmac,String no,String val);
	
	/**
	 * 获取实时数据
	 * command 102
	 * {"mac": , "command": }
	 */
	public void fetchRealTimeData(String mac);
	
	/**
	 * 断开实时数据推送
	 * command 103
	 * {"mac": , "command": }
	 */
	public void stopRealTimeData(String mac);
	
	
	/**
	 * 获取历史数据
	 * command 104
	 * {"mac" , "gprsmac": ,"command": ,"day": }
	 * day 0:今天   1:昨天   2:前天
	 */
	public void fetchHistoryData(String mac,String gprsmac,int day);
	
	
	/**
	 * 获取设备的开关状态
	 * command 105
	 * {"mac" , "gprsmac": ,"command":  }
	 *
	 */
	public void fetchDeviceStatus(String mac,String gprsmac);
	
	/**
	 * 获取风险指数测量与亚硝酸盐测量状态
	 * command 106
	 */
	
	public void fetchRiskIndexAndNitriteStatus(String mac,String gprsmac);
	
	/**
	 * 风险指数测量 或者 亚硝酸盐测量
	 * command 107
	 * which 1 ：风险指数      2： 测量亚硝酸盐含量
	 */
	
	public void mesureRiskOrNitrite(String mac,String gprsmac,int which);
	
	
	

	/**
	 * 断开所有实时数据推送
	 * command 108
	 * {"command": }
	 */
	public void stopAllRealTimeData();
	
	public void reqWebSocketData(String json);
	
	
	

}
