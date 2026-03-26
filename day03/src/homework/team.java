package homework;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class team {
    private String name;
    private String locale;
    private java.sql.Date founded;

    public team(String name, String locale, java.sql.Date founded) {
        this.name = name;
        this.locale = locale;
        this.founded = founded;
    }

    public java.sql.Date getFounded() {
        return founded;
    }

    public String getLocale() {
        return locale;
    }

    public String getName() {
        return name;
    }

   public static List<team> getteam() throws ParseException {
       List<team> teams = new ArrayList<>();
       SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
       team t1=new team("湖人队","洛杉矶",  new Date(sim.parse("1968-12-21").getTime()));
       team t2=new team("勇士队","金州",new Date( sim.parse("1975-05-09").getTime()));
       team t3=new team("火箭队","休斯顿", new Date(sim.parse("1968-10-19").getTime()));
       teams.add(t1);
       teams.add(t2);
       teams.add(t3);
       return teams;
   }

}
