package com.ws.bighomeworkfirst.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {

    public static String writeFile(String content,String dir,String fileName){
        // 写文件
        File file =new File(dir+"/"+fileName);
        try (FileOutputStream fop = new FileOutputStream(file)) {
            // if file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            // get the content in bytes
            byte[] contentInBytes = content.getBytes();

            fop.write(contentInBytes);
            fop.flush();
            fop.close();
            System.out.println("write done");
        } catch (IOException e) {
            e.printStackTrace();
            return "write fail";
        }
        return "write done";
    }

    // 可以全部使用一个启动脚本 只是将镜像id作为参数传进去
    // 写入启动容器的sh脚本
    public static String writeRunFile(String dir,String image){
        String fileName="runContainer.sh";
        String content="";
        content+="#/bin/bash\n";
        content+="docker run "+image+"\n";

        return writeFile(content,dir,fileName);
    }

    //写代码文件
    public static String writeCodeFile(String dir,String type,String content){

        String fileName="";
        if(type.equals("C"))
            fileName="code.c";
        else if(type.equals("java"))
            fileName="code.java";
        else if(type.equals("python"))
            fileName="code.py";

        return writeFile(content,dir,fileName);
    }

    //写 dockerFile
    public static String writeDockerfile(String type,String dir){
        String fileName="Dockerfile";
        //传 type 获取对应内容
        String content=generateContentByType(type);
        return writeFile(content,dir,fileName);
    }

    // 根据type （语言类型） 返回Dockerfile内容
    public static String generateContentByType(String type){
        String content="";
        if(type.equals("C")){
            // 基础镜像
            content+="FROM gcc\n";
            // 拷贝代码文件
            content+="COPY ./code.c /usr/src/myapp/code.c\n";
            // 设置工作目录
            content+="WORKDIR /usr/src/myapp\n";
            // 编译代码文件
            content+="RUN gcc -o code.o code.c\n";
            // 设置启动命令
            content+="CMD [\"./code.o\"]\n";
        }
        else if(type.equals("java")){

        }else if(type.equals("python")){
            // 基础镜像
            content+="FROM python\n";
            // 拷贝代码文件
            content+="COPY ./code.py /usr/src/myapp/code.py\n";
            // 设置工作目录
            content+="WORKDIR /usr/src/myapp\n";
            // 编译代码文件
            content+="RUN [\"chmod\",\"777\",\"/usr/src/myapp/code.py\"]\n";
            // 设置启动命令
            content+="CMD [\"python\",\"./code.py\"]\n";

        }
        return content;
    }
/*
FROM python
COPY ./mypro.py /usr/myapp/mypro.py
WORKDIR /usr/myapp
RUN ["chmod","777","/usr/myapp/mypro.py"]
CMD ["./mypro.py"]

 */
    //先不管
    //写代码文件 这个。。。 post直接传 还是。。。

    //写run sh文件  写还是不写。。。

}
