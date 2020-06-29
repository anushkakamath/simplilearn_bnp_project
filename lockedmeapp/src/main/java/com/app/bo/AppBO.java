package com.app.bo;
import com.app.exception.BusinessException;

//import java.util.List;

import com.app.model.User;

public interface AppBO {
	
	public void getAllFiles();
	public void getFilesByName(String name, String username);
	public User createFiles(User user, String username);
	public void removeFileByName(String name, String username);

}
