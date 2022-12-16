package com.ibik.api.academicservices.authentifications;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ibik.api.academicservices.helper.MyHelpers;
import com.ibik.api.academicservices.students.Students;
import com.ibik.api.academicservices.students.StudentsServices;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private StudentsServices studentsServices;

    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> fetchStudentByAuth(@RequestBody String payload) {
        JsonObject jobj = new Gson().fromJson(payload, JsonObject.class);
        String email = jobj.get("email").getAsString();
        String password = jobj.get("password").getAsString();

        try {
            Students values = studentsServices.findByAuth(email, password);

            Algorithm algorithm = Algorithm.HMAC256(new MyHelpers().PRIVATE_KEY);
            String access_token = JWT.create()
                    .withSubject(values.getNpm())
                    .withExpiresAt(new Date(System.currentTimeMillis() + 10 + 60 * 1000)) //expired 1 minutes
                    .withIssuer("auth0")
                    .sign(algorithm);

            String refresh_token = JWT.create()
                    .withSubject(values.getNpm())
                    .withExpiresAt(new Date(System.currentTimeMillis() + 30 + 60 * 1000)) //expired 3 minutes
                    .withIssuer("auth0")
                    .sign(algorithm);

            List<String> result = new ArrayList<>();
            result.add(access_token);
            result.add(refresh_token);
            Map<String,String> results = new HashMap<>();
            results.put("access_token",access_token);
            results.put("refresh_token", refresh_token);

            return ResponseEntity.ok(results);

        } catch (Exception e) {
            List<String> message = new ArrayList<>();
            message.add(e.getMessage());
            Map<String,String> response = new HashMap<>();
            response.put("result", "false");
            response.put("data", "");
            response.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

}
