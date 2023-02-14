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
public class SecretRest {

    @RequestMapping(method = RequestMethod.GET, value = "secret")
    public String getSecret(@RequestParam String secret) {
        return System.getenv(secret);
    }

    @RequestMapping(method = RequestMethod.GET, value = "SecretInVolume")
    public JsonNode getFile(@RequestParam String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.readTree(new String(Files.readAllBytes(Paths.get(path))));
    }
}
