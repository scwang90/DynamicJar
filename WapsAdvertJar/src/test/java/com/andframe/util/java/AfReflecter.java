package com.andframe.util.java;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
/**
 * java ���乤����
 * @author ���b
 */
public class AfReflecter {

	/**
	 *  ��ȡ subobj ��� ���� supclass �� ��index�����Ͳ���
	 * @param subobj ���� һ����this �� class Type<E> �ɴ��� Type.this
	 * @param supclass ����(ģ����) �� class Type<E> �ɴ��� Type.class
	 * @param index Ҫ��ȡ���������� һ����0
	 * @return null ����ʧ�� ���򷵻ز�������Class<?>
	 */
	@SuppressWarnings("unchecked")
	public static <T> Class<T> getActualTypeArgument(Object subobj,Class<?> supclass,int index){
		Class<?> subclass = subobj.getClass();
		List<ParameterizedType> ptypes = new ArrayList<ParameterizedType>();
		ParameterizedType ptype = null;
		while (!supclass.equals(subclass)) {
			Type type = subclass.getGenericSuperclass();
			if (type == null) {
				throw new Error("GenericSuperclass not find");
			}else if (type instanceof Class) {
				subclass = (Class<?>)type;
			}else if (type instanceof ParameterizedType) {
				ptype = ParameterizedType.class.cast(type);
				ptypes.add(ptype);
				subclass = (Class<?>)ptype.getRawType();
			}else if (type instanceof GenericArrayType) {
				GenericArrayType gtype = GenericArrayType.class.cast(type);
				subclass = (Class<?>)gtype.getGenericComponentType();
			}else{
				throw new Error("GenericSuperclass not case");
			}
		}
		Type type = null;
		do{
			type = ptypes.get(ptypes.size()-1).getActualTypeArguments()[index];
			ptypes.remove(ptypes.size()-1);
		}while(!(type instanceof Class) && ptypes.size() > 0);
		return (Class<T>)type;
	}

	/**
	 * ��clazz�л�ȡ����Field(��������)
	 * @param clazz
	 * @param annot
	 * @return Field[]
	 */
	public static Field[] getField(Class<?> clazz) {
		// TODO Auto-generated method stub
		List<Field> fields = new ArrayList<Field>();
		while (!clazz.equals(Object.class)) {
			for (Field field : clazz.getDeclaredFields()) {
				fields.add(field);
			}
			clazz = clazz.getSuperclass();
		}
		return fields.toArray(new Field[0]);
	}

	/**
	 * ��clazz�л�ȡ���б��annot��Field(��������)
	 * @param clazz
	 * @param annot
	 * @return Field[]
	 */
	public static Field[] getFieldAnnotation(Class<?> clazz, Class<? extends Annotation> annot) {
		// TODO Auto-generated method stub
		List<Field> fields = new ArrayList<Field>();
		while (!clazz.equals(Object.class)) {
			for (Field field : clazz.getDeclaredFields()) {
				if (field.isAnnotationPresent(annot)) {
					fields.add(field);
				}
			}
			clazz = clazz.getSuperclass();
		}
		return fields.toArray(new Field[0]);
	}

	/**
	 * ���÷������� ��ȡtype��method��Annotation(��������)
	 * @param type
	 * @param method
	 * @param annot
	 * @return method or null
	 */
	public static <T extends  Annotation> T getMethodAnnotation(Class<?> type, String method,  Class<T> annot) {
		// TODO Auto-generated method stub
		while (!type.equals(Object.class)) {
			for (Method dmethod : type.getDeclaredMethods()) {
				if (dmethod.getName().equals(method)) {
					if (dmethod.isAnnotationPresent(annot)) {
						return dmethod.getAnnotation(annot);
					}
				}
			}
			type = type.getSuperclass();
		}
		return null;
	}
	/**
	 * ���÷������� ��ȡtype��method(��������)
	 * @param type
	 * @param method
	 * @return method or null
	 */
	public static Method getMethod(Class<?> type, String method) {
		// TODO Auto-generated method stub
		while (!type.equals(Object.class)) {
			for (Method dmethod : type.getDeclaredMethods()) {
				if (dmethod.getName().equals(method)) {
					return dmethod;
				}
			}
			type = type.getSuperclass();
		}
		return null;
	}

	/**
	 * ���÷������� ��ȡtype��method(��������)
	 * @param type
	 * @param method
	 * @param args ��� args û��null ���Ծ�ȷ���ҷ���
	 * @return method or null
	 */
	public static Method getMethod(Class<?> type, String method,Object... args) {
		if (args != null){
			Class<?>[] parameterTypes = new Class<?>[args.length];
			for (int i = 0; i < args.length; i++) {
				if (args[i] != null){
					parameterTypes[i] = args[i].getClass();
				}else{
					parameterTypes = null;
					break;
				}
			}
			if (parameterTypes != null){
				Method method1 = getMethod(type, method, parameterTypes);
				if (method1 != null){
					return method1;
				}
			}
		}
		return getMethod(type,method);
	}
	/**
	 * ���÷������� ��ȡtype��method(��������)
	 * @param type
	 * @param method
	 * @return method or null
	 */
	public static Method getMethod(Class<?> type, String method,Class<?>[] parameterTypes) {
		// TODO Auto-generated method stub
		while (!type.equals(Object.class)) {
			try {
				return type.getDeclaredMethod(method,parameterTypes);
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
			type = type.getSuperclass();
		}
		return null;
	}
	/**
	 * ���÷������� ��ȡtype��field(��������)
	 * @param type
	 * @param field ��֧�֡�.��·��
	 * @return field or null
	 */
	public static Field getField(Class<?> type, String field) {
		// TODO Auto-generated method stub
		while (!type.equals(Object.class)) {
			try {
				return type.getDeclaredField(field);
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			type = type.getSuperclass();
		}
		return null;
	}

	/**
	 * ���÷������� ����ȡ����type������path��Field(��������)
	 * @param obj
	 * @param type
	 * @param path
	 * @param index
	 * @return
	 * @throws NoSuchFieldException
	 * @throws Exception ����Խ��
	 */
	private static Field getField(Class<?> type, String[] path,int index) throws Exception{
		Field field = getField(type,path[index]);
		if (path.length == index + 1) {
			return field;
		} else if (path.length > 0) {
			return getField(field.getType(), path, index + 1);
		}
		return field;
	}

	/**
	 * ��ȡ�ֶ� Field(��������)
	 * @param model
	 * @param field ֧�֡�.��·�� �� person.name
	 * @return
	 * @throws Exception
	 */
	public static Field getField(Object model, String field) throws Exception {
		// TODO Auto-generated method stub
		return getField(model.getClass(), field.split("\\."), 0);
	}

	/**
	 * ��ȡ�ֶ� Field(��������)
	 * @param model
	 * @param field ֧�֡�.��·�� �� person.name
	 * @return
	 */
	public static Field getFieldNoException(Object model, String field) {
		// TODO Auto-generated method stub
		try {
			return getField(model.getClass(), field.split("\\."), 0);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	/**
	 * ���÷������� ����obj������pathΪ value
	 * @param type
	 * @param path
	 * @param obj
	 * @param value
	 * @param index ����ָ��Ϊ 0
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	private static void invokeMember(Class<?> type, String[] path, Object obj,
									 Object value, int index) throws Exception {
		Field field = getField(type,path[index]);
		if (path.length == index + 1) {
			field.setAccessible(true);
			field.set(obj, value);
		} else if (path.length > 0) {
			value = field.get(obj);
			invokeMember(obj.getClass(), path, obj, value, index + 1);
		}
	}

	/**
	 * ���÷������� ��ȡ����obj������path��value
	 * @param obj
	 * @param type
	 * @param path
	 * @param index
	 * @return
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws Exception ����Խ��
	 */
	private static Object invokeMember(Class<?> type, String[] path,Object obj,
									   int index) throws Exception  {
		Field field = getField(type,path[index]);
		field.setAccessible(true);
		Object value = field.get(obj);
		if (path.length == index + 1) {
			return value;
		} else if (path.length > 0 && value != null) {
			return invokeMember(value.getClass(), path, value, index + 1);
		}
		return value;
	}

	/**
	 * ��ȡ obj ���� field ��ֵ
	 * @param obj
	 * @param field ֧�֡�.��·�� �� person.name
	 * @return
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws Exception ����Խ��
	 */
	public static void setMember(Object obj,String field,Object value) throws Exception {
		invokeMember(obj.getClass(), field.split("\\."), obj,value, 0);
	}

	/**
	 * ��ȡ obj ���� field ��ֵ
	 * @param obj
	 * @param field ֧�֡�.��·�� �� person.name
	 * @return
	 */
	public static boolean setMemberNoException(Object obj,String field,Object value) {
		try {
			invokeMember(obj.getClass(), field.split("\\."), obj,value, 0);
			return true;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			return false;
		}
	}


	/**
	 * ��ȡ obj ���� field ��ֵ
	 * @param obj
	 * @param field ֧�֡�.��·�� �� person.name
	 * @return
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws Exception ����Խ��
	 */
	public static Object getMember(Object obj,String field) throws Exception {
		return invokeMember(obj.getClass(), field.split("\\."), obj, 0);
	}

	/**
	 * ��ȡ obj ���� field ��ֵ
	 * @param obj
	 * @param field ֧�֡�.��·�� �� person.name
	 * @return
	 */
	public static Object getMemberNoException(Object obj,String field) {
		try {
			return invokeMember(obj.getClass(), field.split("\\."), obj, 0);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	/**
	 * ��ȡ obj ���� field ��ֵ
	 * @param obj
	 * @param field ֧�֡�.��·�� �� person.name
	 * @return
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws Exception ����Խ��
	 */
	public static <T> T getMember(Object obj,String field,Class<T> clazz) throws Exception {
		obj = invokeMember(obj.getClass(), field.split("\\."), obj, 0);
		if(clazz.isInstance(obj)){
			clazz.cast(obj);
		}
		return null;
	}

	/**
	 * ��ȡ obj ���� field ��ֵ
	 * @param obj
	 * @param field ֧�֡�.��·�� �� person.name
	 * @return
	 */
	public static <T> T  getMemberNoException(Object obj,String field,Class<T> clazz) {
		try {
			return clazz.cast(invokeMember(obj.getClass(), field.split("\\."), obj, 0));
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	public static Object doMethod(Object obj, String smethod, Object... args) {
		Method method = getMethod(obj.getClass(), smethod, args);
		try {
			return method.invoke(obj, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> T doMethod(Object obj, String smethod,Class<T> clazz, Object... args) {
		Method method = getMethod(obj.getClass(), smethod, args);
		try {
			return clazz.cast(method.invoke(obj,args));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Object doStaticMethod(Class<?> clazz, String smethod, Object... args) {
		Method method = getMethod(clazz, smethod, args);
		return doStaticMethod(clazz,method,args);
	}


	public static <T> T doStaticMethod(Class<?> clazz, String smethod,Class<T> rettype, Object... args) {
		Method method = getMethod(clazz, smethod, args);
		return rettype.cast(doStaticMethod(clazz,method,args));
	}

	public static Object doStaticMethod(Class<?> clazz, Method method, Object... args) {
		try {
			return method.invoke(clazz, args);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
}
