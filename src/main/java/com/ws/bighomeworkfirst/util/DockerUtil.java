package com.ws.bighomeworkfirst.util;

import com.spotify.docker.client.LogStream;
import com.spotify.docker.client.exceptions.DockerException;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicReference;

import static com.spotify.docker.client.DockerClient.LogsParam.stderr;
import static com.spotify.docker.client.DockerClient.LogsParam.stdout;

public class   DockerUtil {

    // 训练相关的根路径 这个 还是作为 dockerService 的私有变量吧
    //private String rootPath="/root/unitFilePath";

    /**
     * 根据Dockerfile创建镜像
     * @param dockerDirectory
     * @param fileName
     * @return 返回值不为failed 表示创建成功
     */
    public static String BuildImageFromDockerfile(String dockerDirectory,String fileName){
        //dockerDirectory="/root/tryDockerfile";
        // 指定镜像名称
        //fileName="myacpp";
        String retMessage="failed";
        Paths.get(dockerDirectory);
        //System.out.println("目前可以");
        AtomicReference<String> imageIdFromMessage = new AtomicReference<>();
        try{
            retMessage= DockerClientConfig.Docker().build(
                    Paths.get(dockerDirectory),fileName,message -> {
                        //System.out.println("目前可以");
                        final String imageId=message.buildImageId();
                        if(imageId!=null){
                            imageIdFromMessage.set(imageId);
                        }
                    });
        }catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DockerException e) {
            e.printStackTrace();
        }
        return retMessage;
    }

    /**
     * sh脚本启动 暂时可以
     * @return
     */
    // 我还是想走shell执行run
    public static String startContainer(String cmd){

        //执行sh 获取容器Id
        //返回 containerId前面部分
        String containerId= CommandUtil.execCmd(cmd);

        return containerId;
    }

    // 读取结果日志
    public static String readResultLog(String containId){
        String log="";
        try(LogStream stream=DockerClientConfig.Docker().logs(containId,stdout(),stderr())){
            log=stream.readFully();
        }catch (InterruptedException | DockerException ex){
            ex.printStackTrace();
            log="读取结果失败";
            return log;
        }

        return log;
    }
    // 获取 容器日志 相当于返回运行结果

    // 检测容器是否运行结束？ （简单的运行 其实可以 隔1s 就查结果 就好 不用查运行状态

    // 删除 容器

    // 删除 镜像

    // 删除 代码文件

    // 可能还得 删数据库数据 不归这部分管
}
