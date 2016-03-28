package org.icase.junit;
import static org.junit.Assume.assumeThat;
import static org.hamcrest.CoreMatchers.*;
import java.io.File;

import org.junit.Test;
public class Assumptions {
	@Test
	public void filenameIncludesUserName(){
		 assumeThat(File.separatorChar, is('/'));
	}
}
