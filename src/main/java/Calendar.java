public class Calendar {
    private String calName;
    private int calID;

    public Calendar(String calName, int calID){
        this.calName = calName;
        this.calID = calID;
    }

    public String getCalName()
    {
        return calName;
    }

    public int getCalID()
    {
        return calID;
    }
}
