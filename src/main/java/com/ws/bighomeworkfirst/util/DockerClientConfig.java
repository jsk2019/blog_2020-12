package com.ws.bighomeworkfirst.util;

import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerClient;

import java.net.URI;

/**
 * Docker连接类
 */
public class DockerClientConfig {
    public static DockerClient Docker(){
        return DefaultDockerClient.builder().uri(URI.create("http://localhost:2375")).build();
    }
}
