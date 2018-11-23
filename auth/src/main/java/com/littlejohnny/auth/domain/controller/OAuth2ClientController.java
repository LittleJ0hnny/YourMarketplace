package com.littlejohnny.auth.domain.controller;

import com.littlejohnny.auth.domain.model.dto.OAuth2ClientDTO;
import com.littlejohnny.auth.domain.model.entity.AuthGrantType;
import com.littlejohnny.auth.domain.model.entity.AuthGrantTypes;
import com.littlejohnny.auth.domain.model.entity.OAuth2Client;
import com.littlejohnny.auth.domain.service.AuthGrantTypeService;
import com.littlejohnny.auth.domain.service.OAuth2ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Stream;

@RestController
@RequestMapping("/oauth2client/")
public class OAuth2ClientController {
    @Autowired
    private OAuth2ClientService oAuth2ClientService;

    @Autowired
    private AuthGrantTypeService authGrantTypeService;

    @PostMapping("/save")
    public ResponseEntity saveClient(@RequestBody OAuth2ClientDTO oAuth2ClientDTO) {
        OAuth2Client oAuth2Client = oAuth2ClientDTO.asOAuth2Client();
        Set<AuthGrantType> authGrantTypes = new HashSet<>();
        authGrantTypes.add(authGrantTypeService.getOne(AuthGrantTypes.PASSWORD.getId()));
        authGrantTypes.add(authGrantTypeService.getOne(AuthGrantTypes.REFRESH_TOKEN.getId()));
        oAuth2Client.setGrantTypes(authGrantTypes);
        oAuth2ClientService.save(oAuth2Client);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OAuth2ClientDTO> getClient(@PathVariable Long id) {
        return ResponseEntity.ok(new OAuth2ClientDTO(oAuth2ClientService.getOne(id)));
    }
}
