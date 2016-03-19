package org.icase.corejava.throwable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionOccur {
	
	public void findNotExistFile() throws FileNotFoundException,IOException, MyException{
		File f = new File("abstract.txt");
		FileInputStream fis = new FileInputStream(f);
		int markNum =-1 ;
		while((markNum=fis.read())!=-1){
			System.out.println(markNum);
		}
		throw new MyException("程序执行异常！");
	}
}
