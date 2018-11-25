package com.littlejohnny.auth.domain.controller;

import com.littlejohnny.auth.domain.model.dto.OAuth2ClientDTO;
import com.littlejohnny.auth.domain.model.entity.OAuth2Client;
import com.littlejohnny.auth.domain.service.OAuth2ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/oauth2client/")
public class OAuth2ClientController {
    @Autowired
    private OAuth2ClientService oAuth2ClientService;

    @PostMapping("/save")
    public ResponseEntity saveClient(@RequestBody OAuth2ClientDTO oAuth2ClientDTO) {
        OAuth2Client oAuth2Client = oAuth2ClientDTO.asOAuth2Client();
        oAuth2ClientService.save(oAuth2Client);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OAuth2ClientDTO> getClient(@PathVariable Long id) {
        return ResponseEntity.ok(new OAuth2ClientDTO(oAuth2ClientService.getOne(id)));
    }
}
