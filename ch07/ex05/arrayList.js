function createArrayList() {
	return new ( Java.extend( java.util.ArrayList ) ) {
		add: function( x ) {
			print( "Adding " + x );
			// listという名前じゃないと使えないのは不便
			return Java.super( list ).add( x );
		}
	}
}

var list = createArrayList();
list.add( "hoge" );
list.add( "foo" );
print( list );

// createArrayList().add("aaa");