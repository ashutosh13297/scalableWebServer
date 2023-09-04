package com.iitmandi.scalableWebServer.controller;

import com.iitmandi.scalableWebServer.service.WebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;

@Controller
@RequestMapping("network")
public class NetworkController {

    @Autowired
    WebService webService;

    private static final Logger LOG = LoggerFactory.getLogger(PrivateController.class);

    @CrossOrigin(origins = {"*"})
    @RequestMapping(value = "/getNetworkLoad", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public String getNetworkLoad(@RequestParam(value = "noOfTicks", required = false) Integer noOfTicks) {
        LOG.info("/network/addStudentData called.");
        String response = "[\n" +
                "  {\n" +
                "    \"time\" : 1668255152,\n" +
                "    \"tick\": {\n" +
                "      \"totalSize\": 120,\n" +
                "      \"data\": [\n" +
                "        {\n" +
                "          \"ip\": \"172.18.31.164\",\n" +
                "          \"packetSize\": 60,\n" +
                "          \"packetSizeUnit\": \"Bytes\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"ip\": \"172.18.31.172\",\n" +
                "          \"packetSize\": 60,\n" +
                "          \"packetSizeUnit\": \"Bytes\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"time\" : 1668255153,\n" +
                "    \"tick\": {\n" +
                "      \"totalSize\": 200,\n" +
                "      \"data\": [\n" +
                "        {\n" +
                "          \"ip\": \"172.18.31.164\",\n" +
                "          \"packetSize\": 100,\n" +
                "          \"packetSizeUnit\": \"Bytes\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"ip\": \"172.18.31.172\",\n" +
                "          \"packetSize\": 100,\n" +
                "          \"packetSizeUnit\": \"Bytes\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"time\" : 1668255154,\n" +
                "    \"tick\": {\n" +
                "      \"totalSize\": 300,\n" +
                "      \"data\": [\n" +
                "        {\n" +
                "          \"ip\": \"172.18.31.164\",\n" +
                "          \"packetSize\": 150,\n" +
                "          \"packetSizeUnit\": \"Bytes\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"ip\": \"172.18.31.172\",\n" +
                "          \"packetSize\": 150,\n" +
                "          \"packetSizeUnit\": \"Bytes\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"time\" : 1668255155,\n" +
                "    \"tick\": {\n" +
                "      \"totalSize\": 400,\n" +
                "      \"data\": [\n" +
                "        {\n" +
                "          \"ip\": \"172.18.31.164\",\n" +
                "          \"packetSize\": 200,\n" +
                "          \"packetSizeUnit\": \"Bytes\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"ip\": \"172.18.31.172\",\n" +
                "          \"packetSize\": 200,\n" +
                "          \"packetSizeUnit\": \"Bytes\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"time\" : 1668255156,\n" +
                "    \"tick\": {\n" +
                "      \"totalSize\": 600,\n" +
                "      \"data\": [\n" +
                "        {\n" +
                "          \"ip\": \"172.18.31.164\",\n" +
                "          \"packetSize\": 300,\n" +
                "          \"packetSizeUnit\": \"Bytes\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"ip\": \"172.18.31.172\",\n" +
                "          \"packetSize\": 300,\n" +
                "          \"packetSizeUnit\": \"Bytes\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"time\" : 1668255157,\n" +
                "    \"tick\": {\n" +
                "      \"totalSize\": 400,\n" +
                "      \"data\": [\n" +
                "        {\n" +
                "          \"ip\": \"172.18.31.164\",\n" +
                "          \"packetSize\": 200,\n" +
                "          \"packetSizeUnit\": \"Bytes\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"ip\": \"172.18.31.172\",\n" +
                "          \"packetSize\": 200,\n" +
                "          \"packetSizeUnit\": \"Bytes\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"time\" : 1668255158,\n" +
                "    \"tick\": {\n" +
                "      \"totalSize\": 500,\n" +
                "      \"data\": [\n" +
                "        {\n" +
                "          \"ip\": \"172.18.31.164\",\n" +
                "          \"packetSize\": 250,\n" +
                "          \"packetSizeUnit\": \"Bytes\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"ip\": \"172.18.31.172\",\n" +
                "          \"packetSize\": 250,\n" +
                "          \"packetSizeUnit\": \"Bytes\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"time\" : 1668255159,\n" +
                "    \"tick\": {\n" +
                "      \"totalSize\": 300,\n" +
                "      \"data\": [\n" +
                "        {\n" +
                "          \"ip\": \"172.18.31.164\",\n" +
                "          \"packetSize\": 150,\n" +
                "          \"packetSizeUnit\": \"Bytes\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"ip\": \"172.18.31.172\",\n" +
                "          \"packetSize\": 150,\n" +
                "          \"packetSizeUnit\": \"Bytes\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"time\" : 1668255160,\n" +
                "    \"tick\": {\n" +
                "      \"totalSize\": 400,\n" +
                "      \"data\": [\n" +
                "        {\n" +
                "          \"ip\": \"172.18.31.164\",\n" +
                "          \"packetSize\": 200,\n" +
                "          \"packetSizeUnit\": \"Bytes\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"ip\": \"172.18.31.172\",\n" +
                "          \"packetSize\": 200,\n" +
                "          \"packetSizeUnit\": \"Bytes\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  }\n" +
                "]";
        try {
//            response = webService.addStudentData(noOfTicks);
        } catch (RestClientException ex) {
            throw ex;
        }
        return response;
    }
}