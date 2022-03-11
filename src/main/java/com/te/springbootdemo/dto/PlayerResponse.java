package com.te.springbootdemo.dto;

public class PlayerResponse {

	private int statusCode;
	private String msg;
	private String desc;
	
	private Player player;
	
	
	public  int getStatusCode() {
		return statusCode;
	}
	public  void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public  String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public  String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public  Player getPlayer() {
		return player;
	}
	public  void setPlayer(Player player) {
		this.player = player;
	}
	public PlayerResponse(int statusCode, String msg, String desc, Player player) {
		super();
		this.statusCode = statusCode;
		this.msg = msg;
		this.desc = desc;
		this.player = player;
	}
	public PlayerResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PlayerResponse [statusCode=" + statusCode + ", msg=" + msg + ", desc=" + desc + ", player=" + player
				+ "]";
	}
	
	
	
}