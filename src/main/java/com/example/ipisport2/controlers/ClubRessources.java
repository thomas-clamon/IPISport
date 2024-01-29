package com.example.ipisport2.controlers;

import com.example.ipisport2.dto.ClubDto;
import com.example.ipisport2.service.ServiceClub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("club")
public class ClubRessources {

    @Autowired
    private ServiceClub serviceClub;
    @PostMapping("add")
    public ResponseEntity ajouter(@RequestBody ClubDto body){
        return new ResponseEntity<>(serviceClub.addClub(body), HttpStatus.OK);
    }
}
