import random


class ArraysMethods:
    @staticmethod
    def main():
        first_array = ArraysMethods.get_random_array(10)
        print(first_array)                                      # Example: [3, 46, 11, 67, 90, 16, 19, 13, 11, 52]
        first_array.sort()                                      # To sort elements
        print(first_array)                                      # Prints the same random list in sorted order

        second_array = [0] * 10
        print(second_array)                                     # [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        second_array = [5] * len(second_array)                  # To fill out elements
        print(second_array)                                     # [5, 5, 5, 5, 5, 5, 5, 5, 5, 5]

        third_array = ArraysMethods.get_random_array(10)
        print(third_array)                                      # Example: [4, 24, 61, 55, 52, 41, 54, 97, 65, 77]

        fourth_array = third_array.copy()                       # To make copies of lists
        print(fourth_array)                                     # Same values as third_array

        fourth_array.sort()
        print(third_array)                                      # Original third_array remains unchanged
        print(fourth_array)                                     # Sorted copy of third_array

        smaller_array = third_array[:5]                         # First 5 values while making copies
        print(smaller_array)                                    # First 5 values from third_array

        larger_array = third_array.copy() + [0] * 5
        print(larger_array)                                     # third_array values followed by 5 zeroes

        s_array = ["Able", "Jane", "Mark", "Ralph", "David"]
        s_array.sort()
        print(s_array)                                          # ['Able', 'David', 'Jane', 'Mark', 'Ralph']

        if "Mark" in s_array:
            mark_position = s_array.index("Mark")
            print(f"Found Mark at position {mark_position}")    # Found Mark at position 3

        s1 = [1, 2, 3, 4, 5, 0]
        s2 = [1, 2, 3, 4, 5, 0]

        if s1 == s2:
            print("Arrays are equal")                           # Arrays are equal
        else:
            print("Arrays are not equal")                       # Arrays are not equal

    @staticmethod
    def get_random_array(length):
        new_int = []
        for _ in range(length):
            new_int.append(random.randrange(100))               # Random elements from 0-99 are assigned

        return new_int


if __name__ == "__main__":
    ArraysMethods.main()
