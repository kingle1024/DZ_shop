package com.dz.shop.service;

import com.dz.shop.Page.PageUtil;
import com.dz.shop.entity.MemberVO;

import java.util.Map;

public interface MemberService {
	PageUtil pageUtil(String search, String pageIndex, String type);
	MemberVO login(MemberVO memberVO);
	MemberVO dupUidaCheck(String id);
	MemberVO findByUserId(String userId);
	long insert(MemberVO member);
	long edit(Map<String, Object> map);
}