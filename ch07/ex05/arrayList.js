function createArrayList() {
	var list = new ( Java.extend( java.util.ArrayList ) ) {
		add: function( x ) {
			print( "Adding " + x );
			// listという名前じゃないと使えないのは不便
			return Java.super( list ).add( x );
		}
	}
	return list;
}

var array = createArrayList();
array.add( "hoge" );
array.add( "foo" );
print( array );

// createArrayList().add("aaa");