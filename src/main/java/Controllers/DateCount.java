package Controllers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateCount {
    public String str;

    DateCount(String s){
        str = s;
    }

    public boolean isDigit(char c){
        return Character.isDigit(c);
    }

    public int[] isDate(){
        String delimiter = "-|/";
        String[] dateStringArr = str.split(delimiter);
        int[] dateArr = {0, 0, 0};

        //проверка даты

        boolean bool = true;
        while (bool) {
            if (dateStringArr.length != 3) { System.out.println("Error1 - arr length"); bool = false; }
            else {
                System.out.println("All good1 - arr length");
                boolean isDig = true;
                for (int i = 0; i < dateStringArr.length; i++) {
                    for (int j = 0; j < dateStringArr[i].length(); j++) {
                        if (isDigit(dateStringArr[i].charAt(j)) == false) {
                            isDig = false;
                            break;
                        }
                    }
                    if (isDig == false) break;
                }

                if (isDig == false) { System.out.println("Error2 - all digits"); bool = false; }
                else {
                    System.out.println("All good2 - all digits");
                    if ((dateStringArr[2].length() != 4) && (dateStringArr[2].length() != 2)) {
                        System.out.println("Error3 - year");  bool = false; }
                    else {
                        System.out.println("All good3 - year");
                        dateArr[0] = Integer.parseInt(dateStringArr[0]);
                        dateArr[1] = Integer.parseInt(dateStringArr[1]);
                        if (dateStringArr[2].length() == 2) dateArr[2] = 1900 + Integer.parseInt(dateStringArr[2]);
                        else dateArr[2] = Integer.parseInt(dateStringArr[2]);

                        if ((dateArr[1] > 12) || (dateArr[1] < 1)) { System.out.println("Error4 - month");  bool = false; }
                        else {
                            System.out.println("All good4 - month");

                            int[] numberOfDaysInAMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
                            int[] numberOfDaysInAMonthForLeapYear = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
                            int[] numberOfDays;
                            if ((dateArr[2] % 4 == 0) && ((dateArr[2] % 100 != 0) || (dateArr[2] % 400 == 0)))
                                numberOfDays = numberOfDaysInAMonthForLeapYear;
                            else numberOfDays = numberOfDaysInAMonth;

                            if (dateArr[0] > numberOfDays[dateArr[1] - 1] || dateArr[0] < 1){
                                System.out.println("Error5 - day"); bool = false; }
                            else {
                                System.out.println("All good5 - day");

                            }
                        }
                    }
                }
            }
            System.out.println("date - good");
            bool = false;
        }
        return dateArr;
    }

    public String daysToBirthAndYearsOld(){
        int[] dateArr = isDate();
        int[] nullArr = {0,0,0};

        if (dateArr == nullArr) {
            System.out.println(false);
            return null;
        }
        else {
            System.out.println(true);

            str = ""+ dateArr[0] + "/" + dateArr[1] + "/" + dateArr[2];
            System.out.println(str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

            Date currentDate = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(currentDate);
            String s = simpleDateFormat.format(calendar.getTime());
            System.out.println(s);

            try{
                Date dateC = simpleDateFormat.parse(s);
                Date dateB = simpleDateFormat.parse(str);
                //System.out.println(dateC);
                //System.out.println(dateB);

                long startTimeD = dateC.getTime();
                long endTimeD = dateB.getTime();
                long resultTimeD = endTimeD - startTimeD;
                long daysToBirth = resultTimeD / (1000 * 60 * 60 * 24);
                //System.out.println(daysToBirth);
                //return daysToBirth;

                //изменить год даты

                long startTimeY = dateB.getTime();
                long endTimeY = dateC.getTime();
                long resultTimeY = endTimeY - startTimeY;
                long resultYearsOld = resultTimeY / (1000 * 60 * 60 * 24);
                resultYearsOld /= 365;

                String result = "Age is " + resultYearsOld + " years, " + daysToBirth + " days to next birthday";
                return result;

            } catch (Exception e) {
                System.out.println("parse-error");
                return null;
            }
        }
    }
}
