// Run as jjs -scripting pipe.js

function pipe() {
	var i, result;
	for ( i=0; i < arguments.length; i++ ) {
		result = $EXEC( arguments[i], result );
	}
	print( result );
}

pipe('find .', 'grep -v class', 'sort' )