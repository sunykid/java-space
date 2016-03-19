package org.icase.corejava;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import org.icase.corejava.throwable.ExceptionOccur;
import org.icase.corejava.throwable.MyException;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class ExceptionTest 
    extends TestCase
{
	public static final String TXTLOCATION = "abstract.txt";
	@Test
   public void testPrinException(){
		/**
		 * 对于实现了AutoCloseable接口的Resource资源，可以使用
		 * 如下形式的try（）{...}catch(E e){}finally{}语句
		 * try块正常退出或者发生异常时，都会自动调用资源的close方法
		 * catch及finally中的代码会在资源关闭后执行
		 */
	   try(Scanner in = new Scanner("似的发射点")){
		new ExceptionOccur().findNotExistFile();
	} catch (FileNotFoundException e) {
		System.out.println(e.getMessage());
		System.out.println(e.getClass().getName());
	} catch (IOException|RuntimeException e) {
		//e = null; 捕获多异常时，e隐含为final类型 此处不能对e进行重新赋值
		System.out.println(e.getMessage());
		System.out.println(e.getClass().getName());
		RuntimeException re = new RuntimeException();
		re.initCause(e);
		   throw re;
	} catch (MyException e) {
		System.out.println(e.getMessage());
		System.out.println(e.getClass().getName());
	}
   }
	
	/**
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	public void testPrintExceptionStack() throws FileNotFoundException{
	/*	PrintStream ps = new PrintStream(TXTLOCATION);
		t.printStackTrace(ps);
		String des = ps.toString();
		System.out.println(des);*/
		System.out.println("==========testExceptionStack===============");
		Throwable t  = new Throwable();
		//getStackTrace获得创建Throwable对象时的调用堆栈情况
		StackTraceElement[] elements =  t.getStackTrace();
		printStackTrace(elements);
		System.out.println("==========testExceptionStack===============");
		
	}
	/**
	 * 获取所有线程的堆栈执行情况
	 * 返回各个线程dumpThreads后的堆栈信息（current-2）
	 */
	@Test
	public void testPrintAllStack() throws FileNotFoundException{
		Map<Thread, StackTraceElement[]>  map = Thread.getAllStackTraces();
		for(Thread t:map.keySet()){
			if(!Thread.currentThread().getName().equals(t.getName())){
				continue;
			}
			StackTraceElement[] es = map.get(t);
			printStackTrace(es);
			
		}
	}
	private void printStackTrace(StackTraceElement[] elements) {
		// TODO Auto-generated method stub
		for(StackTraceElement e: elements){
			System.out.print(e.getClassName()+"\t");
			System.out.print(e.getFileName()+"\t");
			System.out.print(e.getMethodName()+"\t");
			System.out.println(e.getLineNumber());
			System.out.println("String:"+e.toString());
		}
	}
}
