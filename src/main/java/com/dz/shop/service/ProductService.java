package com.dz.shop.service;

import com.dz.shop.Page.PageUtil;
import com.dz.shop.entity.BoardFile;
import com.dz.shop.entity.ProductVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface ProductService {
    PageUtil pageUtil(String search, String pageIndex, String type);
    long add(Map<String, Object> map);
    ProductVO getProduct(String no);
    long edit(Map<String, Object> map);
    void fileAdd(String no, Map<String, MultipartFile> fileMap);
    List<BoardFile> fileList(String number);
    BoardFile getBoardFile(String f_id);
    long del(Map<String, Object> map);
}
