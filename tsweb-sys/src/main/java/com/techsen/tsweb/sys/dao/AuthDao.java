package com.techsen.tsweb.sys.dao;

import java.util.List;

import com.techsen.tsweb.core.dao.Dao;
import com.techsen.tsweb.sys.domain.Auth;

public interface AuthDao extends Dao<Auth>{
    Auth getAuthByName(String authName);
    List<Auth> getAuthsByUsername(String username);
}
