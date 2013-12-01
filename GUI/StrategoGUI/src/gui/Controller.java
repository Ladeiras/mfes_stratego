package gui;

import org.overturetool.vdmj.debug.RemoteControl;
import org.overturetool.vdmj.debug.RemoteInterpreter;
//import org.overturetool.vdmj.runtime.Context;
//import org.overturetool.vdmj.values.Value;

public class Controller implements RemoteControl
{
	RemoteInterpreter interpreter;
	@Override
	public void run(RemoteInterpreter intrprtrt) throws Exception
	{
		interpreter = intrprtrt;
		System.out.println("Remote control running...");
		
		/*
		interpreter.init();
		interpreter.create("t", "new TestGame()");
		Value result = interpreter.valueExecute("t.test()");
		Context ctxt = null;
		System.out.println(result.boolValue(ctxt));
		*/
		
		interpreter.finish();
	}
}
