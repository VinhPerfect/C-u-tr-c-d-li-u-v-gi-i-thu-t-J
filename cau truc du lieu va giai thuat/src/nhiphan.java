public class nhiphan {
    public static void main(String[] args) {
        int stp = 20;
        String sonhiphanString = thapphansangnhiphan(stp);
        System.out.println(sonhiphanString);
    }
    public static String thapphansangnhiphan(int stp){
        StringBuilder sonhiphan = new StringBuilder();
        if(stp==0){
            return "0";
        }
        while(stp>0){
            int sodu = stp%2;
            sonhiphan.insert(0, sodu);
            stp = stp/2;
        }
        return sonhiphan.toString();
    }
}