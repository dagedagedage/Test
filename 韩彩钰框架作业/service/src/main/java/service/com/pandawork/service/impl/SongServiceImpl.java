package com.pandawork.service.impl;

import com.pandawork.common.entity.song;
import com.pandawork.common.utils.NFException;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.mapper.SongMapper;
import com.pandawork.service.SongService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

@Service("songService")
public class SongServiceImpl implements SongService {
    @Autowired
    SongMapper songMapper;

    @Override
    public List<song> listAllSong( ) throws SSException{
        List<song> songList = Collections.emptyList();
        try {
            songList = songMapper.listAllSong();
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.ListStudentAll, e);
        }
        return songList;
    }

    @Override
    public void addSong(song song) throws SSException{
        try {
            songMapper.addSong(song);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    public boolean deleteSong(int id) throws SSException{
        try {
            return songMapper.deleteSong(id);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.DelStudentNull, e);
        }
    }

    @Override
    public void updateSong(song song) throws SSException{
        try {
            songMapper.updateSong(song);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.UpdateStudentFailed, e);
        }
    }

    @Override
    public List<song> searchSong(String search) throws SSException{
        List<song> songList = Collections.emptyList();
        try {
            songList = songMapper.searchSong(search);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.ListStudentAll, e);
        }
        return songList;
    }

    @Override
    public song getSong(int id) throws SSException{
        try {
            return songMapper.getSong(id);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.queryStudentByIdFailed, e);
        }
    }

//    @Override
//    public List<song> listAllSong() throws SSException {
//        InputStream in = null;
//        List<song> list = null;
//        SongMapper songMapper = null;
//        //加载Mybatis配置文件
//        try {
//            in = Resources.getResourceAsStream("testmybatis.xml");
//            //根据相关的mybatis配置文件， 创建连接SQLSessionFactory连接对象
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//            //创建出SQLSession对象
//            SqlSession sqlSeesion = factory.openSession();
//            //通过sqlSession取到映射接口
//            songMapper = sqlSeesion.getMapper(SongMapper.class);
//            list = songMapper.listAllSong();
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//        return list;
//    }
}


