package com.example.networkrepair2.mapper;

import com.example.networkrepair2.pojo.NoticeList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Lm
* @description 针对表【notice_list(公告列表)】的数据库操作Mapper
* @createDate 2022-03-02 17:41:12
* @Entity com.example.networkrepair2.pojo.NoticeList
*/

@Mapper
public interface NoticeListMapper extends BaseMapper<NoticeList> {

}




