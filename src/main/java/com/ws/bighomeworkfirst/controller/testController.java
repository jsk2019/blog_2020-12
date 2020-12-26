package com.ws.bighomeworkfirst.controller;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import com.ws.bighomeworkfirst.util.DockerUtil;
import com.ws.bighomeworkfirst.util.FileUtil;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/run")
public class testController {
    /*// 暂时可以 启动容器
    @RequestMapping(value = "/container",method = RequestMethod.GET)
    public String run(){
        return new DockerUtil().startContainer();
    }
*/
    /**
     * 测试创建镜像 暂时可以
     * @return
     */
    @RequestMapping(value = "/buildim",method = RequestMethod.GET)
    public String build(){
        return new DockerUtil().BuildImageFromDockerfile("/root/tryDockerfile","mycpp");
    }

    /**
     * 测试写Dockerfile 暂时可以
     * @return
     */
    /*@RequestMapping(value = "/writedockerfile",method = RequestMethod.GET)
    public String writeDockerfile(){
        return new FileUtil().writeDockerfile("/root/tryWriteDockerfile");
    }*/

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        System.out.println("hello");
        return "Hello";
    }
}
