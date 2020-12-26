.bighomeworkfirst.controller;

import com.ws.bighomeworkfirst.domain.Article;
import com.ws.bighomeworkfirst.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;package com.ws

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    /**
     * 提交博文
     * @param article
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String commitArticle(@RequestBody Article article){
        return articleService.commitArticle(article);
    }

    /**
     * 查询所有 博文
     * @return
     */
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Article> getAllArticle(){
        return articleService.getAllArticle();
    }

    /**
     *
     * @param articleId
     * @return
     */
    @RequestMapping(value = "/{articleId}",method = RequestMethod.GET)
    public Article getArticleByArticleId(@PathVariable Integer articleId){
        return articleService.getArticleByArticleId(articleId);
    }


    /**
     * 分页查询 博文
     * @param
     * @param num
     * @return
     */
    @RequestMapping(value = "/paged/{pageNow}/{num}",method = RequestMethod.GET)
    public List<Article> getAticlePaged(@PathVariable Integer pageNow,@PathVariable Integer num){
        return articleService.getArticlePaged(pageNow,num);
    }

    /**
     * 标题模糊查询 博文
     * @param keyWord
     * @return
     */
    @RequestMapping("/title/{keyWord}")
    public List<Article> getArticleTitleVague(@PathVariable String keyWord){
        return articleService.getArticleTitleVague(keyWord);
    }

    /**
     * 内容模糊查询 博文
     * @param keyWord
     * @return
     */
    @RequestMapping("/content/{keyWord}")
    public List<Article> getArticleContentVague(@PathVariable String keyWord){
        return articleService.getArticleContentVague(keyWord);
    }

    @RequestMapping(value = "/{articleId}",method = RequestMethod.DELETE)
    public String deleteArticleByArticleId(@PathVariable Integer articleId){
        return articleService.deleteArticleByArticleId(articleId);
    }

    @RequestMapping(value = "/test/views/{articleId}",method = RequestMethod.GET)
    public  String increaseViews(@PathVariable Integer articleId){
        return articleService.increaseViewsByArticleId(articleId);
    }

    @RequestMapping(value = "/test/setviews/{articleId}/{num}",method = RequestMethod.GET)
    public String setViews(@PathVariable Integer articleId,@PathVariable Integer num) throws Exception {
        return articleService.setArticleViewsByArticleId(articleId,num);
    }

    @RequestMapping(value = "/commit",method = RequestMethod.PUT)
    public String commitArticleByPut(@RequestBody Article article){
        return articleService.commitArticle(article);
    }

    @RequestMapping(value = "/",method = RequestMethod.PUT)
    public String changeArticle(@RequestBody Article article){
        return articleService.changeArticle(article);
    }

    @RequestMapping(value = "/totalNum",method = RequestMethod.GET)
    public Integer getTotalNum(){
        return articleService.getTotalNum();
    }

    @RequestMapping(value = "/search/{keyWord}",method = RequestMethod.GET)
    public List<Article> getArticleBySearch(@PathVariable String keyWord){
        return articleService.getArticleBySearch(keyWord);
    }
}
