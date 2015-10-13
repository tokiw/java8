var JScanner = Java.type( "java.util.Scanner" );
var JSystem = Java.type( "java.lang.System" );

function nextYear() {
	var age = parseInt( getAge() );
	
	while ( !age ) {
		age = parseInt( getInput() );
	}
	
	print( "Next year, you will be " + ++age );
}

function getInput() {
	print("Please input your age: ")
	var scanner = new JScanner(JSystem.in);
	return scanner.next();
}

function getAge() {
	return $ARG[ 0 ] | $ENV[ "AGE" ];
}


nextYear( $ARG[0] );