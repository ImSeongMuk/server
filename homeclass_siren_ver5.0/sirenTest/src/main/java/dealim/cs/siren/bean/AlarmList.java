package dealim.cs.siren.bean;

public class AlarmList {
	private int userNum;
	private String alarmCode;
	private String time;
	private String receiverList;
	
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public String getAlarmCode() {
		return alarmCode;
	}
	public void setAlarmCode(String alarmCode) {
		this.alarmCode = alarmCode;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getReceiverList() {
		return receiverList;
	}
	public void setReceiverList(String receiverList) {
		this.receiverList = receiverList;
	}
	
	
}
