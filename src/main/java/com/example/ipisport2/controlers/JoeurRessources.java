package com.example.ipisport2.controlers;

import com.example.ipisport2.dto.ImputPlayerDto;
import com.example.ipisport2.dto.playerDto;
import com.example.ipisport2.entities.JoueurEntity;
import com.example.ipisport2.repository.JoueurRepository;
import com.example.ipisport2.service.IJoeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("player")
public class JoeurRessources {

    @Autowired
    private IJoeurService service;

    @GetMapping("get/{id}")
    public ResponseEntity get (@PathVariable String id) {
        Integer ID = null;
        try {
           ID = Integer.parseInt(id);
        }
        catch (Exception e){
            return new ResponseEntity<>("l'id n'est un entier", HttpStatusCode.valueOf(200));
        }
        if (!service.exist(ID)){
            return new ResponseEntity<>("le jouer n'existe pas", HttpStatusCode.valueOf(200));
        }
        return new ResponseEntity<>(service.toDto(service.get(ID)),HttpStatusCode.valueOf(200));


    }

    @GetMapping("getall")
    public ResponseEntity getall(){
        List<JoueurEntity> list = service.getALL();

        // on crée une liste vide
        List<playerDto> result = new ArrayList<playerDto>();

        for (int i = 0; i<list.size(); i++){
            result.add(service.toDto(list.get(i)));
        }
        return new ResponseEntity<>(result, HttpStatusCode.valueOf(200));
    }

    @GetMapping("delete/{id}")
    public ResponseEntity  supp (@PathVariable String id){
        Integer ID = null;
        try {
            ID = Integer.parseInt(id);
        }
        catch (Exception e){
            return new ResponseEntity<>("l'id n'est un entier", HttpStatusCode.valueOf(200));
        }
        if (!service.exist(ID)){
            return new ResponseEntity<>("le jouer n'existe pas", HttpStatusCode.valueOf(200));
        }
        return new ResponseEntity<>(service.delete(ID),HttpStatusCode.valueOf(200));

    }

    @GetMapping("deleteBatch")
    public ResponseEntity delete (@RequestParam List<Integer> id){
        int result = 0;
        for (int i = 0; i < id.size() ; i++ ){
            service.delete(id.get(i));
            result ++;
        }
        return new ResponseEntity(result + "element supprimee", HttpStatusCode.valueOf(200));
    }

    @PostMapping("add")
    public ResponseEntity ajouter (@RequestBody ImputPlayerDto body){

        // Controle du body
        if (null == body.getNom())
            return new ResponseEntity("nom vide", HttpStatus.BAD_REQUEST);
        if (null == body.getPrenom())
            return new ResponseEntity("prenom vide", HttpStatus.BAD_REQUEST);
        if (null == body.getDate_naissance())
            return new ResponseEntity("date naissance vide", HttpStatus.BAD_REQUEST);
        if (null == body.getSport())
            return new ResponseEntity("sport vide", HttpStatus.BAD_REQUEST);

        Integer id = service.add(body);
        return new ResponseEntity(String.format("element ajoutée : %d;", id), HttpStatus.OK);
    }
}