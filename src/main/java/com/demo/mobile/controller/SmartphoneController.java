package com.demo.mobile.controller;


import com.demo.mobile.model.Smartphone;
import com.demo.mobile.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/smartphones")
@CrossOrigin
public class SmartphoneController {
    @Autowired
    private ISmartPhoneService smartPhoneService;

    @PostMapping("/createSmartPhone")
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(smartPhoneService.save(smartphone), HttpStatus.CREATED);
    }
    @GetMapping("/list")
    public ResponseEntity<List<Smartphone>> getAllSmartphonePage()
    {
        List<Smartphone> smartphones = (List<Smartphone>)smartPhoneService.findAll();

        if (smartphones.size() == 0)
        {
            return new ResponseEntity<>(smartphones, HttpStatus.NO_CONTENT);
        }
        else
        {
            return new ResponseEntity<>(smartphones, HttpStatus.OK);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Smartphone> deleteSmartphone(@PathVariable Long id) {
        Optional<Smartphone> smartphoneOptional = smartPhoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartPhoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }
}
