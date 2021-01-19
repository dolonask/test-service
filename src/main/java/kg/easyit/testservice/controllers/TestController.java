package kg.easyit.testservice.controllers;

import kg.easyit.testservice.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {


    @Autowired
    private TestService testService;


    @PostMapping("/result")
    public ResponseEntity<?> getResult(@RequestHeader String operationId,
                                       @RequestBody Map<String, String> params){

        return new ResponseEntity<>(testService.getResult(params), HttpStatus.OK);


    }
}
