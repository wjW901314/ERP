package com.wd.erp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wd.erp.mapper.UserInfoMapper;
import com.wd.erp.model.UserInfo;
import com.wd.erp.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoMapper userMapper;//这里会报错，但是并不会影响

    @Override
    public int addUser(UserInfo user) {
        int insert = userMapper.insert(user);
        return insert;

    }

    /*
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
    @Override
    public PageInfo<UserInfo> findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<UserInfo> userDomains = userMapper.selectUsers();
        PageInfo result = new PageInfo(userDomains);
        return result;
    }

    @Override
    public boolean getUserInfo(int userCode,String userPwd) {
        UserInfo userInfo = userMapper.selectByPrimaryKey(userCode);
        if(userInfo != null){
            if(userInfo.getUserPwd().equals(userPwd))
                return true;
            else
                return false;
        }
        else
            return false;
    }
}
