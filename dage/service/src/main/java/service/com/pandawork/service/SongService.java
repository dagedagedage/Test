package com.pandawork.service;

import com.pandawork.common.entity.song;
import com.pandawork.core.common.exception.SSException;

import java.util.List;

public interface SongService {
    /**
     * 列出所有歌曲hahahaah
     * @return
     * @throws SSException
     */
    public List<song> listAllSong() throws SSException;

    /**
     * 增加歌曲
     * @throws SSException
     */
    public void addSong(song song) throws SSException;

    /**
     * 删除歌曲
     * @return
     * @throws Exception
     */
    public boolean deleteSong(int id) throws SSException;

    /**
     * 修改歌曲
     * @throws SSException
     */
    public void updateSong(song song) throws SSException;

    /**
     * 搜索歌曲
     * @return
     * @throws Exception
     */
    public List<song> searchSong(String search) throws SSException;

    /**
     * 得到歌曲
     * @return
     * @throws SSException
     */
    public song getSong(int id) throws SSException;
}
