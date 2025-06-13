import matplotlib.pyplot as plt


categories = ['Category A', 'Category B', 'Category C', 'Category D']
values = [10, 45, 50, 75]


plt.figure(figsize=(8, 5))
plt.plot(categories, values, marker='p', markersize=20, color='black', label='Line Plot')
plt.title('Line Plot Example', fontsize=13)
plt.xlabel('Categories', fontsize=12)
plt.ylabel('Values', fontsize=12)
plt.legend()
plt.grid(True)
plt.show()

plt.figure(figsize=(8, 5))
plt.bar(categories, values, color='g', alpha=1)
plt.title('Bar Chart Example', fontsize=12)
plt.xlabel('Categories', fontsize=12)
plt.ylabel('Values', fontsize=12)
plt.show()


plt.figure(figsize=(8, 5))
plt.scatter(categories, values, color='black', marker='h')
plt.title('Scatter Plot')
plt.xlabel('Categories')
plt.ylabel('Values')
plt.show()


plt.figure()
plt.pie(values, labels=categories, autopct='%1.1f%%')
plt.title("Pie Chart")
plt.show()

