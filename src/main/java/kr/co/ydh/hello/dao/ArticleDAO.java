package kr.co.ydh.hello.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.ydh.hello.vo.Article;

@Repository
public class ArticleDAO {
	/*
	public void insertArticle(Article article) {
		System.out.println("Insert " + article.toString());
	}

	public Article selectArticleById(String articleId) {
		Article article = new Article(10, "lee", "hi", "bye");
		return article;
	}
	*/
	
	@Autowired
	SqlSession sqlSession;
	
	public void insertArticle(Article article) {
		sqlSession.insert(
				"mappers.article-mapper.insertArticle", article);
	}

	public Article selectArticleById(String articleId) {
		return sqlSession.selectOne("mappers.article-mapper.selectArticleById", articleId);
	}
}
