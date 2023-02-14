package com.bootcamp.devops.openshift.rest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class ConfigMapRest {

    @RequestMapping(method = RequestMethod.GET, value = "data")
    public String getData(@RequestParam String data) {
        return System.getenv(data);
    }

    @RequestMapping(method = RequestMethod.GET, value = "ConfigMapInVolume")
    public JsonNode getFile(@RequestParam String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.readTree(new String(Files.readAllBytes(Paths.get(path))));
    }


}
