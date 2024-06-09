import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorAPI {
    //responsavel pela interação com a API

    public void converter(ListaConversoes listaConversoes, String consultaMoeda, String moedaBase, double valorAConverter)  {
        String endereco = "https://v6.exchangerate-api.com/v6/2238efed930f0bdeb042fbc0/pair/"
                + consultaMoeda + "/" + moedaBase + "/" + valorAConverter;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            moedasParaConverter moedasParaConverter = new Gson().fromJson(json, moedasParaConverter.class);

            ConversorMoeda moeda = new ConversorMoeda(moedasParaConverter);
            moeda.setValorAConverter(valorAConverter);

            Telas tela = new Telas();
            tela.imprimeResposta(moeda);

            listaConversoes.adicionarConversao(moeda);

        } catch (IllegalArgumentException e) {
            System.out.println("Erro com o endereço da busca!");
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}

