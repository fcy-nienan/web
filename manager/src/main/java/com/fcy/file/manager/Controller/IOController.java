package com.fcy.file.manager.Controller;

import com.fcy.file.manager.VO.ResponseVO;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.PasswordAuthentication;
import java.net.URLEncoder;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
@Controller
@RequestMapping("/file")
public class IOController {
    private static Logger logger = Logger.getLogger(IOController.class.getName());
    @RequestMapping(value="/getFileInfo",method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO getFileInfo(@RequestParam("path")String path){
        PasswordAuthentication passwordAuthentication;
        File file=new File(path);
        if (file.exists()&&file.isDirectory()){
            return ResponseVO.success().data(file.list());
        }else{
            return ResponseVO.warning().msg("不合法的路径!");
        }
    }
    @RequestMapping(value="/upload", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO upload(@RequestParam("file")MultipartFile file,
                         @RequestParam("path")String path,
                         HttpServletRequest request) {
        String originalFilename = file.getOriginalFilename();
        File newFile=new File(path+originalFilename);
        if(newFile.exists()){
            return ResponseVO.warning().msg("当前目录已存在该文件!");
        }
        int count=0;
        try {
            count=IOUtils.copy(file.getInputStream(), new FileOutputStream(newFile));
        }catch (Exception e){
            e.printStackTrace();
            logger.log(Level.WARNING,"上传文件时出错:"+count);
            return ResponseVO.error().msg("上传文件时出错!");
        }
        logger.info(new Date()+"-upload-"+path+file.getOriginalFilename());
        return ResponseVO.success();
    }
    @RequestMapping(value = "/download")
    public ResponseVO down(@RequestParam("name")String name,
                     @RequestParam("path")String path,
                     HttpServletResponse response){
        response.setContentType("application/force-download");// 设置强制下载不打开
        response.setHeader("content-type", "application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(name));
        File file=new File(path+name);
        if(!file.exists()){
            return ResponseVO.warning().msg("文件不存在!");
        }
        int count=0;
        try {
            count=IOUtils.copy(new FileInputStream(file), response.getOutputStream());
        }catch (Exception e){
            e.printStackTrace();
            logger.log(Level.WARNING,"下载文件时出错:"+count);
            return ResponseVO.error().msg("下载文件出错!");
        }
        logger.info(new Date()+"-download-"+path+name);
        return ResponseVO.success().msg("下载文件成功");
    }
}
