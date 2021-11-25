package com.example.demo.Controller;

import com.example.demo.Service.EstatesService;
import com.example.demo.dto.request.EstatesFilterObject;
import com.example.demo.dto.request.EstatesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Estates")
public class EstatesController {

    @Autowired
    EstatesService estatesService;



    @GetMapping("/getAllEstates")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_VISITOR')")
    public ResponseEntity<Object> getAllEstates() throws Exception {
            try {
                return new ResponseEntity<>(estatesService.getAllEstates(), HttpStatus.OK);


            } catch (Exception e) {
                e.printStackTrace();
                throw new Exception(e.getCause());
            }

    }
    @PostMapping(value = "/EstatesFilter")
    @PreAuthorize("hasAuthority('estates_write')")
    public ResponseEntity<Object> EstatesFilter(@RequestBody EstatesFilterObject estatesFilter) {
        try {


            return new ResponseEntity<>(estatesService.filterEstates(estatesFilter), HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e, HttpStatus.FAILED_DEPENDENCY);
        }



    }

    }





