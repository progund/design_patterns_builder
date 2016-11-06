import java.util.Date;
public final class ReservationXMLExporter implements Reservation.Exporter{
  // Mandatory fields
  private String seatClass; // Using String!!!
  private int numSeats;
  private Date day;
  // Optional fields
  private int numMeals;
  private boolean isWindowSeat;
  private boolean isNonSmoking;
  private boolean hasTable;
  public void addSeatClass(String seatClass){ this.seatClass = seatClass; }
  public void addNumSeats(int numSeats){ this.numSeats = numSeats; }
  public void addDay(Date day){ this.day = day; }
  public void addNumMeals(int numMeals){ this.numMeals = numMeals; }
  public void addIsWindowSeat(boolean isWindowSeat){ this.isWindowSeat = isWindowSeat; }
  public void addIsNonSmoking(boolean isNonSmoking){ this.isNonSmoking = isNonSmoking; }
  public void addHasTable(boolean hasTable){ this.hasTable = hasTable; }

  @Override
  public String toString(){
    return new StringBuilder("<reservation day=\"")
      .append(day).append("\">\n")
      .append("  <seats>").append(numSeats).append("</seats>\n")
      .append("  <meals>").append(numMeals).append("</meals>\n")
      .append("  <class>").append(seatClass).append("</class>\n")
      .append("  <placement table=\"")
      .append(hasTable).append("\" nonsmoking=\"")
      .append(isNonSmoking).append("\" window=\"")
      .append(isWindowSeat).append("\" />\n")
      .append("</reservation>").toString();
  }
  public String toXML(){ return this.toString(); }
  
}
