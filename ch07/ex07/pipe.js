// Run as jjs -scripting pipe.js
var JProcessBuilder = Java.type( "java.lang.ProcessBuilder" );
var JScanner = Java.type( "java.util.Scanner" );


function pipe() {
	var i,
		processes = [],
		input, output,
		lastProcess,
		scanner,
		result;
		
	for ( i=0; i < arguments.length; i++ ) {
		processes.push( new JProcessBuilder( arguments[i].split(" ") ).start() );
		
		new java.lang.Thread(function () {
			if ( i > 0 ) {
				input = processes[i-1].getInputStream();
				output = processes[i].getOutputStream();
				while ((value = input.read()) != -1) {
				  output.write(value);
				}
				output.close();
			}
		}).start();
	}
	
	lastProcess = processes.pop();
	
	scanner = new JScanner( lastProcess.getInputStream() );
	result = "";
	while (scanner.hasNextLine()) {
	  result += scanner.nextLine() + "\n";
	}
	print( result );
}

pipe('find .', 'grep -v class', 'sort' )