package project;

public class ReserveDTO {

	private String reserveNum;
	private String usertel;
	private String departure;
	private String destination;
	private String date;
	private String depT;
	private String arrT;
	private String people;
	private String seat;
	private String price;

	public String getReserveNum() {
		return reserveNum;
	}

	public void setReserveNum(String reserveNum) {
		this.reserveNum = reserveNum;
	}

	public String getUsertel() {
		return usertel;
	}

	public void setUsertel(String usertel) {
		this.usertel = usertel;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDepT() {
		return depT;
	}

	public void setDepT(String depT) {
		this.depT = depT;
	}

	public String getArrT() {
		return arrT;
	}

	public void setArrT(String arrT) {
		this.arrT = arrT;
	}

	public String getPeople() {
		return people;
	}

	public void setPeople(String people) {
		this.people = people;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public static void main(String[] args) {
		ReserveDTO dto = new ReserveDTO();

	}
}
