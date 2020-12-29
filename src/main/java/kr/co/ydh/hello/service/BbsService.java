package kr.co.ydh.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ydh.hello.dao.ArticleDAO;
import kr.co.ydh.hello.vo.Article;

@Service
public class BbsService {

	// context:component-scan을 통해 setter or 생성자로서 class를 생성하는 것이 아니라
	// @autowired 어노테이션으로 자동으로 사용할 수 있음.
	@Autowired
	private ArticleDAO articleDAO;
	
	
	public BbsService(ArticleDAO dao) {
		this.articleDAO = dao;
	}
	
	public void registArticle(Article article) {
		articleDAO.insertArticle(article);
	}

	public Article viewArticleDetail(String articleId) {
		return articleDAO.selectArticleById(articleId);
	}
	
}
