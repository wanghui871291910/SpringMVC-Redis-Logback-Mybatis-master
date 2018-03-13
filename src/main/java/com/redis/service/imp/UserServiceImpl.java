package com.redis.service.imp;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.redis.dao.UserMapper;
import com.redis.domain.User;
import com.redis.service.IUserService;

/**
 * userService
 * 
 * �������˵�������еĲ�ѯ������Ž��˻��棬Ҳ���ǰ�MySQL��ѯ�Ľ���ŵ���redis��ȥ��
 * Ȼ��ڶ��η��������ѯʱ�Ϳ��Դ�redis��ȥ��ȡ��ѯ�Ľ�����Ӷ�����MySQL�������Ӷ��ﵽ�Ż���Ч����
 * redis�Ĳ�ѯ�ٶ�֮��MySQL�Ĳ�ѯ�ٶ��൱�� �ڴ��д�ٶ� /Ӳ�̶�д�ٶ� 
 * @Cacheable("a")ע���������ǰѸ÷����Ĳ�ѯ����ŵ�redis��ȥ����һ���ٷ����ѯ��ȥredis��ȥȡ������redis�е����ݵ�key����a��
 * @CacheEvict(value={"a","b"},allEntries=true) ����˼����ִ�и÷�����Ҫ���redis��key����Ϊa,b�����ݣ�
 */
@Service("userService")
@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)  
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper iUserDao;

    @Cacheable("getUserById") //��ע�÷�����ѯ�Ľ�����뻺�棬�ٴη���ʱֱ�Ӷ�ȡ�����е�����
    @Override
    public User getUserById(int userId) {
        return this.iUserDao.selectByPrimaryKey(userId);
    }

    @Cacheable("getAllUser")
    @Override
    public List<User> getAllUser() {
        return this.iUserDao.selectAllUser();
    }

    @CacheEvict(value= {"getAllUser","getUserById","findUsers"},allEntries=true)//��ջ��棬allEntries������ʾ���ж���Ļ��涼���
    @Override
    public void insertUser(User user) {
        this.iUserDao.insertUser(user);
    }

    @CacheEvict(value= {"getAllUser","getUserById","findUsers"},allEntries=true)
    @Override
    public void deleteUser(int id) {
        this.iUserDao.deleteUser(id);
    }

    @Cacheable("findUsers")
    @Override
    public List<User> findUsers(String keyWords) {
        return iUserDao.findUsers(keyWords);
    }

    @CacheEvict(value= {"getAllUser","getUserById","findUsers"},allEntries=true)
    @Override
    public void editUser(User user) {
        this.iUserDao.editUser(user);
    }
}
