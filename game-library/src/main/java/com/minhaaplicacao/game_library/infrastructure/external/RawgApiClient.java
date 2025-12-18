package com.minhaaplicacao.game_library.infrastructure.external;

import com.minhaaplicacao.game_library.infrastructure.dto.GameResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

// url: O endereço base da API externa
// name: Um apelido interno para este cliente
@FeignClient(name = "rawgApi", url = "https://api.rawg.io/api")
public interface RawgApiClient {

    // Mapeia a chamada para: https://api.rawg.io/api/games/{id}?key={apiKey}
    @GetMapping("/games/{id}")
    GameResponseDTO getGameDetails(@PathVariable("id") Long id, @RequestParam("key") String apiKey);
}
