class InputMethod:
    @staticmethod
    def main():
        print("Enter first number")
        a = InputMethod.get_int_from_input()
        print("Enter second number")
        b = InputMethod.get_int_from_input()
        print(f"Sum is {a + b}")

    @staticmethod
    def get_int_from_input():
        is_valid_data = False
        val = 0

        while not is_valid_data:
            try:
                print("Enter a Number")
                num = input()
                val = int(num)
                is_valid_data = True
            except ValueError:
                print("Invalid Data, Try Again")

        return val


if __name__ == "__main__":
    InputMethod.main()
