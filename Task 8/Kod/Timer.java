import java.time.Duration;
import java.time.Instant;

public class Timer {
    private Instant start;
    private Instant end;

    public void start(){
        start = Instant.now();
    }

    public void stop(){
        end = Instant.now();
    }

    public long getTimeInMillis(){
        return Duration.between(start, end).toMillis();
    }

    public void reset(){
        start = end;
    }
}
