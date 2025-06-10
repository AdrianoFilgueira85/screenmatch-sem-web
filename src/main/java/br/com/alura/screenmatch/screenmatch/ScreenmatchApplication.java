package br.com.alura.screenmatch.screenmatch;

import br.com.alura.screenmatch.screenmatch.model.DadosEpisodio;
import br.com.alura.screenmatch.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.screenmatch.service.ConverterDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		ConsumoApi consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&Season&apikey=cabd56e7");
		System.out.println(json);
		ConverterDados converterDados = new ConverterDados();
		DadosSerie dados = converterDados.obterDados(json,DadosSerie.class);
		System.out.println(dados);

		ConverterDados dadosEpisodio = new ConverterDados();
		json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=1&episode=1&apikey=cabd56e7");

		DadosEpisodio episodio = converterDados.obterDados(json,DadosEpisodio.class);
		System.out.println(episodio);


	}
}
