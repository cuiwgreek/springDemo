package com.cuiwjava.tx;

import com.cuiwjava.service.impl.EmployeeServiceImpl;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Classname DynamicProxyClassGenerator
 * @Description TODO
 * @Date 2019/4/24/024 9:40
 * @Created by cuiwjava
 */
public class DynamicProxyClassGenerator {
    public static void main(String[] args) throws IOException {
        generateClassFile(EmployeeServiceImpl.class,"EmployeeServiceProxy");
    }
//生成代理类的字节码
    public static void generateClassFile(Class targetClass,String proxyName) throws IOException {
        System.out.println(targetClass);
        //根据类信息和提供的代理类名称, 生成字节码
        byte[] classFile = ProxyGenerator.generateProxyClass(proxyName, targetClass.getInterfaces());
        String path = targetClass.getResource(".").getPath();
        System.out.println(path);
        FileOutputStream out = null;
        //保留到硬盘中
        out = new FileOutputStream(path + proxyName + ".class");
        out.write(classFile);
        out.close();

    }
}
