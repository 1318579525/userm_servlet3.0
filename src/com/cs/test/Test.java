package com.cs.test;

import com.cs.dao.impl.UserDaoImpl;
import com.cs.entity.User;
import com.cs.util.PageSupport;

import java.sql.SQLOutput;
import java.util.List;

public class Test {

    public static void main(String[] args) throws Exception {
        UserDaoImpl udi=new UserDaoImpl();
        PageSupport ps=new PageSupport();
        ps.setPageSize(3);
        ps.setCurrentPageNo(1);
        ps.setTotalCount(udi.findByCountUser());
        System.out.println("总页数为："+ps.getTotalPageCount());
        System.out.println("总记录数为："+ps.getTotalCount());
        System.out.println("当前页码为："+ps.getCurrentPageNo());
        List<User> list=udi.findByPageUserInfo(ps.getCurrentPageNo(),ps.getPageSize());
        for(User u:list){
            System.out.println(u.getUsername()+" "+u.getPassword());
        }
    }
}
