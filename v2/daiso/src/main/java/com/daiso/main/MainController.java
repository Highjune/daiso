package com.daiso.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.daiso.service.BoardService;
import com.daiso.service.MemberService;
import com.daiso.service.ProductService;
import com.daiso.vo.BoardVO;
import com.daiso.vo.MemberVO;
import com.daiso.vo.ProductVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MainController {
	@Autowired
	private BoardService boardService;

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login"; // templates/login.html
	}

	// 게시판 모든 글 보기
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String selectAllBoard(Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		this.boardService.selectAllBoards(map);
		// 들고온 것 list에 다 담기
		List<BoardVO> list = (List<BoardVO>) map.get("results");
		model.addAttribute("code", "success");
		model.addAttribute("datas", list); // board.html의 타임리프에서 쓰는 "datas"
		return "board"; // templates/board.html
	}

	// 게시판 1개 글 상세보기(boarddetail)
	@GetMapping("/board/{b_num}")
	public String selectOneBoard(@PathVariable("b_num") int b_num, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("b_num", b_num);
		this.boardService.selectBoard(map);
		Map<String, Object> mapping = (Map<String, Object>) map.get("selectOneResult");
		model.addAttribute("code", "success");
		model.addAttribute("datas", mapping); // boarddetail.html의 타임리프에서 쓰는 "datas"
		return "boarddetail";
	}

	// 회원가입 페이지 정보입력시
//	@RequestMapping(value = "/register", method = RequestMethod.GET)
	@GetMapping("/register")
	public String getRegister() {
		return "register"; // templates/register.html
	}

	// 회원가입 정보 입력 후 전송
//	@RequestMapping(value = "/reigster", method = RequestMethod.POST)
	@PostMapping("/register")
	public String postRegister(MemberVO member) {
		this.memberService.insertMember(member);
		return "redirect:/"; // templates/register.html
	}

	// 게시판 글 삭제
	@GetMapping("/delete/{b_num}")
	public String boarddelete(@PathVariable("b_num") int b_num) {
//		System.out.println("----------------------delete의 b_nm-----------------------");
//		log.info("b_num = " + b_num);
		this.boardService.deleteBoard(b_num);
		return "redirect:/board";
	}

	// 게시판 글 수정
	@GetMapping("/update/{b_num}")
	public String boardupdate(@PathVariable("b_num") int b_num, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("b_num", b_num);
		this.boardService.selectBoard(map);
		Map<String, Object> mapping = (Map<String, Object>) map.get("selectOneResult");
		model.addAttribute("code", "success");
		model.addAttribute("datas", mapping);
		return "boardupdate";
	}
	

	@PutMapping("/boarddetail")
	public String boardupdate(HttpServletRequest http) {
		BoardVO vo = new BoardVO();

//		log.info("디버그 = " + (String)http.getParameter("p_image"));
//		log.info(http.getParameter("m_userid"));
//		log.info(http.getParameter("b_title"));
//		log.info(http.getParameter("b_writing"));
//		log.info(http.getParameter("b_num"));
//		log.info(http.getParameter("p_productid"));		

		vo.setM_userid(http.getParameter("m_userid"));
		vo.setB_title(http.getParameter("b_title"));
		vo.setB_writing(http.getParameter("b_writing"));

		int b_num = Integer.parseInt(http.getParameter("b_num"));
		vo.setB_num(b_num);
		int p_productid = Integer.parseInt(http.getParameter("p_productid"));
		vo.setP_productid(p_productid);

		this.boardService.updateBoard(vo);
		return "redirect:/board";
	}

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/logout")
	public String logout() {
		return "logout"; // templates/logout.html
	}

	// 게시판 글쓰기 화면(원래)
//	@GetMapping("/boardwrite")
//	public String getboardwrite() {
//		return "boardwrite"; // templates/boardwrite2.html
//	}

	// 게시판 글쓰기 화면(모달)
	@GetMapping("/boardwrite2")
	public String getboardwrite() {
		return "boardwrite2"; // templates/boardwrite2.html
	}

	// 게시판 글쓰기(원래)
//	@PostMapping("/board")
//	@ResponseBody
//	public Map sendwrite(@RequestBody BoardVO board) {
//		this.boardService.insertBoard(board);
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("code", "success");
//		return map;
//	}

	// 게시판 글쓰기
	@PostMapping("/board")
	public String writeprocess(HttpServletRequest http) {
		BoardVO vo = new BoardVO();
//		logger.info("디버그 = " + http.getUserPrincipal().getName());
		vo.setM_userid(http.getUserPrincipal().getName());
		vo.setB_title((String) http.getParameter("title"));
		vo.setB_writing((String) http.getParameter("content"));
		vo.setP_productid(productService.selectProductId((String) http.getParameter("image")));
		boardService.insertBoard(vo);
		return "redirect:/board";
	}
}
