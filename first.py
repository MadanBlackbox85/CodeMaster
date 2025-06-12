def sample_function(x):
    if x > 0:
        print("Positive number")
    elif x < 0:
        print("Negative number")
    else:
        print("Zero")
def sample_function_modified(x):
    if x > 0:
        for i in range(x):
            if i % 2 == 0:
                print(i, "is even")
            else:
                print(i, "is odd")
    elif x < 0:
        print("Negative number")
    else:
        print("Zero")
def calculate_cyclomatic_complexity(function_code):
    """
    Cyclomatic Complexity (CC) = E - N + 2P
    E (Edges) ~ Decision Points + 1
    N (Nodes) ~ Statements
    P (Connected Components) ~ 1 (for simple program)
    """
    decision_keywords = ['if', 'elif', 'for', 'while', 'case', 'except']
    lines = function_code.strip().split('\n')

    decisions = 0
    nodes = 0

    for line in lines:
        line = line.strip()
        if not line or line.startswith('#'):
            continue
        nodes += 1
        for keyword in decision_keywords:
            if line.startswith(keyword):
                decisions += 1
                break

    edges = decisions + 1
    complexity = edges - nodes + 2
    return complexity
def display_control_flow_diagram_simple():
    print("\nSimple Control Flow Diagram for 'sample_function':\n")
    print("[Start]")
    print(" |")
    print(" [Check x > 0]")
    print("         /   \\")
    print("      Yes /     \\ No")
    print("       [Print Positive]    [Check x < 0]")
    print("                             /   \\")
    print("                          Yes /     \\ No")
    print("                           [Print Negative] [Print Zero]")
    print("                             \\   /")
    print("                               [End]")
def control_flow_demo(x):
    print("\nControl Flow Execution for input:", x)
    print("Start")
    if x > 0:
        print("Decision: x > 0 → True path")
    elif x < 0:
        print("Decision: x < 0 → True path")
    else:
        print("Else path (Zero)")
    print("End")

import inspect


print("---- Analyzing Original 'sample_function' ----")
function_source = inspect.getsource(sample_function)
complexity = calculate_cyclomatic_complexity(function_source)
print("Cyclomatic Complexity of 'sample_function' is:", complexity)
control_flow_demo(0)
control_flow_demo(5)
control_flow_demo(-3)
display_control_flow_diagram_simple()



def sample_function_modified_extra(x):
    if x > 0:
        for i in range(x):
            if i % 2 == 0:
                print(i, "is even")
            else:
                print(i, "is odd")
    elif x < 0:
        print("Negative number")
    else:
        print("Zero")
    if x != 0:
        print("x is not zero")

print("\n---- Analyzing Further Modified 'sample_function_modified_extra' ----")
function_source_modified_extra = inspect.getsource(sample_function_modified_extra)
complexity_modified_extra = calculate_cyclomatic_complexity(function_source_modified_extra)
print("Cyclomatic Complexity of 'sample_function_modified_extra' is:", complexity_modified_extra)
