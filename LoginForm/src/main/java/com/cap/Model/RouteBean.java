package com.cap.Model;

public class RouteBean {
	private Integer routeId;
	private String routePath;
	private String routeName;
	private int occupied;
	private int totalSeats;
	private String diverName;
	private String busNo;
	private int totalKm;
	public RouteBean() {
		super();
	}
	public RouteBean(Integer routeId, String routePath, String routeName, int occupied, int totalSeats,
			String diverName, String busNo, int totalKm) {
		super();
		this.routeId = routeId;
		this.routePath = routePath;
		this.routeName = routeName;
		this.occupied = occupied;
		this.totalSeats = totalSeats;
		this.diverName = diverName;
		this.busNo = busNo;
		this.totalKm = totalKm;
	}
	public Integer getRouteId() {
		return routeId;
	}
	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}
	public String getRoutePath() {
		return routePath;
	}
	public void setRoutePath(String routePath) {
		this.routePath = routePath;
	}
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	public int getOccupied() {
		return occupied;
	}
	public void setOccupied(int occupied) {
		this.occupied = occupied;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	public String getDiverName() {
		return diverName;
	}
	public void setDiverName(String diverName) {
		this.diverName = diverName;
	}
	public String getBusNo() {
		return busNo;
	}
	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}
	public int getTotalKm() {
		return totalKm;
	}
	public void setTotalKm(int totalKm) {
		this.totalKm = totalKm;
	}
	@Override
	public String toString() {
		return "RouteBean [routeId=" + routeId + ", routePath=" + routePath + ", routeName=" + routeName + ", occupied="
				+ occupied + ", totalSeats=" + totalSeats + ", diverName=" + diverName + ", busNo=" + busNo
				+ ", totalKm=" + totalKm + "]";
	}
	
	
}
