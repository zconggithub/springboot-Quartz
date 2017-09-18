package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.example.demo.bean.Friend;

public interface FriendService {
	
	List<Map<String,String>> getFriendUnionCompanyInfo(@Param("fname")String fname);

	List<Friend> getAllFriend();
	
	List<Map<String,Object>> getAllFriendResultMap();
}
