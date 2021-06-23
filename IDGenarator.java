public class IDGenarator {
    static int serialNo;

    public static String genarate(int id, Date date){
        return String.format("%04d",date.year)+"-"+ String.format("%02d",date.month)+"-"+ String.format("%05d",id);
    }
}
