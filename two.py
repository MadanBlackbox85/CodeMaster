def validate_input(number):
    if 10 <= number <= 100:
        return "Valid Input"
    else:
        return "Invalid Input"
def equivalence_partitioning_tests():
    print("\n")
    test_cases = [-5, 5, 50, 150]
    for num in test_cases:
        result = validate_input(num)
        print(f"Test with input {num}: {result}")
def boundary_value_analysis_tests():
    print("\n")
    boundary_values = [9, 10, 11, 99, 100, 101]
    for num in boundary_values:
        result = validate_input(num)
        print(f"Test with input {num}: {result}")
if __name__ == "__main__":

    try:
        user_input = int(input("Enter a number between 10 and 100: "))
        print(validate_input(user_input))
    except ValueError:
        print("Invalid input: Please enter an integer.")

   
    equivalence_partitioning_tests()
    boundary_value_analysis_tests()
