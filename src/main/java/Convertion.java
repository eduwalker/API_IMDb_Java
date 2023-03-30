public class Convertion {

    private static String star = "⭐";
    private Integer toInt;

    public static final String purpleBack = "\u001B[45m";

    public void stars (String rate){
        Double toDouble = Double.parseDouble(rate);

         for (int i =0; Math.round(toDouble) > i; i++)
             System.out.print(star);
                System.out.println();

    }

}







