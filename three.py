

def square(x):
    return x * x
test_cases = [
    {"input": 2, "expected": 4},
    {"input": -3, "expected": 7},
    ]
def run_tests():
    print("\n")
    passed = 0  

    for index, test in enumerate(test_cases):
        input_value = test["input"]
        expected_output = test["expected"]
        actual_output = square(input_value)

       
        if actual_output == expected_output:
            result = "PASS"
            passed += 1
        else:
            result = "FAIL"

        
        print(f"Test Case {index + 1}: Input={input_value} | Expected={expected_output} | Actual={actual_output} --> {result}")

    total = len(test_cases)
    print(f"\nTesting Completed: {passed}/{total} Tests Passed.")
if __name__ == "__main__":
    run_tests()
