class StringMethods:
    @staticmethod
    def main():
        string = "Hello World"
        StringMethods.info_methods(string)
        StringMethods.info_methods("   ")
        StringMethods.comparison_methods(string)
        StringMethods.manipulation_methods()

    @staticmethod
    def info_methods(string):
        length = len(string)
        print(f"Length = {length}")                             # Hello World: Length = 11

        if string == "":
            print("String is Blank")                            # for ""
            return

        if string.strip() == "":
            print("String is blank")                            # for "    "

        print(f"First Character is {string[0]}")                # Hello World: First Character is H
        print(f"Last Character is {string[length - 1]}")        # Hello World: Last Character is d
        print("-" * 20)                                         # --------------------

        print("Index of r is " + str(string.find("r")))         # Hello World: Index of r is 8
        print("Index of World is " + str(string.find("World"))) # Hello World: Index of World is 6

        print("Index of l is " + str(string.find("l")))         # finds first index from left: 2
        print("Last index of l is " + str(string.rfind("l")))   # finds first index from right: 9

        print("Index of l is " + str(string.find("l", 3)))      # finds first index from index 3: 3
        print("Last index of l is " + str(string.rfind("l", 0, 8))) # finds last index before index 8: 3

        print("-" * 20)                                         # --------------------

    @staticmethod
    def comparison_methods(string):
        lower = string.lower()
        print(lower)                                            # hello world

        if string == lower:
            print("Values match exactly")                       # Prints only when case also matches

        if string.lower() == lower.lower():
            print("Values match ignoring case")                 # Values match ignoring case

        if string.startswith("Hel"):
            print("It starts with Hel")                         # It starts with Hel

        if string.endswith("rld"):
            print("It ends with rld")                           # It ends with rld

        if "llo" in string:
            print("It contains with llo")                       # It contains with llo

        print("-" * 20)                                         # --------------------

    @staticmethod
    def manipulation_methods():
        birth_date = "25/11/1982"
        starting_index = birth_date.find("1982")
        print("startingIndex = " + str(starting_index))         # startingIndex = 6
        print("Birth year = " + birth_date[starting_index:])    # Birth year = 1982

        print("Month = " + birth_date[3:5])                     # Month = 11

        new_date = "/".join(["25", "11", "1982"])
        print("newDate = " + new_date)                          # newDate = 25/11/1982

        new_date = "25"
        new_date += "/"
        new_date += "11"
        new_date += "/"
        new_date += "1982"
        print("newDate = " + new_date)                          # newDate = 25/11/1982

        new_date = "25" + "/" + "11" + "/" + "1982"
        print("newDate = " + new_date)                          # newDate = 25/11/1982

        new_date = "25".__add__("/").__add__("11").__add__("/").__add__("1982")
        print("newDate = " + new_date)                          # newDate = 25/11/1982

        print(new_date.replace("/", "-"))                       # Replaces all matches: 25-11-1982
        print(new_date.replace("2", "00"))                      # Using string: 005/11/19800

        print(new_date.replace("/", "-", 1))                    # Replaces first match: 25-11/1982
        print(new_date.replace("/", "---"))                     # Replaces all matches: 25---11---1982

        print("ABC\n" * 3)                                      # ABC printed 3 times
        print("-" * 20)                                         # --------------------


if __name__ == "__main__":
    StringMethods.main()
