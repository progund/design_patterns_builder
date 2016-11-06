import java.util.Date;
// A reservation on the Moon Shuttle
public class Reservation{
  public static final int FIRST_CLASS=0;
  public static final int SECOND_CLASS=1;
  public static final int ECONOMY_CLASS=2;
  // Mandatory fields
  private int seatClass;
  private int numSeats;
  private Date day;
  // Optional fields
  private int numMeals;
  private boolean isWindowSeat;
  private boolean isNonSmoking;
  private boolean hasTable;
  
  public interface Exporter{
    void addSeatClass(String seatClass);
    void addNumSeats(int numSeats);
    void addDay(Date day);
    void addNumMeals(int numMeals);
    void addIsWindowSeat(boolean isWindowSeat);
    void addIsNonSmoking(boolean isNonSmoking);
    void addHasTable(boolean hasTable);
  }
  
  public void export(Exporter builder){
    builder.addSeatClass(seatClassAsString());
    builder.addNumSeats(numSeats);
    builder.addNumMeals(numMeals);
    builder.addDay(day);
    builder.addIsWindowSeat(isWindowSeat);
    builder.addIsNonSmoking(isNonSmoking);
    builder.addHasTable(hasTable);
  }
  
  public static class Builder{
    //Mandatory
    private int seatClass;
    private int numSeats;
    private Date day;
    // Optional fields
    private int numMeals;
    private boolean isWindowSeat;
    private boolean isNonSmoking;
    private boolean hasTable;
    public Builder(Date day, int seatClass, int numSeats){
      this.day = day;
      this.seatClass = seatClass;
      this.numSeats = numSeats;
    }
    public Builder numMeals(int numMeals){
      this.numMeals = numMeals; return this;
    }
    public Builder isWindowSeat(boolean isWindowSeat){
      this.isWindowSeat = isWindowSeat; return this;
    }
    public Builder isNonSmoking(boolean isNonSmoking){
      this.isNonSmoking = isNonSmoking; return this;
    }
    public Builder hasTable(boolean hasTable){
      this.hasTable = hasTable; return this;
    }
    public Reservation build(){
      return new Reservation(this);
    }
  }

  private Reservation(Builder b){
    this.day = b.day;
    this.seatClass = b.seatClass;
    this.numSeats = b.numSeats;
    this.numMeals = b.numMeals;
    this.isWindowSeat = b.isWindowSeat;
    this.isNonSmoking = b.isNonSmoking;
    this.hasTable = b.hasTable;
  }
  
  /*
  // Mandatory fields
  private int seatClass;
  private int numSeats;
  private Date day;
  // Optional fields
  private int numMeals;
  private boolean isWindowSeat;
  private boolean isNonSmoking;
  private boolean hasTable;
   */  
  private String seatClassAsString() {
    String sClass="";
    switch(seatClass){
    case FIRST_CLASS:
      sClass="First class";
      break;
    case SECOND_CLASS:
      sClass="Second class";
      break;
    default:
      sClass="Economy class";
    }
    return sClass; 
  }
  public String seatClass() { return seatClassAsString(); }
  public int numSeats() { return numSeats; }
  public Date day() { return day; }
  public int numMeals() { return numMeals; }
  public boolean isWindowSeat() { return isWindowSeat; }
  public boolean isNonSmoking() { return isNonSmoking; }
  public boolean hasTable() { return hasTable; }
  
  @Override
  public String toString(){
    String sClass=seatClassAsString();
    return String
      .format("Trip on %s in %s for %d people %s %s %s %s",
              day.toString(),sClass,numSeats,
              (numMeals!=0?("with " + numMeals + " meals"):""),
              (isWindowSeat?"window seat":""),
              (isNonSmoking?"Non-smoking":"Smoking"),
              (hasTable?"with a table":"")).trim();
  }
}
