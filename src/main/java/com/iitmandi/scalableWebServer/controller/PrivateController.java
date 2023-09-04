package com.iitmandi.scalableWebServer.controller;

import com.iitmandi.scalableWebServer.service.WebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;

@CrossOrigin(origins = {"*"})
@Controller
@RequestMapping("private")
public class PrivateController {

    @Autowired
    WebService webService;

    private static final Logger LOG = LoggerFactory.getLogger(PrivateController.class);

    @RequestMapping(value = "/addStudentData", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public String addStudentData(@RequestParam(value = "noOfStudent", required = false) Integer noOfStudent) {
        LOG.info("/private/addStudentData called.");
        String response;
        try {
            response = webService.addStudentData(noOfStudent);
        } catch (RestClientException ex) {
            throw ex;
        }
        return response;
    }

    @RequestMapping(value = "/addCollegeData", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public String addCollegeData(@RequestParam(value = "noOfCollege", required = false) Integer noOfCollege) {
        LOG.info("/private/addCollegeData called.");
        String response;
        try {
            response = webService.addCollegeData(noOfCollege);
        } catch (RestClientException ex) {
            throw ex;
        }
        return response;
    }

    @RequestMapping(value = "/addClgApplication", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public String addClgApplication(@RequestParam(value = "noOfApplication", required = false) Integer noOfApplication) {
        LOG.info("/private/addClgApplication called.");
        String response;
        try {
            response = webService.addClgApplication(noOfApplication);
        } catch (RestClientException ex) {
            throw ex;
        }
        return response;
    }
}
