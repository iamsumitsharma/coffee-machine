package com.project.test;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.rules.ExpectedException;

import com.projecct.coffemachine.CoffeeImpl;
import com.projecct.coffemachine.Main;

public class Test {

	private final ByteArrayOutputStream	outContent	= new ByteArrayOutputStream();
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	  @Rule
	  public final TextFromStandardInputStream systemInMock
	    = TextFromStandardInputStream.emptyStandardInputStream();
	
	@Before
	public void init()
	{
	
		System.setOut(new PrintStream(outContent));
	}
	
	@After
	public void cleanUp()
	{
		System.setOut(null);
	}
	
	// this test case is to run the whole flow
	@org.junit.Test
	public void TestMain() throws Exception {
			 System.out.println("main");
			 String[] args = null;
			 systemInMock.provideLines("y", "ginger_syrup", "50");
			 Main.main(args);
	}
	// this test case is to run only coffee machine flow
    @org.junit.Test
	public void TestCoffeeMachine() throws Exception {
		System.out.println("coffee machine test started");
		CoffeeImpl impl = CoffeeImpl.getInstance();
		Boolean result = impl.testOutput("./input_file.json");
		assertTrue(result);
	}
	
	
	
}
