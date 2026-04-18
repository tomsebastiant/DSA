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
        System.out.printf("Length = %d %n",length);             // Hello World: Length = 11
        if(string.isEmpty()){
            System.out.printf("String is Blank");               // for ""
            return;
        }
        if(string.isBlank()){
            System.out.println("String is blank");              // for "    "
        }

        System.out.printf("First Character is %c %n",string.charAt(0));      // Hello World: First Character is H
        System.out.printf("Last Character is %c %n",string.charAt(length-1)); // Hello World: Last Character is d
        System.out.printf("-".repeat(20));                       // --------------------
        System.out.println();

        System.out.println("Index of r is "+string.indexOf('r'));            // Hello World: Index of r is 8
        System.out.println("Index of World is "+string.indexOf("World"));    // Hello World: Index of World is 6

        System.out.println("Index of l is "+string.indexOf("l"));            // finds first index from left: 2
        System.out.println("Last index of l is "+string.lastIndexOf("l"));   // finds first index from right: 9

        System.out.println("Index of l is "+string.indexOf("l",3));          // finds first index from index 3: 3
        System.out.println("Last index of l is "+string.lastIndexOf("l",8)); // finds last index before index 8: 3

        System.out.printf("-".repeat(20));                       // --------------------
        System.out.println();


    }

    public static void comparisonMethods(String string){
        String lower = string.toLowerCase();
        System.out.println(lower);                               // hello world
        if(string.equals(lower)){
            System.out.println("Values match exactly");          // Prints only when case also matches
        }
        if(string.equalsIgnoreCase(lower)){
            System.out.println("Values match ignoring case");    // Values match ignoring case
        }

        if(string.startsWith("Hel")){
            System.out.println("It starts with Hel");            // It starts with Hel
        }
        if(string.endsWith("rld")){
            System.out.println("It ends with rld");              // It ends with rld
        }
        if(string.contains("llo")){
            System.out.println("It contains with llo");          // It contains with llo
        }

        System.out.printf("-".repeat(20));                       // --------------------
        System.out.println();
    }

    public static void manipulationMethods(){
        String birthDate = "25/11/1982";
        int startingIndex = birthDate.indexOf("1982");
        System.out.println("startingIndex = " + startingIndex);  // startingIndex = 6
        System.out.println("Birth year = " + birthDate.substring(startingIndex)); // Birth year = 1982

        System.out.println("Month = " + birthDate.substring(3, 5)); // Month = 11

        String newDate = String.join("/", "25", "11", "1982");
        System.out.println("newDate = " + newDate);              // newDate = 25/11/1982

        newDate = "25";
        newDate = newDate.concat("/");
        newDate = newDate.concat("11");
        newDate = newDate.concat("/");
        newDate = newDate.concat("1982");
        System.out.println("newDate = " + newDate);              // newDate = 25/11/1982

        newDate = "25" + "/" + "11" + "/" + "1982";
        System.out.println("newDate = " + newDate);              // newDate = 25/11/1982

        newDate = "25".concat("/").concat("11").concat("/")
                .concat("1982");
        System.out.println("newDate = " + newDate);              // newDate = 25/11/1982

        System.out.println(newDate.replace('/', '-'));           // Using char: 25-11-1982
        System.out.println(newDate.replace("2", "00"));         // Using string: 005/11/19800

        System.out.println(newDate.replaceFirst("/", "-"));      // can use regex: 25-11/1982
        System.out.println(newDate.replaceAll("/", "---"));      // can use regex: 25---11---1982

        System.out.println("ABC\n".repeat(3));                   // ABC printed 3 times

//        System.out.println("ABC\n".repeat(3).indent(8));                // indent added in jdk15
        System.out.println("-".repeat(20));                         // repeat added in jdk11: --------------------

    }

}
