package com.elegant.codes.web.controller;

import com.elegant.codes.common.annotation.DDLAnnotationScanner;
import com.elegant.codes.common.exception.ClientErrorCode;
import com.elegant.codes.common.exception.ClientException;
import com.elegant.codes.model.user.User;
import com.elegant.codes.service.user.TestService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@RestController
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestService testService;

    @ApiOperation("测试文件下载接口")
    @GetMapping(value = "/download")
    public void fileDownload(@RequestParam(name = "fileName", required = false) String fileName,
                             HttpServletRequest request,
                             HttpServletResponse response){

        try(FileInputStream fis = FileUtils.openInputStream(new File("D:\\tmp\\工作.xmind"));
            BufferedInputStream bis = new BufferedInputStream(fis);
            OutputStream os = response.getOutputStream();){
            response.setHeader("content-type", "application/octet-stream");
            response.setContentType("application/octet-stream");
            // 下载文件能正常显示中文
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("工作.xmind", "UTF-8"));
            // 实现文件下载
            byte[] buffer = new byte[1024];
            int i = bis.read(buffer);

            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
        }catch (Exception e){
            logger.error(e.getMessage(), e);
        }
    }

    @ApiOperation("测试获取用户信息接口GET")
    @GetMapping(value = "/clientexception")
    public User clientexception(@RequestParam(name = "id", required = false) String id){
        logger.info("/get/user called. id={}", id);
        User user = new User();
        user.setUserName("tom");
        throw new ClientException(ClientErrorCode.Code.PARAMS_ERROR.as("测试ClientException"));
    }

    @ApiOperation("测试接口异常处理")
    @GetMapping(value = "/test/exception")
    public String exception(@RequestParam(name = "id", required = false) String id){
        return testService.testException();
    }

    @GetMapping(value = "/test/annotation")
    public String annotation(@RequestParam(name = "id", required = false) String id){
        try {
            DDLAnnotationScanner.generateSQL("com.elegant");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "";
    }


}
