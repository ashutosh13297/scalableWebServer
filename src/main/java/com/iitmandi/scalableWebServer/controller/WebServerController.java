package com.iitmandi.scalableWebServer.controller;

import com.iitmandi.scalableWebServer.service.WebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;

import java.util.List;

@RestController
@RequestMapping("test")
public class WebServerController {

    @Autowired
    WebService webService;

    private static final Logger LOG = LoggerFactory.getLogger(WebServerController.class);

    @CrossOrigin(origins = {"*"})
    @RequestMapping(value = "/inexpensiveQuery", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public List<String> testInexpensiveQuery() {
        LOG.info("/test/inexpensiveQuery called.");
        try {
            return webService.testInExpensiveQuery();
        } catch (RestClientException ex) {
            throw ex;
        }
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping(value = "/moderatelyExpensiveQuery", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public List<String> testModeratelyExpensiveQuery() {
        LOG.info("/test/moderatelyExpensiveQuery called.");
        try {
            return webService.testModeratelyExpensiveQuery();
        } catch (RestClientException ex) {
            throw ex;
        }
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping(value = "/highlyExpensiveQuery", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public List<String> testHighlyExpensiveQuery() {
        LOG.info("/test/highlyExpensiveQuery called.");
        try {
            return webService.testHighlyExpensiveQuery();
        } catch (RestClientException ex) {
            throw ex;
        }
    }

}

