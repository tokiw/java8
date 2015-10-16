function start() {
	var JString = Java.type( "java.lang.String" );
	var JPaths = Java.type( "java.nio.file.Paths" );
	var JFiles = Java.type( "java.nio.file.Files" );
	var JStandardCharsets = Java.type( "java.nio.charset.StandardCharsets" );
	var JFXCollections = Java.type( "javafx.collections.FXCollections" );
	var JPieChart = Java.type( "javafx.scene.chart.PieChart" );
	var JScene = Java.type( "javafx.scene.Scene" );
	
	var data = JSON.parse( new JString( JFiles.readAllBytes( JPaths.get("./data.json")), JStandardCharsets.UTF_8) );
	var list = [];
	for ( var i in data ) {
		list[ i ] = new JPieChart.Data( data[ i ].name, data[ i ].value );
	}
	
	var pieChart = new JPieChart( JFXCollections.observableArrayList( list ) );
	$STAGE.scene = new JScene( pieChart );
	$STAGE.title = "chart";
	$STAGE.show();
}