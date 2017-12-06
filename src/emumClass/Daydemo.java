package emumClass;

public class Daydemo {
    public static void main(String[] args) {
        day[] days=new day[]{day.Four,day.Four,day.One};
        for (int i = 0; i <days.length ; i++) {
            System.out.println(days[i]);
            System.out.println(days[i].ordinal());
        }
    }
}

enum day{
    One,Two,Three,Four
}