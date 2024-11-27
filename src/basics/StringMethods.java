package basics;

public class StringMethods {

    public static void main(String[] args) {
        String string = "Hello World";
        infoMethods(string);
        infoMethods("   ");
        comparisonMethods(string);
        manipulationMethods();

    }

    public static void infoMethods(String string){
        int length = string.length();
        System.out.printf("Length = %d %n",length);
        if(string.isEmpty()){
            System.out.printf("String is Blank");   // for ""
            return;
        }
        if(string.isBlank()){
            System.out.println("String is blank");  // for "    "
        }

        System.out.printf("First Character is %c %n",string.charAt(0));
        System.out.printf("Last Character is %c %n",string.charAt(length-1));
        System.out.printf("-".repeat(20));
        System.out.println();

        System.out.println("Index of r is "+string.indexOf('r'));
        System.out.println("Index of World is "+string.indexOf("World"));

        System.out.println("Index of l is "+string.indexOf("l"));               //finds first index from left
        System.out.println("Last index of l is "+string.lastIndexOf("l"));  //finds first index from right

        System.out.println("Index of l is "+string.indexOf("l",3));            //finds first index from left from index 3
        System.out.println("Last index of l is "+string.lastIndexOf("l",8));  //finds first index from right from index 8

        System.out.printf("-".repeat(20));
        System.out.println();


    }

    public static void comparisonMethods(String string){
        String lower = string.toLowerCase();
        System.out.println(lower);
        if(string.equals(lower)){
            System.out.println("Values match exactly");
        }
        if(string.equalsIgnoreCase(lower)){
            System.out.println("Values match ignoring case");
        }

        if(string.startsWith("Hel")){
            System.out.println("It starts with Hel");
        }
        if(string.endsWith("rld")){
            System.out.println("It ends with rld");
        }
        if(string.contains("llo")){
            System.out.println("It contains with llo");
        }

        System.out.printf("-".repeat(20));
        System.out.println();
    }

    public static void manipulationMethods(){
        String birthDate = "25/11/1982";
        int startingIndex = birthDate.indexOf("1982");
        System.out.println("startingIndex = " + startingIndex);
        System.out.println("Birth year = " + birthDate.substring(startingIndex));

        System.out.println("Month = " + birthDate.substring(3, 5));

        String newDate = String.join("/", "25", "11", "1982");
        System.out.println("newDate = " + newDate);

        newDate = "25";
        newDate = newDate.concat("/");
        newDate = newDate.concat("11");
        newDate = newDate.concat("/");
        newDate = newDate.concat("1982");
        System.out.println("newDate = " + newDate);

        newDate = "25" + "/" + "11" + "/" + "1982";
        System.out.println("newDate = " + newDate);

        newDate = "25".concat("/").concat("11").concat("/")
                .concat("1982");
        System.out.println("newDate = " + newDate);

        System.out.println(newDate.replace('/', '-'));          // Using char
        System.out.println(newDate.replace("2", "00"));        // Using string

        System.out.println(newDate.replaceFirst("/", "-"));     //can use regex
        System.out.println(newDate.replaceAll("/", "---"));     //can use regex

        System.out.println("ABC\n".repeat(3));

//        System.out.println("ABC\n".repeat(3).indent(8));                // indent added in jdk15
        System.out.println("-".repeat(20));                         // repeat added in jdk11

    }
/*
Output of the above
    Length = 11
First Character is H
Last Character is d
--------------------
Index of r is 8
Index of World is 6
Index of l is 2
Last index of l is 9
Index of l is 3
Last index of l is 3
--------------------
Length = 3
String is blank
First Character is
Last Character is
--------------------
Index of r is -1
Index of World is -1
Index of l is -1
Last index of l is -1
Index of l is -1
Last index of l is -1
--------------------
hello world
Values match ignoring case
It starts with Hel
It ends with rld
It contains with llo
--------------------
startingIndex = 6
Birth year = 1982
Month = 11
newDate = 25/11/1982
newDate = 25/11/1982
newDate = 25/11/1982
newDate = 25/11/1982
25-11-1982
005/11/19800
25-11/1982
25---11---1982
ABC
ABC
ABC

--------------------
 */

}
