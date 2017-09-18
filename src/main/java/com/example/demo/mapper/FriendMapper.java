package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.example.demo.bean.Friend;
public interface FriendMapper {
    
	List<Map<String,String>> getFriendUnionCompanyInfo(@Param("fname")String fname);

	List<Friend> getAllFriend();
	
	List<Map<String,Object>> getAllFriendResultMap();
	
    int deleteByPrimaryKey(Integer fid);

    int insert(Friend record);

    int insertSelective(Friend record);

}