import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;

public class StickerFactory {

    public InputStream inputUrl;
    public Integer rating;

  //  InputStream inputStream = new URL(inputImg);
    public BufferedImage imgOrigT = ImageIO.read(new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_1.jpg"));

    public void getUrlImg (String url) throws IOException {
         this.inputUrl =
                   new URL(url)
                            .openStream();
    }
    public StickerFactory() throws IOException {
    }

    public void verTam(){
        System.out.println("Largura: "+imgOrigT.getWidth());
        System.out.println("Altura: "+imgOrigT.getHeight());

        }
        public void cria(String url, String nome, String rating) throws Exception {

            // Ler imagem
            this.inputUrl =
                    new URL(url)
                            .openStream();


            String ratingStr = String.valueOf(rating);

           BufferedImage imgOrig = ImageIO.read(inputUrl);

            String titulo = "Classificação IMDb: "+ratingStr;
            String nomeArquivoFormated = nome.trim().replaceAll("[^a-zA-Z]","")+".png";

            // Cria nova imagem em memoria com transparencia e tamanho novo

            int largura = imgOrig.getWidth();
            int altura = imgOrig.getHeight();
            int novaAltura = altura+300;
            int larguraFix = 1080;
            int alturaFix = 1980;
            BufferedImage novaImg = new BufferedImage(largura,novaAltura,BufferedImage.TRANSLUCENT);

            //copiar a imagem original para nova imagem (em memória)

            Graphics2D graphics = (Graphics2D) novaImg.getGraphics();

            graphics.drawImage(imgOrig,0,0, null);

            // configuar fonte

            var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 90);
            graphics.setColor(Color.ORANGE);
            graphics.setFont(fonte);

            // escrever uma frase na nova imagem

            graphics.drawString(titulo, 0, novaAltura - 100);

            // escrever nova imagem em um arquivo

            ImageIO.write(novaImg, "png", new File("src/main/imgOut/"+nomeArquivoFormated));
        }

    public static void main(String[] args) throws Exception {

            var geradora = new StickerFactory();
        System.out.println();
         //   geradora.cria();
            geradora.verTam();
    }
}
