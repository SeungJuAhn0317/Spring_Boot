package com.ggoreb.basic.controller;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestTemplateController {
	@SuppressWarnings("unchecked")
	@GetMapping("/getData")
	public List<Map<String, Object>> getData() {
		RestTemplate rt = new RestTemplate();
		List<Map<String, Object>> result = rt.getForObject("http://ggoreb.com/dinosaur/info.jsp", List.class);
		for (int i = 0; i < result.size(); i++) {
			Map<String, Object> map = result.get(i);
			map.get("dinosaurs");
			List<Map<String, Object>> dinosaurs = (List<Map<String, Object>>) map.get("dinosaurs");
			for (int j = 0; j < dinosaurs.size(); j++) {
				Map<String, Object> dinosaur = dinosaurs.get(j);
				String title = (String) dinosaur.get("title");
				System.out.println(title);
			}
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/getString")
	public List<Map<String, Object>> getString() {

		RestTemplate rt = new RestTemplate();
		List<Map<String, Object>> result = rt.getForObject("http://ggoreb.com/http/json3.jsp", List.class);
		for (int i = 0; i < result.size(); i++) {
			Map<String, Object> map = result.get(i);
			String name = (String) map.get("name");
			System.out.println(name);
		}

		return result;
	}

	@GetMapping("/getKakao")
	public ResponseEntity<Map> getKakao() {
		RestTemplate rt = new RestTemplate();
		RequestEntity requestEntity = null;
		try {
			requestEntity = RequestEntity
					.get(new URI("https://dapi.kakao.com/v2/local/search/address.json?query="
							+ URLEncoder.encode("부산 동래구 사직로 80", "utf-8")))
					.header("Authorization", "KakaoAK f33c0bdc28cf3a49a87aeb9f5e218e65").build();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<Map> entity = rt.exchange(requestEntity, Map.class);
		Map<String, Object> result = entity.getBody();
		List<Map<String, Object>> documents = (List<Map<String, Object>>) result.get("documents");
		for(int i = 0; i < documents.size(); i++) {
			Map<String, Object> doc = documents.get(i);
			Map<String, Object> address = (Map<String, Object>) doc.get("address");
			String 위도 = (String) address.get("y");
			String 경도 = (String) address.get("x");
			System.out.println(위도 + ", " + 경도);
		}
		return entity;
	}
}