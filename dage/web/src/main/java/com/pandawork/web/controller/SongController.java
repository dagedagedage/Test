package com.pandawork.web.controller;

import com.pandawork.common.entity.song;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.service.SongService;
import com.pandawork.web.spring.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collections;
import java.util.List;


/**
 * 歌曲管理系统
 */
@Controller
@RequestMapping("")
public class SongController extends AbstractController {

    @Autowired
    SongService songService;

    @RequestMapping("/song")
    public String listAllSong(Model model) {
        try {
            List<song> list = Collections.emptyList();
            list = songService.listAllSong();
            model.addAttribute("songList", list);
            return "home";
        } catch (SSException e) {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "add_do";
    }

    @RequestMapping(value = "/addSong",method = RequestMethod.POST)
    public String addSong(song song,RedirectAttributes redirectAttributes){
        try {
            songService.addSong(song);
            redirectAttributes.addFlashAttribute("message", "添加成功！");
            return "redirect:/song";
        } catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    @RequestMapping(value = "deleteSong/{id}",method = RequestMethod.GET)
    public String deleteSong(@PathVariable("id") int id){
        try {
            songService.deleteSong(id);
            return "redirect:/song";
        } catch (SSException e) {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    @RequestMapping(value = "/toUpdate/{id}",method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") int id, RedirectAttributes redirectAttributes,Model model){
        try{
            redirectAttributes.addAttribute("id", id);
            model.addAttribute("song",songService.getSong(id));
//            redirectAttributes.addAttribute("song",songService.getSong(id));
            return "update_do";
        }catch (Exception e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    @RequestMapping(value = "updateSong/{id}", method = RequestMethod.POST)
    public String updateSong(song song, @PathVariable("id") int id) {
        try {
            songService.updateSong(song);
            return "redirect:/song";
        } catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    @RequestMapping(value = "searchSong",method = RequestMethod.POST)
    public String searchSong(Model model,@RequestParam("search") String search){
        try {
            List<song> list = Collections.emptyList();
            list = songService.searchSong(search);
            model.addAttribute("songList", list);
            return "searchResult";
        } catch (SSException e ){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }
}
