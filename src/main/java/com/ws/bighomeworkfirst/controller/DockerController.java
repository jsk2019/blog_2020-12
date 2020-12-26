package com.ws.bighomeworkfirst.controller;

import com.ws.bighomeworkfirst.domain.Code;
import com.ws.bighomeworkfirst.service.IDockerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/run")
public class DockerController {

    @Autowired
    private IDockerService dockerService;

    // 测试OK
    /**
     * 根据传来的code 创建Dockerfile
     * @param code
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String runCode(@RequestBody Code code){
        return dockerService.runCode(code);
    }

    //好像不需要了 因为容器是前台执行 返回命令结果 就是 执行结果 不是容器ID 先说明一下
    public String readResultLog(@PathVariable String containerId){
        return dockerService.readResultLog(containerId);
    }
}
