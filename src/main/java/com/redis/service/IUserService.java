package com.redis.service;

import java.util.List;

import com.redis.domain.User;

/**
 * user��Ĳ����ӿ�
 * @author YaoQi
 */
public interface IUserService {

    /**
     * ͨ��id��ѯuser�ӿڷ���
     * @param userId
     * @return
     */
     public User getUserById(int userId);  
     
     /**
      * ��ѯ���е�user
      * @return ����userList
      */
     public List<User> getAllUser();
     
     /**
      * ���һ��user
      * @param user
      */
     public void insertUser(User user);
     
     /**
      * ͨ��IDɾ���û�
      * @param id
      */
     public void deleteUser(int id);
     
     /**
      * ͨ���ؼ��ֲ�ѯ�û�
      * @param keyWords
      * @return
      */
     public List<User> findUsers(String keyWords);
     
     /**
      * �����û�
      * @param user
      */
     public void editUser(User user);
}
