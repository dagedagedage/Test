package com.pandawork.test;

import com.pandawork.common.entity.song;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.service.SongService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 歌曲测试系统
 * 测试Service页面
 * SongService
 */

public class SongServiceTest extends AbstractTestCase {
    @Autowired
    SongService songService;

    //测试列出所有歌曲
    @Test
    public void testListAllSong() throws SSException {
        System.out.print(songService.listAllSong());
    }

    //测试增加歌曲
    @Test
    public void testAddSong() throws SSException {
        song song = new song();
        song.setName("儿子娃娃(LIVE)");
        song.setBelonging("中国新说唱");
        song.setSinger("那吾克热");
        songService.addSong(song);
    }

    //删除歌曲
    @Test
    public void testDeleteSong() throws SSException {
        int id = 41;
        System.out.println(songService.deleteSong(id));
    }

    //测试修改歌曲信息
    @Test
    public void testUpdateSong() throws SSException {
        song song = new song();
        song.setId(35);
        song.setName("哈哈哈");
        song.setBelonging("嘿嘿嘿");
        song.setSinger("吼吼吼");
        songService.updateSong(song);
    }

    //测试搜索歌曲
    @Test
    public void testSearchSong() throws SSException {
        String search = "1";
        System.out.println(songService.searchSong(search));
    }

    //测试得到歌曲
    @Test
    public void testGetSong() throws SSException {
        int id = 42;
        System.out.println(songService.getSong(id));
    }
}
