var helloNashorn = function(){
        print("Hello Nashorn");
};

var info = function() {
    return "javaleader.pl";
};

helloNashorn();

var MyJavaClass = Java.type('pl.javaleader.nashorn.NashornDemo');
var result      = MyJavaClass.info();

print(result);