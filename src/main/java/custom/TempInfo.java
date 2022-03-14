package custom;

import java.util.Random;

public class TempInfo {
    public static final Random random = new Random();

    private final String town;
    private final int temp;

    public TempInfo(String town, int temp) {
        this.town = town;
        this.temp = temp;
    }

    public static TempInfo fetch(String town) {
//        if(random.nextInt(1000) == 0) {
//            throw new RuntimeException(); //10분의 1 확률로 실패한다.
//        }
        return new TempInfo(town, random.nextInt(100));
    }

    @Override
    public String toString() {
        return "custom.TempInfo{" +
                "town='" + town + '\'' +
                ", temp=" + temp +
                '}';
    }

    public String getTown() {
        return town;
    }

    public int getTemp() {
        return temp;
    }
}
