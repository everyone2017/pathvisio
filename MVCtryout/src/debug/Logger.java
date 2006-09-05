package debug;

import java.io.PrintStream;

/**
	Logs output to a stream, with the option to filter for types of messages
	
	log levels:
		1: Trace
		2: debug
		3: info
		4: warn
		5: error
		6: fatal
*/
public class Logger
{
	private boolean debugEnabled = true;
	private boolean traceEnabled = true;
	private boolean infoEnabled = true;
	private boolean warnEnabled = true;
	private boolean errorEnabled = true;
	private boolean fatalEnabled = true;
		
	private PrintStream s = System.err;
		
	public PrintStream getStream () { return s; }	
	public void setStream (PrintStream _s) { s = _s; }
	
	/** 
		get/set log level to a certain level. The higher the level, the
		move output. Messages above this level are discarded. 	
	*/
	
	public void setLogLevel (boolean debug, boolean trace, boolean info,
		boolean warn, boolean error, boolean fatal)
	{
		debugEnabled = debug;
		traceEnabled = trace;
		infoEnabled = info;
		warnEnabled = warn;
		errorEnabled = error;
		fatalEnabled = fatal;
	}
		
	public void trace (String msg) { if (traceEnabled) s.println ("Trace: " + msg); }
	public void debug (String msg) { if (debugEnabled) s.println ("Debug: " + msg); }
	public void info  (String msg) { if (infoEnabled) s.println ("Info:  " + msg); }
	public void warn  (String msg) { if (warnEnabled) s.println ("Warn:  " + msg); }
	public void error (String msg) { if (errorEnabled) s.println ("Error: " + msg); }
	public void error (String msg, Exception e) 
	{
		if(errorEnabled) { error(msg); }
		if(debugEnabled) { e.printStackTrace(s); }
	}
	public void fatal (String msg) { if (fatalEnabled) s.println ("Fatal: " + msg); }
	
	
}