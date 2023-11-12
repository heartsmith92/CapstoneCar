package com.educlaas.xyzcar.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/xyz")
@CrossOrigin(origins = "http://localhost:3000/")
public class DashboardController {

}
