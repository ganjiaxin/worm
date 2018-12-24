package com.data.utils;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author regan
 * @createDate 2018/2/8
 * @description 反射工具类
 */
public class ReflectUtils {

    /**
     * 获取实体类主键
     *
     * @param clazz
     * @return
     */
    public static Field getIdField(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        Field item = null;
        for (Field field : fields) {
            Id id = field.getAnnotation(Id.class);
            if (id != null) {
                field.setAccessible(true);
                item = field;
                break;
            }
        }
        if (item == null) {
            Class<?> superclass = clazz.getSuperclass();
            if (superclass != null) {
                item = getIdField(superclass);
            }
        }
        return item;
    }

    /**
     * 根据主键名称获取实体类主键属性值
     *
     * @param clazz
     * @param pkName
     * @return
     */
    public static Object getPkValueByName(Object clazz, String pkName) {
        try {
            String getter = "get" + getMethodName(pkName);
            Method method = clazz.getClass().getMethod(getter, new Class[]{});
            Object value = method.invoke(clazz, new Object[]{});
            return value;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 通过反射将 class1不为空的值赋值给class2
     *
     * @param class1
     * @param class2
     * @throws Exception
     */
    public static void reflectClass1ToClass2(Object class1, Object class2) throws Exception {
        Field[] field = class1.getClass().getDeclaredFields();
        for (int i = 0; i < field.length; i++) {
            String name = field[i].getName();
            if ("serialVersionUID".equals(name)) {
                continue;
            }
            name = name.substring(0, 1).toUpperCase() + name.substring(1);
            Method m1 = class1.getClass().getMethod("get" + name);
            Object value = m1.invoke(class1);
            if (value != null) {
                Field f = field[i];
                f.setAccessible(true);
                f.set(class2, value);
            }
        }
    }

    /**
     * 获取实体类 @Column 的所有属性名称
     *
     * @param clazz
     * @return
     */
    public static List getColumnName(Class<?> clazz) {
        List list = new ArrayList();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
                /**
                 * 获取字段名
                 */
                Column declaredAnnotation = field.getDeclaredAnnotation(Column.class);
                String column = declaredAnnotation.name();
                list.add(column);
            }
        }
        return list;
    }

    /**
     * 通过获取类上的@Table注解获取表名称
     *
     * @param clazz
     * @return
     */
    public static String getTableName(Class<?> clazz) {
        Table annotation = clazz.getAnnotation(Table.class);
        String tableName = annotation.name();
        return tableName;
    }


    public static List getObjectValue(Object object) {
        List list = new ArrayList();
        try {
            if (object != null) {
                // 拿到该类
                Class<?> clz = object.getClass();
                // 获取实体类的所有属性，返回Field数组
                Field[] fields = clz.getDeclaredFields();
                for (Field field : fields) {
                    // 如果类型是String
                    if (field.getGenericType().toString().equals(
                            "class java.lang.String")) { // 如果type是类类型，则前面包含"class "，后面跟类名
                        // 拿到该属性的gettet方法
                        Method m = (Method) object.getClass().getMethod(
                                "get" + getMethodName(field.getName()));
                        String val = (String) m.invoke(object);// 调用getter方法获取属性值
                        if (val != null) {
                            list.add("'" + val + "'");
                        } else {
                            list.add(null);
                        }

                    }
                    // 如果类型是Integer
                    if (field.getGenericType().toString().equals(
                            "class java.lang.Integer")) {
                        Method m = (Method) object.getClass().getMethod(
                                "get" + getMethodName(field.getName()));
                        Integer val = (Integer) m.invoke(object);
                        if (val != null) {
                            list.add(val);
                        } else {
                            list.add(null);
                        }

                    }
                    // 如果类型是Double
                    if (field.getGenericType().toString().equals(
                            "class java.lang.Double")) {
                        Method m = (Method) object.getClass().getMethod(
                                "get" + getMethodName(field.getName()));
                        Double val = (Double) m.invoke(object);
                        if (val != null) {
                            list.add(val);
                        }

                    }
                    // 如果类型是Boolean 是封装类
                    if (field.getGenericType().toString().equals(
                            "class java.lang.Boolean")) {
                        Method m = (Method) object.getClass().getMethod(
                                field.getName());
                        Boolean val = (Boolean) m.invoke(object);
                        if (val != null) {
                            list.add(val);
                        }

                    }
                    // 如果类型是boolean 基本数据类型不一样 这里有点说名如果定义名是 isXXX的 那就全都是isXXX的
                    // 反射找不到getter的具体名
                    if (field.getGenericType().toString().equals("boolean")) {
                        Method m = (Method) object.getClass().getMethod(
                                field.getName());
                        Boolean val = (Boolean) m.invoke(object);
                        if (val != null) {
                            list.add(val);
                        }

                    }
                    // 如果类型是Date
                    if (field.getGenericType().toString().equals(
                            "class java.util.Date")) {
                        Method m = (Method) object.getClass().getMethod(
                                "get" + getMethodName(field.getName()));
                        Date val = (Date) m.invoke(object);
                        if (val != null) {
                            list.add("'" + DateUtils.dateStr4(val) + "'");
                        } else {
                            list.add(null);
                        }

                    }
                    // 如果类型是Short
                    if (field.getGenericType().toString().equals(
                            "class java.lang.Short")) {
                        Method m = (Method) object.getClass().getMethod(
                                "get" + getMethodName(field.getName()));
                        Short val = null;

                        val = (Short) m.invoke(object);

                        if (val != null) {
                            list.add(val);
                        }

                    }
                    // 如果还需要其他的类型请自己做扩展
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return list;
    }

    // 把一个字符串的第一个字母大写、效率是最高的、
    private static String getMethodName(String fildeName) {
        byte[] items = fildeName.getBytes();
        items[0] = (byte) ((char) items[0] - 'a' + 'A');
        return new String(items);
    }

}
