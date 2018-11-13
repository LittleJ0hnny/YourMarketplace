package com.littlejohnny.auth.domain.controller;

import com.littlejohnny.auth.domain.model.dto.OAuth2ClientDTO;
import com.littlejohnny.auth.domain.service.OAuth2ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oauth2client/")
public class OAuth2ClientController {
    @Autowired
    private OAuth2ClientService oAuth2ClientService;

    @PostMapping("/save")
    public ResponseEntity saveClient(@RequestBody OAuth2ClientDTO oAuth2ClientDTO) {
        oAuth2ClientService.save(oAuth2ClientDTO.asOAuth2Client());
        return ResponseEntity.ok("Done!");
    }
}
