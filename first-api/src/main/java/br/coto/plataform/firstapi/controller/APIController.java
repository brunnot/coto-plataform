package br.coto.plataform.firstapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/v1/first")
public class APIController {

	@GetMapping("/call")
	public @ResponseBody String call( @RequestParam("requestId") String itemid ) {
		log.info( "Endpoint chamado. " + itemid );
		return "Chamou: " + itemid;
	}
	
}
