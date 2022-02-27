package com.ms.hrworker.resources;

import com.ms.hrworker.entities.Worker;
import com.ms.hrworker.repositories.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

    private static final Logger LOG = LoggerFactory.getLogger(WorkerResource.class);
    @Value("${test.config}") String testConfig;

    @Autowired
    private Environment environment;

    @Autowired
    private WorkerRepository repository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        List<Worker> list = repository.findAll();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/config")
    public ResponseEntity<Void> getConfig(){
        LOG.info("CONFIG = " + testConfig);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id){
        Optional<Worker> worker = repository.findById(id);
        LOG.info("PORT = " + environment.getProperty("local.server.port"));
        if(worker.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(worker.get());
    }
}
