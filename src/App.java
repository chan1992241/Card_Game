public class App {
    public static void main(String[] args) throws Exception {
        Player p1 = CardPlayer.getInstance();
        Player p2 = CardPlayer.getInstance();
        Player p3 = CardPlayer.getInstance();
        Player p4 = CardPlayer.getInstance();
        Player p5 = CardPlayer.getInstance();
        Player p6 = CardPlayer.getInstance();
        // System.out.println(p1);
        System.out.println(p1.getName());
        System.out.println(p2.getName());
        System.out.println(p3.getName());
        System.out.println(p4.getName());
        System.out.println(p5.getName());
        System.out.println(p6.getName());
        System.out.println(CardPlayer.totalNumberOfPlayer);

    }
}
