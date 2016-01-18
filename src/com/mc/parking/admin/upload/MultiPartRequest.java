package com.mc.parking.admin.upload;

import java.io.File;
import java.util.Map;

/**
 * @author ZhiCheng Guo
 * @version 2014�?10�?7�? 上午11:04:36
 */
public interface MultiPartRequest {

    public void addFileUpload(String param,File file); 
    
    public void addStringUpload(String param,String content); 
    
    public Map<String,File> getFileUploads();
    
    public Map<String,String> getStringUploads(); 
}