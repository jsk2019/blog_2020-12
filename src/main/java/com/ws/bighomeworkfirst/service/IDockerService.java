package com.ws.bighomeworkfirst.service;

import com.ws.bighomeworkfirst.domain.Code;

public interface IDockerService {

    String createDockerImage(Code code);

    String runCode(Code code);

    String readResultLog(String containerId);
}
