package telran.imagga.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import telran.imagga.dto.ResponseDto;
import telran.imagga.dto.TagDto;

public class ImaggaClientAppl {

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://api.imagga.com/v2/tags";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic YWNjXzc4ZjA5OWY5ZmY5NzIxMjphYTY0YjcxMzgwMTE5NmVkYTkxNDRlZjk1ZDU2MGNkMw==");
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
				.queryParam("image_url", "https://24smi.org/public/media/235x307/person/2017/12/22/4sqqykgn04bo-cheburashka.jpg")
				.queryParam("language", "en")
				.queryParam("limit", 3);
		RequestEntity<String> request = 
				new RequestEntity<>(headers, HttpMethod.GET, builder.build().toUri());
		ResponseEntity<ResponseDto> response = 
				restTemplate.exchange(request, ResponseDto.class);
		
		displayTags(response.getBody().getResult().getTags());
	}

	private static void displayTags(List<TagDto> tags) {
		tags.forEach(System.out::println);
		
	}

}
