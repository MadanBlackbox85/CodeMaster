from collections import Counter
import string

def get_most_frequent_words(filename, top_n=5):
    try:
        with open(filename, 'r') as file:
            text = file.read()
            # Convert to lowercase and remove punctuation
            text = text.lower()
            text = text.translate(str.maketrans('', '', string.punctuation)) # Corrected line

            # Splits text into words
            words = text.split()

            # Count word frequencies
            word_counts = Counter(words) # Corrected 'counter' to 'Counter'

            # Get the top 'n' most common words
            most_common = word_counts.most_common(top_n) # Corrected 'word_counter mopst_common'

            print(f"\nTop {top_n} most frequent words in '{filename}':")
            for word, count in most_common:
                print(f"{word}: {count} times")
    except FileNotFoundError:
        print(f"Error: File '{filename}' not found")

# Example usage - moved outside the function to be called after definition
filename = input("Enter the filename (ex: hi.txt): ")
get_most_frequent_words(filename, top_n=5)
