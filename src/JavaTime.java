import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by 1 on 15.12.2014.
 */
public class JavaTime {
    public JavaTime() {
        Ex_1();
        Ex_2();
        Ex_3();
        Ex_4();
    }

    private void Ex_1() {
        LocalDate localDate = LocalDate.of(1996, Month.JANUARY, 23);
        LocalTime localTime = LocalTime.of(19,00,00);

        ZonedDateTime zonedDateTime = ZonedDateTime.of(2014, 11, 3, 19, 15, 36, 55, ZoneId.of("Etc/GMT+3"));
        ZonedDateTime zonedDateTime1 = ZonedDateTime.now(ZoneId.of("Europe/London"));

        int diff = zonedDateTime.getHour()-zonedDateTime1.getHour();

        //New Classes
//        Instant; - момент времени Like util.Date point in Time
//        Duration; - мера времени в (мили)сек, machine time
//        Period; - человеческое время, fields
//        Date has method .toInstant() for new API
    }

    public void Ex_2(){
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);
        boolean isTodayBeforeTomorrow = tomorrow.isAfter(today);

        LocalDate logestDay = today.withMonth(6).withDayOfMonth(23);
        Period.between(logestDay, today); // P-2M-20D
    }

    public void Ex_3(){
        List<DayOfWeek> days = new ArrayList<DayOfWeek>();
        for(Month month:Month.values()) {
            DayOfWeek dayOfWeek = LocalDate.now()
                    .withYear(2014)
                    .withMonth(month.getValue())
                    .with(TemporalAdjusters.lastDayOfMonth())
                    .getDayOfWeek();

            days.add(dayOfWeek);
        }

        //StreamStyle
        days = Stream.of(Month.values()).map(month -> LocalDate.now()
                .withYear(2014)
                .withMonth(month.getValue())
                .with(TemporalAdjusters.lastDayOfMonth())
                .getDayOfWeek())
                .collect(Collectors.toList());// collet - terminal operation
    }

    //DateTimeFormatter
    public void Ex_4(){
//        DateTimeFormatter.ISO_DATE
        // myself pattern
        // 2014-04-03
        String date1 = LocalDate.now().format(DateTimeFormatter.ISO_DATE);

        //ToDO
        // 04/03/2014
//        String date2  LocalDate.now().format(DateTimeFormatter.ofPattern("MM/DD/yyyy"));

    }
}
