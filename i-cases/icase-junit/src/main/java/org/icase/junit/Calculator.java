package org.icase.junit;

import org.junit.Assert;

/**
 * Hello world!
 *
 */
public class Calculator 
{
    public int evaluate(String expression){
    	Assert.assertNotNull("expression 为空", expression);
    	int sum = 0;
    	for(String summand:expression.split("\\+")){
    		sum+=Integer.valueOf(summand);
    	}
    	return sum;
    }
}
