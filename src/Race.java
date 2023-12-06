import java.util.ArrayList;

public class Race {
  private long timeOfRace;
  private long recordDistance;

  private long waysToWin;
  Race(long n, long r) {
    waysToWin = 0;
    timeOfRace = n;
    recordDistance = r;
    validTimes();
  }

  public long getWaysToWin() {
    return waysToWin;
  }

  private void validTimes() {
    for (long x = 0; x < timeOfRace; ++x){
      long validGoTime = timeOfRace - x;
      long distance = validGoTime * x;
      if (distance > recordDistance) {
        ++waysToWin;
      }
    }
  }

}
