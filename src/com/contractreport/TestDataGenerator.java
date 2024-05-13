package com.contractreport;

public class TestDataGenerator {
    public static void main(String[] args) {
        for (int i = 11111; i < 30000; i++) {
            if (i % 2 == 0)
                System.out.println(i + ",2345,us_east,RedTeam,ProjectApple,3445s");
            else if (i % 3 == 0)
                System.out.println(i + ",2345,us_west,BlueTeam,ProjectBanana,2211s");
            else if (i % 5 == 0)
                System.out.println(i + ",2346,eu_west,YellowTeam3,ProjectCarrot,4322s");
            else if (i % 7 == 0)
                System.out.println(i + ",2345,eu_east,BlueTeam,ProjectDate,2221s");
        }
    }
}
