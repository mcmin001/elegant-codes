package com.elegant.codes.common.annotation;


import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@Slf4j
public class DDLAnnotationScanner {

    public static List<String> generateSQL(String packageName) throws ClassNotFoundException, IOException {
        List<String> sqlStatements = new ArrayList<>();
        // List<Class<?>> classes = scanClasses(packageName);
        List<Class<?>> classes = scanClassesNew(packageName);
        for (Class<?> clazz : classes) {
            if (clazz.isAnnotationPresent(DDLTableName.class)) {
                StringBuilder sql = new StringBuilder("CREATE TABLE ");
                DDLTableName tableAnnotation = clazz.getAnnotation(DDLTableName.class);
                sql.append(tableAnnotation.tableName()).append(" (");
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    if (field.isAnnotationPresent(DDLColumn.class)) {
                        DDLColumn columnAnnotation = field.getAnnotation(DDLColumn.class);
                        if (columnAnnotation.primaryKey()) {
                            sql.append(" PRIMARY KEY");
                        }
                        sql.append(", ");
                    }
                }
                // Remove the last comma and space
                sql.delete(sql.length() - 2, sql.length());
                sql.append(")");
                sqlStatements.add(sql.toString());
            }
        }
        return sqlStatements;
    }


    private static List<Class<?>> scanClasses(String packageName) throws ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();
        String path = packageName.replace('.', '/');
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        File directory = new File(classLoader.getResource(path).getFile());
        if (directory.exists()) {
            File[] files = directory.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    classes.addAll(scanClasses(packageName + "." + file.getName()));
                } else if (file.getName().endsWith(".class")) {
                    String className = packageName + '.' + file.getName().substring(0, file.getName().length() - 6);
                    classes.add(Class.forName(className));
                }
            }
        }
        return classes;
    }


    public static List<Class<?>> scanClassesNew(String packageName) throws ClassNotFoundException, IOException {
        List<Class<?>> classes = new ArrayList<>();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            if (resource != null) {
                String protocol = resource.getProtocol();
                if (protocol.equals("file")) {
                    String filePath = resource.getFile().replace("%20", " ");
                    findClassesInDirectory(packageName, new File(filePath), classes);
                }
            }
        }
        return classes;
    }

    private static void findClassesInDirectory(String packageName, File directory, List<Class<?>> classes) throws ClassNotFoundException {
        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        findClassesInDirectory(packageName + "." + file.getName(), file, classes);
                    } else if (file.getName().endsWith(".class")) {
                        String className = packageName + '.' + file.getName().substring(0, file.getName().length() - 6);
                        Class<?> clazz = Class.forName(className);
                        classes.add(clazz);
                    }
                }
            }
        }
    }


    private static void findClasses(String packageName, File directory, List<Class<?>> classes) throws ClassNotFoundException {
        if (!directory.exists()) {
            return;
        }
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    findClasses(packageName + "." + file.getName(), file, classes);
                } else if (file.getName().endsWith(".class")) {
                    String className = packageName + '.' + file.getName().substring(0, file.getName().length() - 6);
                    Class<?> clazz = Class.forName(className);
                    classes.add(clazz);
                }
            }
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        String packageName = "com."; // 指定要扫描的包名
        String databaseType = "mysql"; // 指定数据库类型
        List<String> sqlStatements = generateSQL(packageName);
        for (String sql : sqlStatements) {
            System.out.println(sql);
        }
    }
}
