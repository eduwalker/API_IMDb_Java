public class test {
    public static void main(String[] args) {

        final String ANSI_PURPLE = "\u001B[35m";
         final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";



        var parse = new Convertion();


        parse.stars("5.5");

        System.out.println("⭐");

        System.out.println(ANSI_PURPLE_BACKGROUND + "This text is red!"+reset);
        System.out.println("Outro Teste");

    }
    public static final String reset = "\033[0m";
}
