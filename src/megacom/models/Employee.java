package megacom.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {

    private Date birthday;

    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public Employee(String birthday) {
        try {
            this.birthday = sdf.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getBirthday() {
        return sdf.format(this.birthday);
    }

    public boolean after(Date birthday){
        if(this.getBirthday().equals(birthday)) {
            return true;
        } else
        {
            return false;
        }
    }


}