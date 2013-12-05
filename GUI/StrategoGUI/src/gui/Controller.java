package gui;

import org.overturetool.vdmj.debug.RemoteControl;
import org.overturetool.vdmj.debug.RemoteInterpreter;
import org.overturetool.vdmj.runtime.Context;
import org.overturetool.vdmj.values.Value;

public class Controller implements RemoteControl
{
	RemoteInterpreter interpreter;
	@Override
	public void run(RemoteInterpreter intrprtrt) throws Exception
	{
		interpreter = intrprtrt;
		System.out.println("Remote control running...");
		interpreter.create("p", "new Play()");
		interpreter.valueExecute("p.initializeBoard()");
		//interpreter.valueExecute("p.play(0,3,0,4)");
		//interpreter.valueExecute("p.printBoard()");
		
		
		interpreter.valueExecute("p.getBoard()");
		Context ctxt = new Context(location, title, outer)
		
		/*
		interpreter.init();
		interpreter.create("t", "new TestGame()");
		Value result = interpreter.valueExecute("t.test()");
		System.out.println(result.boolValue(ctxt));
		*/
		
		interpreter.finish();
	}
}
