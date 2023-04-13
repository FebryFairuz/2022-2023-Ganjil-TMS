package com.ibik.api.academicservices.chart;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ibik.api.academicservices.dto.ResponseData;
import com.ibik.api.academicservices.helper.BaseEncDeco;
import com.ibik.api.academicservices.products.Products;
import com.ibik.api.academicservices.products.ProductsServices;
import com.ibik.api.academicservices.students.Students;

@RestController
@RequestMapping("/api/chart")

public class ChartController {

    @Autowired
    private ChartServices chartServices;

    // @JsonProperty(access = Access.READ_ONLY)
    @PostMapping(value = "/mychart")
    public ResponseEntity<ResponseData<Chart>> postMyChart(@Valid @RequestBody String payload, Errors errors) {
        ResponseData<Chart> responseData = new ResponseData<>();

        JsonObject jobj = new Gson().fromJson(payload, JsonObject.class);
        String invoice_code = jobj.get("invoice_code").getAsString();
        int student_id = jobj.get("student_id").getAsInt();
        int product_id = jobj.get("product_id").getAsInt();
        int total = jobj.get("total").getAsInt();
        Chart chart = new Chart();
        chart.setInvoice_code(invoice_code);
        Students std = new Students();
        std.setId(student_id);
        chart.setStudents(std);
        Products prd = new Products();
        prd.setId(product_id);
        chart.setProducts(prd);
        chart.setTotal(total);

        List<Chart> value = new ArrayList<>();
        value.add(chartServices.save(chart));
        responseData.setData(value);

        responseData.setResult(true);

        return ResponseEntity.ok(responseData);
    }

    @GetMapping("/mychart")
    public ResponseEntity<ResponseData<Chart>> fetchMyChart(
            @RequestHeader(value = "Authorization", required = false) String token) {
        ResponseData<Chart> responseData = new ResponseData<>();
        try {
            try {
                List<String> tokenObj = new BaseEncDeco().Decoded(token);
                String objString = tokenObj.get(1);
                JsonObject jobj = new Gson().fromJson(objString, JsonObject.class);
                JsonObject identity = jobj.get("identity").getAsJsonObject();
                int user_id = Integer.parseInt(identity.get("id").getAsString());
                Iterable<Chart> mylist = chartServices.findChartByUserID(user_id);
                responseData.setResult(true);
                responseData.setMessage(null);
                responseData.setData(mylist);
                return ResponseEntity.ok(responseData);
            } catch (Exception e) {
                List<String> message = new ArrayList<>();
                message.add(e.getMessage());
                responseData.setMessage(message);
                responseData.setData(null);
                responseData.setResult(false);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
            }

        } catch (Exception e) {
            List<String> message = new ArrayList<>();
            message.add(e.getMessage());
            responseData.setMessage(message);
            responseData.setData(null);
            responseData.setResult(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

    @GetMapping("/sample")
    public String sampleOfObject() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Thesya Marcella");
        map.put("gender", "Female");
        map.put("age", "20");
        String jobj = new Gson().toJson(map);
        System.out.println(jobj);
        return jobj;
    }
}
