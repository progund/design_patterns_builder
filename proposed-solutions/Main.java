import java.util.Date;
import java.text.SimpleDateFormat;
public class Main{
  public static void main(String[] args){
    Date day = new Date();
    try{
      day = new SimpleDateFormat("yyyy-MM-dd").parse("2020-02-28");
    }catch(Exception e){}
    Reservation res = new Reservation.Builder
      (day, Reservation.FIRST_CLASS, 2)
      .numMeals(2)
      .isNonSmoking(true)
      .isWindowSeat(true)
      .build();
    System.out.println(res);
    Reservation other = 
      new Reservation.Builder(day, Reservation.ECONOMY_CLASS, 1)
      .isWindowSeat(true)
      .numMeals(4)
      .isNonSmoking(true)
      .hasTable(true)
      .build();    
    System.out.println(other);

    ReservationXMLExporter xml = new ReservationXMLExporter();
    res.export(xml);
    System.out.println(xml);
    other.export(xml);
    System.out.println(xml);
  }
}
