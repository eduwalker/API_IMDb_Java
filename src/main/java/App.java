import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {


                        //Conexão HTTPS & Buscar Filmes

        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String body = response.body();
        System.out.println(body);

                         // Extração de dados  (Titilo, Ano, Classificação)

        var extrator = new JsonParse();
        var convertion = new Convertion();
        var geradora = new StickerFactory();


        List<Map<String, String>> listaFilmes = extrator.parse(body);

        System.out.println("Tamanho da List: "+listaFilmes.size());
        System.out.println(listaFilmes.get(0));


                        // Exibir e manipular os dados.
        System.out.println("\n");

        for (Map<String , String > filme: listaFilmes) {
            System.out.println(purpleBack + "Classificação: "+filme.get("imDbRating")+reset);
            convertion.stars(filme.get("imDbRating"));
            System.out.println("Título: "+negrito+filme.get("title")+reset);
            System.out.println("Ano: "+negrito+filme.get("year")+reset);
            System.out.println("-------------------------------------------------------------------\n");
            geradora.getUrlImg(filme.get("image"));
            geradora.cria(filme.get("image"),filme.get("title"),filme.get("imDbRating"));


        }

    }

    public static final String purpleBack = "\u001B[45m";
    public static final String reset = "\033[0m";
    public static final String negrito = "\u001b[1m";
}
