package com.pchome.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pchome.Entity.Member;
import com.pchome.Entity.Message;
import com.pchome.Entity.ReplyMessage;
import com.pchome.Service.ForumService;
import com.pchome.Service.ReplyService;

@Controller
@RequestMapping("/forum")
public class ForumController {

	@Autowired
	ForumService forumService;
	@Autowired
	ReplyService replyService;
	//新增主題
	@RequestMapping(value="/addmessage",method = RequestMethod.POST)
	public String addMessage(@ModelAttribute("messageform") Message message) {
		forumService.addMessage(message);
		return "redirect:/forum";
	}
	
	/**
	 * 點選主題進入留言
	 */
	@RequestMapping(value="/{messageno}",method=RequestMethod.GET)
	public String linkMessage(@PathVariable String messageno,Map<String,Object> map
			,HttpSession session) {
		Member membersession = (Member) session.getAttribute("LoginOK");
		map.put("memberbean", membersession);
		Message message = forumService.linkMessage(messageno);
		map.put("linkmessage",message);
		List<ReplyMessage> replylist = replyService.findbyMessageNo(Integer.parseInt(messageno));
		map.put("replymessage", replylist);
		return "forum/forumMessage";
	}
	
	/**
	 * 回覆留言
	 */
	@RequestMapping(value="/reply",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> replyMsg(@RequestParam("msgData") String msg,//取得回覆的訊息
									   @RequestParam("msgNo") String msgid,//取得要回覆的主題
									   HttpSession session) {
		Member membersession = (Member) session.getAttribute("LoginOK");  // 取得回覆人的帳號
		Map<String,Object> map = new HashMap<String, Object>();
		ReplyMessage replyMsgAdded = replyService.addReplyMsg(msg, membersession.getMemberid(), Integer.parseInt(msgid));
		map.put("replyMsgAdded", replyMsgAdded);
		return map;
	}
	
	@RequestMapping(value="/delmsg",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> delMsg(@RequestParam("msgData") String msg,//取得回覆的訊息
			  						 @RequestParam("msgNo") String msgid,//取得要回覆的主題
								     HttpSession session){
		Member membersession = (Member) session.getAttribute("LoginOK");  // 取得回覆人的帳號
		Map<String,Object> map = new HashMap<String, Object>();
		return map;
	}
}
