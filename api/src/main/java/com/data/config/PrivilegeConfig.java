package com.data.config;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author : ganjiaxin
 * create at:  2018/12/19  5:44 PM
 * @description:
 */
@Component
public class PrivilegeConfig{
    /**
     *
     */
    private static final long serialVersionUID = 5227750147762179055L;


    private static ResourceLoader resourceLoader = new DefaultResourceLoader();

    /**
     * 配置文件路径.
     */
    private static final String CONFIG_FILE_NAME = "privilege.xml";


    public static List PrivilegeConfig(String key) {
        List<Object> list = new ArrayList<Object>();
        Document doc = null;
        SAXReader reader = new SAXReader();
        try {
            Resource resource = resourceLoader.getResource(CONFIG_FILE_NAME);
            doc = reader.read(new InputStreamReader(resource.getInputStream(), "utf-8"));
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element root = doc.getRootElement();
        List ecList = root.selectNodes("//" + key); //查找
        for (Iterator iterator = ecList.iterator(); iterator.hasNext(); ) {
            Element element = (Element) iterator.next();
            list.add(element.getTextTrim());
        }
        return list;
    }


}
