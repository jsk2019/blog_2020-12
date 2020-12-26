package com.ws.bighomeworkfirst.service.impl;

import com.ws.bighomeworkfirst.domain.Code;
import com.ws.bighomeworkfirst.service.IDockerService;
import com.ws.bighomeworkfirst.util.DockerUtil;
import com.ws.bighomeworkfirst.util.FileUtil;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;


@Service
public class DockerServiceImpl implements IDockerService {
    // 训练相关的根路径 这个 还是作为 dockerService 的私有变量吧
    private String rootPath="/root/unitFilePath";


    /**
     * 创建代码镜像
     * @param code
     * @return
     */
    @Override
    public String createDockerImage(Code code) {

        System.out.println("before");
        System.out.println(code.getContent());
        String str_code=code.getContent().replaceAll("↵","\n");
        //str_code=str_code.replaceAll("\"", "\\\\\"");
        code.setContent(str_code);
        System.out.println("after");
        System.out.println(str_code);
        // 获取时间戳 用于创建唯一文件夹
        String currentTimeString = ""+System.currentTimeMillis();

        String dir=rootPath+"/"+currentTimeString;

        // 当前路径不存在就创建 按道理就是不存在的
        File fileDir=new File(dir);
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }

        if(FileUtil.writeCodeFile(dir,code.getType(),code.getContent()).equals("write fail"))
            return "write codeFile fail";

        if(FileUtil.writeDockerfile(code.getType(),dir).equals("write fail"))
            return "write Dockerfile fail";

        return DockerUtil.BuildImageFromDockerfile(dir,"myapp"+currentTimeString);
    }

    /**
     * 创建镜像 启用容器运行代码
     * @param code
     * @return
     */
    @Override
    public String runCode(Code code) {
        String imageId=createDockerImage(code);
        if(imageId.equals("failed"))
            return "create image fail";

        String cmd="sh "+rootPath+"/runContainer.sh "+imageId;

        return DockerUtil.startContainer(cmd);
    }

    @Override
    public String readResultLog(String containerId){
        return DockerUtil.readResultLog(containerId);
    }
}
