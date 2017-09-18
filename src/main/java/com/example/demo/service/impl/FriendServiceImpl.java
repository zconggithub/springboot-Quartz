package com.example.demo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.example.demo.bean.Friend;
import com.example.demo.common.CommonUtil;
import com.example.demo.mapper.FriendMapper;
import com.example.demo.service.FriendService;
@Service
public class FriendServiceImpl implements FriendService{

	@Autowired
	private FriendMapper firendMapper;

	@Override
	public List<Map<String, String>> getFriendUnionCompanyInfo(String fname) {
		// TODO Auto-generated method stub
		return firendMapper.getFriendUnionCompanyInfo(fname);
	}

	@Override
	public List<Friend> getAllFriend() {
		// TODO Auto-generated method stub
		List<Friend> listFriend=firendMapper.getAllFriend();
	String listData=CommonUtil.ListJudge(listFriend);
	List<Friend> list=	JSON.parseArray(listData, Friend.class);//JSON解析为list<T>
		return list;
	}

	@Override
	public List<Map<String, Object>> getAllFriendResultMap() {
		// TODO Auto-generated method stub
		List<Map<String, Object>> listData=firendMapper.getAllFriendResultMap();
	
			return listData;
	}

	
}
