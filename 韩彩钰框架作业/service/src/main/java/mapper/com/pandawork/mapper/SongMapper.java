package com.pandawork.mapper;

import com.pandawork.common.entity.song;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SongMapper {
    /**
     * 列出所有歌曲
     * @return
     * @throws Exception
     */
    public List<song> listAllSong() throws Exception;

    /**
     * 增加歌曲
     * @param song
     * @throws Exception
     */
    public void addSong(@Param("song") song song) throws Exception;

    /**
     * 删除歌曲
     * @param id
     * @return
     * @throws Exception
     */
    public boolean deleteSong(@Param("id") int id) throws Exception;

    /**
     * 修改歌曲信息
     * @param song
     * @throws Exception
     */
    public void updateSong(@Param("song") song song) throws Exception;

    /**
     * 搜索歌曲
     * @param search
     * @return
     * @throws Exception
     */
    public List<song> searchSong(@Param("search") String search) throws Exception;

    /**
     * 得到歌曲
     * @param id
     * @return
     * @throws Exception
     */
    public song getSong(@Param("id") int id) throws Exception;
}
