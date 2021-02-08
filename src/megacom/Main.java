package megacom;

import megacom.models.Employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int timeH, timeM; boolean temp = false;

        Date[] dates = new Date[10];
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        for(int i=0; i< dates.length; i++){

            do {
                System.out.print((i + 1) + ") Hour [1:24] - ");
                timeH = scan.nextInt();

                System.out.print((i + 1) + ") Minute [00:60] - ");
                timeM = scan.nextInt();

                System.out.println("*********************");

                String h = String.valueOf(timeH);
                String m = String.valueOf(timeM);
                String hm = h+":"+m;


                try {
                    dates[i] = sdf.parse(hm);
                } catch (ParseException e) {
                    e.printStackTrace();
                }


            }while((timeH<=0 || timeH>24) || (timeM<0 || timeM>60));
        }

        Date minDate = dates[0];

        for(int i=0; i< dates.length; i++){
            System.out.println(sdf.format(dates[i]));
            if(minDate.after(dates[i])){
                minDate = dates[i];
            }
        }

        System.out.println("Min time - "+ sdf.format(minDate));


        System.out.println("************************************");
        System.out.print("Employee > 5 - ");
        int e = scan.nextInt();
        Employee[] empl = new Employee[e];


        for(int i=1; i<empl.length; i++){

            if(i==2){continue;}

            int day = (int)(Math.random()*(31-0))+0;
            int month = (int)(Math.random()*(12-1))+1;
            int year = (int)(Math.random()*(2002-1970))+1970;
            String ds = String.valueOf(day);
            String ms = String.valueOf(month);
            String ys = String.valueOf(year);
            String dmy = ds+"."+ms+"."+ys;
            empl[i] = new Employee(dmy);

            empl[0] = new Employee("9.02.2000");
            empl[2] = new Employee("10.02.2000");

        }

        for(int i=0; i<empl.length; i++){
            System.out.println((i+1)+") "+empl[i].getBirthday());
        }

        String delimiter = "\\.";
        String[]s1 = new String[2];
        int[] d = new int[e];
        int[] d1 = new int[e];
        int[] d2 = new int[e];

        for(int i=0; i<empl.length; i++){
            for(int j=0; j<empl.length; j++){

                s1 = (empl[i].getBirthday().split(delimiter));
                d[i] = Integer.valueOf(s1[2]); //YEAR
                d1[i] = Integer.valueOf(s1[0]); //DAY
                d2[i] = Integer.valueOf(s1[1]); //MONTH
            }
        }

        System.out.println("************************************");
        System.out.println("Peers:");
       for(int i=0; i<empl.length; i++){
            for(int j=0; j<i; j++){
                //System.out.println(s1[2]);
                //System.out.println(d[i]);
               if(d[i]==d[j] && i!=j){
                   System.out.println((j+1) +" == "+ (i+1));
                }
            }
        }

        int olderEmpl = d[0];
        for(int i=0; i<empl.length; i++){

                if(olderEmpl>d[i]){
                    olderEmpl = d[i];
                }
                //System.out.println(d[i]);
        }

        System.out.println("************************************");
        for(int i=0; i<empl.length; i++){
            if(olderEmpl == d[i]) {
                System.out.println((i + 1) + ") Older Employee: " + olderEmpl);
            }
        }
        System.out.println("************************************");


        int sr=0;
        for(int i=0; i<empl.length; i++){
            sr+=d[i];
        }
        System.out.println("Average age of employees == "+(sr/empl.length));
        System.out.println("************************************");


        Date emplBirthday = new Date();
        SimpleDateFormat sdfDay = new SimpleDateFormat("dd.MMM.yyyy");
        System.out.println("-------"+sdfDay.format(emplBirthday)+"-------");



        for(int i=0; i<empl.length; i++){
            if(emplBirthday.getDate() == d1[i] && emplBirthday.getMonth() == (d2[i]-1)){
                System.out.println((i+1)+") Birthday Today - "+sdfDay.format(emplBirthday));
            }
            if((emplBirthday.getDate()+1) == d1[i] && emplBirthday.getMonth() == (d2[i]-1)){
                System.out.println((i+1)+") Birthday Tommorow - "+sdfDay.format(emplBirthday));
            }
        }

        

    }
}
