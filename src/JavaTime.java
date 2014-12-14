import java.time.*;

/**
 * Created by 1 on 15.12.2014.
 */
public class JavaTime {
    public JavaTime() {
        Example_1();
    }

    private void Example_1() {
        LocalDate localDate = LocalDate.of(1996, Month.JANUARY, 23);
        LocalTime localTime = LocalTime.of(19,00,00);

        ZonedDateTime zonedDateTime = ZonedDateTime.of(2014, 11, 3, 19, 15, 36, 55, ZoneId.of())
    }
}
