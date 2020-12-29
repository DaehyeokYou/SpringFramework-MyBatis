package kr.co.ydh.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.ydh.hello.service.BbsService;
import kr.co.ydh.hello.vo.Article;

@Controller
// http://localhost:8080/springframwork-sample/bbs
@RequestMapping("/bbs")
public class BbsController {

	@Autowired
	private BbsService bbsService;
	/*
	// http://localhost:8080/springframwork-sample/bbs/write
	@RequestMapping("/write") // 따로 지정이 없으면 GET 방식 
	// parameter 처리 : @RequestParam 으로 처리 
	public String write(@RequestParam("author") String author) { // ~~/bbs/write?author=kim -- postman에서 prams에 author:kim 추가  
		bbsService.registArticle(new Article(3,"ydh","diary","hello spring framework by ydh"));
		System.out.println("GET Request..");
		return "write_ok"; // WEB-INF/views/write_ok.jsp 실행 
	}
	
	//POST 요청 
	@RequestMapping(value="/write", method=RequestMethod.POST)  
	public String doWrite() { 
		bbsService.registArticle(new Article(3,"ydh","diary","hello spring framework by ydh"));
		System.out.println("POST Request..");
		return "write_ok"; // WEB-INF/views/write_ok.jsp 실행 
	}
	*/
	
	/*
	//어노테이션 적용 @GetMapping, @PostMapping
	@GetMapping("/{articleId}")
	// URL Path Variable 처리 : 중괄호와 @PathVariable로 처리 
	public String viewDetail(@PathVariable String articleId) {  // ~~/bbs/27
		System.out.println("article ID : " + articleId);
		
		return "write_ok";
	}
	*/
	/*
	@GetMapping("/write")
	public String write() { 
		bbsService.registArticle(new Article(4,"ydh","ydh","ydh"));
		return "write_ok"; // WEB-INF/views/write_ok.jsp 실행 
	}
	
	@PostMapping(value="/write")  
	public String doWrite(Article article) { // POST 방식이므로, postman에서 body에 x-www-form~~에 추가 
		bbsService.registArticle(article);
		return "write_ok"; // WEB-INF/views/write_ok.jsp 실행 
	}
	*/
	
	/*
	// ModelAndView 사용 
	@PostMapping("/write")  
	public ModelAndView doWrite(Article article) { // POST 방식이므로, postman에서 body에 x-www-form~~에 추가 
		bbsService.registArticle(article);
		System.out.println("POST Request..");
		return new ModelAndView("write_ok").addObject("article", article); // WEB-INF/views/write_ok.jsp 실행 
	}
	*/
	
	// REST API 
	/*
	@GetMapping("/{articleId}")
	@ResponseBody // 객체를 JSON 타입으로 반환함. Jackson Dependency 추가. 
	public Article viewDetail(@PathVariable String articleId) {
		Article article = this.bbsService.viewArticleDetail(articleId);
		return article;
	}
	@PostMapping("/write")  
	@ResponseBody
	public Article doWrite(@RequestBody Article article) { // POST 방식이므로, postman에서 body에 x-www-form~~에 추가 
		Article art = article;
		return art; // WEB-INF/views/write_ok.jsp 실행 
	}
	*/
	@GetMapping("/write")
	public ModelAndView write() { 
		Article article = new Article(4,"ydh","ydh","ydh");
		bbsService.registArticle(article);
		return new ModelAndView("write_ok").addObject("article", article); 
	}
	
	@PostMapping(value="/write")  
	public ModelAndView doWrite(Article article) { // POST 방식이므로, postman에서 body에 x-www-form~~에 추가 
		bbsService.registArticle(article);
		return new ModelAndView("write_ok").addObject("article", article);
	}
	
	@GetMapping("/{articleId}")  
	public ModelAndView viewArticleById(@PathVariable String articleId) { // POST 방식이므로, postman에서 body에 x-www-form~~에 추가 
		Article article = bbsService.viewArticleDetail(articleId);
		return new ModelAndView("write_ok").addObject("article", article); // WEB-INF/views/write_ok.jsp 실행 
	}
	
	// static resource 처리 
	@GetMapping("")
	public String index() {
		return "index";
	}
	
}
