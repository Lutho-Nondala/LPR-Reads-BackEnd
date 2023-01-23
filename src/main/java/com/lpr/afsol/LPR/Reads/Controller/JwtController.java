package com.lpr.afsol.LPR.Reads.Controller;

import com.lpr.afsol.LPR.Reads.Entity.JwtRequest;
import com.lpr.afsol.LPR.Reads.Entity.JwtResponse;
import com.lpr.afsol.LPR.Reads.Service.JwtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Console;

@RestController
@CrossOrigin
@RequestMapping("/lpr/jwt")
@Slf4j
public class JwtController {
    @Autowired
    private JwtService jwtService;

    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception{
        return jwtService.createJwtToken(jwtRequest);
    }
}
