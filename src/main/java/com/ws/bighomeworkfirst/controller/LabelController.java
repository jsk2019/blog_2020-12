package com.ws.bighomeworkfirst.controller;

import com.ws.bighomeworkfirst.domain.Article;
import com.ws.bighomeworkfirst.domain.Label;
import com.ws.bighomeworkfirst.service.ILabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/labels")
public class LabelController {

    @Autowired
    private ILabelService labelService;

    /**
     * 获取全部标签
     * @return
     */
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Label> getAllLabel(){
        return labelService.getAllLabel();
    }

    /**
     * 根据 标签id 获取全部博文
     * @param labelId
     * @return
     */
    @RequestMapping(value = "/id/{labelId}",method = RequestMethod.GET)
    public List<Article> getArticlesByLabelId(@PathVariable Integer labelId){
        return labelService.getArticlesByLabelId(labelId);
    }

    /**
     * 根据 标签title 获取全部博文
     * @param labelTitle
     * @return
     */
    @RequestMapping(value = "/title/{labelTitle}",method = RequestMethod.GET)
    public List<Article> getArticlesByLabelId(@PathVariable String labelTitle){
        return labelService.getArticlesByLabelTitle(labelTitle);
    }
    @RequestMapping(value = "/getNum",method = RequestMethod.GET)
    public Integer getLabelNum(){
        return labelService.getLabelNum();
    }

    @RequestMapping(value = "/paged/{pageNow}/{num}",method = RequestMethod.GET)
    public List<Label> getLabelPaged(@PathVariable Integer pageNow,@PathVariable Integer num){
        return labelService.getLabelPaged(pageNow,num);
    }


    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String commitLabel(@RequestBody Label label){
        return labelService.commitLabel(label);
    }

    /**
     * 根据标签名字获取博客数
     * @param labelName
     * @return
     */
    @RequestMapping(value = "/each/{labelName}",method = RequestMethod.GET)
    public Integer getNumByName(@PathVariable String labelName){
        return labelService.getNumByName(labelName);
    }
}
