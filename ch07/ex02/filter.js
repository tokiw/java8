var contents = new java.lang.String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get("./alice.txt")), java.nio.charset.StandardCharsets.UTF_8);
var StringArray = Java.type("java.lang.String[]");
var words = java.util.Arrays.asList(Java.to(contents.split(/[\W]+/), StringArray));
words.stream().filter(function(w) w.length() > 12).distinct().sorted().forEach(function(w) print(w));